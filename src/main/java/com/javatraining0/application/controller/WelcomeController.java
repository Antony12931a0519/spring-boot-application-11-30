package com.javatraining0.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatraining0.application.utility.ApplicationProperties;

@RestController
public class WelcomeController {
	
	@Autowired
	ApplicationProperties applicationProperties;

	@Autowired
	private Environment env;

	@Value("${application.username}")
	private String val1;

	// @Value("$val1") private static String value1;

	@RequestMapping("/welcome/page")
	public String showWelcomeMessage() {
		return "Welcome to my Application!";
	}

	@RequestMapping("/welcome/user")
	public String showWelcomeMessageToUser() {
		// return "Welcome to my Application!" +
		// env.getProperty("application.username");
//		return "Welcome to my Application!" + val1;
		return "Welcome to my Application!" + applicationProperties.getUsername();
	}

}
