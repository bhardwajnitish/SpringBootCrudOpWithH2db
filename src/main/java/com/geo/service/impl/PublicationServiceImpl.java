package com.geo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geo.model.Publication;
import com.geo.repository.PublicationRepository;
import com.geo.service.PublicationService;

@Service
public class PublicationServiceImpl implements PublicationService {

	@Autowired
	private PublicationRepository publicationRepository;

	@Override
	public List<Publication> getPublicationsByAuthorNameAndYear(String authorName, Integer year) {
		return publicationRepository.getPublicationByAuthorNameAndYear(authorName, year);
	}
	
	
}
