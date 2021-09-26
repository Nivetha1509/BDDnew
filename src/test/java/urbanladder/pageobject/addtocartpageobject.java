package urbanladder.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import urbanladder.reusablecomponents.*;
import urbanladder.uistore.*;

public class addtocartpageobject {
	public static void search(WebDriver driver, String product, Logger log) throws InterruptedException {
	ReusableMethods.sendKeys(addtocartUi.search, product, driver);
	ReusableMethods.click(addtocartUi.button, driver);
	}
	public static void product(WebDriver driver,  Logger log) throws InterruptedException{
		ReusableMethods.click(addtocartUi.product, driver);
	}
	public static void cart(WebDriver driver,  Logger log) throws InterruptedException{
		ReusableMethods.click(addtocartUi.cart, driver);
	}
	
	

}
