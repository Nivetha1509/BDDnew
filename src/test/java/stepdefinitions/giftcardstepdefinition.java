package stepdefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import urbanladder.pageobject.giftcardpageobject;
import urbanladder.reusablecomponents.ReusableComponents;
import urbanladder.reusablecomponents.ReusableMethods;
import urbanladder.utility.ExtentReport;
import urbanladder.utility.Log;
import urbanladder.utility.PropertyFileReader;

public class giftcardstepdefinition {
	WebDriver driver;
	private Logger log = Log.logger(giftcardstepdefinition.class.getName());
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	@Given("^User selecting the required gift card$")
    public void user_selecting_the_required_gift_card() throws Throwable {
		driver =  ReusableComponents.loadDriver();
    	driver.get(PropertyFileReader.loadFile().getProperty("url"));
    	extentTest = report.createTest("Search page");
    	giftcardpageobject.gift(driver, log);
    }

    @When("^User entering the details in the gift card$")
    public void user_entering_the_details_in_the_gift_card() throws Throwable {
    	giftcardpageobject.money(driver, log);
    }

    @Then("^Checking the next button$")
    public void validating_the() throws Throwable {
    	giftcardpageobject.next(driver,log);
    	ReusableMethods.TakeScreenShot(driver, "Gift Card");
    	log.info("Gift card page is validated");
    	extentTest.pass("Validation of gift page passed");
    	report.flush();
		driver.close();
    }
    /*@Then("^Validating the (.+)$\")
    public void validating_the_nice_so_who_is_this_lucky_person(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
    	giftcardpageobject.verify(driver, message, log);
    	ReusableMethods.TakeScreenShot(driver, "Gift Card");
    	log.info("Gift card page is validated");
    	extentTest.pass("Validation of gift page passed");
    	report.flush();
		driver.close();*/
    
}
