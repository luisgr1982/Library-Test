package com.at.test.curso.controller;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.at.test.curso.exception.BookBadRequestException;
import com.at.test.curso.exception.BookNotFoundException;
import com.at.test.curso.exception.Error;

@ControllerAdvice
public class ExceptionController {
	private Error errorDetail;
	
	@ResponseBody
	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Error> bookNotFoundException(BookNotFoundException ex, WebRequest request) {
		errorDetail = new Error(new Date(),ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Error>(errorDetail, HttpStatus.NOT_FOUND);
	}

	@ResponseBody
	@ExceptionHandler(BookBadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Error> bookBadRequestException(BookBadRequestException ex, WebRequest request) {
		errorDetail = new Error(new Date(),ex.getMessage(), request.getDescription(false));		
		return new ResponseEntity<Error>(errorDetail, HttpStatus.BAD_REQUEST);
	}

}
