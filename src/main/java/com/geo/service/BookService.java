package com.geo.service;

import java.util.List;

import com.geo.model.Book;
import com.geo.model.Publication;

public interface BookService {

	Publication saveBook(Book book);
	Publication getBook(Integer bookId);
	List<Publication> getBooks();
}
