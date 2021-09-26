package urbanladder.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import urbanladder.reusablecomponents.ReusableMethods;
import urbanladder.uistore.homepagesearchui;
import urbanladder.uistore.*;

public class homepagesearchpageobject {

	public static void search(WebDriver driver, String data, Logger log) throws InterruptedException {
		// TODO Auto-generated method stub
		ReusableMethods.sendKeys( homepagesearchui.search, data, driver);
		Thread.sleep(1000);
		
	}
	public static void click(WebDriver driver, Logger log) throws InterruptedException {
		ReusableMethods.click(homepagesearchui.searchbutton, driver);
		Thread.sleep(1000);
	}
	public static void verify(WebDriver driver, String data, Logger log) throws InterruptedException {
		ReusableMethods.getAttribute(homepagesearchui.text, data, driver);
	}
	
}
