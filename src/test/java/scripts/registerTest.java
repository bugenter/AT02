package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import common.commonBase;
import common.homePage;
import common.registerPage;
import datadriven.Constant;
import datadriven.ExcelUtils;


public class registerTest  {
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
	public void registerSuccess() throws Exception {
		String abc =   commonBase.getRandomString(4);
		String email = "phuongnt_" + abc + "@abcd.com";		
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,Constant.sheetName);
		String firstName= ExcelUtils.getCellData(1, 0);
		String lastName= ExcelUtils.getCellData(1, 1);
		String pass= ExcelUtils.getCellData(1, 3);
		String repass= ExcelUtils.getCellData(1, 3);
		reg.inputRegister(firstName,lastName,email,pass,repass);
		Thread.sleep(300);
		reg.verifyRegister(true);

	}

	@Test
	public void registerFail() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,Constant.sheetName);
		String firstName= ExcelUtils.getCellData(1, 0);
		String lastName= ExcelUtils.getCellData(1, 1);
		String email= ExcelUtils.getCellData(1, 2);
		String pass= ExcelUtils.getCellData(1, 3);
		String repass= ExcelUtils.getCellData(1, 3);
		reg.inputRegister(firstName,lastName,email,pass,repass);
		Thread.sleep(1000);
		reg.verifyRegister(false);
	}



	@AfterMethod
	public void after(){
		home.closeBrowser();
	}


}