package stepdefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import urbanladder.pageobject.loginpageobject;
import urbanladder.reusablecomponents.ReusableComponents;
import urbanladder.reusablecomponents.ReusableMethods;
import urbanladder.utility.ExtentReport;
import urbanladder.utility.Log;
import urbanladder.utility.PropertyFileReader;

public class loginpagestepdefinitions {
	WebDriver driver;
	private Logger log = Log.logger(loginpagestepdefinitions.class.getName());
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;

    @Given("^User selects the login icon$")
    public void user_selects_the_login_icon() throws Throwable {
    	driver =  ReusableComponents.loadDriver();
    	driver.get(PropertyFileReader.loadFile().getProperty("url"));
    	extentTest = report.createTest("Login page");
    	loginpageobject.login(driver, log);
    }

    @When("^User gives the (.+) and (.+)$")
    public void user_gives_the_and(String email, String password) throws Throwable {
    	loginpageobject.sendkeys(driver, email, password, log);
    }

    @Then("^User clicks on login$")
    public void user_clicks_on_login() throws Throwable {
    	loginpageobject.submit(driver, log);
    	ReusableMethods.TakeScreenShot(driver, "Login page");
    	log.info("Login page is automated");
    	extentTest.pass("Automation of login page passed");
    	report.flush();
		driver.close();
    }
}
