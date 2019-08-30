package com.geo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.model.Magazine;
import com.geo.model.Publication;
import com.geo.repository.MagazineRepository;
import com.geo.service.MagazineService;

@Service
public class MagazineServiceImpl implements MagazineService {

	@Autowired
	private MagazineRepository magazineRepository;
	
	@Override
	public Publication saveMagazine(Magazine magazine) {
		return magazineRepository.save(magazine);
	}

	@Override
	public Publication getMagazine(Integer magazineId) {
		return magazineRepository.findById(magazineId).get();
	}

	@Override
	public List<Publication> getMagazines() {
		return magazineRepository.findAll();
	}

}
