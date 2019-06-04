package com.at.test.curso.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.at.test.curso.dto.BookDTO;
import com.at.test.curso.exception.BookBadRequestException;
import com.at.test.curso.exception.BookNotFoundException;
import com.at.test.curso.mapper.MapperService;
import com.at.test.curso.model.Book;
import com.at.test.curso.service.BookService;


@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	private MapperService<BookDTO, Book> mapper;
	@Autowired
	private BookService bookService;
	
	@ResponseBody
	@RequestMapping("/all")
	public Page<BookDTO> getAllBooks(){ 
		return mapper.mapPageEntitytoDto(bookService.getListAllBook());
	}
	@GetMapping("/{id}")
	public ResponseEntity<BookDTO> getBook(@PathVariable("id") Integer idBook) throws BookNotFoundException{
		return new ResponseEntity<BookDTO>(mapper.mapEntityToDto(bookService.getBook(idBook)), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) throws BookBadRequestException {
		if (bookDTO.getIsbn()=="")throw new BookBadRequestException();
		return new ResponseEntity<BookDTO>(mapper.mapEntityToDto(bookService.createBook(bookDTO)),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") Integer idBook) throws BookNotFoundException{
		return new ResponseEntity<String>(bookService.deleteBook(idBook), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookDTO> putBook(@PathVariable("id") Integer idBook, @Valid @RequestBody BookDTO bookDTO) throws BookNotFoundException {
		return new ResponseEntity<BookDTO>(mapper.mapEntityToDto(bookService.updateBook(idBook, bookDTO)),HttpStatus.OK);
	}
	@GetMapping
	public ResponseEntity<List<BookDTO>> getListContainsName(@RequestParam(name = "name") String name) throws BookNotFoundException {
		return new ResponseEntity<List<BookDTO>>(mapper.mapListEntityToDto(bookService.getBookContainsName(name)), HttpStatus.OK);
	}
}
