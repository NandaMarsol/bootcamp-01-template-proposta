package br.com.zup.apicartaobrancoproposta.exception;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionAdvice {
	
	@Autowired
	private MessageSource messagesource;
	
	@Autowired
	private Logger logger;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<String> errors = e.getBindingResult().getFieldErrors()
				.stream()
				.map(error -> messagesource.getMessage(error, Locale.getDefault()))
				.collect(Collectors.toList());
				
		
		StandardError standardError = new StandardError(errors);
		
		logger.warn("Tratando erros de MethodArgumentNotValidException: " +standardError);
		
		return ResponseEntity.badRequest().body(standardError);
	}

}
