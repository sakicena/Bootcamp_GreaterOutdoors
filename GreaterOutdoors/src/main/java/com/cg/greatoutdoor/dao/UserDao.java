package com.cg.greatoutdoor.dao;

import com.cg.greatoutdoor.entity.User;

public interface UserDao {
	

	/**
	 * Login related methods  
	 *  */
	public int validateLogin(String userName,String password);
		
	public int generateUserId(User Id);
	
	public int userExistsOrNot(String userName); //Method checks whether the user with that username exists or not while signup
	
	/** 
	 * Customer Creation or Customer SignUp related methods 
	 * */
	
	public boolean signUp(User user);
	
	public int SignUpNumberValidate(String phoneNumber);
	
	public int SignUpEmailValidate(String email);

	



}
