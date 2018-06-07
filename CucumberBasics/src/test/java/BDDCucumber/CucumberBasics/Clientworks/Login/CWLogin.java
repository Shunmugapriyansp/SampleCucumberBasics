
/*
 * @author: Priyan
 *Simple Changes 
 */

package BDDCucumber.CucumberBasics.Clientworks.Login;

import BDDCucumber.CucumberBasics.Clientworks.Core.Corelib;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CWLogin {
Corelib clsCorelib = new Corelib();	
/*	@Given("^I goto \"([^\"])\" on \"([^\"])\"$")
	public void I_Go_To_On(String url, String browserName){
		System.out.println("Launching ClientWorks " + url +" on " + browserName);
		
	}
	
		// TODO Auto-generated method stub
	@And("^I enter \"([^\"])\" as \"([^\"])\"$")
	public void I_Enter_(String object, String text){
		System.out.println("Entering "+ text +"in " + object );
	}
		// TODO Auto-generated method stub
	@And("^I click on \"([^\"])\" button$")
	public void I_Click_On(String object){
		System.out.println("Clicking "+ object );
		
	}
	
	@Then("^Login should be \"([^\"])\"$")
	public void Login_Should_Be(String strExpectedResults){
		System.out.println("Login is "+ strExpectedResults );
		
	}*/
	
	
	//You can implement missing steps with the snippets below:

		@Given("^I go to \"([^\"]*)\" on \"([^\"]*)\"$")
		public void i_go_to_on(String url, String browserName) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			System.out.println("Launching ClientWorks " + url +" on " + browserName);
			clsCorelib.OpenBrowser(browserName);
			clsCorelib.navigate();
		    //throw new PendingException();
		}

		@And("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
		public void i_enter_as(String strText, String strObject) throws Throwable {
			System.out.println("Entering "+ strText +"in " + strObject );
		    // Write code here that turns the phrase above into concrete actions
		    //throw new PendingException();
		}

		@Given("^I Click on \"([^\"]*)\" button$")
		public void i_Click_on_button(String strObject) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			System.out.println("Clicking "+ strObject );
		    //throw new PendingException();
		}

		@Then("^Login should be \"([^\"]*)\"$")
		public void login_should_be(String strExpectedResults) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			System.out.println("Login is "+ strExpectedResults );
		    //throw new PendingException();
		}


}
