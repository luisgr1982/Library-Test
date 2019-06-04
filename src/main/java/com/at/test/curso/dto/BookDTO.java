package com.at.test.curso.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BookDTO {
	@NotNull(message = "El campo id tiene que tener un valor")
	private int id;
	@NotNull(message = "El campo isbn tiene que tener un valor")
	private String isbn;
	@NotNull(message = "El campo name tiene que tener un valor")
	private String name;
	@NotNull(message = "El campo synopsis tiene que tener un valor")
	private String synopsis;
	@NotNull(message = "EL campo pages tiene que tener un valor")
	private String pages;
}
