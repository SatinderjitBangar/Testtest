package com.CPM.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RE_MyProfilePage {

public WebDriver ldriver;
	
	//Constructor
	public RE_MyProfilePage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
}
