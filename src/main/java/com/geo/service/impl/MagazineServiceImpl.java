package com.geo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.model.Magazine;
import com.geo.repository.MagazineRepository;
import com.geo.service.AuthorService;
import com.geo.service.MagazineService;

@Service
public class MagazineServiceImpl implements MagazineService {

	@Autowired
	private MagazineRepository magazineRepository;
	
	@Autowired
	private AuthorService authorService;

	@Override
	public Magazine saveMagazine(Magazine magazine) {
		return magazineRepository.save(magazine);
	}

	@Override
	public Magazine getMagazine(Integer magazineId) {
		return magazineRepository.findById(magazineId).get();
	}

	@Override
	public List<Magazine> getMagazines() {
		return magazineRepository.findAll();
	}

}
