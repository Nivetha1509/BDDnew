package urbanladder.reusablecomponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import urbanladder.utility.*;
public class ReusableComponents {
	public static WebDriver loadDriver() {
		System.setProperty("webdriver.chrome.driver", PropertyFileReader.loadFile().getProperty("ChromeDriverPath"));
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		ReusableMethods.timelapse(driver);
		return driver;
	}
}
