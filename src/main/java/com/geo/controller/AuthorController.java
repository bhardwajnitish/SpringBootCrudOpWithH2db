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

import com.geo.model.Author;
import com.geo.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping(value = "/")
	public String sayHello() {
		return "I am live and running on ";
	}

	@GetMapping("/authors")
	public List<Author> getAuthors() {
		List<Author> authors =  authorService.getAuthors();
		System.out.println("Authors = " + authors.size());
		return authors;
	}
	
	@GetMapping("/author/{authorId}")
	public Author getAuthor(@PathVariable Integer authorId) {
		Author author =  authorService.getAuthor(authorId);
		return author;
	}

	@PostMapping("/authors")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
		Author persistedAuthor = authorService.saveAuthor(author);
		System.out.println("Saved author  = " + author);
		return new ResponseEntity<Author>(persistedAuthor, HttpStatus.OK);
	}

}
