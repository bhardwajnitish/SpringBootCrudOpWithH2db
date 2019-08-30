package com.geo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geo.model.Publication;

@Repository
public interface BookRepository extends JpaRepository<Publication, Integer> {

}
