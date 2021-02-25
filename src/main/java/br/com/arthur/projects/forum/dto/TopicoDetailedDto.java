package br.com.arthur.projects.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.arthur.projects.forum.model.StatusTopico;
import br.com.arthur.projects.forum.model.Topico;

public class TopicoDetailedDto
{
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusTopico status;
	private List<RespostaDto> respostas;
	
	public TopicoDetailedDto(Topico topico)
	{
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
		this.nomeAutor = topico.getAutor().getNome();
		this.status = topico.getStatus();
		this.respostas = new ArrayList<>();
		this.respostas.addAll(RespostaDto.convertToDtoList(topico.getRespostas()));
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

	public String getNomeAutor()
	{
		return nomeAutor;
	}

	public StatusTopico getStatus()
	{
		return status;
	}

	public List<RespostaDto> getRespostas()
	{
		return respostas;
	}
}
