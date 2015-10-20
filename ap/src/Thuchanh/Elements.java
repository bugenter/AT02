package Thuchanh;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Elements {
	static WebDriver driver;
	static WebDriverWait wait;
	public static String E_BASE_URL = "http://live.guru99.com/index.php/mobile.html";
	// homepage
	public static By E_MOBILE_LINK = By.xpath(".//a[text()='Mobile']");
	public static By E_TV_LINK = By.xpath(".//*[@class = 'nav-primary']/li[2]");
	//	btn to register
	public static By E_ACCOUNT_LINK = By.xpath(".//a[@class='skip-link skip-account']/span[text()='Account']");
	public static By E_REGISTER_LINK = By.xpath(".//*[text()='Register']");
	//	element on register
	public static By E_FIRSTNAME = By.xpath("//input[@id='firstname']");
	public static By E_LASTNAME = By.id("lastname");
	public static By E_REGISTER_EMAIL = By.id("email_address");
	public static By E_PASSWORD = By.id("password");
	public static By E_PASSWORD_CONFIRM = By.id("confirmation");
	public static By E_REGISTER_SUBMIT = By.xpath(".//*[@class = 'button' and @type ='submit']");

	//	element on login
	public static By E_LOGIN_LINK = By.xpath("//a[@title ='Log In']");
	public static By E_EMAIL_LOGIN = By.id("email");
	public static By E_PASS_LOGIN = By.id("pass");
	public static By E_BTN_LOGIN = By.id("send2");
	public static By E_DASHBOARD = By.xpath(".//h1[. = 'My Dashboard']");
	public static By E_SATUS_ON_LOGINPAGE = By.xpath("//*[@class = 'form-instructions' and text() ='If you have an account with us, please log in.' ]");


	/**
	 * get random string from alphabet & number
	 * @param length
	 * @return
	 */
	public static String randomString(int length){
		String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
				"1234567890"; //numbers
		return RandomStringUtils.random(length, allowedChars);
	}
	public static void gotoLoginPage(){
		wait.until(ExpectedConditions.visibilityOfElementLocated(E_ACCOUNT_LINK));
		WebElement btnAccount = driver.findElement(E_ACCOUNT_LINK);
		btnAccount.click();
		if(driver.findElements(E_LOGIN_LINK).size()>0){
		WebElement btnLogin = driver.findElement(E_LOGIN_LINK);
		btnLogin.click();
		}
	}
	public static void login(String email, String pass){
		gotoLoginPage();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(E_EMAIL_LOGIN));
		WebElement txtEmail = driver.findElement(E_EMAIL_LOGIN);
		txtEmail.sendKeys("nguyenpham90913@gmail.com");
		WebElement txtPass = driver.findElement(E_PASS_LOGIN);
		txtPass.sendKeys("123456");
		WebElement btnLogin = driver.findElement(E_BTN_LOGIN);
		btnLogin.click();
	}
	public static void addProductToCart(String productname){
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+productname+"')]/../../..//button")));
		WebElement btnAddtocart = driver.findElement(By.xpath("//a[contains(text(),'"+productname+"')]/../../..//button"));
		btnAddtocart.click();
	}
	public static void waitElement(By element){
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public static void findProductInProductList(String productname) throws InterruptedException{
		Thread.sleep(3000);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'product-name']/a[contains(text(),'"+productname+"')]")));
		driver.findElement(By.xpath("//*[@class = 'product-name']/a[contains(text(),'"+productname+"')]"));
	}
	
}