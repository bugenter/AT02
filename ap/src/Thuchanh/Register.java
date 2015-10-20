package Thuchanh;

//import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register extends Elements {
	static WebDriver driver;//= new FirefoxDriver();
	static WebDriverWait wait;
	static String url = "http://live.guru99.com";
	/**
	 * ham khoi tao voi 2 tham so 
	 * @param webdriver
	 * @param baseUrl
	 */
	public Register(WebDriver webdriver, String baseUrl){
		Register.driver= webdriver;
		url = baseUrl;
		wait= new WebDriverWait(driver,30);
		webdriver.get(baseUrl);
	}

	/**
	 * RG_001 register success
	 */
	public void registerAccountSuccess(){
		WebElement btnAccount = driver.findElement(E_ACCOUNT_LINK);
		btnAccount.click();
		WebElement btnRegister =driver.findElement(E_REGISTER_LINK);
		btnRegister.click();
		enterDataToRegister("pham", "tham", randomString(5) +"@gmail.com", "123456", "123456");
		WebElement btnSubmitRegister = driver.findElement(E_REGISTER_SUBMIT);
		btnSubmitRegister.click();
		WebElement alertSuccess=driver.findElement(By.xpath(".//span[text()='Thank you for registering with Main Website Store.']"));
		//		wait for alert announce account was created success
		wait.until(ExpectedConditions.visibilityOf(alertSuccess));
	}
	
	/**
	 * RG_002 register fail
	 */
	public void registerAccountFail(){
		WebElement btnAccount = driver.findElement(E_ACCOUNT_LINK);
		btnAccount.click();
		WebElement btnRegister =driver.findElement(E_REGISTER_LINK);
		btnRegister.click();
		enterDataToRegister(" ", " ", "phamthamgmail.com", "123456", "1234f56");
		WebElement btnSubmitRegister = driver.findElement(E_REGISTER_SUBMIT);
		btnSubmitRegister.click();
		WebElement statusCreateAccount = driver.findElement(By.xpath("//*[text()='Create an Account']"));
		statusCreateAccount.isDisplayed();
		System.out.print("pass");
	}


	/**
	 * function nhap du lieu cho form dang ky
	 * @param firtName
	 * @param lastName
	 * @param registerEmail
	 * @param password
	 * @param confirmPass
	 */
	public static void enterDataToRegister(String firtName, String lastName, String registerEmail, String password, String confirmPass){

		WebElement txtFirstName = driver.findElement(E_FIRSTNAME);
		txtFirstName.sendKeys(firtName);
		WebElement txtLastName = driver.findElement(E_LASTNAME);
		txtLastName.sendKeys(lastName);
		WebElement txtEmail = driver.findElement(E_REGISTER_EMAIL);
		txtEmail.sendKeys(registerEmail);
		WebElement txtPass = driver.findElement(E_PASSWORD);
		txtPass.sendKeys(password);
		WebElement txtConfirm = driver.findElement(E_PASSWORD_CONFIRM);
		txtConfirm.sendKeys(confirmPass);
	}
}
