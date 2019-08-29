package com.geo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geo.model.Magazine;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Integer> {

}
