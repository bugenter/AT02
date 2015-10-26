package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.homePage;
import common.loginPage;


public class loginTest {
	WebDriver dr ;
	homePage home;
	loginPage log;

	@BeforeMethod
	public void before(){
		WebDriver dr = new FirefoxDriver();		
		home = new homePage(dr);
		log = new loginPage(dr);
		home.openHomepage();
		log.gotoLogin();
	}

	@Test
	public void testLogin(){
		log.inputLogin("phuong@abc.com", "111111");
		log.verifyLogin(true);
	}

	@AfterMethod
	public void after(){
		//		home.logOut();
		home.closeBrowser();
	}

}