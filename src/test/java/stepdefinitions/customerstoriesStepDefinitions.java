package stepdefinitions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import urbanladder.reusablecomponents.ReusableComponents;
import urbanladder.reusablecomponents.ReusableMethods;
import urbanladder.utility.PropertyFileReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import urbanladder.pageobject.customerStoriesPageObject;
import urbanladder.utility.ExtentReport;
import urbanladder.utility.Log;
public class customerstoriesStepDefinitions {
	WebDriver driver;
	private Logger log = Log.logger(customerstoriesStepDefinitions.class.getName());
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
    @Given("^User scroll down$")
    public void user_scroll_down() throws Throwable {
    	driver =  ReusableComponents.loadDriver();
    	driver.get(PropertyFileReader.loadFile().getProperty("url"));
    	extentTest = report.createTest("Customer Stories");
       customerStoriesPageObject.scroll(driver, log);
    }

    @When("^User click on customer stories$")
    public void user_click_on_customer_stories() throws Throwable {
    	customerStoriesPageObject.click(driver, log);
    }

    @Then("^Validating the images shown$")
    public void validating_the_images_shown() throws Throwable {
    	customerStoriesPageObject.image(driver, log);
    	ReusableMethods.TakeScreenShot(driver, "Customer Stories");
    	log.info("Customer Services page is validated");
    	extentTest.pass("Validation of customer service passed");
    	report.flush();
		driver.close();
    }
}
