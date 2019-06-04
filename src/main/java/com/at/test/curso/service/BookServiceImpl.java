package com.at.test.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.at.test.curso.dao.BookRepository;
import com.at.test.curso.dto.BookDTO;
import com.at.test.curso.exception.BookNotFoundException;
import com.at.test.curso.mapper.MapperService;
import com.at.test.curso.model.Book;

@Component
public class BookServiceImpl implements BookService {
	@Autowired
	private MapperService<BookDTO, Book> mapper;
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book createBook(BookDTO bookDTO) {
		return bookRepository.save(Optional.ofNullable(mapper.mapDtoToEntity(bookDTO)).orElse(new Book()));
	}

	@Override
	public Book updateBook(Integer idBook, BookDTO bookDTO) throws BookNotFoundException {
		Optional<Book> book = Optional.ofNullable(bookRepository.findById(idBook)).orElseThrow(BookNotFoundException::new);
		//He tenido que poner por ultimo un try-catch porque el optional no me lanzaba la excepcion y continuaba con la ejecucion y con el get me daba un 500		
		try { 
			book.get().setId(bookDTO.getId());
			book.get().setIsbn(bookDTO.getIsbn());
			book.get().setName(bookDTO.getName());
			book.get().setPages(bookDTO.getPages());
			book.get().setSynopsis(bookDTO.getSynopsis());
			bookRepository.save(book.get());
		}
		catch (Exception e) {throw new BookNotFoundException();}
		return book.get();
	}

	@Override
	public String deleteBook(Integer idBook) throws BookNotFoundException {
		bookRepository.delete(
				Optional.ofNullable(bookRepository.findById(idBook)).get().orElseThrow(BookNotFoundException::new));
		return "Libro eliminado correctamente.";
	}

	@Override
	public Book getBook(Integer idBook) throws BookNotFoundException {
		return Optional.ofNullable(bookRepository.findById(idBook)).get().orElseThrow(BookNotFoundException::new);
	}

	@Override
	public List<Book> getBookContainsName(String name) throws BookNotFoundException {
		return Optional.ofNullable(bookRepository.findByNameIgnoreCaseContaining(name))
				.orElseThrow(BookNotFoundException::new);
	}

	@Override
	public Page<Book> getListAllBook() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<Book> pageBook = bookRepository.findAll(pageable);
		return pageBook;
	}

}
