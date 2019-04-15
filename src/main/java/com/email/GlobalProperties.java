package com.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class GlobalProperties {
	
	 @Value("${emailHost}")
	 String emailHost;
	 
	 @Value("${emailStoreType}")
     String emailStoreType;
	 
	 @Value("${emailUsername}")
     String emailUsername ;
	 
	 @Value("${emailPassword}")
     String emailPassword ;
	 
	 @Value("${emailPort}")
	 String emailPort;

	public String getEmailPort() {
		return emailPort;
	}

	public void setEmailPort(String emailPort) {
		this.emailPort = emailPort;
	}

	public String getEmailHost() {
		return emailHost;
	}

	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}

	public String getEmailStoreType() {
		return emailStoreType;
	}

	public void setEmailStoreType(String emailStoreType) {
		this.emailStoreType = emailStoreType;
	}

	public String getEmailUsername() {
		return emailUsername;
	}

	public void setEmailUsername(String emailUsername) {
		this.emailUsername = emailUsername;
	}

	public String getEmailPassword() {
		return emailPassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	 

}
