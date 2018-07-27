package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class ShoppingCartSteps extends DriverFactory {
	
	@When("^user clicks on Sale link$")
	public void user_clicks_on_Sale_link() throws Throwable {
	    homePage.clickOnSaleLink();
	}

	@Then("^the Sale page should be displayed$")
	public void the_Sale_page_should_be_displayed() throws Throwable {
		categoryPage.confirmSalePageTitle();
	}

	@When("^user clicks on Hoodies and Sweatshirts link$")
	public void user_clicks_on_Hoodies_and_Sweatshirts_link() throws Throwable {
		categoryPage.clickOnHoodiesCategoryLink();
	}

	@Then("^the Hoodies and Sweatshirts page should be displayed$")
	public void the_Hoodies_and_Sweatshirts_page_should_be_displayed() throws Throwable {
		categoryPage.confirmCategoryPageTitle();
	}

	@When("^user clicks on \"([^\"]*)\" item title$")
	public void user_clicks_on_item_title(String itemTitle) throws Throwable {
	    categoryPage.clickOnProductLink(itemTitle);
	}

	@Then("^the \"([^\"]*)\" item title page should be displayed$")
	public void the_item_title_page_should_be_displayed(String itemTitle) throws Throwable {
	    productPage.confirmProductPageTitle(itemTitle);
	}

	@When("^user clicks on Color$")
	public void user_clicks_on_Color() throws Throwable {
		productPage.clickOnColorItem();
	}

	@When("^user clicks on Size$")
	public void user_clicks_on_Size() throws Throwable {
		productPage.clickOnSizeItem();
	}

	@When("^user enters \"([^\"]*)\" quantity$")
	public void user_enters_quantity(String quantity) throws Throwable {
		productPage.enterProductQty(quantity);
	}
	
	@When("^user clicks on Add to Cart button$")
	public void user_clicks_on_Add_to_Cart_button() throws Throwable {
	    productPage.clickOnAddToCartButton();
	}

	@Then("^confirmation message \"([^\"]*)\" should appear$")
	public void confirmation_message_should_appear(String itemTitle) throws Throwable {
		Thread.sleep(2000);
	    productPage.confirmValidCartMessage(itemTitle);
	}

	@When("^user clicks on Show Cart button$")
	public void user_clicks_on_Cart_link() throws Throwable {
		productPage.clickOnShowCartButton();
	}

	@Then("^the Cart Subtotal amount should be correct \"([^\"]*)\" X \"([^\"]*)\"$")
	public void the_Cart_Subtotal_amount_should_be_correct_X(String quantity, String price) throws Throwable {
		productPage.confirmCorrectCartPrice(quantity, price);
	}
}