package stepdefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import urbanladder.pageobject.subscriptionpageobject;
import urbanladder.reusablecomponents.ReusableComponents;
import urbanladder.reusablecomponents.ReusableMethods;
import urbanladder.utility.ExtentReport;
import urbanladder.utility.Log;
import urbanladder.utility.PropertyFileReader;

public class subscriptionstepdefinitions {
	WebDriver driver;
	private Logger log = Log.logger(subscriptionstepdefinitions.class.getName());
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	@Given("^User scroll down and send (.+) in the box$")
    public void user_scroll_down_and_send_in_the_box(String email) throws Throwable {  
        driver =  ReusableComponents.loadDriver();
    	driver.get(PropertyFileReader.loadFile().getProperty("url"));
    	extentTest = report.createTest("Subscription page");
    	subscriptionpageobject.subscription(driver, email, log);
    }

    @When("^User click on the subscription button$")
    public void user_click_on_the_subscription_button() throws Throwable {
    	subscriptionpageobject.click(driver, log);
    }

    @Then("^Verifying the (.+)$")
    public void verifying_the(String text) throws Throwable {
    	subscriptionpageobject.verify(driver, text, log);
    	ReusableMethods.TakeScreenShot(driver, "Subscription");
    	log.info("Subscription age has been validated successfully");
    	extentTest.pass("Subscription page has been validated");
    	report.flush();
		driver.close();
    }
}
