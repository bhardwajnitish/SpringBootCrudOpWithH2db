package com.geo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "publication_type")
public class Publication implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer publicationId;

	private String title;
	private Integer year;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "publication_author", joinColumns = {
			@JoinColumn(name = "authorId", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "publicationId", nullable = false, updatable = false) })
	private List<Author> authors;

	public Publication() {
	}

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

	/**
	 * @return the publicationId
	 */
	public Integer getPublicationId() {
		return publicationId;
	}

	/**
	 * @param publicationId
	 *            the publicationId to set
	 */
	public void setPublicationId(Integer publicationId) {
		this.publicationId = publicationId;
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
	
	public void addAuthor(Author author) {
		if (authors == null) {
			authors = new ArrayList<>();
		}
		authors.add(author);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Publication [publicationId=" + publicationId + ", title=" + title + ", year=" + year + "]";
	}

	

}
