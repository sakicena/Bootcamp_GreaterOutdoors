package com.cg.greatoutdoor.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cg.greatoutdoor.test.dao.UserLoginDao;
import com.cg.greatoutdoor.test.entity.User;
import com.cg.greatoutdoor.test.service.UserLoginService;

public class MockitoTesting
{
		UserLoginDao dao=Mockito.mock(UserLoginDao.class);
		UserLoginService service=new UserLoginService(dao);
		
		
		
		
		@Test
		@DisplayName("Test for Admin Login")
		public void addTest()
		{
			User user=new User();
			user.setId(1);
			user.setUsername("Admin");
			user.setPassword("Admin@123");
			user.setRole("ADMIN");
			user.setEmail("saijavvadi98@gmail.com");
			user.setPhoneNumber("7330857377");
			when(dao.getUserByUserName("Admin")).thenReturn(user);
			assertEquals("ADMIN LOGIN",service.login("Admin", "Admin@123") );
		} 
		@Test
		@DisplayName("Test for Goadmin Login")
		public void addTest1()
		{
			User user=new User();
			user.setId(1);
			user.setUsername("Goadmin");
			user.setPassword("Goadmin@123");
			user.setRole("GOADMIN");
			user.setEmail("saijavvadi98@gmail.com");
			user.setPhoneNumber("7330857377");
			when(dao.getUserByUserName("Goadmin")).thenReturn(user);
			assertEquals("GOADMIN LOGIN",service.login("Goadmin", "Goadmin@123") );
		} 
		@Test
		@DisplayName("Test for User Login")
		public void addTest2()
		{
			User user=new User();
			user.setId(1);
			user.setUsername("User");
			user.setPassword("User@123");
			user.setRole("USER");
			user.setEmail("saijavvadi98@gmail.com");
			user.setPhoneNumber("7330857377");
			when(dao.getUserByUserName("User")).thenReturn(user);
			assertEquals("USER LOGIN",service.login("User", "User@123") );
		} 
		@Test
		@DisplayName("Test for ProductMaster Login")
		public void addTest3()
		{
			User user=new User();
			user.setId(1);
			user.setUsername("ProductMaster");
			user.setPassword("ProductMaster@123");
			user.setRole("PRODUCTMASTER");
			user.setEmail("saijavvadi98@gmail.com");
			user.setPhoneNumber("7330857377");
			when(dao.getUserByUserName("ProductMaster")).thenReturn(user);
			assertEquals("PRODUCTMASTER LOGIN",service.login("ProductMaster", "ProductMaster@123") );
		} 
		
		@Test
		@DisplayName("Test for checking invalid Login")
		public void addTest4()
		{
			User user=new User();
			user.setId(1);
			user.setUsername("Admin");
			user.setPassword("Admin@123");
			user.setRole("ADMIN");
			user.setEmail("saijavvadi98@gmail.com");
			user.setPhoneNumber("7330857377");
			when(dao.getUserByUserName("Admin")).thenReturn(user);
			assertEquals("NOT VALID",service.login("Admin", "Admin1@123") );
		} 
		
		@Test
		@DisplayName("Test for adding an User")
		public void addTest5()
		{
			User user=new User(1,"saki","asdfghjk","USER","asdfg@gmail.cm","7418529638");
			when(dao.getUserByUserId(1)).thenReturn(user);
			assertEquals("User Added",service.createUser(user)) ;  
		}
		
		@Test
		@DisplayName("Test for adding an Empty User")
		public void addTest6()
		{
			User user = new User();
			when(dao.getUserByUserId(1)).thenReturn(user);
			assertEquals("User Not Added",service.createUser(user)) ;  
		}
	
	
	
	
	
}
