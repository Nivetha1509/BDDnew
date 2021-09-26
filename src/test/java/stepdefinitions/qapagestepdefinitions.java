package stepdefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import urbanladder.pageobject.qandapageobject;
import urbanladder.reusablecomponents.ReusableComponents;
import urbanladder.reusablecomponents.ReusableMethods;
import urbanladder.utility.ExtentReport;
import urbanladder.utility.Log;
import urbanladder.utility.PropertyFileReader;

public class qapagestepdefinitions {
	WebDriver driver;
	private Logger log = Log.logger(qapagestepdefinitions.class.getName());
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
    @Given("^User clicks on the help button$")
    public void user_clicks_on_the_help_button() throws Throwable {
    		driver =  ReusableComponents.loadDriver();
        	driver.get(PropertyFileReader.loadFile().getProperty("url"));
        	extentTest = report.createTest("Validating QA page"); 
        	qandapageobject.qa(driver, log);
    }

    @When("^User asks for a (.+)$")
    public void user_asks_for_a(String question) throws Throwable {
    	qandapageobject.sendkeys(driver, question, log);
    }

    @Then("^verifing the obtained (.+)$")
    public void verifing_the_obtained(String data) throws Throwable {
    	qandapageobject.verify(driver, data, log);
    	ReusableMethods.TakeScreenShot(driver, "QA page");
    	log.info("QA page has been successfully validated");
    	extentTest.pass("Validation of QA page is completed");
    	report.flush();
		driver.close();
    }
}
