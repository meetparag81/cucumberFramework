package com_bdd_POM;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com_bdd_base.TestBase;
import com_bdd_util.TestUtil;

public class CartPage extends TestBase
{
	@FindBy(css="#checkout_page_container > div.slide1 > a")WebElement continueToCheckout; 
	@FindBy(css="#wpsc_checkout_form_2")WebElement FirstName;
	@FindBy(css="#wpsc_checkout_form_3")WebElement LastName;
	@FindBy (css="#wpsc_checkout_form_9")WebElement emailAddress;
	@FindBy(css="#wpsc_checkout_form_18") WebElement phone;
	@FindAll(@FindBy(xpath="//label[contains (text(),'Country')]//following::select[@name='collected_data[7][0]']/option" ))List<WebElement> countryList;
	@FindBy(xpath = "//div[@class='selector'][@id='uniform-current_country']")WebElement countryDropDown;
	@FindBy(css="#wpsc_checkout_form_4")WebElement address;
	@FindBy(css="#wpsc_checkout_form_5")WebElement city;
	@FindBy(css="#wpsc_checkout_form_8")WebElement postcode;
	@FindBy(css="#shippingSameBilling")WebElement shipToDifferetAddress;
	@FindBy(css="#wpsc_shopping_cart_container > form > div.wpsc_make_purchase > div > div > span > input")WebElement placeOrder;
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnContinue()
	{
		TestUtil.ActionForMovetoElement(continueToCheckout).click().perform();
	}
	
	public void FillPersonalDetails() throws InterruptedException
	{
		ClickOnContinue();
		FirstName.sendKeys("Lakshay");
		LastName.sendKeys("Sharma");
		emailAddress.sendKeys("test@gmail.com");
		phone.sendKeys("07438862327");
		city.sendKeys("Delhi");
		postcode.sendKeys("110088");
		for(int i= 0;i<=countryList.size();i++)
		{
			String country= countryList.get(i).getText();
			if(country.equals("India")) 
			{
				countryList.get(i).click();	
				Thread.sleep(3000);
				break;
			}	
			address.sendKeys("Shalimar Bagh");
			city.sendKeys("Delhi");
			postcode.sendKeys("110088");
		
		}
		
		
		
	}
	public void ShipToDifferentAddress(boolean flag)
	{
		if(flag=true)
		{
			shipToDifferetAddress.click();
		}
		else
		{
			return;
		}
		
		
	}
	
	public void clickOn_PlaceOrder()
	{
		placeOrder.click();
	}
	
	

}
