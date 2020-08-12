package com.cg.greatoutdoor.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.greatoutdoor.GreaterOutdoorsApplication;
import com.cg.greatoutdoor.entity.User;
import com.cg.greatoutdoor.service.UserService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
    
	Logger logger = LoggerFactory.getLogger(GreaterOutdoorsApplication.class);
	String message;
	
	@GetMapping("/Login/Validate/{name}/{password}") 
	public int validateLogin(@PathVariable String name,@PathVariable String password) throws Exception
	{
    	
    	message="Successfully Logged in";
    	logger.info(message);
		return userService.validateLogin(name, password);
	}

	
	@PostMapping("/SignUp/Register")
	public ResponseEntity<String> customerSignUp(@RequestBody User userobject) throws Exception
	{
	
        userService.customerSignUp(userobject);
    	message="User Successfully Registered";
    	logger.info(message);
        
        
		return new ResponseEntity<String>("User Successfully Created",HttpStatus.OK);
	}
	
	@PostMapping("/Admin/CreateProductMaster")
	public ResponseEntity<String> createProductMaster(@RequestBody User userobject) throws Exception
	{
        userService.createProductMaster(userobject);
    	message="Product Master Successfully Registered";
    	logger.info(message);
        
		return new ResponseEntity<String>("Product Master Successfully Created",HttpStatus.OK);
	}
	


}
