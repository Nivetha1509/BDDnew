package stepdefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import urbanladder.pageobject.trackorderpageobject;
import urbanladder.reusablecomponents.ReusableComponents;
import urbanladder.reusablecomponents.ReusableMethods;
import urbanladder.utility.ExtentReport;
import urbanladder.utility.Log;
import urbanladder.utility.PropertyFileReader;

public class trackstepdefinitions {
	WebDriver driver;
	private Logger log = Log.logger(trackstepdefinitions.class.getName());
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	@Given("^User click on track order icon$")
    public void user_click_on_track_order_icon() throws Throwable {
		driver =  ReusableComponents.loadDriver();
    	driver.get(PropertyFileReader.loadFile().getProperty("url"));
    	extentTest = report.createTest("Track order page");
       trackorderpageobject.track(driver, log); 
    }

    @When("^User enter the (.+) and (.+)$")
    public void user_enter_the_and(String orderno, String phonenumber) throws Throwable {
    	trackorderpageobject.values(driver, orderno, phonenumber, log);
    }
    @Then("^User click on submit$")
    public void user_click_on_submit() throws Throwable {
    	trackorderpageobject.submit(driver, log);
    	ReusableMethods.TakeScreenShot(driver, "Track");
    	log.info("Track page has been validated");
    	extentTest.pass("Track page validated");
    	report.flush();
		driver.close();
    }
}
