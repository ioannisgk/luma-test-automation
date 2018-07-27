package pageObjects;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyDashboard_Page extends BasePage{
	
	//Locators for current page
	public @FindBy(xpath = "//span[contains(text(), 'My Dashboard')]") WebElement text_PageTitle;
	public @FindBy(xpath = "(//span[contains(@class, 'customer-name')])[1]") WebElement text_CustomerName;
	public @FindBy(xpath = "(//a[contains(text(), 'Sign Out')])[1]") WebElement button_SignOut;
	
	public MyDashboard_Page() throws IOException {
		super();
	}
	
	public MyDashboard_Page confirmPageTitle() throws IOException, InterruptedException {
		WaitUntilWebElementIsVisible(text_PageTitle);
		String expectedValue = ("My Dashboard").toLowerCase().replaceAll("\\s+","");
		String actualValue = text_PageTitle.getText().toLowerCase().replaceAll("\\s+","");
		Assert.assertEquals(expectedValue, actualValue);
		return new MyDashboard_Page();
	}
	
	public MyDashboard_Page confirmFirstnameLastname(String firstname, String lastname) throws IOException, InterruptedException {
		WaitUntilWebElementIsVisible(text_CustomerName);
		String expectedValue = (firstname + lastname + "change").toLowerCase().replaceAll("\\s+","");
		String actualValue = text_CustomerName.getText().toLowerCase().replaceAll("\\s+","");
		Assert.assertEquals(expectedValue, actualValue);
		return new MyDashboard_Page();
	}
	
	public MyDashboard_Page clickOnSignOutButton() throws Exception {
		waitAndClickElement(text_CustomerName);
		waitAndClickElement(button_SignOut);
		return new MyDashboard_Page();
	}
}