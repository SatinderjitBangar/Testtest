package com.CPM.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	// Properties Class
	Properties pro; 
	
	// Constructor
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");// Creating File object
			
		try 
		{
			// Open FileInputStream and Read data 
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis); // Load config.properties file
		} 
		catch (Exception e) 
		{	
			// If config.properties file is not available it will throw an exception
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	// Methods to read data from config.properties 
	// Method to read url from config file
	public String getApplicationURL()                            
	{
		String url=pro.getProperty("baseURL"); // Value from config.properties stored in url variable
		return url;
	}
	//Method to read renter credentials from config file
	public String getUsername1()   
	{
		String username1=pro.getProperty("username1");
		return username1;
	}
	
	public String getPassword1() 
	{
	String password1=pro.getProperty("password1");
	return password1;
	}
	
	//Method to read second renter credentials from config file
	public String getUsername3()   
	{
		String username3=pro.getProperty("username3");
		return username3;
	}
	
	public String getPassword3() 
	{
	String password3=pro.getProperty("password3");
	return password3;
	}
	
	//Method to read Property Manager credentials from config file
	public String getUsername2()  
	{
		String username2=pro.getProperty("username2");
		return username2;
	}
	public String getPassword2() 
	{
	String password2=pro.getProperty("password2");
	return password2;
	}
	
	//Method to read path of chromedriver from config file	
	public String getChromePath() 
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	//Method to read path of geckodriver from config file
	public String getFFPath() 
	{
	String chromepath=pro.getProperty("ffpath");
	return chromepath;
	}
	
	//Method to read path of edgedriver from config file
	public String getEdgePath() 
	{
	String chromepath=pro.getProperty("edgepath");
	return chromepath;
	}
		
	//Method to read path of edgedriver from config file
	public String getOs() 
	{
	String os=pro.getProperty("os");
	return os;
	}
		
	
}
