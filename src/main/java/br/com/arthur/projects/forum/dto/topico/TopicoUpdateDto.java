package br.com.arthur.projects.forum.dto.topico;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class TopicoUpdateDto
{
	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String mensagem;

	public String getTitulo()
	{
		return titulo;
	}

	public String getMensagem()
	{
		return mensagem;
	}
}
