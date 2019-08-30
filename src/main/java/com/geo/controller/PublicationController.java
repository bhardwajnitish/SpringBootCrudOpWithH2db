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
import com.geo.model.Comics;
import com.geo.model.Magazine;
import com.geo.model.Publication;
import com.geo.service.BookService;
import com.geo.service.ComicsService;
import com.geo.service.MagazineService;
import com.geo.service.PublicationService;

@RestController
public class PublicationController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private ComicsService comicsService;
	
	@Autowired
	private MagazineService magazineService;
	
	@Autowired
	private PublicationService publicationService;

	@GetMapping("/book/{id}")
	public Publication getBook(@PathVariable Integer id) {
		return bookService.getBook(id);
	}

	@GetMapping("/books")
	public List<Publication> getBooks() {
		return bookService.getBooks();
	}

	@PostMapping("/book")
	public ResponseEntity<Publication> addBook(@RequestBody Book book) {
		Publication savedBook = bookService.saveBook(book);
		return new ResponseEntity<Publication>(savedBook, HttpStatus.OK);
	}

	@GetMapping("/magazine/{id}")
	public Publication getMagazine(@PathVariable Integer id) {
		return magazineService.getMagazine(id);
	}

	@GetMapping("/magazines")
	public List<Publication> getMagazines() {
		return magazineService.getMagazines();
	}

	@PostMapping("/magazine")
	public ResponseEntity<Publication> addMagazine(@RequestBody Magazine magazine) {
		Publication savedMagazine = magazineService.saveMagazine(magazine);
		return new ResponseEntity<Publication>(savedMagazine, HttpStatus.OK);
	}

	@GetMapping("/comics/{id}")
	public Publication getComics(@PathVariable Integer id) {
		return comicsService.getComics(id);
	}

	@GetMapping("/comicses")
	public List<Publication> getComicss() {
		return comicsService.getComicss();
	}

	@PostMapping("/comics")
	public ResponseEntity<Publication> addComics(@RequestBody Comics comics) {
		Publication savedComics = comicsService.saveComics(comics);
		return new ResponseEntity<Publication>(savedComics, HttpStatus.OK);
	}
	
	@GetMapping("/publications/author/{authorName}/year/{year}")
	public List<Publication> getPublicationsByAuthorNameAndYear(@PathVariable String authorName, @PathVariable Integer year) {
		return publicationService.getPublicationsByAuthorNameAndYear(authorName, year);
	}
}
