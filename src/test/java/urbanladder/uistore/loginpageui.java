package urbanladder.uistore;

import org.openqa.selenium.By;

public class loginpageui {
	
		public static By mainmenu=By.cssSelector("#header > div.header__topBar > div > section.header__topBar_sectionRight > ul > li.header__topBarIconList_profile-icon > span > svg > path");
		public static By submenu=By.xpath("//*[@id=\'header\']/div[1]/div/section[3]/ul/li[2]/span/ul/li[1]/a");
		public static By mailid=By.xpath("/html/body/div[6]/div/div[1]/div/div[2]/div[3]/form/div/input");
		public static By password=By.xpath("/html/body/div[6]/div/div[1]/div/div[2]/div[3]/form/div/div/div/input");
		public static By click=By.xpath("//*[@id=\"ul_site_login\"]");
}
