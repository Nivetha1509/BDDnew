package urbanladder.reusablecomponents;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import urbanladder.utility.PropertyFileReader;

import urbanladder.utility.*;

public class ReusableMethods {

	public static void loadURL(WebDriver driver) {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		timelapse(driver);
	}
	
	public static void timelapse(WebDriver driver) {
		int wait = Integer.parseInt(PropertyFileReader.loadFile().getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}
	public static void TakeScreenShot(WebDriver driver,String title) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(src,new File(".\\screenshot\\"+title+"screenshot.png"));
	}
	
	
	public static boolean getElement(By selector, WebDriver driver) {
		try {
			driver.findElement(selector);
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Element %s doesnt exist", selector));
		}
		return false;
	}
	public static WebElement getElementActions(By selector, WebDriver driver) {
		try {
			driver.findElement(selector);
			
		}
		catch(Exception e) {
			System.out.println(String.format("Element %s doesnt exist", selector));
		}
		return null;
		
	}
	
	public static List<WebElement> image(By selector, WebDriver driver) {
		try {
			driver.findElement(selector);
			List<WebElement> listwebelement = driver.findElements(selector);
	        System.out.println("Number of images in the Customer Stories is"+" "+listwebelement.size());
			return listwebelement;
		}
		catch(Exception e) {
			
			System.out.println(String.format("Element %s doesnt exist", selector));
		}
		List<WebElement> flag = null;
		return flag;
	}
	
	
	public static boolean sendKeys(By selector, String keys, WebDriver driver) {
		try {
			driver.findElement(selector).sendKeys(keys);;
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Keys could not be sent to Element %s ", selector));
		}
		return false;
	}
	
	public static boolean sendKeysEnter(By selector, WebDriver driver) {
		try {
			driver.findElement(selector).sendKeys(Keys.ENTER);;
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Keys could not be sent to Element %s ", selector));
		}
		return false;
	}
	public static boolean sendKeysArrowDown(By selector, WebDriver driver) {
		try {
			driver.findElement(selector).sendKeys(Keys.ARROW_DOWN);;
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Keys could not be sent to Element %s ", selector));
		}
		return false;
	}
	
	
	public static boolean click(By selector, WebDriver driver) {
		try {
			driver.findElement(selector).click();;
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Element %s could not be clicked ", selector));
		}
		return false;
	}


	public static void getAttribute(By selector, String keys, WebDriver driver) {
		// TODO Auto-generated method stub
		try {
			String expected=driver.findElement(selector).getAttribute("innerHTML");;
			keys="'"+keys+"'";
			Assert.assertEquals(keys, expected);
			
		}
		catch(Exception e) {
			System.out.println(String.format("Keys are not available %s ", selector));
		}
	}
	public static void getAttributeqa(By selector, String keys, WebDriver driver) {
		// TODO Auto-generated method stub
		try {
			String expected=driver.findElement(selector).getAttribute("innerHTML");;
			//expected="'"+expected+"'";
			Assert.assertEquals(keys,expected);
			
			
		}
		catch(Exception e) {
			System.out.println(String.format("Keys are not available %s ", selector));
		}
	}
		public static void getAttributeonly(By selector,  WebDriver driver) {
			// TODO Auto-generated method stub
			try {
				System.out.println(driver.findElement(selector).getAttribute("innerHTML"));;
				
			}
			catch(Exception e) {
				System.out.println(String.format("Keys are not available %s ", selector));
			}
		
		
	}
}
