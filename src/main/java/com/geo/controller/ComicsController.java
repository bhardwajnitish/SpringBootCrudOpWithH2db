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

import com.geo.model.Comics;
import com.geo.service.ComicsService;

@RestController
public class ComicsController {

	@Autowired
	private ComicsService comicsService;
	
	@GetMapping("/comics/{id}")
	public Comics getComics(@PathVariable Integer id) {
		return comicsService.getComics(id);
	}
	
	@GetMapping("/comicses")
	public List<Comics> getComicss() {
		return comicsService.getComicss();
	}
	
	@PostMapping("/comics")
	public ResponseEntity<Comics> addComics(@RequestBody Comics comics) {
		Comics savedComics = comicsService.saveComics(comics);
		return new ResponseEntity<Comics>(savedComics, HttpStatus.OK);
	}
}



