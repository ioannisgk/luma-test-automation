package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class LoginSteps extends DriverFactory {
	
	@When("^user clicks on Sign In link$")
	public void user_clicks_on_Sign_In_link() throws Throwable {
		homePage.clickOnSignInLink();
	}

	@Then("^the Customer Login page should be displayed$")
	public void the_Customer_Login_page_should_be_displayed() throws Throwable {
		customerLoginPage.confirmPageTitle();
	}

	@When("^user enters a \"([^\"]*)\" email to the login form$")
	public void user_enters_a_email_to_the_login_form(String email) throws Throwable {
		customerLoginPage.enterEmail(email);
	}

	@When("^user enters a \"([^\"]*)\" password to the login form$")
	public void user_enters_a_password_to_the_login_form(String password) throws Throwable {
		customerLoginPage.enterPassword(password);
	}
	
	@When("^user clicks on Sign In button$")
	public void user_clicks_on_sign_in_button() throws Throwable {
		customerLoginPage.clickOnSignInButton();
	}

	@Then("^the \"([^\"]*)\" email should be displayed$")
	public void the_email_should_be_displayed(String email) throws Throwable {
		customerLoginPage.confirmEmailInformation(email);
	}
	
	@Then("^the Invalid login or password message should be displayed$")
	public void the_Invalid_login_or_password_email_should_be_displayed() throws Throwable {
		customerLoginPage.confirmInvalidLoginMessages();
	}
}