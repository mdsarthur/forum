package br.com.arthur.projects.forum.dto;

public class NoHandlerDto
{
	private String methodName;
	private String urlPath;
	
	public NoHandlerDto(String methodName, String urlPath)
	{
		super();
		this.methodName = methodName;
		this.urlPath = urlPath;
	}

	public String getMethodName()
	{
		return methodName;
	}

	public String getUrlPath()
	{
		return urlPath;
	}	
}
