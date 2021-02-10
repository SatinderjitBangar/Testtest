package com.CPM.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RE_TrackMaintenancePage {

public WebDriver ldriver;
	
	//Constructor
	public RE_TrackMaintenancePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
}
