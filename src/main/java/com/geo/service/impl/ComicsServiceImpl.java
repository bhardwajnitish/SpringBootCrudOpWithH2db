package com.geo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.model.Comics;
import com.geo.repository.ComicsRepository;
import com.geo.service.AuthorService;
import com.geo.service.ComicsService;

@Service
public class ComicsServiceImpl implements ComicsService {

	@Autowired
	private ComicsRepository comicsRepository;

	@Autowired
	private AuthorService authorService;

	@Override
	public Comics saveComics(Comics comics) {
		return comicsRepository.save(comics);
	}

	@Override
	public Comics getComics(Integer comicsId) {
		return comicsRepository.findById(comicsId).orElse(new Comics(null, 0, null));
	}

	@Override
	public List<Comics> getComicss() {
		return comicsRepository.findAll();
	}

}
