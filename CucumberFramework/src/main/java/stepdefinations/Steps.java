package stepdefinations;

import com_bdd_base.TestBase;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import junit.framework.Assert;
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
	public void user_is_already_on_login_page() 
	{
		String Act = HomePage.HomePageTitle();
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
	    
	    
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() 
	{
	    
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
	public void select_payment_Method_as_payment(String arg1) 
	{
	    
	}

	@When("^plsce the oeder$")
	public void plsce_the_oeder() 
	{
		
	}
	@After
	public void Teardown()
	{
		driver.quit();
	}
	   
	

}
