package br.com.arthur.projects.forum.dto;

public class TopicoError
{
	private String campo;
	private String mensagem;

	public TopicoError(String campo, String mensagem)
	{
		super();
		this.campo = campo;
		this.mensagem = mensagem;
	}

	public String getCampo()
	{
		return campo;
	}

	public String getMensagem()
	{
		return mensagem;
	}
	
	
}
