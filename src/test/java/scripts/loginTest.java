package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import common.homePage;
import common.loginPage;
import datadriven.Constant;
import datadriven.ExcelUtils;


public class loginTest {
	WebDriver dr ;
	homePage home;
	loginPage log;

	@BeforeMethod(groups={"testlogin"})
	public void before(){
		WebDriver dr = new FirefoxDriver();		
		home = new homePage(dr);
		log = new loginPage(dr);
		home.openHomepage();
		log.gotoLogin();
	}

	@Test(groups={"testlogin"})
	public void testLogin() throws Exception{
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,Constant.sheetName);
		String email= ExcelUtils.getCellData(2, 2);
		String pass= ExcelUtils.getCellData(2, 3);
		log.inputLogin(email, pass);

		dr.findElement(By.xpath(".//a/*[text()='Account']")).click();
		dr.findElement(By.xpath(".//*[@id='header-account']//*[contains(text(),'My Cart')]")).click();
		WebElement e = dr.findElement(By.id("empty_cart_button"));
		if (e!=null)
			e.click();
	}

	@AfterMethod(groups={"testlogin"})
	public void after(){
		//		home.logOut();
		//home.closeBrowser();
	}


}