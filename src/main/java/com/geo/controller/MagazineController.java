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

import com.geo.model.Magazine;
import com.geo.service.MagazineService;

@RestController
public class MagazineController {

	@Autowired
	private MagazineService magazineService;
	
	@GetMapping("/magazine/{id}")
	public Magazine getMagazine(@PathVariable Integer id) {
		return magazineService.getMagazine(id);
	}
	
	@GetMapping("/magazines")
	public List<Magazine> getMagazines() {
		return magazineService.getMagazines();
	}
	
	@PostMapping("/magazine")
	public ResponseEntity<Magazine> addMagazine(@RequestBody Magazine magazine) {
		Magazine savedMagazine = magazineService.saveMagazine(magazine);
		return new ResponseEntity<Magazine>(savedMagazine, HttpStatus.OK);
	}
}
