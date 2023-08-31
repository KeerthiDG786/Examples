package com.mob.sts.Exception;

import org.springframework.http.HttpStatus;

/**
 * 
 */
public class StudentDetailsNotFound extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
    private HttpStatus status;
	public StudentDetailsNotFound(String message,HttpStatus status) {
		super();
		this.message = message;
		this.status=status;
	}

	
	public HttpStatus getStatus() {
		return status;
	}


	public String getMessage() {
		return message;
	}


	
    
	

}
