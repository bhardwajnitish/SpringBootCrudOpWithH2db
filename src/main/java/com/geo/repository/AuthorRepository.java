package com.geo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geo.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
