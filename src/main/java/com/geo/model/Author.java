package com.geo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer authorId;

	private String name;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "author_book", joinColumns = {
			@JoinColumn(name = "authorId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "bookId", nullable = false, updatable = false) })
	private List<Book> books;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "author_magazine", joinColumns = {
			@JoinColumn(name = "authorId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "magazineId", nullable = false, updatable = false) })
	private List<Magazine> magazines;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "author_magazine", joinColumns = {
			@JoinColumn(name = "authorId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "comicsId", nullable = false, updatable = false) })
	private List<Comics> comicses;

	/**
	 * @return the authorId
	 */
	public Integer getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId
	 *            the authorId to set
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	/**
	 * @return the magazines
	 */
	public List<Magazine> getMagazines() {
		return magazines;
	}

	/**
	 * @param magazines the magazines to set
	 */
	public void setMagazines(List<Magazine> magazines) {
		this.magazines = magazines;
	}

	/**
	 * @return the comicses
	 */
	public List<Comics> getComicses() {
		return comicses;
	}

	/**
	 * @param comicses the comicses to set
	 */
	public void setComicses(List<Comics> comicses) {
		this.comicses = comicses;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + ", books=" + books + ", magazines=" + magazines
				+ ", comicses=" + comicses + "]";
	}	
	
	

}
