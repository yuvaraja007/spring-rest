package com.cognizant.springlearn.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Country {

	@NotNull
	@Size(min = 2, max = 2, message = "Country code should be 2 characters")
	private String code;
	private String name;

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

	public Country() {
		super();
		LOGGER.debug("“Inside Country Constructor.");
	}

	public String getCode() {
		LOGGER.debug("Inside code getter");
		return code;
	}

	public void setCode(String code) {
		LOGGER.debug("Inside code setter");
		this.code = code;
	}

	public String getName() {
		LOGGER.debug("Inside name getter");
		return name;
	}

	public void setName(String name) {
		LOGGER.debug("Inside name setter");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
