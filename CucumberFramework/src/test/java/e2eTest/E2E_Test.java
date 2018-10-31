package e2eTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com_bdd_util.TestUtil;

public class E2E_Test
{
	private static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://store.demoqa.com");

	driver.navigate().to("http://store.demoqa.com/?s=" + "apple" + "&post_type=product");


	List<WebElement> items = driver.findElements(By.xpath("//div[@class='article-wrap']/article//following::img"));
	items.get(0).click();
	Thread.sleep(2000);
	WebElement addToCart = driver.findElement(By.cssSelector("#single_product_page_container > div.single_product_display.group > div.productcol > form > div.wpsc_buy_button_container.group > div.input-button-buy"));
	addToCart.click();		
	
	WebElement cart = driver.findElement(By.cssSelector("#header_cart > a > span.icon"));
	cart.click();
	
	WebElement continueToCheckout = driver.findElement(By.cssSelector("#checkout_page_container > div.slide1 > a"));
	continueToCheckout.click();		
		
	Thread.sleep(5000);
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
	
	WebElement placeOrder = driver.findElement(By.cssSelector("#wpsc_shopping_cart_container > form > div.wpsc_make_purchase > div > div > span > input"));
	placeOrder.submit();
	
	driver.quit();

}

}
