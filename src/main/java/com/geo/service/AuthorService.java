package com.geo.service;

import java.util.List;

import com.geo.model.Author;

public interface AuthorService {
	
	Author saveAuthor(Author author);
	
	Author getAuthor(Integer authorId);
	
	List<Author> getAuthors();
}
