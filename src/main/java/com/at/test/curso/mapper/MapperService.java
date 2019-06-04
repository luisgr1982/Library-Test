package com.at.test.curso.mapper;

import java.util.List;

import org.springframework.data.domain.Page;

/**
 * Interfaz para mappear de DTO a Entity y viceversa.
 */
public interface MapperService <T, S>{
	/**
	 * Metodo que recibe una entidad y la mapea a dto
	 * 
	 * @param entity
	 * @return DTO
	 */
	T mapEntityToDto (S entity);
	/**
	 * 
	 * Metodo que recibe un DTO y la mapea a Entidad
	 * @param dto
	 * @return Entity
	 */
	S mapDtoToEntity (T dto);
	/**
	 * 
	 * Metodo que recibe una lista de Entity y devuelve una lista de DTO
	 * 
	 * @param listEntity Recibimos una lista de Book
	 * @return lista de BookDTO
	 */
	List<T> mapListEntityToDto(List<S> listEntity);
	/**
	 * Metodo que mapea un page de Book a BookDTO
	 * 
	 * @param pageEntity Recibimos el page de Book
	 * @return devolvemos el page de BookDTO
	 * 
	 */
	Page<T> mapPageEntitytoDto(Page<S> pageEntity);
}
