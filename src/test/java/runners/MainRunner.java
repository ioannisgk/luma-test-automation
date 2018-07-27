package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)

@CucumberOptions(
				features = {"src/test/java/resources/features/"},
				glue = {"stepDefinitions" },
				monochrome = true,
				tags = {}, 
				plugin = {
						"pretty",
						"html:target/LumaTestReport",
						"json:target/LumaTestReport.json",
						"com.cucumber.listener.ExtentCucumberFormatter:target/report.html" })

public class MainRunner extends AbstractTestNGCucumberTests {
}