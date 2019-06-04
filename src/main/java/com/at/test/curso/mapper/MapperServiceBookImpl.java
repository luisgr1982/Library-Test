package com.at.test.curso.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.at.test.curso.dto.BookDTO;
import com.at.test.curso.model.Book;

@Component
public class MapperServiceBookImpl implements MapperService<BookDTO, Book>{
	
	@Override
	public BookDTO mapEntityToDto(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setIsbn(book.getIsbn());
		bookDTO.setName(book.getName());
		bookDTO.setPages(book.getPages());
		bookDTO.setSynopsis(book.getSynopsis());
		return bookDTO;
	}

	@Override
	public  Book mapDtoToEntity(BookDTO bookDTO) {
		Book bookEntity = new Book();
		bookEntity.setId(bookDTO.getId());
		bookEntity.setIsbn(bookDTO.getIsbn());
		bookEntity.setName(bookDTO.getName());
		bookEntity.setPages(bookDTO.getPages());
		bookEntity.setSynopsis(bookDTO.getSynopsis());	
		return bookEntity;
	}

	@Override
	public List<BookDTO> mapListEntityToDto(List<Book> listEntity) {
		List<BookDTO> listDTO = new ArrayList<>();
		listEntity.forEach(b -> {
			final BookDTO bookDTO = new BookDTO();
			bookDTO.setId(b.getId());
			bookDTO.setIsbn(b.getIsbn());
			bookDTO.setName(b.getName());
			bookDTO.setPages(b.getPages());
			bookDTO.setSynopsis(b.getSynopsis());
			listDTO.add(bookDTO);
		});
		return listDTO;
	}

	@Override
	public Page<BookDTO> mapPageEntitytoDto(Page<Book> pageEntity) {
		return pageEntity.map(b-> mapEntityToDto(b));
	}

}
