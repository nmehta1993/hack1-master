package com.hackathon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.hackathon.dao.AppDAO;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class TC1 {
	
	private static final Logger logger = LoggerFactory.getLogger(TC1.class);
	
	
	@Autowired
    private AppDAO dao;
	
	@Test
	public void testCSVRead() {
		dao = new AppDAO();
		logger.info(dao.readCSVData("Coordinator").toString());
	}
	   @Configuration
	    static class Config {
	        @Bean
	        public AppDAO getTodoController() {
	            return new AppDAO();
	        }
	 
	    }
}
