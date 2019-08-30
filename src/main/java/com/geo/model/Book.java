package com.geo.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Book")
public class Book extends Publication implements Serializable {

	private static final long serialVersionUID = 1L;

	private String genre;
	
	public Book() {
	}

	public Book(String title, int year, String genre) {
		super(title, year);
		this.genre = genre;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [genre=" + genre + ", toString()=" + super.toString() + "]";
	}
	
	/**
	 * @return the authors
	 */
	public static enum BookType {

		Drama, Novel, Detective;
	}	


}
