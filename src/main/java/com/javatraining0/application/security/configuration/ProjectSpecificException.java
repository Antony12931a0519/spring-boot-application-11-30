package com.javatraining0.application.security.configuration;

public class ProjectSpecificException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public ProjectSpecificException(String message) {
//		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "ProjectSpecificException [message=" + message + "]";
	}
	
	

	
	
	
	

}
