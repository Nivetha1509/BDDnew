package stepdefinitions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import urbanladder.pageobject.cartpageobject;
import urbanladder.reusablecomponents.ReusableComponents;
import urbanladder.reusablecomponents.ReusableMethods;
import urbanladder.utility.ExtentReport;
import urbanladder.utility.Log;
import urbanladder.utility.PropertyFileReader;
public class cartstepdefinitions {
	WebDriver driver;
	private Logger log = Log.logger(cartstepdefinitions.class.getName());
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;

    @Given("^User click on the cart$")
    public void user_click_on_the_cart() throws Throwable {
    	driver =  ReusableComponents.loadDriver();
    	driver.get(PropertyFileReader.loadFile().getProperty("url"));
    	extentTest = report.createTest("Checking the cart page");
    	cartpageobject.click(driver, log);
    }

    @When("^User wait for the page to load$")
    public void user_wait_for_the_page_to_load() throws Throwable {
    	cartpageobject.pass(driver, log);
    }

    @Then("^Validating the text shown$")
    public void validating_the_text_shown() throws Throwable {
    	cartpageobject.cart(driver, log);
    	ReusableMethods.TakeScreenShot(driver, "Cart");
    	log.info("Cart page has been verified");
    	extentTest.pass("Text has been successfully verified");
    	report.flush();
		driver.close();
    }
	
}
