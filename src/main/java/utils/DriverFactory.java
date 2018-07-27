package utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import pageObjects.BasePage;
import pageObjects.Category_Page;
import pageObjects.CreateAccount_Page;
import pageObjects.CustomerLogin_Page;
import pageObjects.Home_Page;
import pageObjects.MyDashboard_Page;
import pageObjects.Product_Page;

public class DriverFactory {

	public static WebDriver driver;
	public static BasePage basePage;
	public static Home_Page homePage;
	public static CreateAccount_Page createAccountPage;
	public static MyDashboard_Page myDashboardPage;
	public static CustomerLogin_Page customerLoginPage;
	public static Category_Page categoryPage;
	public static Product_Page productPage;

	// Method to get web driver
	public WebDriver getDriver() {

		try {

			// Read configuration file
			ReadConfigFile file = new ReadConfigFile();
			String browserName = file.getBrowser();

			switch (browserName) {

			case "chrome":

				if (driver == null) {

					// Set chrome driver
					if (file.getOS().equals("linux")) System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY_LINUX);
					else if (file.getOS().equals("windows")) System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY_WINDOWS);
						
					// Chrome options
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				break;

			case "firefox":

				if (driver == null) {

					// Set firefox driver and firefox version
					if (file.getOS().equals("linux")) System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY_LINUX);
					else if (file.getOS().equals("windows")) System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY_WINDOWS);
						
					if (file.getOS().equals("linux")) System.setProperty("webdriver.firefox.bin", Constant.FIREFOX_BINARY_DIRECTORY_LINUX);
					else if (file.getOS().equals("windows")) System.setProperty("webdriver.firefox.bin", Constant.FIREFOX_BINARY_DIRECTORY_WINDOWS);

					// Firefox options
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", true);					
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
				}
				break;

			case "ie":

				if (driver == null) {

					// Set internet explorer driver
					if (file.getOS().equals("linux")) System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER_DIRECTORY_LINUX);
					else if (file.getOS().equals("windows")) System.setProperty("webdriver.ie.driver", Constant.IE_DRIVER_DIRECTORY_WINDOWS);

					// Internet explorer options
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability("ignoreZoomSetting", true);
					driver = new InternetExplorerDriver();
					driver.manage().window().maximize();
				}
				break;
			}

		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());

		} finally {
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			basePage = PageFactory.initElements(driver, BasePage.class);
			homePage = PageFactory.initElements(driver, Home_Page.class);
			createAccountPage = PageFactory.initElements(driver, CreateAccount_Page.class);
			myDashboardPage = PageFactory.initElements(driver, MyDashboard_Page.class);
			customerLoginPage = PageFactory.initElements(driver, CustomerLogin_Page.class);
			categoryPage = PageFactory.initElements(driver, Category_Page.class);
			productPage = PageFactory.initElements(driver, Product_Page.class);
		}

		return driver;
	}
}