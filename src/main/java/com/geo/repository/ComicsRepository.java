package com.geo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.geo.model.Publication;

@Service
public interface ComicsRepository extends JpaRepository<Publication, Integer>{

}
