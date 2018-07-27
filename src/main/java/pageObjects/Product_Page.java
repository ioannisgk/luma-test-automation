package pageObjects;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product_Page extends BasePage{
	
	//Locators for current page	
	public @FindBy(xpath = "//h1/span") WebElement text_PageTitle;
	public @FindBy(xpath = "(//div[contains(@class, 'swatch-option color')])[1]") WebElement item_ProductColor;
	public @FindBy(xpath = "(//div[contains(@class, 'swatch-option text')])[1]") WebElement item_ProductSize;
	public @FindBy(xpath = "//*[@id='qty']") WebElement textfield_ProductQty;
	public @FindBy(xpath = "//button[@title='Add to Cart']") WebElement button_AddtoCart;
	public @FindBy(xpath = "(//*[@class='messages'])[1]") WebElement text_ValidCartMessage;
	public @FindBy(xpath = "(//span[@class='counter qty'])[1]") WebElement button_ShowCart;
	public @FindBy(xpath = "(//span[@class='price'])[3]") WebElement item_ProductPrice;
	public @FindBy(xpath = "//span[@class='count']") WebElement item_CartQty;
	public @FindBy(xpath = "(//span[@class='price'])[1]") WebElement item_CartPrice;
	
	public Product_Page() throws IOException {
		super();
	}
	
	public Product_Page confirmProductPageTitle(String itemTitle) throws IOException, InterruptedException {
		WaitUntilWebElementIsVisible(text_PageTitle);
		String expectedValue = itemTitle.toLowerCase().replaceAll("\\s+","");
		String actualValue = text_PageTitle.getText().toLowerCase().replaceAll("\\s+","");
		Assert.assertEquals(expectedValue, actualValue);
		return new Product_Page();
	}
	
	public Product_Page clickOnColorItem() throws IOException, InterruptedException {
		waitAndClickElement(item_ProductColor);
		return new Product_Page();
	}
	
	public Product_Page clickOnSizeItem() throws IOException, InterruptedException {
		waitAndClickElement(item_ProductSize);
		return new Product_Page();
	}
	
	public Product_Page enterProductQty(String quantity) throws Exception {
		sendKeysToWebElement(textfield_ProductQty, quantity);
		return new Product_Page();
	}
	
	public Product_Page clickOnAddToCartButton() throws IOException, InterruptedException {
		waitAndClickElement(button_AddtoCart);
		return new Product_Page();
	}
	
	public Product_Page confirmValidCartMessage(String itemTitle) throws IOException, InterruptedException {
		WaitUntilWebElementIsVisible(button_AddtoCart);
		String expectedValue = (itemTitle).toLowerCase().replaceAll("\\s+","");
		String actualValue = (text_PageTitle).getText().toLowerCase().replaceAll("\\s+","");
		Assert.assertEquals(expectedValue, actualValue);
		return new Product_Page();
	}
	
	public Product_Page clickOnShowCartButton() throws IOException, InterruptedException {
		waitAndClickElement(button_ShowCart);
		return new Product_Page();
	}
	
	public Product_Page confirmCorrectCartPrice(String quantity, String price) throws IOException, InterruptedException {
		
		double expectedCartPrice = (Double.parseDouble(quantity)) * (Double.parseDouble(price));
		String actualQuantity = (item_CartQty).getText().toLowerCase().replaceAll("\\s+","");
		String actualPrice = (item_ProductPrice).getText().toLowerCase().replaceAll("\\s+","");
		actualPrice = actualPrice.substring(1, actualPrice.length());
		double actualCartPrice = (Double.parseDouble(actualQuantity)) * (Double.parseDouble(actualPrice));
		
		Assert.assertEquals(String.valueOf(expectedCartPrice), String.valueOf(actualCartPrice));
		return new Product_Page();
	}
}