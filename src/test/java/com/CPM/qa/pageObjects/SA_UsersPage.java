package com.CPM.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SA_UsersPage {
	
	public WebDriver ldriver;
	
	//Constructor
	public SA_UsersPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
}
