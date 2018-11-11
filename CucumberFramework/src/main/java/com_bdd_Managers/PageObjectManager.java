package com_bdd_Managers;

import org.openqa.selenium.WebDriver;

import com_bdd_POM.CartPage;
import com_bdd_POM.HomePage;
import com_bdd_POM.ProductListingPage;
import com_bdd_base.TestBase;

public class PageObjectManager extends TestBase 
{
	private ProductListingPage PLP;
	 
	private CartPage cartPage;
 
	private HomePage homePage;
	
 
	
 
	 public PageObjectManager(WebDriver driver)
	 {
		 this.driver= driver;
	 }
	 
	 public HomePage getHomePage()
	 {
		 
			return (homePage == null) ? homePage = new HomePage() : homePage;
	 
	}
	 
	 public ProductListingPage getProductListingPage() 
	 {
		 
			return (PLP == null) ? PLP = new ProductListingPage() : PLP;
	 
	}
	 
	 public CartPage getCartPage()
	 {
		 
			return (cartPage == null) ? cartPage = new CartPage() : cartPage;
	 
		}
	

}
