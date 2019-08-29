package com.geo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geo.model.Book;
import com.geo.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable Integer id) {
		return bookService.getBook(id);
	}
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		return bookService.getBooks();
	}
	
	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book savedBook = bookService.saveBook(book);
		return new ResponseEntity<Book>(savedBook, HttpStatus.OK);
	}
}
