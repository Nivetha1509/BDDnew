package urbanladder.pageobject;
import urbanladder.uistore.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import urbanladder.reusablecomponents.*;
public class qandapageobject {
	public static void qa(WebDriver driver,Logger log) throws InterruptedException {
		// TODO Auto-generated method stub
		ReusableMethods.click(qandaui.qa, driver);
		Thread.sleep(1000);
	}

	public static void verify(WebDriver driver, String data ,Logger log) throws InterruptedException {
		ReusableMethods.getAttributeqa(qandaui.text, data, driver);
		
	}
	public static void sendkeys(WebDriver driver, String question, Logger log) {
		ReusableMethods.sendKeys(qandaui.searchbutton, question, driver);
		ReusableMethods.sendKeysArrowDown(qandaui.searchbutton, driver);
		ReusableMethods.sendKeysEnter(qandaui.searchbutton, driver);
	}
	
	
}
