package com.CPM.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RE_ReportIssuesPage {

public WebDriver ldriver;
	
	//Constructor
	public RE_ReportIssuesPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
}
