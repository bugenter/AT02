package common;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register {
	LoginPage login = new LoginPage();
	protected  WebDriver driver;
	protected  WebDriverWait wait;
	public  By E_REGISTER_LINK = By.xpath(".//*[text()='Register']");
	public  By E_FIRSTNAME = By.xpath("//input[@id='firstname']");
	public  By E_LASTNAME = By.id("lastname");
	public  By E_REGISTER_EMAIL = By.id("email_address");
	public  By E_PASSWORD = By.id("password");
	public  By E_PASSWORD_CONFIRM = By.id("confirmation");
	public  By E_REGISTER_SUBMIT = By.xpath(".//*[@class = 'button' and @type ='submit']");
	public  By E_ALERT_SUCCESSFULLY = By.xpath(".//span[text()='Thank you for registering with Main Website Store.']");
	public  String randomString(int length){
		String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
				"1234567890"; //numbers
		return RandomStringUtils.random(length, allowedChars);
	}
	public  void gotoRegisterPage(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(login.E_ACCOUNT_LINK));
		driver.findElement(login.E_ACCOUNT_LINK).click();
		driver.findElement(E_REGISTER_LINK).click();
	}
	public  void enterDataRegister(String Firstname, String Lastname, String Email, String Password, String PasswordConfirm){
		wait.until(ExpectedConditions.visibilityOfElementLocated(E_FIRSTNAME));
		driver.findElement(E_FIRSTNAME).sendKeys(Firstname);
		driver.findElement(E_LASTNAME).sendKeys(Lastname);
		driver.findElement(E_REGISTER_EMAIL).sendKeys(Email);
		driver.findElement(E_PASSWORD).sendKeys(Password);
		driver.findElement(E_PASSWORD_CONFIRM).sendKeys(PasswordConfirm);
	}
	
}
