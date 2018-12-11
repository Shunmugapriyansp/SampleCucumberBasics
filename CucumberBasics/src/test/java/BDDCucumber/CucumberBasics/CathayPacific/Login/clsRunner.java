package BDDCucumber.CucumberBasics.CathayPacific.Login;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( monochrome = true, glue={"BDDCucumber.CucumberBasics.Clientworks.Login"},plugin = {"html:target/html/cucumber-html-report", "json:target/json/cucumber-json-report.json" })
//@CucumberOptions(plugin = {"pretty"}, strict = false)
public class clsRunner {
	}
