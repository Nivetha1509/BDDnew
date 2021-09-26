package stepdefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import urbanladder.pageobject.signinpageobject;
import urbanladder.reusablecomponents.ReusableComponents;
import urbanladder.reusablecomponents.ReusableMethods;
import urbanladder.utility.ExtentReport;
import urbanladder.utility.Log;
import urbanladder.utility.PropertyFileReader;

public class signupstepdefinitions {
	WebDriver driver;
	private Logger log = Log.logger(signupstepdefinitions.class.getName());
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
    @Given("^User open the browser and enters the (.+)$")
    public void user_open_the_browser_and_enters_the(String email) throws Throwable {
    	driver =  ReusableComponents.loadDriver();
    	driver.get(PropertyFileReader.loadFile().getProperty("url"));
    	extentTest = report.createTest("Automating Signup page");
    	signinpageobject.email(driver, email, log);
    }

    @When("^User enters (.+)$")
    public void user_enters(String password) throws Throwable {
    	signinpageobject.password(driver, password, log);
    }

    @Then("^User clicking on submit$")
    public void user_clicking_on_submit() throws Throwable {
    	signinpageobject.click(driver, log);
    	ReusableMethods.TakeScreenShot(driver, "Sign up");
    	log.info("Login page has been successfully automated");
    	extentTest.pass("Signup age automated successfully");
    	report.flush();
		driver.close();
    }

}
