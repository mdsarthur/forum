package br.com.arthur.projects.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.arthur.projects.forum.model.Topico;

public class TopicoDto
{
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoDto(Topico topico)
	{
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}
	
	public Long getId()
	{
		return id;
	}
	public String getTitulo()
	{
		return titulo;
	}
	public String getMensagem()
	{
		return mensagem;
	}
	public LocalDateTime getDataCriacao()
	{
		return dataCriacao;
	}
	
	public static TopicoDto convert(Topico topico)
	{
		return new TopicoDto(topico);
	}
	
	public static List<TopicoDto> convertList(List<Topico> topicos)
	{
		List<TopicoDto> dto = new ArrayList<>();
		for (Topico topico : topicos)
		{
			dto.add(TopicoDto.convert(topico));
		}
		return dto;
	}
	
	
}
