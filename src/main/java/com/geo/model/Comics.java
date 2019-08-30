package com.geo.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Comics")
public class Comics extends Publication implements Serializable {

	private static final long serialVersionUID = 1L;

	private String hero;
	
	public Comics() {
	}

	public Comics(String title, int year, String hero) {
		super(title, year);
		this.hero = hero;
	}

	/**
	 * @return the hero
	 */
	public String getHero() {
		return hero;
	}

	/**
	 * @param hero
	 *            the hero to set
	 */
	public void setHero(String hero) {
		this.hero = hero;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comics [hero=" + hero + ", toString()=" + super.toString() + "]";
	}
		

}
