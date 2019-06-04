package com.at.test.curso.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.at.test.curso.dto.BookDTO;
import com.at.test.curso.exception.BookNotFoundException;
import com.at.test.curso.model.Book;

public interface BookService {
	/**
	 * 
	 * Metodo que recibe un objeto tipo DTO y devuelve un objeto Book guardado en BD
	 * 
	 * @param bookDTO
	 * @return un objeto Book Entity guardado en BD
	 * 
	 */
	Book createBook(BookDTO bookDTO);
	/**
	 * 
	 * Metodo que recibe un idBook y un objeto BookDTO y devuelve un objeto Book modificado.
	 * 
	 * @param bookDTO
	 * @param idBook
	 * 
	 * @return Objeto Book guardado en BD
	 */
	Book updateBook(Integer idBook, BookDTO bookDTO) throws BookNotFoundException;
	/**
	 * 
	 * Metodo que recibe un idBook y lo elimina de BD
	 * 
	 * @param idBook Identificador del book
	 * @return Devuelve mensaje de ok de la eliminacion del objeto
	 */
	String deleteBook(Integer idBook) throws BookNotFoundException;
	/**
	 * 
	 * Metodo que recibe un idBook y lo busca en BD
	 * 
	 * @param idBook Identificador de book
	 * @return Devuelve un objeto Book de BD
	 */
	Book getBook(Integer idBook) throws BookNotFoundException;
	/**
	 * 
	 * Metodo que recibe un String con el nombre a buscar
	 * 
	 * @param name Nombre a buscar en la tabla
	 * @return Devuelve una lista de Book con los libros que contengan el parametro indicado.
	 */
	List<Book> getBookContainsName(String name) throws BookNotFoundException;
	/**
	 * 
	 * Metodo que devuelve una Page de objeto Book
	 * 
	 * @return Page<Book>
	 */
	Page<Book> getListAllBook() ;
}
