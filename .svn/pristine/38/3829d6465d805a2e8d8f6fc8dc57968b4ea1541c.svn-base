package com.yukon.atms.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@SuppressWarnings("rawtypes")
@JsonAutoDetect
public class AbsenceType {

	private final long id;
	private final String shortName;
	private final String externalReference;
	private final String category; 
	private final Map traslationName;

	public AbsenceType(long id, String shortName, String externalReference, String category, Map traslationName) {
		this.id = id;
		this.shortName = shortName;
		this.externalReference = externalReference;
		this.category = category;
		this.traslationName = traslationName;
	}

	public long getId() {
		return id;
	}

	public String getShortName() {
		return shortName;
	}

	public String getExternalReference() {
		return externalReference;
	}

	public String getCategory() {
		return category;
	}

	public Map getTraslationName() {
		return traslationName;
	}
}
