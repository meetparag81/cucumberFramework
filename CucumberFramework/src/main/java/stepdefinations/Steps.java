package stepdefinations;

import com_bdd_base.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com_bdd_POM.HomePage;

@SuppressWarnings("deprecation")
public class Steps extends TestBase 
{
	HomePage HomePage;
	
	
	@Before
	public void Setup()
	{
		HomePage=TestBase.initalization();
	}
	
	@Given("^user is already on login page$")
	public void user_is_already_on_login_page() throws InterruptedException 
	{
		String Act = HomePage.GetTitle();
		String Exp = "ONLINE STORE | Toolsqa Dummy Test site";
		Assert.assertEquals(Exp, Act);
		
	}

	@When("^user search for \"([^\"]*)\"$")
	public void user_search_for(String arg1) 
	{
		HomePage.perform_Search("apple");  
	}

	@When("^choose to buy first item$")
	public void choose_to_buy_first_item() 
	{
		List<WebElement> items = driver.findElements(By.xpath("//div[@class='article-wrap']/article//following::img"));
		items.get(0).click();	 
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() throws InterruptedException 
	{
		WebElement addToCart = driver.findElement(By.cssSelector("#single_product_page_container > div.single_product_display.group > div.productcol > form > div.wpsc_buy_button_container.group > div.input-button-buy"));
		addToCart.click();		
		Thread.sleep(2000);
		WebElement cart = driver.findElement(By.cssSelector("#header_cart > a > span.icon"));
		cart.click();
		
		WebElement continueToCheckout = driver.findElement(By.cssSelector("#checkout_page_container > div.slide1 > a"));
		continueToCheckout.click();
	}

	@When("^personal details on checkout page$")
	public void personal_details_on_checkout_page() 
	{
	   
	}

	@When("^select same delivery adress$")
	public void select_same_delivery_adress() 
	{
	    
	}

	@When("^select payment Method as \"([^\"]*)\" payment$")
	public void select_payment_Method_as_payment(String arg1) throws InterruptedException 
	{
		WebElement firstName = driver.findElement(By.cssSelector("#wpsc_checkout_form_2"));
		firstName.sendKeys("Lakshay");
		
		WebElement lastName = driver.findElement(By.cssSelector("#wpsc_checkout_form_3"));
		lastName.sendKeys("Sharma");
		
		WebElement emailAddress = driver.findElement(By.cssSelector("#wpsc_checkout_form_9"));
		emailAddress.sendKeys("test@gmail.com");
		
		WebElement phone = driver.findElement(By.cssSelector("#wpsc_checkout_form_18"));
		phone.sendKeys("07438862327");
				
		WebElement countryDropDown = driver.findElement(By.xpath("//div[@class='selector'][@id='uniform-current_country']"));
		countryDropDown.click();
		Thread.sleep(2000);
		List<WebElement> countryList = driver.findElements(By.xpath("//label[contains (text(),'Country')]//following::select[@name='collected_data[7][0]']/option"));
		for(int i= 0;i<=countryList.size();i++)
		{
			String country= countryList.get(i).getText();
			if(country.equals("India")) 
			{
				countryList.get(i).click();	
				Thread.sleep(3000);
				break;
			}		
		}
		WebElement address = driver.findElement(By.cssSelector("#wpsc_checkout_form_4"));
		address.sendKeys("Shalimar Bagh");
		
		WebElement city = driver.findElement(By.cssSelector("#wpsc_checkout_form_5"));
		city.sendKeys("Delhi");
		
		WebElement postcode = driver.findElement(By.cssSelector("#wpsc_checkout_form_8"));
		postcode.sendKeys("110088");		
		
		WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#shippingSameBilling"));
		shipToDifferetAddress.click();
		Thread.sleep(3000);
	    
	}

	@When("^place the order$")
	public void place_the_order() 
	{
		WebElement placeOrder = driver.findElement(By.cssSelector("#wpsc_shopping_cart_container > form > div.wpsc_make_purchase > div > div > span > input"));
		placeOrder.submit();
		
	}
	@After
	public void Teardown()
	{
		driver.quit();
	}
	   
	

}
