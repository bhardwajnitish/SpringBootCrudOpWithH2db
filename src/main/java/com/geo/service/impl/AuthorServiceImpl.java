package com.geo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.model.Author;
import com.geo.repository.AuthorRepository;
import com.geo.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
		
	}

	@Override
	public Author getAuthor(Integer authorId) {
		return authorRepository.findById(authorId).get();
	}

	@Override
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	

}
