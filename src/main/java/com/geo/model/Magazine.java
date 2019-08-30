package com.geo.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Magazine")
public class Magazine extends Publication implements Serializable {

	private static final long serialVersionUID = 1L;

	private String type;

	public Magazine() {
	}

	public Magazine(String title, int year, String type) {
		super(title, year);
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Magazine [type=" + type + ", toString()=" + super.toString() + "]";
	}



	public static enum MagazineType {
		Printed, Online;
	}



}
