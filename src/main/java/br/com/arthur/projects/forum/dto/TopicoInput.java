package br.com.arthur.projects.forum.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.arthur.projects.forum.model.Curso;
import br.com.arthur.projects.forum.model.Topico;

public class TopicoInput
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
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	public String getMensagem()
	{
		return mensagem;
	}
	public void setMensagem(String mensagem)
	{
		this.mensagem = mensagem;
	}
	public String getNomeCurso()
	{
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso)
	{
		this.nomeCurso = nomeCurso;
	}
	
	public Topico convertToTopico(Curso curso)
	{
		return new Topico(this.titulo, this.mensagem, curso);
	}
	
}
