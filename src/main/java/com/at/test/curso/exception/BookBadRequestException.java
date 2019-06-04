package com.at.test.curso.exception;

public class BookBadRequestException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1916766945710401557L;
	private static final String message = "La url que se ha usado no cumple con las especificaciones fijadas en el controlador";
	
	public BookBadRequestException() {
		super(message);
	}
}
