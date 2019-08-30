package com.geo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.model.Book;
import com.geo.model.Publication;
import com.geo.repository.BookRepository;
import com.geo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Publication saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Publication getBook(Integer bookId) {
		return bookRepository.findById(bookId).get();
	}

	@Override
	public List<Publication> getBooks() {
		return bookRepository.findAll();
	}

}
