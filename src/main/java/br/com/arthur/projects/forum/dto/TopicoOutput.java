package br.com.arthur.projects.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.arthur.projects.forum.model.Topico;

public class TopicoOutput
{
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	public TopicoOutput(Topico topico)
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
	
	public static TopicoOutput convertToOutput(Topico topico)
	{
		return new TopicoOutput(topico);
	}
	
	public static List<TopicoOutput> convertToOutputList(List<Topico> topicos)
	{
		List<TopicoOutput> dto = new ArrayList<>();
		for (Topico topico : topicos)
		{
			dto.add(TopicoOutput.convertToOutput(topico));
		}
		return dto;
	}	
}
