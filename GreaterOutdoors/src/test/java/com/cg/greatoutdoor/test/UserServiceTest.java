package com.cg.greatoutdoor.test;


import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.greatoutdoor.entity.Role;
import com.cg.greatoutdoor.entity.User;
import com.cg.greatoutdoor.exception.UserNamePasswordInvalidException;
import com.cg.greatoutdoor.exception.UserNotCreatedException;
import com.cg.greatoutdoor.exception.UserNotFoundException;
import com.cg.greatoutdoor.service.UserServiceImp;





@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest
{
   
	@Autowired
	UserServiceImp userService;

	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("All Test Cases started");
	}

	@BeforeEach
	void setup() {
		System.out.println("Test Case Started");
	}

	@AfterEach
	void tearDown() {
		System.out.println("Test Case Over");
	}

	@AfterAll
	static void setUpAfterClass() {
		System.out.println("All test cases ended.");
	}
	
	@Test
	@DisplayName("Test for adding an user")
	public void addUserTest() throws UserNotCreatedException
	{
		User user = new User(11111,"SAKICENA","pass123", Role.USER, "9090229222", "xyz@abc.com");
		assertEquals(1, userService.customerSignUp(user));
	}
	
	@Test
	@DisplayName("Test for adding an customer")
	public void addProductMasterTest() throws UserNotCreatedException {
		User user = new User(22222,"HEMANTH123","pass123", Role.PRODUCTMASTER, "9090229223", "abc@xyz.com");
		assertEquals(1, userService.createProductMaster(user));
	}
	
	@Test
	@DisplayName("Test for validating admin")
	public void adminLoginTest() throws UserNotFoundException,UserNamePasswordInvalidException
	{
		assertEquals(1, userService.validateLogin("KRISHNA1","krishna1"));
	}
	
	@Test
	@DisplayName("Test for validating goAdmin")
	public void goAdminLoginTest() throws UserNotFoundException,UserNamePasswordInvalidException
	{
		assertEquals(2, userService.validateLogin("CHAITANYA","chaitanya"));
	}
	
	@Test
	@DisplayName("Test for validating user")
	public void userLoginTest() throws UserNotFoundException,UserNamePasswordInvalidException
	{
		User user = new User(33333,"SAKICENA","pass123", Role.USER, "9090229222", "xyz@abc.com");
		userService.customerSignUp(user);
		assertEquals(3, userService.validateLogin(user.getUserName(),user.getPassword()));
	}
	
	@Test
	@DisplayName("Test for validating productMaster")
	public void productMasterLoginTest() throws UserNotFoundException,UserNamePasswordInvalidException
	{
		User user = new User(44444,"HEMANTH123","pass123", Role.PRODUCTMASTER, "9090229223", "abc@xyz.com");
		userService.createProductMaster(user);
		assertEquals(4, userService.validateLogin(user.getUserName(),user.getPassword()));
	}
	
	
}
