package urbanladder.pageobject;
import urbanladder.uistore.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import urbanladder.reusablecomponents.*;
public class cartpageobject {
	public static void pass(WebDriver driver,Logger log) throws InterruptedException
	{
		Thread.sleep(1000);
	}
	public static void cart(WebDriver driver,Logger log) throws InterruptedException
	{
		ReusableMethods.getAttributeonly(cartui.text, driver);
	}
	public static void click(WebDriver driver, Logger log) {
		// TODO Auto-generated method stub
		ReusableMethods.click( cartui.cart,  driver);
	}
	
	
}
