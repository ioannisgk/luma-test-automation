package pageObjects;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccount_Page extends BasePage{
	
	//Locators for current page
	public @FindBy(xpath = "//span[contains(text(), 'Create New Customer Account')]") WebElement text_PageTitle;
	
	public @FindBy(xpath = "//input[@name='firstname']") WebElement textfield_Firstname;
	public @FindBy(xpath = "//input[@name='lastname']") WebElement textfield_Lastname;
	public @FindBy(xpath = "//input[@name='email']") WebElement textfield_Email;
	public @FindBy(xpath = "//input[@name='password']") WebElement textfield_Password;
	public @FindBy(xpath = "//input[@name='password_confirmation']") WebElement textfield_PasswordConfirmation;
	public @FindBy(xpath = "//button[@title='Create an Account']") WebElement button_CreateAccount;

	public CreateAccount_Page() throws IOException {
		super();
	}
	
	public CreateAccount_Page confirmPageTitle() throws IOException, InterruptedException {
		WaitUntilWebElementIsVisible(text_PageTitle);
		String expectedValue = ("Create New Customer Account").toLowerCase().replaceAll("\\s+","");
		String actualValue = text_PageTitle.getText().toLowerCase().replaceAll("\\s+","");
		Assert.assertEquals(expectedValue, actualValue);
		return new CreateAccount_Page();
	}
	
	public CreateAccount_Page enterFirstname(String firstname) throws Exception {
		sendKeysToWebElement(textfield_Firstname, firstname);
		return new CreateAccount_Page();
	}
	
	public CreateAccount_Page enterLastname(String lastname) throws Exception {
		sendKeysToWebElement(textfield_Lastname, lastname);
		return new CreateAccount_Page();
	}
	
	public CreateAccount_Page enterEmail(String email) throws Exception {
		sendKeysToWebElement(textfield_Email, email);
		return new CreateAccount_Page();
	}
	
	public CreateAccount_Page enterPassword(String password) throws Exception {
		sendKeysToWebElement(textfield_Password, password);
		return new CreateAccount_Page();
	}
	
	public CreateAccount_Page enterRepeatPassword(String repeatPassword) throws Exception {
		sendKeysToWebElement(textfield_PasswordConfirmation, repeatPassword);
		return new CreateAccount_Page();
	}
	
	public CreateAccount_Page clickOnCreateNewAccountButton() throws Exception {
		waitAndClickElement(button_CreateAccount);
		return new CreateAccount_Page();
	}
}