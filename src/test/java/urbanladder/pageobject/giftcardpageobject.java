package urbanladder.pageobject;
import urbanladder.uistore.*;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import urbanladder.reusablecomponents.*;
public class giftcardpageobject {
	public static void gift(WebDriver driver, Logger log) throws InterruptedException {
		ReusableMethods.click(giftcardUi.giftcard, driver);
	  WebElement ele = driver.findElement(By.xpath("//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[1]"));
	  Actions action = new Actions(driver);
	  action.moveToElement(ele).perform();
	  ReusableMethods.click(giftcardUi.chose, driver); 
	}
	public static void money(WebDriver driver, Logger log) throws InterruptedException {
		ReusableMethods.click(giftcardUi.money, driver);
		ReusableMethods.sendKeysArrowDown(giftcardUi.date, driver);
		ReusableMethods.sendKeysEnter(giftcardUi.date, driver);
	}
	public static void next(WebDriver driver,  Logger log) throws InterruptedException {
		 ReusableMethods.click(giftcardUi.next, driver);
	}
	
	
}
