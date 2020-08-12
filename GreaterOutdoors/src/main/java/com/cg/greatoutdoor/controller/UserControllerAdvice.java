package com.cg.greatoutdoor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.greatoutdoor.exception.ContactExistsException;
import com.cg.greatoutdoor.exception.EmailExistsException;
import com.cg.greatoutdoor.exception.UserNameExistsException;
import com.cg.greatoutdoor.exception.UserNamePasswordInvalidException;
import com.cg.greatoutdoor.exception.UserNotCreatedException;
import com.cg.greatoutdoor.exception.UserNotFoundException;



@ControllerAdvice
public class UserControllerAdvice {
	
	@ExceptionHandler(UserNamePasswordInvalidException.class)
    public final ResponseEntity<String> exceptionHandler( UserNamePasswordInvalidException exception) 
    {
       
     System.out.println();
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(UserNotCreatedException.class)
    public final ResponseEntity<String> exceptionHandler( UserNotCreatedException exception) 
    {
       
     System.out.println();
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<String> exceptionHandler( UserNotFoundException exception) 
    {
       
     System.out.println();
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
	
	

	
	
	@ExceptionHandler(ContactExistsException.class)
    public final ResponseEntity<String> exceptionHandler( ContactExistsException exception) 
    {
       
     System.out.println();
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(EmailExistsException.class)
    public final ResponseEntity<String> exceptionHandler( EmailExistsException exception) 
    {
       
     System.out.println();
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(UserNameExistsException.class)
    public final ResponseEntity<String> exceptionHandler( UserNameExistsException exception) 
    {
       
     System.out.println();
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
	
	
	
	

}
