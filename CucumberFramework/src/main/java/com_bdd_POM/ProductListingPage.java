package com_bdd_POM;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com_bdd_base.TestBase;
import com_bdd_util.TestUtil;

public class ProductListingPage extends TestBase
{
	
	private @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='article-wrap']/article//following::img"))List<WebElement> prodListing;
	private @FindBy(name="Buy") WebElement AddToCart;
	private @FindBy(xpath="(//span[@class='icon'])[1]")WebElement COCart;
	
	
	
	public ProductListingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void selectProductNo(int productNumber)
	{
		
		 prodListing.get(productNumber).click();
		
	}
	public WebElement ClickonCartbutton(WebElement ele)
	{
		return ele;
	}
	
	public void AddtoCart()
	{
		ClickonCartbutton(AddToCart).click();
	
	}
	public CartPage ClickonCheckoutcart()
	{
		try
		{
			TestUtil.VisibleOn(driver, COCart, 30);
		}
		catch(TimeoutException e)
		{
			System.out.println("COCart is not seen with in 3 sec");
		}
		TestUtil.ActionForMovetoElement(COCart).click().perform();
				
		return new CartPage();
		
	}
	
	
	

}
