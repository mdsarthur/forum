package br.com.arthur.projects.forum.dto.topico;

public class TopicoErrorDto
{
	private String campo;
	private String mensagem;

	public TopicoErrorDto(String campo, String mensagem)
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
