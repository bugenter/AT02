package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends commonBase {
	public WebDriver driver;

	//Login, logout
	public static By ELEMENT_ACCOUNT = By.xpath(".//a/*[text()='Account']");
	public static By ELEMENT_LOGIN = By.xpath(".//*[text()='Log In']");
	public static By ELEMENT_BUTTON_LOGIN = By.xpath(".//span[text()='Login']/../..");
	public static By ELEMENT_LOGOUT = By.xpath(".//a[text()='Log Out']");
	public static By ELEMENT_LOGIN_EMAIL = By.id("email");
	public static By ELEMENT_LOGIN_PASS = By.id("pass");
	public static By ELEMENT_NAME_DARDBOARD = By.xpath(".//*[contains(text(),'Hello, phuong nguyen')]");

	/**
	 * construction
	 * @param dr
	 */
	public loginPage(WebDriver dr){
		driver = dr;
	}

	/**
	 * go to login page
	 */
	public void gotoLogin()
	{
		driver.findElement(ELEMENT_ACCOUNT).click();
		driver.findElement(ELEMENT_LOGIN).click();

	}

	/**
	 * input valua to login form
	 * @param email
	 * @param pass
	 */
	public void inputLogin(String email, String pass){
		typeText(driver.findElement(ELEMENT_LOGIN_EMAIL),email);
		typeText(driver.findElement(ELEMENT_LOGIN_PASS),pass);
		driver.findElement(ELEMENT_BUTTON_LOGIN).click();		
	}

	/**
	 * verify login
	 * @param isSuccess
	 */
	public  void verifyLogin(boolean isSuccess){
		if(isSuccess){
			driver.findElement(ELEMENT_ACCOUNT);
			driver.findElement(ELEMENT_LOGOUT);
		}
		else
		{
			driver.findElement(ELEMENT_BUTTON_LOGIN);
		}
	}
}