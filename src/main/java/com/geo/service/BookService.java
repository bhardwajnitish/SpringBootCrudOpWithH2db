package com.geo.service;

import java.util.List;

import com.geo.model.Book;

public interface BookService {

	Book saveBook(Book book);
	Book getBook(Integer bookId);
	List<Book> getBooks();
}
