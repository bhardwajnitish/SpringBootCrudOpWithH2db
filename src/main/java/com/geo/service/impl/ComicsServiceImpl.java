package com.geo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.geo.model.Comics;
import com.geo.model.Publication;
import com.geo.repository.ComicsRepository;
import com.geo.service.ComicsService;

@Repository
public class ComicsServiceImpl implements ComicsService {

	@Autowired
	private ComicsRepository comicsRepository;

	@Override
	public Comics saveComics(Comics comics) {
		return comicsRepository.save(comics);
	}

	@Override
	public Publication getComics(Integer comicsId) {
		return comicsRepository.findById(comicsId).get();
	}

	@Override
	public List<Publication> getComicss() {
		return comicsRepository.findAll();
	}

}
