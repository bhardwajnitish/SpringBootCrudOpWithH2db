package com.geo.service;

import java.util.List;

import com.geo.model.Comics;
import com.geo.model.Publication;

public interface ComicsService {

	Publication saveComics(Comics comics);
	Publication getComics(Integer comicsId);
	List<Publication> getComicss();
}
