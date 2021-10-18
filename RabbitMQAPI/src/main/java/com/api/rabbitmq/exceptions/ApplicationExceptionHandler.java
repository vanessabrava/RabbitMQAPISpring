package com.api.rabbitmq.exceptions;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.api.rabbitmq.dto.ExceptionDTO;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionDTO> handleException(RuntimeException e){
		ExceptionDTO erro = new ExceptionDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return new ResponseEntity<ExceptionDTO>(erro, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ExceptionDTO> handleException(ConstraintViolationException e){
		ExceptionDTO erro = new ExceptionDTO(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return new ResponseEntity<ExceptionDTO>(erro, HttpStatus.BAD_REQUEST);
	}
	
}
