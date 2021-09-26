package urbanladder.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import urbanladder.uistore.*;
import urbanladder.reusablecomponents.*;
public class subscriptionpageobject {
	public static void subscription(WebDriver driver, String email, Logger log) throws InterruptedException {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1200)", "");
	    Thread.sleep(1000);
		ReusableMethods.sendKeys( subscriptionUi.email, email, driver);
		
	}
	public static void click(WebDriver driver,  Logger log) throws InterruptedException
	{
		ReusableMethods.click(subscriptionUi.button, driver);
		Thread.sleep(1000);
	}
	public static void verify(WebDriver driver, String data, Logger log) throws InterruptedException
	{
		ReusableMethods.getAttributeqa(subscriptionUi.text, data, driver);
	}
}
