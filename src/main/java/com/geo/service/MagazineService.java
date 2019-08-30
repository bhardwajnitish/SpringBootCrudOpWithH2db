package com.geo.service;

import java.util.List;

import com.geo.model.Magazine;
import com.geo.model.Publication;

public interface MagazineService {

	Publication saveMagazine(Magazine magazine);
	Publication getMagazine(Integer magazineId);
	List<Publication> getMagazines();
	
}
