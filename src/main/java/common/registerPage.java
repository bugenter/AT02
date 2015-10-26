package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPage extends commonBase {
	public WebDriver driver;
	//Register
	public static By ELEMENT_ACCOUNT = By.xpath(".//a/*[text()='Account']");
	public static By ELEMENT_REGISTER = By.xpath(".//*[text()='Register']");
	public static By ELEMENT_BUTTON_REGISTER = By.xpath(".//span[text()='Register']/../..");
	public static By ELEMENT_F_NAME = By.id("firstname");
	public static By ELEMENT_L_NAME = By.id("lastname");
	public static By ELEMENT_EMAIL = By.id("email_address");
	public static By ELEMENT_PASS = By.id("password");
	public static By ELEMENT_PASS_CONFIRM = By.id("confirmation");
	public static By ELEMENT_TEXT_REGISTER_SUCESS = By.xpath(".//*[text()='Thank you for registering with Main Website Store.']");
	public static By ELEMENT_TEXT_REGISTER_FAIL = By.id("advice-required-entry-email_address");


	public registerPage (WebDriver dr){
		driver = dr;
	}

	/**
	 * gotoRegister form
	 */
	public void gotoRegister()
	{
		driver.findElement(ELEMENT_ACCOUNT).click();
		driver.findElement(ELEMENT_REGISTER).click();
	}

	/**
	 * input value to register page
	 * @param f_name
	 * @param l_name
	 * @param email
	 * @param pass
	 * @param confirm_pass
	 */
	public  void inputRegister(String f_name, String l_name, String email, String pass, String confirm_pass) {
		typeText(driver.findElement(ELEMENT_F_NAME),f_name);
		typeText(driver.findElement(ELEMENT_L_NAME),l_name);
		typeText(driver.findElement(ELEMENT_EMAIL),email);
		typeText(driver.findElement(ELEMENT_PASS),pass);
		typeText(driver.findElement(ELEMENT_PASS_CONFIRM),confirm_pass);
		driver.findElement(ELEMENT_BUTTON_REGISTER).click();
	}

	/**
	 * Verify register
	 * @param isSuccess
	 */
	public  void verifyRegister(Boolean isSuccess){
		if(isSuccess){
			driver.findElement(ELEMENT_TEXT_REGISTER_SUCESS);
		}
		else
		{
			driver.findElement(ELEMENT_TEXT_REGISTER_FAIL);
		}
	}
}