package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = "C:\\Parag\\PrjectIVF\\BDDProjectwithhooks\\src\\main\\java\\Features\\Hooks.feature",
	glue = {"stepdefinations"},
	format={"pretty","html:test-outout","json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
	monochrome=true,
		strict = true, //it will check if any step is not defined in step definition file
	dryRun = true)
public class TestRunner 
{

}
