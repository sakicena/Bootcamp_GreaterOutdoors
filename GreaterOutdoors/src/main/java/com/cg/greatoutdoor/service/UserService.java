package com.cg.greatoutdoor.service;

import com.cg.greatoutdoor.entity.User;

public interface UserService {

		
		public int validateLogin(String userName,String password);
		
		public int customerSignUp(User user);
		
		public int createProductMaster(User user);

}
