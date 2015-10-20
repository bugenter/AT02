package Thuchanh;

import org.openqa.selenium.WebDriver;

public class Login extends Elements{
static WebDriver driver;
/**
 * LG001: Login successfully
 */
	public static void loginSuccessfully(){
		gotoLoginPage();
		login("nguyenpham90913@gmail.com","123456");
		driver.findElement(E_DASHBOARD);
	}
	/**
	 * LG002: Check login fail with wrong email
	 */
	public static void loginFailWrongEmail(){
		gotoLoginPage();
		login("dsffjls","123456");
		driver.findElement(E_SATUS_ON_LOGINPAGE);
	}
	/**
	 * LG003: check login fail with wrong password
	 */
	public static void loginFailWrongPass(){
		gotoLoginPage();
		login("nguyenpham90913@gmail.com","342432");
		driver.findElement(E_SATUS_ON_LOGINPAGE);
	}
	
}
