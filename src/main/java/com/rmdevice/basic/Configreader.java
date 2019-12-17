package com.rmdevice.basic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configreader {
	private final String path = System.getProperty("user.dir");
	private final String propertyFilePath= path + "//configs//config.properties";
	private static Properties properties;



	public Configreader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		} 
	}

	public static String getEmail(){
		String email = properties.getProperty("email");
		if(email!= null) return email;
		else throw new RuntimeException("email not specified in the Configuration.properties file."); 
	}
	
	
	public static String getPassword()
	{
		String password = properties.getProperty("password");
		if(password!=null)
		return password;
		else throw new RuntimeException("password not specified in the configuration.properties fiel");
		
	}
	
	 public long getImplicitlyWait() { 
		 String implicitlyWait = properties.getProperty("implicitlyWait");
		 if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		 else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file."); 
		 }

}
