package com.CPM.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SA_RolesPage {
	
	public WebDriver ldriver;
	
	//Constructor
	public SA_RolesPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
}
