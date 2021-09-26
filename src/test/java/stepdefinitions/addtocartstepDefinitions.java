package stepdefinitions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import urbanladder.reusablecomponents.ReusableMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import urbanladder.pageobject.addtocartpageobject;
import urbanladder.pageobject.homepagesearchpageobject;
import urbanladder.reusablecomponents.ReusableComponents;
import urbanladder.utility.ExtentReport;
import urbanladder.utility.Log;
import urbanladder.utility.PropertyFileReader;

public class addtocartstepDefinitions {
	WebDriver driver;
	private Logger log = Log.logger(addtocartstepDefinitions.class.getName());
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;

    @Given("^User is searching for a (.+)$")
    public void user_is_searching_for_a(String product) throws Throwable {
    	driver =  ReusableComponents.loadDriver();
    	driver.get(PropertyFileReader.loadFile().getProperty("url"));
    	extentTest = report.createTest("Adding a product to the cart");
    	addtocartpageobject.search(driver, product, log);
    }

    @When("^User selecting on the particular product$")
    public void user_selecting_on_the_particular_product() throws Throwable {
    	addtocartpageobject.product(driver, log);
        
    }

    @Then("^User adding the product to cart$")
    public void user_adding_the_product_to_cart() throws Throwable {
    	addtocartpageobject.cart(driver, log);
    	ReusableMethods.TakeScreenShot(driver, "Adding product to cart");
    	log.info("Product has been successfully added to cart");
    	extentTest.pass("Product has been added");
    	report.flush();
		driver.close();
    }
}
