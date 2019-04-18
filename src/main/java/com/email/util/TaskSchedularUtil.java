package com.email.util;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.email.GlobalProperties;
import com.email.entity.EmailData;
import com.email.repository.EmailDataRepository;
import com.email.repository.UserRegistrationRepository;
@Component
public class TaskSchedularUtil {
	@Autowired
	EmailDataRepository dao;
	
	@Autowired
	 Environment env;
	
	@Autowired
	GlobalProperties prop;
	
	@Autowired
	UserRegistrationRepository userDao;
	 
	@Scheduled(cron ="${emailFetch.trigger}") 
	 public void checkEmail(){  
				EmailUtil util = new EmailUtil();
				
			  String keyValue = env.getProperty("spring.datasource.url");
			  String host = prop.getEmailHost();
		      String mailStoreType = prop.getEmailStoreType();
		      String username = prop.getEmailUsername();
		      String password = prop.getEmailPassword();
		      String port = prop.getEmailPort();
		     // es.check(host, mailStoreType, username, password);
		     // Email e =es.checkEmail(host, mailStoreType, username, password);
		      ArrayList<EmailData> emailData=util.downloadEmails(host, port, username, password,userDao);
		      if(emailData!=null) {
		    	  dao.save(emailData);
		      }
		    
		      System.out.println(" run Task Current time is :: " + Calendar.getInstance().getTime());
	  }  
}
