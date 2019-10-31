package com.javatraining0.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class WelcomeController {

	// @Path//@producs// @Consumes @Get

	@RequestMapping("/welcome/page")
	public String showWelcomeMessage() {
		return "Welcome to my Application!";
	}

	/*@RequestMapping(value = "/books/total", produces = "application/json", method = { RequestMethod.GET })
	public String get() {
		return "The totabl books in the lib are :" + 500;

	}
	@RequestMapping(value = "/books/total", produces = "application/json", method = { RequestMethod.GET })
	public String getTotalNoOfBooks() {
		return "The totabl books in the lib are :" + 500;

	}
	@RequestMapping(value = "/books/total", produces = "application/json", method = { RequestMethod.GET })
	public String getTotalNoOfBooks() {
		return "The totabl books in the lib are :" + 500;

	}
	@RequestMapping(value = "/books/total", produces = "application/json", method = { RequestMethod.GET })
	public String getTotalNoOfBooks() {
		return "The totabl books in the lib are :" + 500;

	}*/

}
