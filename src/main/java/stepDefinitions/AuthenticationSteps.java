package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class AuthenticationSteps extends DriverFactory {
	
	@Given("^user navigates to \"([^\"]*)\" website$")
	public void user_navigates_to_website(String url) throws Throwable {
		Thread.sleep(6000);
	    homePage.getHomePage(url);
	}

	@When("^user clicks on Create an Account link$")
	public void user_clicks_on_create_an_account_link() throws Throwable {
	    homePage.clickOnCreateAccount();
	}

	@Then("^the Create New Customer Account page should be displayed$")
	public void the_create_new_customer_account_page_should_be_displayed() throws Throwable {
	    createAccountPage.confirmPageTitle();
	}

	@When("^user enters a \"([^\"]*)\" firstname$")
	public void user_enters_a_firstname(String firstname) throws Throwable {
		createAccountPage.enterFirstname(firstname);
	}

	@When("^user enters a \"([^\"]*)\" lastname$")
	public void user_enters_a_lastname(String lastname) throws Throwable {
		createAccountPage.enterLastname(lastname);
	}

	@When("^user enters a \"([^\"]*)\" email$")
	public void user_enters_a_email(String email) throws Throwable {
		createAccountPage.enterEmail(email);
	}

	@When("^user enters a \"([^\"]*)\" password$")
	public void user_enters_a_password(String password) throws Throwable {
		createAccountPage.enterPassword(password);
	}

	@When("^user enters a \"([^\"]*)\" repeat password$")
	public void user_enters_a_repeat_password(String repeatPassword) throws Throwable {
		createAccountPage.enterRepeatPassword(repeatPassword);
	}

	@When("^user clicks on Create an Account button$")
	public void user_clicks_on_create_an_account_button() throws Throwable {
		createAccountPage.clickOnCreateNewAccountButton();
	}

	@Then("^the My Dashboard page should be displayed$")
	public void the_My_Dashboard_page_should_be_displayed() throws Throwable {
	    myDashboardPage.confirmPageTitle();
	}
	
	@Then("^the \"([^\"]*)\" firstname and \"([^\"]*)\" lastname should be displayed$")
	public void the_firstname_and_lastname_should_be_displayed(String firstname, String lastname) throws Throwable {
		Thread.sleep(3000);
		myDashboardPage.confirmFirstnameLastname(firstname, lastname);
	}
	
	@When("^user clicks on Sign Out button$")
	public void user_clicks_on_sign_out_button() throws Throwable {
		myDashboardPage.clickOnSignOutButton();
	}

	@Then("^the Sign In link should be displayed$")
	public void the_sign_in_link_should_be_displayed() throws Throwable {
	    homePage.confirmSignInLink();
	}

	@Then("^the Create an Account link should be displayed$")
	public void the_firstname_should_not_be_displayed() throws Throwable {
		Thread.sleep(5000);
		homePage.confirmCreateAccountLink();
	}
}