package com.geo.model;

public enum PublicationType {

	BOOK("Book"), MAGAZINE("Magazine"), COMICS("Comics");

	private String name;

	private PublicationType(String name) {
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
