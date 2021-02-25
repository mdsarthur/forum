package br.com.arthur.projects.forum.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.arthur.projects.forum.model.Resposta;

public class RespostaDto
{
	private Long id;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	
	public RespostaDto(Resposta resposta)
	{
		this.id = resposta.getId();
		this.mensagem = resposta.getMensagem();
		this.dataCriacao = resposta.getDataCriacao();
		this.nomeAutor = resposta.getAutor().getNome();
	}

	public Long getId()
	{
		return id;
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
	
	public static RespostaDto convertToDto(Resposta resposta)
	{
		return new RespostaDto(resposta);
	}

	public static List<RespostaDto> convertToDtoList(List<Resposta> respostas)
	{
		List<RespostaDto> dto = new ArrayList<>();
		for (Resposta resposta : respostas)
		{
			dto.add(RespostaDto.convertToDto(resposta));
		}
		return dto;		
	}	
}
