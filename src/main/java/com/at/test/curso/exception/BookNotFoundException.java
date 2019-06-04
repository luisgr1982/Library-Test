package com.at.test.curso.exception;

public class BookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3019085000026652801L;
	
	private static final String message = "El libro buscado no se encuentra en base de datos.";
	
	public BookNotFoundException() {
		super(message);
	}
}
