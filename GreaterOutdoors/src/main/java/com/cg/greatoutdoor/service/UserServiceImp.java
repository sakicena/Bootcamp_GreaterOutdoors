package com.cg.greatoutdoor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.greatoutdoor.dao.UserDao;
import com.cg.greatoutdoor.entity.Role;
import com.cg.greatoutdoor.entity.User;
import com.cg.greatoutdoor.exception.ContactExistsException;
import com.cg.greatoutdoor.exception.EmailExistsException;
import com.cg.greatoutdoor.exception.UserNameExistsException;
import com.cg.greatoutdoor.exception.UserNamePasswordInvalidException;
import com.cg.greatoutdoor.exception.UserNotCreatedException;
import com.cg.greatoutdoor.exception.UserNotFoundException;



@Service
public class UserServiceImp implements UserService {
     
	@Autowired
	UserDao userDao;
	
	@Override
	public int customerSignUp(User user) throws UserNotCreatedException{
		
		int numberStatus=userDao.SignUpNumberValidate(user.getPhoneNumber());
		int emailStatus=userDao.SignUpEmailValidate(user.getEmail());
		int userNameStatus=userDao.userExistsOrNot(user.getUserName());
		if(numberStatus==1)
		{
		
			throw new ContactExistsException("Mobile Number already used,try with different number ");
		}
		
		else if(emailStatus==1)
		{
			throw new EmailExistsException("Email already used ,try with different Email Id");
		}
	    	
		else if(userNameStatus==1) 
		{
			throw new UserNameExistsException("UserName already taken ,try different UserName");
		}
	
		else
		{
		
		
		    int userIdNumber=userDao.generateUserId(user);	
			user.setUserId(userIdNumber+1);
			user.setRole(Role.USER);
			boolean status = userDao.signUp(user);			
			if(status==true)
			{
				return 1;
			}
			else
			{
				 throw new UserNotCreatedException("Unable to Create User");
				}
		

		}
		
		
		
		
	}
	
	
	@Override
	public int createProductMaster(User user) throws UserNotCreatedException{
		
		int numberStatus=userDao.SignUpNumberValidate(user.getPhoneNumber());
		int emailStatus=userDao.SignUpEmailValidate(user.getEmail());
		int userNameStatus=userDao.userExistsOrNot(user.getUserName());
		if(numberStatus==1)
		{
		
			throw new ContactExistsException("Mobile Number already used,try with different number ");
		}
		
		else if(emailStatus==1)
		{
			throw new EmailExistsException("Email already used ,try with different Email Id");
		}
	    	
		else if(userNameStatus==1) 
		{
			throw new UserNameExistsException("UserName already taken ,try different UserName");
		}
	
		else
		{
		
		
		    int userIdNumber=userDao.generateUserId(user);	
			user.setUserId(userIdNumber+1);
			user.setRole(Role.PRODUCTMASTER);;
			boolean status = userDao.signUp(user);			
			if(status==true)
			{
				return 1;
			}
			else
			{
				 throw new UserNotCreatedException("Unable to Create Product Master");
			}
		

		}
		
		
		
		
	}

	
	public int validateLogin(String userName,String password)
	{
		     int user=userDao.userExistsOrNot(userName);
		     int user1=userDao.validateLogin(userName, password);
	         if(user==0) 
	                    {
		                      throw new UserNotFoundException("User does not exist");	
	                    }
	         else
	                    {	
	        	 
	        	            if(user1==0) {

                                throw new UserNamePasswordInvalidException(" Password Invalid");
	        	            }
	
		                  return userDao.validateLogin(userName, password);
	                    }
      }

	
}
