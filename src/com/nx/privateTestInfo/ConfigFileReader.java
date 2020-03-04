package com.nx.privateTestInfo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties prop;
	private final String propertyInputPath = "C:\\Users\\amiller\\Documents\\SeleniumTraining\\NexientPortalVerification\\config.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyInputPath));
			prop = new Properties();
			try {
				prop.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Config.properties not found at " + propertyInputPath);
		}
	}
	
	public String getDriverPath(){
		 String driverPath = prop.getProperty("driverPath");
		 if(driverPath!= null) return driverPath;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }

	public String getUsername() {
		String usernamePath = prop.getProperty("username");
		if (usernamePath != null)
			return usernamePath;
		else
			throw new RuntimeException("username not specified in the Configuration.properties file.");
	}
	
	public String getPassword() {
		String passwordPath = prop.getProperty("password");
		if (passwordPath != null)
			return passwordPath;
		else
			throw new RuntimeException("password not specified in the Configuration.properties file.");
	}
	
	public String getUrl() {
		String urlPath = prop.getProperty("url");
		if (urlPath != null)
			return urlPath;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	

}
