package urbanladder.pageobject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import urbanladder.uistore.*;
import urbanladder.reusablecomponents.*;
public class trackorderpageobject {

		public static void values(WebDriver driver, String orderno,String phonenumber,Logger log) throws InterruptedException
		{
			ReusableMethods.sendKeys(trackorderui.orderno, orderno, driver);
			ReusableMethods.sendKeys(trackorderui.phoneno, phonenumber, driver);
		}
		public static void submit(WebDriver driver, Logger log) throws InterruptedException
		{
			ReusableMethods.click(trackorderui.submit, driver);
		}
		public static void track(WebDriver driver, Logger log) {
			// TODO Auto-generated method stub
			ReusableMethods.click(trackorderui.track, driver);
		}
		
		
		
}


