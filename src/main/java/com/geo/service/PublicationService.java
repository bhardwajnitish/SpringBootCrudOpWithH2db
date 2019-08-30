package com.geo.service;

import java.util.List;

import com.geo.model.Publication;

public interface PublicationService {

	List<Publication> getPublicationsByAuthorNameAndYear(String authorName, Integer year);
}
