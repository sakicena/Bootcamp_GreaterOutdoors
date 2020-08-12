package com.cg.greatoutdoor.exception;

public class ContactExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ContactExistsException(String message) {
		super(message);
	}
	
	public ContactExistsException(String message,Throwable t)
	{
		super(message,t);
	}
	
	
	
}
