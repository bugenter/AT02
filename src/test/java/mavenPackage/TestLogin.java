package mavenPackage;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.Constant;
import common.ExcelUtils;
import common.LoginPage;

public class TestLogin extends LoginPage {

	@BeforeMethod
	public void before(){
		driver = new FirefoxDriver();
		driver.get(Constant.homePageUrl);
		 wait = new WebDriverWait(driver,30);
	}
	@AfterMethod
	public void after(){
		driver.close();
	}
	@Test (priority =0)
	public void loginSuccessfully() throws Exception{
		ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData, "Login");
		String email= ExcelUtils.getCellData(1, 0);
		String pass= ExcelUtils.getCellData(1, 1);
		gotoLoginPage();
		enterDataOnLogin(email, pass);
		driver.findElement(E_BTN_LOGIN).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(E_DASHBOARD));
		driver.findElement(E_DASHBOARD);
		
	}
	@Test (priority =1)
	public void loginFail() throws Exception{
		ExcelUtils.setExcelFile(Constant.Path_TestData+Constant.File_TestData, "Login");
		String email= ExcelUtils.getCellData(2, 0);
		String pass= ExcelUtils.getCellData(2, 1);
		gotoLoginPage();
		enterDataOnLogin(email, pass);
		driver.findElement(E_BTN_LOGIN).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(E_ALERT_LOGIN_FAIL_NOT_EXIST));
		driver.findElement(E_ALERT_LOGIN_FAIL_NOT_EXIST);
	}

}
