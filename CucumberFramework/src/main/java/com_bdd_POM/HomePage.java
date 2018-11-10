package com_bdd_POM;

import org.openqa.selenium.support.FindBy;

import com_bdd_base.TestBase;
import cucumber.api.java.Before;

public class HomePage extends TestBase 
{
	String msg;
	ProductListingPage PLP;
	
	
	public void perform_Search(String search) 
	{
		driver.navigate().to("http://shop.demoqa.com/?s=" + search + "&post_type=product");
	}
	
	public ProductListingPage ListTheProducts() throws InterruptedException
	{
		msg= driver.getTitle();
		Thread.sleep(2000);
		if(!msg.equals(null))
		{
			PLP= new ProductListingPage();
		}
		return PLP;
	}
	
	public String GetTitle() throws InterruptedException
	{
		Thread.sleep(3000);
		return msg= driver.getTitle();
		
	}

}
