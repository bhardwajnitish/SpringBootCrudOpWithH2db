package com.geo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Magazine implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer magazineId;

	@Embedded
	private Publication publication;

	private String type;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "magazines")
	private List<Author> authors;

	public Magazine() {
	}

	public Magazine(String title, int year, String type) {
		publication = new Publication(title, year);
		this.type = type;
	}

	/**
	 * @return the magazineId
	 */
	public Integer getMagazineId() {
		return magazineId;
	}

	/**
	 * @param magazineId
	 *            the magazineId to set
	 */
	public void setMagazineId(Integer magazineId) {
		this.magazineId = magazineId;
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

	public static enum MagazineType {
		Printed, Online;
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
		return "Magazine [magazineId=" + magazineId + ", publication=" + publication + ", type=" + type + ", authors="
				+ authors + "]";
	}
	
	

}
