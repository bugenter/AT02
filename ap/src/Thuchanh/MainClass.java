package Thuchanh;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainClass {
	static WebDriver driver = new FirefoxDriver();
	static WebDriverWait wait = new WebDriverWait(driver, 15);
//	static Register registerAccount = new Register(driver, "http://live.guru99.com");
	
//static Login login = new Login();
	public static void main(String[] args) throws InterruptedException {
//		register
		driver.manage().window().maximize();
//		registerAccount.registerAccountSuccess();
//		registerAccount.getClass();
//		registerAccount.registerAccountFail();
//		Login
//		Login.loginSuccessfully();
//		Login.loginFailWrongEmail();
//		Login.loginFailWrongPass();
//		shoppings
//		Shopping.testbtnAddToCart();
		new Shopping(driver, wait,"http://live.guru99.com/index.php/mobile.html");
		Shopping.testAddToCart_UserIsLogined();
		Shopping.testAddToWishlist_UserIsLogined();
	}

}
