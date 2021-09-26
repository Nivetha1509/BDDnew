package urbanladder.pageobject;
import urbanladder.uistore.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import urbanladder.reusablecomponents.*;
public class customerStoriesPageObject {
	public static void scroll(WebDriver driver,  Logger log) throws InterruptedException {
		// TODO Auto-generated method stub
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,1200)", "");
	}
	public static void click(WebDriver driver,  Logger log) throws InterruptedException
	{
		Thread.sleep(1000);
		ReusableMethods.click( customerStoriesUi.cs,  driver);
	}
	public static void image(WebDriver driver,  Logger log) throws InterruptedException
	{
		ReusableMethods.image(customerStoriesUi.image, driver);
	}
	
	
}
