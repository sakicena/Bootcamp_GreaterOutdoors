package com.cg.greatoutdoor.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.greatoutdoor.entity.Role;
import com.cg.greatoutdoor.entity.User;

@Transactional
@Repository
public class UserImp implements UserDao{
	
	@PersistenceContext
	EntityManager entityManagerObject;
	 
	static int userIdNumber=10001;
	
	
	
	public boolean signUp(User user) 
	{
		
			entityManagerObject.persist(user);
			if (entityManagerObject.find(User.class, user.getUserId()) != null)
			{
				return true;
			} 
			else
			{
				return false;
			}
	}
	
    @Override
    public int generateUserId(User id) 
        {
    	  
    	String qStr1 = "SELECT userName FROM User";
    	TypedQuery<String> query = entityManagerObject.createQuery(qStr1, String.class);
    	List<String> user = query.getResultList();
    	if ( !user.contains(id.getUserName())) {
    		String Str = "SELECT max(userId) FROM User";
    		TypedQuery<Integer> query1 = entityManagerObject.createQuery(Str, Integer.class);
    		int num = query1.getSingleResult();
    		return num; 
    	} else if (user.isEmpty()) {
    		return userIdNumber; 
    	} else {
    		return 0; 
    	}

        }


	public int validateLogin(String userName,String password)
	{
	 
	
		List<User> passList = new ArrayList<User>();
		
		String str = "select login from User login where login.userName = :name";
		TypedQuery<User> query = entityManagerObject.createQuery(str,User.class);
		query.setParameter("name",userName);
		
		passList = query.getResultList();
	
		
		if(passList.size()>0)
		{
		if(passList.get(0).getPassword().equals(password) && passList.get(0).getRole().equals(Role.ADMIN) )
			return 1;
		
		else if(passList.get(0).getPassword().equals(password) && passList.get(0).getRole().equals(Role.GOADMIN) )
			return 2;
		
		else if(passList.get(0).getPassword().equals(password) && passList.get(0).getRole().equals(Role.USER) )
			return 3;
		
		else if(passList.get(0).getPassword().equals(password) && passList.get(0).getRole().equals(Role.PRODUCTMASTER))
			return 4;
		
		else 
		  return 0;
		}
		else
		{
			return 0;
		}
		
		
    }
	
	

        public int userExistsOrNot(String userName) {
        	
        	List<User> passList = new ArrayList<User>();
        	String str = "select login from User login where login.userName = :name";
    		TypedQuery<User> query = entityManagerObject.createQuery(str,User.class);
    		query.setParameter("name",userName);
    		
    		passList = query.getResultList();
    		if(passList.size()>0) {
    			return 1;
    		}
    		else 
    			return 0;
        	
        	
        }

       public int SignUpNumberValidate(String mobileNumber) 
       {
        	
        	List<User> passList = new ArrayList<User>();
        	String str = "select login from User login where login.phoneNumber = :number";
    		TypedQuery<User> query = entityManagerObject.createQuery(str,User.class);
    		query.setParameter("number",mobileNumber);
    		passList = query.getResultList();
    	
    		if(passList.size()>0) 
    			return 1;
    		else 
    			return 0;
        	
        }
    
       public int SignUpEmailValidate(String email) 
       {
        	
        	List<User> passList = new ArrayList<User>();
        	String str = "select login from User login where login.email = :emailid";
    		TypedQuery<User> query = entityManagerObject.createQuery(str,User.class);
    		query.setParameter("emailid",email);
    		passList = query.getResultList();
    	
    		if(passList.size()>0) 
    			return 1;
    		else 
    			return 0;
        	
        }

    
	
    public List<User> getUserList() 
    {
   	    List<User> passList = new ArrayList<User>();
		String str = "select login from User login";
		TypedQuery<User> query = entityManagerObject.createQuery(str,User.class);
		passList = query.getResultList();
		 
		return passList;
   	 
     }



}
