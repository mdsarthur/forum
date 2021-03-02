package br.com.arthur.projects.forum.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.arthur.projects.forum.dto.topico.TopicoCreateDto;
import br.com.arthur.projects.forum.dto.topico.TopicoDetailedDto;
import br.com.arthur.projects.forum.dto.topico.TopicoDto;
import br.com.arthur.projects.forum.dto.topico.TopicoUpdateDto;
import br.com.arthur.projects.forum.model.Curso;
import br.com.arthur.projects.forum.model.Topico;
import br.com.arthur.projects.forum.repository.CursoRepository;
import br.com.arthur.projects.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController
{
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	@Cacheable(value ="listaDeTopicos")
	public Page<TopicoDto> listar(
			@RequestParam(required = false) String nomeCurso,
			@PageableDefault(sort = "id", direction = Direction.DESC) Pageable paginacao)
	{
		if (nomeCurso == null)
		{
			return topicoRepository.findAllProjectedBy(paginacao);
		}
		else
		{			
			return topicoRepository.findByCursoNome(nomeCurso, paginacao);
		}
	}
	
	@GetMapping("/{id}")
	public TopicoDetailedDto detalhar(@PathVariable Long id)
	{
		Topico topico = topicoRepository.getOne(id);
		return new TopicoDetailedDto(topico);
	}
	
	@PostMapping
	@CacheEvict(value="listaDeTopicos", allEntries = true)
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoCreateDto input, UriComponentsBuilder uriBuilder)
	{
		Curso curso = cursoRepository.findByNome(input.getNomeCurso());
		Topico topico = input.convertToTopico(curso);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	@PutMapping("/{id}")
	@CacheEvict(value="listaDeTopicos", allEntries = true)
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid TopicoUpdateDto input)
	{
		Optional<Topico> optional = topicoRepository.findById(id);
		if (optional.isPresent())
		{
			Topico topico = optional.get();
			topico.setTitulo(input.getTitulo());
			topico.setMensagem(input.getMensagem());
			topicoRepository.save(topico);
			return ResponseEntity.ok(new TopicoDto(topico));
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@CacheEvict(value="listaDeTopicos", allEntries = true)
	public ResponseEntity<Void> remover(@PathVariable Long id)
	{
		Optional<Topico> optional = topicoRepository.findById(id);
		
		if (optional.isPresent())
		{
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
}