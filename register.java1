package suiteTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.commonBase;
import common.homePage;
import common.registerPage;


public class register  {
	WebDriver dr ;
	homePage home;
	registerPage reg;


	@BeforeMethod
	public void before(){
		WebDriver dr = new FirefoxDriver();		
		home = new homePage(dr);
		reg = new registerPage(dr);
		home.openHomepage();
		reg.gotoRegister();
	}

	@Test
	public void registerSuccess() {
		String abc =   commonBase.getRandomString(4);
		String email = "phuongnt_" + abc + "@abcd.com";
		reg.inputRegister("phuong","nguyen",email,"111111","111111");
		reg.verifyRegister(true);

	}

	@Test
	public void registerFail() {
		reg.inputRegister("phuong","nguyen",null,"111111","111111");
		reg.verifyRegister(false);
	}



	@AfterMethod
	public void after(){
		home.closeBrowser();
	}





}
