package com_bdd_POM;

import org.openqa.selenium.support.FindBy;

import com_bdd_base.TestBase;
import cucumber.api.java.Before;

public class HomePage extends TestBase 
{
	String msg;
	
	
	
	public void perform_Search(String search) 
	{
		driver.navigate().to("http://shop.demoqa.com/?s=" + search + "&post_type=product");
	}
	
	public String HomePageTitle()
	{
		return msg= driver.getTitle();
		
	}

}
