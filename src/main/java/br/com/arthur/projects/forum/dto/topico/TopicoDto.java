package br.com.arthur.projects.forum.dto.topico;

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
	
	public TopicoDto(Long id, String titulo, String mensagem, LocalDateTime dataCriacao)
	{
		this.id = id;
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.dataCriacao = dataCriacao;
	}
	
	public Long getId()
	{
		return id;
	}
		
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopicoDto other = (TopicoDto) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public static TopicoDto convertToDto(Topico topico)
	{
		return new TopicoDto(topico);
	}
	
	public static List<TopicoDto> convertToDtoList(List<Topico> topicos)
	{
		List<TopicoDto> dto = new ArrayList<>();
		for (Topico topico : topicos)
		{
			dto.add(TopicoDto.convertToDto(topico));
		}
		return dto;
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
}
