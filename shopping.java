package Package_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Shopping 
 * @author PhuongNT
 *
 */
public class shopping {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://live.guru99.com/index.php/";
		//open browser
		driver.get(baseUrl);
		//maximize browser
		driver.manage().window().maximize();
		
		//login
		driver.findElement(By.xpath(".//a/*[text()='Account']")).click();
		driver.findElement(By.xpath(".//*[text()='Log In']")).click();
		driver.findElement(By.id("email")).sendKeys("phuong@abc.com");
		driver.findElement(By.id("pass")).sendKeys("111111");
		driver.findElement(By.xpath(".//span[text()='Login']/../..")).click();
		
		//empty cart
		driver.findElement(By.xpath(".//a/*[text()='Account']")).click();		
		driver.findElement(By.xpath(".//*[@id='header-account']//*[contains(text(),'My Cart')]")).click();
		driver.findElement(By.id("empty_cart_button")).click();
		
		
		//shopping add to cart
		driver.findElement(By.xpath(".//*[text()='Mobile']")).click();
		driver.findElement(By.xpath(".//a[text()='Samsung Galaxy']/../..//*[text()='Add to Cart']/../..")).click();
		
		//shopping checkout
		driver.findElement(By.xpath(".//ul[@class='checkout-types top']//button[@title='Proceed to Checkout']")).click();

		//billing information
//		Select add = new Select(driver.findElement(By.id("billing-address-select")));
//		add.selectByVisibleText("New Address");		
		WebElement e = null;
		e = driver.findElement(By.id("billing:firstname"));
		e.clear();
		driver.findElement(By.id("billing:firstname")).sendKeys("Phuong");
		e = driver.findElement(By.id("billing:lastname"));
		e.clear();
		driver.findElement(By.id("billing:lastname")).sendKeys("Nguyen");
		e = driver.findElement(By.id("billing:company"));
		e.clear();
		driver.findElement(By.id("billing:company")).sendKeys("ABC Company");
		e = driver.findElement(By.id("billing:street1"));
		e.clear();
		driver.findElement(By.id("billing:street1")).sendKeys("40/43 Trung Kinh, ABC");
		e = driver.findElement(By.id("billing:street2"));
		e.clear();
		driver.findElement(By.id("billing:street2")).sendKeys("40/43 Trung Kinh, ABC");
		e = driver.findElement(By.id("billing:city"));
		e.clear();
		driver.findElement(By.id("billing:city")).sendKeys("Ha Noi");
//		e = driver.findElement(By.id("billing:region"));
//		e.clear();
//		driver.findElement(By.id("billing:region")).sendKeys("Ha Noi");
		Select region = new Select(driver.findElement(By.id("billing:region_id")));
		region.selectByVisibleText("Alabama");
		
		e = driver.findElement(By.id("billing:postcode"));
		e.clear();
		driver.findElement(By.id("billing:postcode")).sendKeys("84");
		Select country = new Select(driver.findElement(By.id("billing:country_id")));
		country.selectByValue("VN");
		e = driver.findElement(By.id("billing:telephone"));
		e.clear();
		driver.findElement(By.id("billing:telephone")).sendKeys("123456789");
		e = driver.findElement(By.id("billing:fax"));
		e.clear();
		driver.findElement(By.id("billing:fax")).sendKeys("987654321");
		driver.findElement(By.xpath(".//*[text()='Ship to different address']/../input")).click();
		driver.findElement(By.xpath(".//*[@id='billing-buttons-container']/button")).click();
		Thread.sleep(1000);

		//shipping information
		e = driver.findElement(By.id("shipping:firstname"));
		e.clear();
		driver.findElement(By.id("shipping:firstname")).sendKeys("Phuong");
		e = driver.findElement(By.id("shipping:lastname"));
		e.clear();
		driver.findElement(By.id("shipping:lastname")).sendKeys("Nguyen");
		e = driver.findElement(By.id("shipping:company"));
		e.clear();
		driver.findElement(By.id("shipping:company")).sendKeys("ABC Company");
		e = driver.findElement(By.id("shipping:street1"));
		e.clear();
		driver.findElement(By.id("shipping:street1")).sendKeys("40/43 Trung Kinh, ABC");
		e = driver.findElement(By.id("shipping:street2"));
		e.clear();
		driver.findElement(By.id("shipping:street2")).sendKeys("40/43 Trung Kinh, ABC");
		e = driver.findElement(By.id("shipping:city"));
		e.clear();
		driver.findElement(By.id("shipping:city")).sendKeys("Ha Noi");
		e = driver.findElement(By.id("shipping:region"));
		e.clear();
		driver.findElement(By.id("shipping:region")).sendKeys("Ha Noi");
		e = driver.findElement(By.id("shipping:postcode"));
		e.clear();
		driver.findElement(By.id("shipping:postcode")).sendKeys("84");
		Select country1 = new Select(driver.findElement(By.id("shipping:country_id")));
		country1.selectByValue("VN");
		e = driver.findElement(By.id("shipping:telephone"));
		e.clear();
		driver.findElement(By.id("shipping:telephone")).sendKeys("123456789");
		e = driver.findElement(By.id("shipping:fax"));
		e.clear();
		driver.findElement(By.id("shipping:fax")).sendKeys("987654321");
		driver.findElement(By.xpath(".//*[text()='Use Billing Address']/../input")).click();
		driver.findElement(By.xpath(".//*[@id='shipping-buttons-container']/button")).click();
		Thread.sleep(1000);

		//shipping method
		driver.findElement(By.xpath(".//*[@id='shipping-method-buttons-container']/button")).click();
		Thread.sleep(1000);

		//payment information
		driver.findElement(By.xpath(".//*[contains(text(),'Check / Money order')]/../input")).click();
		driver.findElement(By.xpath(".//*[@id='payment-buttons-container']/button")).click();
		Thread.sleep(1000);

		//order review
		driver.findElement(By.xpath(".//*[@id='review-buttons-container']/button")).click();
		Thread.sleep(1000);

		//verify shopping success
		driver.findElement(By.xpath(".//*[contains(text(),'Your order has been received')]"));

		//logout
		driver.findElement(By.xpath(".//a/*[text()='Account']")).click();		
		driver.findElement(By.xpath(".//a[text()='Log Out']")).click();
		//close browser
		driver.close();

	}

}
