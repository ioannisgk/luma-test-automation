package pageObjects;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerLogin_Page extends BasePage{
	
	//Locators for current page
	public @FindBy(xpath = "//span[contains(text(), 'Customer Login')]") WebElement text_PageTitle;
	public @FindBy(xpath = "//input[@name='login[username]']") WebElement textfield_Email;
	public @FindBy(xpath = "//input[@name='login[password]']") WebElement textfield_Password;
	public @FindBy(xpath = "//button[@name='send']") WebElement button_SignIn;
	public @FindBy(xpath = "(//*[@class='box-content'])[1]") WebElement text_ContactInformation;
	public @FindBy(xpath = "(//*[@class='messages'])[1]") WebElement text_InvalidLoginMessages;
	
	public CustomerLogin_Page() throws IOException {
		super();
	}
	
	public CustomerLogin_Page confirmPageTitle() throws IOException, InterruptedException {
		WaitUntilWebElementIsVisible(text_PageTitle);
		String expectedValue = ("Customer Login").toLowerCase().replaceAll("\\s+","");
		String actualValue = text_PageTitle.getText().toLowerCase().replaceAll("\\s+","");
		Assert.assertEquals(expectedValue, actualValue);
		return new CustomerLogin_Page();
	}
	
	public CustomerLogin_Page enterEmail(String email) throws Exception {
		sendKeysToWebElement(textfield_Email, email);
		return new CustomerLogin_Page();
	}
	
	public CustomerLogin_Page enterPassword(String password) throws Exception {
		sendKeysToWebElement(textfield_Password, password);
		return new CustomerLogin_Page();
	}
	
	public CustomerLogin_Page clickOnSignInButton() throws Exception {
		waitAndClickElement(button_SignIn);
		return new CustomerLogin_Page();
	}
	
	public CustomerLogin_Page confirmEmailInformation(String email) throws IOException, InterruptedException {
		WaitUntilWebElementIsVisible(text_ContactInformation);
		String expectedValue = email.toLowerCase().replaceAll("\\s+","");
		
		int neededCharacters = expectedValue.length();
		String actualValue = text_ContactInformation.getText().toLowerCase().replaceAll("\\s+","");
		actualValue = actualValue.substring(actualValue.length() - neededCharacters);
		
		Assert.assertEquals(expectedValue, actualValue);
		return new CustomerLogin_Page();
	}
	
	public CustomerLogin_Page confirmInvalidLoginMessages() throws IOException, InterruptedException {
		WaitUntilWebElementIsVisible(button_SignIn);
		String actualValue = text_InvalidLoginMessages.getText().toLowerCase().replaceAll("\\s+","");
		int messageSize = actualValue.length();
		
		if (messageSize == 0) Assert.assertTrue(false);
		else Assert.assertTrue(true);
		
		return new CustomerLogin_Page();
	}
}