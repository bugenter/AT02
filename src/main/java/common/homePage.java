package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage extends commonBase {
	public WebDriver driver;

	//Login, logout
	public static By ELEMENT_ACCOUNT = By.xpath(".//a/*[text()='Account']");
	public static By ELEMENT_LOGIN = By.xpath(".//*[text()='Log In']");
	public static By ELEMENT_BUTTON_LOGIN = By.xpath(".//span[text()='Login']/../..");
	public static By ELEMENT_LOGOUT = By.xpath(".//a[text()='Log Out']");
	public static By ELEMENT_LOGIN_EMAIL = By.id("email");
	public static By ELEMENT_LOGIN_PASS = By.id("pass");
	public static By ELEMENT_NAME_DARDBOARD = By.xpath(".//*[contains(text(),'Hello, phuong nguyen')]");

	public homePage (WebDriver dr){
		driver = dr;
	}

	/**
	 * Open the home page
	 */
	public void openHomepage(){
		//		WebDriver dr = new FirefoxDriver();
		String baseUrl = "http://live.guru99.com/index.php/";
		//open browser
		driver.get(baseUrl);
		//maximize browser
		driver.manage().window().maximize();
	}

	/**
	 * go to logout action
	 */
	public  void logOut(){
		driver.findElement(ELEMENT_ACCOUNT).click();
		driver.findElement(ELEMENT_LOGOUT).click();
	}

	/**
	 * close browser
	 */
	public void closeBrowser(){
		driver.close();
	}
}