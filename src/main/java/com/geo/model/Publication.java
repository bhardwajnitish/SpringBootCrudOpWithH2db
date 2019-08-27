package com.geo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Publication implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private Integer year;
	
	public Publication(String title, Integer year) {
		this.title = title;
		this.year = year;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the year
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Publication [title=" + title + ", year=" + year + "]";
	}
	
	

}
