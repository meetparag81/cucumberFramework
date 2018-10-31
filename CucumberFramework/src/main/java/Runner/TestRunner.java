package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "C:\\Parag\\Git\\CucumberFramework\\CucumberFramework\\src\\main\\java\\featureFile\\End2EndTest.feature",
glue={"stepdefinations"})


	
public class TestRunner 
{

}
