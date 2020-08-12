package com.cg.greatoutdoor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.greatoutdoor.dao.UserImp;


@SpringBootApplication
public class GreaterOutdoorsApplication implements CommandLineRunner {
  
	
	@Autowired
	UserImp dao;
	
	private static final Logger logger=LoggerFactory.getLogger(GreaterOutdoorsApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(GreaterOutdoorsApplication.class, args);
		logger.info("Hello welcome to Greater Outdoors Application ");
      
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(dao.getUserList());
	
		
	}
	
	

}
