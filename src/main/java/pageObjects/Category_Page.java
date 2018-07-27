package pageObjects;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Category_Page extends BasePage{
	
	//Locators for current page	
	public @FindBy(xpath = "//h1/span") WebElement text_PageTitle;
	public @FindBy(xpath = "//div[@class='categories-menu']/ul[1]//a[contains(text(), 'Hoodies and Sweatshirts')]") WebElement link_HoodiesCategory;
	
	public Category_Page() throws IOException {
		super();
	}
	
	public Category_Page confirmSalePageTitle() throws IOException, InterruptedException {
		WaitUntilWebElementIsVisible(text_PageTitle);
		String expectedValue = ("Sale").toLowerCase().replaceAll("\\s+","");
		String actualValue = text_PageTitle.getText().toLowerCase().replaceAll("\\s+","");
		Assert.assertEquals(expectedValue, actualValue);
		return new Category_Page();
	}
	
	public Category_Page clickOnHoodiesCategoryLink() throws IOException, InterruptedException {
		waitAndClickElement(link_HoodiesCategory);
		return new Category_Page();
	}
	
	public Category_Page confirmCategoryPageTitle() throws IOException, InterruptedException {
		WaitUntilWebElementIsVisible(text_PageTitle);
		String expectedValue = ("Hoodies & Sweatshirts").toLowerCase().replaceAll("\\s+","");
		String actualValue = text_PageTitle.getText().toLowerCase().replaceAll("\\s+","");
		Assert.assertEquals(expectedValue, actualValue);
		return new Category_Page();
	}
	
	public Category_Page clickOnProductLink(String itemTitle) throws IOException, InterruptedException {
		basePage.WaitUntilWebElementIsVisibleUsingByLocator(By.xpath("//div/strong/a[contains(text(), '" + itemTitle + "')]"));
		getDriver().findElement(By.xpath("//div/strong/a[contains(text(), '" + itemTitle + "')]")).click();
		return new Category_Page();
	}
}