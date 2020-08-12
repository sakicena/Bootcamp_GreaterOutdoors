package com.cg.greatoutdoor.test.service;

import com.cg.greatoutdoor.test.dao.UserLoginDao;
import com.cg.greatoutdoor.test.entity.User;

public class UserLoginService{
	UserLoginDao dao;
	public UserLoginService(UserLoginDao dao)
	{
		this.dao=dao;
	}
	public String login(String username,String password)
	{
		User user=dao.getUserByUserName(username);
		if(password.equals(user.getPassword()) && user.getRole().equals("ADMIN"))
		{
			return "ADMIN LOGIN";
		}
		else if(password.equals(user.getPassword()) && user.getRole().equals("GOADMIN"))
		{
		return "GOADMIN LOGIN";
		}
		else if(password.equals(user.getPassword()) && user.getRole().equals("USER"))
		{
			return "USER LOGIN";
		}
		else if(password.equals(user.getPassword()) && user.getRole().equals("PRODUCTMASTER"))
		{
			return "PRODUCTMASTER LOGIN";
		}
		
		return "NOT VALID";
	}
	
	public String createUser(User user)
	{
	    User userObject=dao.getUserByUserId(user.getId());
	    if(userObject==null)
	    {
	    	return "User Not Added";
	    }
	    else
	    {
		return "User Added";
	    }
	}

}
