package com.geo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.model.Book;
import com.geo.repository.BookRepository;
import com.geo.service.AuthorService;
import com.geo.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorService authorService;
	
	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book getBook(Integer bookId) {
		return bookRepository.findById(bookId).get();
	}

	@Override
	public List<Book> getBooks() {
		return bookRepository.findAll();
	}

}
