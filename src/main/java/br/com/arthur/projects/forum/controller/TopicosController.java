package br.com.arthur.projects.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arthur.projects.forum.dto.TopicoDto;
import br.com.arthur.projects.forum.repository.TopicoRepository;

@RestController
public class TopicosController
{
	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso)
	{
		System.out.println(nomeCurso);
		if (nomeCurso == null)
			return TopicoDto.convertList(topicoRepository.findAll());
		else
			return TopicoDto.convertList(topicoRepository.findByCursoNome(nomeCurso));
	}
}