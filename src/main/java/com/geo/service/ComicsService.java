package com.geo.service;

import java.util.List;

import com.geo.model.Comics;

public interface ComicsService {

	Comics saveComics(Comics comics);
	Comics getComics(Integer comicsId);
	List<Comics> getComicss();
}
