package com_bdd_POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_bdd_Managers.PageObjectManager;
import com_bdd_base.TestBase;
import com_bdd_util.TestUtil;
import cucumber.api.java.Before;

public class HomePage extends TestBase 
{
	@FindBy(xpath="//fieldset/input[@name='s']") WebElement searchbox;
	String msg;
	ProductListingPage PLP;
	PageObjectManager POM;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	

	public void perform_Search() 
	{
		try
		{
			TestUtil.VisibleOn(driver, searchbox, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("Element- searchbox is not seen with in 30 sec");
		}
		TestUtil.ActionForMovetoElement(searchbox).click().perform();
		searchbox.clear();
		//TestUtil.SendvaluesInputboxByJavaScriptExecutor(searchbox, "Apple");
		searchbox.sendKeys("Apple");
		searchbox.sendKeys(Keys.ENTER);
		//driver.navigate().to("http://shop.demoqa.com/?s=" + search + "&post_type=product");
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
