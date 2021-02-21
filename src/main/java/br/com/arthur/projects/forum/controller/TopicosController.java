package br.com.arthur.projects.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.arthur.projects.forum.dto.TopicoOutput;
import br.com.arthur.projects.forum.dto.TopicoInput;
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
	public List<TopicoOutput> lista(String nomeCurso)
	{
		if (nomeCurso == null)
			return TopicoOutput.convertToOutputList(topicoRepository.findAll());
		else
			return TopicoOutput.convertToOutputList(topicoRepository.findByCursoNome(nomeCurso));
	}
	
	@PostMapping
	public ResponseEntity<TopicoOutput> cadastrar(@RequestBody @Valid TopicoInput input, UriComponentsBuilder uriBuilder)
	{
		Curso curso = cursoRepository.findByNome(input.getNomeCurso());
		Topico topico = input.convertToTopico(curso);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoOutput(topico));
	}	
}