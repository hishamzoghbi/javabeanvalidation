package de.adesso.beanvalidation.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		 BindingResult bindingResult = ex.getBindingResult();
		    List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		    List<String> errors = fieldErrors
		            .stream()
		            .map(err -> err.getField() + ":" + err.getDefaultMessage())
		            .collect(Collectors.toList());
		    return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}

}
