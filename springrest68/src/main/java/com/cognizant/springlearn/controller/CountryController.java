package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.entity.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService countryService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public Country getCountryIndia() {
		LOGGER.info("START!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		return context.getBean("in", Country.class);

	}

	@GetMapping
	public List<Country> getAllCountries() {
		LOGGER.info("START!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> countries = context.getBean("countryList", ArrayList.class);

		return countries;
	}

	@GetMapping("/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("START!!");
		return countryService.getCountry(code);
	}

	@PostMapping
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("START!!");
		LOGGER.debug("Country{}" + country);
		return country;
	}

}
