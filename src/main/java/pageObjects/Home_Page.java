package pageObjects;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends BasePage{
	
	//Locators for current page	
	public @FindBy(xpath = "(//a[contains(text(), 'Create an Account')])[1]") WebElement link_CreateAccount;
	public @FindBy(xpath = "(//li[contains(@class, 'authorization-link')])[1]") WebElement link_SignIn;
	public @FindBy(xpath = "//a[@role='menuitem']/span[.='Sale']") WebElement link_Sale;

	public Home_Page() throws IOException {
		super();
	}
	
	public Home_Page getHomePage(String url) throws IOException {
		getDriver().get(url);
		return new Home_Page();
	}
	
	public Home_Page clickOnCreateAccount() throws IOException, InterruptedException {
		waitAndClickElement(link_CreateAccount);
		return new Home_Page();
	}
	
	public Home_Page clickOnSignInLink() throws IOException, InterruptedException {
		waitAndClickElement(link_SignIn);
		return new Home_Page();
	}
	
	public Home_Page confirmSignInLink() throws IOException, InterruptedException {
		WaitUntilWebElementIsVisible(link_SignIn);
		String expectedValue = ("Sign In").toLowerCase().replaceAll("\\s+","");
		String actualValue = link_SignIn.getText().toLowerCase().replaceAll("\\s+","");
		Assert.assertEquals(expectedValue, actualValue);
		return new Home_Page();
	}
	
	public Home_Page confirmCreateAccountLink() throws IOException, InterruptedException {
		WaitUntilWebElementIsVisible(link_CreateAccount);
		String expectedValue = ("Create an Account").toLowerCase().replaceAll("\\s+","");
		String actualValue = link_CreateAccount.getText().toLowerCase().replaceAll("\\s+","");
		Assert.assertEquals(expectedValue, actualValue);
		return new Home_Page();
	}
	
	public Home_Page clickOnSaleLink() throws IOException, InterruptedException {
		waitAndClickElement(link_Sale);
		return new Home_Page();
	}
}