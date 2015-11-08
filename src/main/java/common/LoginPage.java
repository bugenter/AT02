package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	public  WebDriverWait wait;
	public  WebDriver driver;
	public  By E_LOGIN_LINK = By.xpath("//a[@title ='Log In']");
	public  By E_EMAIL_LOGIN = By.id("email");
	public  By E_PASS_LOGIN = By.id("pass");
	public  By E_BTN_LOGIN = By.id("send2");
	public  By E_DASHBOARD = By.xpath(".//h1[. = 'My Dashboard']");
	public  By E_SATUS_ON_LOGINPAGE = By.xpath("//*[@class = 'form-instructions' and text() ='If you have an account with us, please log in.' ]");
	public  By E_MOBILE_LINK = By.xpath(".//a[text()='Mobile']");
	public  By E_TV_LINK = By.xpath(".//*[@class = 'nav-primary']/li[2]");
	public  By E_ACCOUNT_LINK = By.xpath(".//a[@class='skip-link skip-account']/span[text()='Account']");
	public By E_ALERT_LOGIN_FAIL_NOT_EXIST= By.xpath("//*[text()='Invalid login or password.']");
	public  void gotoLoginPage(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(E_ACCOUNT_LINK));
		driver.findElement(E_ACCOUNT_LINK).click();
		driver.findElement(E_LOGIN_LINK).click();
	}
	public  void enterDataOnLogin(String email, String pass){
		wait.until(ExpectedConditions.visibilityOfElementLocated(E_EMAIL_LOGIN));
		driver.findElement(E_EMAIL_LOGIN).sendKeys(email);
		driver.findElement(E_PASS_LOGIN).sendKeys(pass);
	}
}
