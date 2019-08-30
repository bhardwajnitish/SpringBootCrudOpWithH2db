package com.geo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geo.model.Publication;

@Repository
public interface PublicationRepository extends CrudRepository<Publication, Integer> {

	List<Publication> getPublicationByAuthorNameAndYear(String authorName, Integer year);
}
