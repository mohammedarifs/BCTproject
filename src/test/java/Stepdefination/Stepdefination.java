package Stepdefination;

import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;

import UtilityLib.UtilityFunctions;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefination {
	 UtilityFunctions UtilityLib= new UtilityFunctions();


	@Given("^I launch the \"(.*)\" on browser$")
	public void i_launch_the_login_page(String AppName) {
	    
		UtilityLib.launchurl(AppName);
	}

	@When("^I Select the \"(.*)\" date for trip on calendar$")
	public void I_Select_the_date_for_trip_on_calendar(String day) {
	
		UtilityLib.Datepicker();	    
	}
	
	@When("^I enter \"(.*)\" as \"(.*)\" in the field$")
	public void I_enter_Text_in_field(String ObjectID,String text) {
	
		UtilityLib.EnterText(ObjectID,text);   
	}
	
	@When("^I click on \"(.*)\" button$")
	public void I_click_on_button(String ObjectID) {
		
		UtilityLib.ClickOnElement(ObjectID);    
	}
	
	@Then("^I Verify the user navigate to \"(.*)\" page$")
	public void i_verify_the_user_navigate_to_page(String txt) {
		
		UtilityLib.VerifyPage();
	}
	
	@Then("^I enter Card Details in the \"(.*)\" page$")
	public void I_enter_Card_Details_in_the_page() {
	
		UtilityLib.VerifyPage();
	}
	
	@Then("^I Verify the message \"(.*)\" in \"(.*)\"$")
	public void I_Verify_the_message(String msg,String page ) {
	
		UtilityLib.VerifyMessage(msg,page);
	}
	
	@Then("^I Select the \"(.*)\" from the \"(.*)\" dropdown$")
	public void I_Select_from_dropdown(String Dropdown,String option) {
		
		UtilityLib.SelectOption(Dropdown, option);
	}
	
	@When("I enter username in usernamefield")
	public void i_enter_username_in_usernamefield() {
	  
		System.out.println("1");
	}

	@When("I enter password in passwordfield")
	public void i_enter_password_in_passwordfield() {
	   
		System.out.println("2");
	}

	@When("I click on login button")
	public void i_click_on_login_button() {
	   
		System.out.println("3");
	}

	@Then("I validate the user able to navigate to home page")
	public void i_validate_the_user_able_to_navigate_to_home_page() {
	   
		System.out.println("5");
	}

	@Then("check titile displayed")
	public void check_titile_displayed() {
	  
		System.out.println("t");
	}
	
	@After
	public void Close_the_browser() {
	
		UtilityLib.closebrowser();
	}
}
