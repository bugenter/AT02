package mavenPackage;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.Constant;
import common.Register;

public class TestRegister extends Register {
	@BeforeMethod
	public void before(){
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		driver.get(Constant.homePageUrl);
	}
	@AfterMethod
	public void after(){
		driver.close();
	}
	@Test (priority =0)
	public void RegisterSuccessfully(){
		gotoRegisterPage();
		String email = randomString(5)+"@gmail.com";
		enterDataRegister("pham", "Tham", email, "123456","123456");
		driver.findElement(E_REGISTER_SUBMIT).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(E_ALERT_SUCCESSFULLY));
		driver.findElement(E_ALERT_SUCCESSFULLY);
	}
	@Test (priority =1)
	public void RegisterFail(){
		gotoRegisterPage();
		String email = randomString(5)+"@gmail.com";
		enterDataRegister("pham", "Tham", "nguyenpham90913@gmail.com", "123456","123456");
		driver.findElement(E_REGISTER_SUBMIT).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(E_ALERT_SUCCESSFULLY));
		driver.findElement(E_ALERT_SUCCESSFULLY);
	}
	
}
