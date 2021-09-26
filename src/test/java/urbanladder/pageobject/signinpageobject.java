package urbanladder.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import urbanladder.uistore.*;
import urbanladder.reusablecomponents.*;
public class signinpageobject {
	public static void email(WebDriver driver, String email, Logger log) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(10000);
		ReusableMethods.sendKeys(signupui.email, email, driver);	
	}
	public static void password(WebDriver driver,String password, Logger log) throws InterruptedException 
	{
		ReusableMethods.sendKeys(signupui.password, password, driver);
	}
	public static void click(WebDriver driver,  Logger log) throws InterruptedException 
	{
		Thread.sleep(10000);
		ReusableMethods.click(signupui.click, driver);	
	}
	
	

}
