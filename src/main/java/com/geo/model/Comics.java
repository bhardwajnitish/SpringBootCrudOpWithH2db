package com.geo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Comics implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer comicsId;

	@Embedded
	private Publication publication;

	private String hero;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "comicses", cascade = CascadeType.PERSIST)
	private List<Author> authors;

	public Comics() {
	}

	public Comics(String title, int year, String hero) {
		publication = new Publication(title, year);
		this.hero = hero;
	}

	/**
	 * @return the comicsId
	 */
	public Integer getComicsId() {
		return comicsId;
	}

	/**
	 * @param comicsId
	 *            the comicsId to set
	 */
	public void setComicsId(Integer comicsId) {
		this.comicsId = comicsId;
	}

	/**
	 * @return the publication
	 */
	public Publication getPublication() {
		return publication;
	}

	/**
	 * @param publication
	 *            the publication to set
	 */
	public void setPublication(Publication publication) {
		this.publication = publication;
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
		//author.addComics(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Comics [comicsId=" + comicsId + ", publication=" + publication + ", hero=" + hero + ", authors="
				+ authors + "]";
	}
	
	
	

}
