package com.cg.greatoutdoor.test.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.greatoutdoor.test.entity.User;



public class UserLoginDao {
	public User getUserByUserName(String name)
	{
		List<User> userlist=new ArrayList<>();
		for(User user:userlist)
		{
			if(name==user.getUsername())
			{
				return user;
			}
		}
		return null;
		
	}
	
	public User getUserByUserId(int id)
	{
		List<User> userlist=new ArrayList<>();
		for(User user:userlist)
		{
			if(id==user.getId())
			{
				return user;
			}
		}
		return null;
		
	}
	
}
