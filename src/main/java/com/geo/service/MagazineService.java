package com.geo.service;

import java.util.List;

import com.geo.model.Magazine;

public interface MagazineService {

	Magazine saveMagazine(Magazine magazine);
	Magazine getMagazine(Integer magazineId);
	List<Magazine> getMagazines();
	
}
