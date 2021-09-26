package stepdefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import urbanladder.pageobject.homepagesearchpageobject;
import urbanladder.reusablecomponents.ReusableComponents;
import urbanladder.reusablecomponents.ReusableMethods;
import urbanladder.utility.ExtentReport;
import urbanladder.utility.Log;
import urbanladder.utility.PropertyFileReader;

public class homesearchpagestepdefinitions {
	WebDriver driver;
	private Logger log = Log.logger(homesearchpagestepdefinitions.class.getName());
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;

	    @Given("^User searches for a (.+)$")
	    public void user_searches_for_a(String product) throws Throwable {
	    	driver =  ReusableComponents.loadDriver();
	    	driver.get(PropertyFileReader.loadFile().getProperty("url"));
	    	extentTest = report.createTest("Search page");
	    	homepagesearchpageobject.search(driver, product, log);
	    }

	    @When("^User select the search button$")
	    public void user_select_the_search_button() throws Throwable {
	    	homepagesearchpageobject.click(driver, log);
	    }

	    @Then("^(.+) is validated$")
	    public void is_validated(String product) throws Throwable {
	    	ReusableMethods.TakeScreenShot(driver, "Gift Card");
	    	homepagesearchpageobject.verify(driver, product, log);
	    	log.info("Search page is validated");
	    	extentTest.pass("Validation of search page passed");
	    	report.flush();
			driver.close();
	    }
}
