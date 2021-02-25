package br.com.arthur.projects.forum.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import br.com.arthur.projects.forum.dto.NoHandlerDto;
import br.com.arthur.projects.forum.dto.TopicoErrorDto;

@RestControllerAdvice
public class ExceptionResolver
{
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<TopicoErrorDto> validationHandler(MethodArgumentNotValidException exception)
	{
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		List<TopicoErrorDto> dto = new ArrayList<>();
		
		for (FieldError erro : fieldErrors)
		{
			String mensagem = messageSource.getMessage(erro, LocaleContextHolder.getLocale());
			dto.add(new TopicoErrorDto(erro.getField(), mensagem));
		}		
		return dto;
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoHandlerFoundException.class)
	public NoHandlerDto noHandler(NoHandlerFoundException exception)
	{		
		return new NoHandlerDto(exception.getHttpMethod().toString(), exception.getRequestURL());
	}
}