package com_bdd_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com_bdd_base.TestBase;
import com_bdd_util.TestUtil;

public class CartPage extends TestBase
{
	@FindBy(css="#checkout_page_container > div.slide1 > a")WebElement continueToCheckout; 
	@FindBy(css="#wpsc_checkout_form_2")WebElement FirstName;
	
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnContinue()
	{
		TestUtil.ActionForMovetoElement(continueToCheckout).click().perform();
	}
	
	public void FillPersonalDetails()
	{
		ClickOnContinue();
		FirstName.sendKeys("Lakshay");
		
		
	}
	
	

}
