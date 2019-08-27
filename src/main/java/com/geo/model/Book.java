package com.geo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Integer bookId;

	@Embedded
	private Publication publication;

	private String genre;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
	private List<Author> authors;


	public Book(String title, int year, String genre) {
		publication = new Publication(title, year);
		this.genre = genre;
	}

	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the publication
	 */
	public Publication getPublication() {
		return publication;
	}

	/**
	 * @param publication the publication to set
	 */
	public void setPublication(Publication publication) {
		this.publication = publication;
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

	/**
	 * @return the authors
	 */
	public List<Author> getAuthors() {
		return authors;
	}
	
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public static enum BookType {

		Drama, Novel, Detective;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", publication=" + publication + ", genre=" + genre + ", authors=" + authors
				+ "]";
	}
	
	


}
