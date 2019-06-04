package com.at.test.curso.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.at.test.curso.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	/**
	 * Metodo que devuelve una lista de libros que contenga en el titulo el parametro pasado por valor
	 * 
	 * @param name Palabra a buscar en el campo Name
	 * 
	 * @return Devuelve lista de libros que contengan la palabra pasada por parametro
	 */
	public List<Book> findByNameIgnoreCaseContaining(String name);
	
	public Page<Book> findAll(Pageable pageable);
}
