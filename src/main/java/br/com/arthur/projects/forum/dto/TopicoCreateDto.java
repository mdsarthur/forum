package br.com.arthur.projects.forum.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.arthur.projects.forum.model.Curso;
import br.com.arthur.projects.forum.model.Topico;

public class TopicoCreateDto
{
	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String mensagem;
	
	@NotNull @NotEmpty
	private String nomeCurso;
	
	public String getTitulo()
	{
		return titulo;
	}
	
	public String getMensagem()
	{
		return mensagem;
	}
	
	public String getNomeCurso()
	{
		return nomeCurso;
	}
	
	public Topico convertToTopico(Curso curso)
	{
		return new Topico(this.titulo, this.mensagem, curso);
	}
	
}
