package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	@GetMapping("/hello")
	public String sayHello() {
		LOGGER.info("Starting!!");
		LOGGER.info("End!!");
		return "Hello World!!";
	}
	
}
