package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.entity.Country;

@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("Inside main!!");
//		displayDate();
//		displayCountry();
//		displayCountries();
	}

	public static void displayDate() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			LOGGER.debug(format.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		LOGGER.info("END!!");
	}
	
	private static void displayCountry() {
		LOGGER.info("START!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = context.getBean("in", Country.class);

		LOGGER.debug("Country : {}", country);
		LOGGER.info("END!!");
	}
	
	public static void displayCountries() {
		LOGGER.info("START!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List<Country> countryList = context.getBean("countryList", ArrayList.class);

		LOGGER.debug("CountryList : {}", countryList);
		LOGGER.info("END!!");
	}

}
