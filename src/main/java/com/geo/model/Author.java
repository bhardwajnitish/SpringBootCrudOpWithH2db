package com.geo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer authorId;

	private String name;

	public Author() {
	}

	public Author(String name) {
		super();
		this.name = name;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "authors")
	private List<Publication> publications;

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
	 * @return the publications
	 */
	public List<Publication> getPublications() {
		return publications;
	}

	/**
	 * @param publications
	 *            the publications to set
	 */
	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public void addPublication(Publication publication) {
		if (this.publications == null) {
			this.publications = new ArrayList<>();
		}
		this.publications.add(publication);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + ", publications=" + publications + "]";
	}

}
