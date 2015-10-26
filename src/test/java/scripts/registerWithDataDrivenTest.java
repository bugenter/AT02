package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.commonBase;
import common.homePage;
import common.registerPage;
import datadriven.ExcelUtils;

public class registerWithDataDrivenTest {
	String Path_TestData = "/home/phuong_dt/working/project/AT02/src/test/java/resources/";
	String File_TestData = "TestData.xls";
	String sheetName="Sheet1";
	WebDriver dr ;
	homePage home;
	registerPage reg;
	ExcelUtils exUtil;
	@BeforeMethod
	public void beforeMethod(){
		//Init driver
		WebDriver dr = new FirefoxDriver();		
		home = new homePage(dr);
		reg = new registerPage(dr);
		exUtil = new ExcelUtils();
		home.openHomepage();
		reg.gotoRegister();
	}

	@AfterMethod
	public void after(){
		home.closeBrowser();
	}

	@Test(groups={"datadriven"})
	public void registerSuccess1() throws Exception{
		ExcelUtils.setExcelFile(Path_TestData + File_TestData,sheetName);
		String firstName= ExcelUtils.getCellData(1, 0);
		String lastName= ExcelUtils.getCellData(1, 1);
		String email= commonBase.getRandomString(4)+ExcelUtils.getCellData(1, 2);
		String pass= ExcelUtils.getCellData(1, 3);
		String repass= ExcelUtils.getCellData(1, 4);
		reg.inputRegister(firstName,lastName,email,pass,repass);
		reg.verifyRegister(true);
	}
	
	@Test(groups={"datadriven2"})
	public void registerSuccess2() throws Exception{
		ExcelUtils.setExcelFile(Path_TestData + File_TestData,sheetName);
		String firstName= ExcelUtils.getCellData(1, 0);
		String lastName= ExcelUtils.getCellData(1, 1);
		String email= commonBase.getRandomString(4)+ExcelUtils.getCellData(1, 2);
		String pass= ExcelUtils.getCellData(1, 3);
		String repass= ExcelUtils.getCellData(1, 4);
		reg.inputRegister(firstName,lastName,email,pass,repass);
		reg.verifyRegister(true);
	}
}
