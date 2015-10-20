package Thuchanh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shopping extends Elements{
	
	public Shopping(WebDriver driver, WebDriverWait wait, String baseUrl){
		Shopping.driver=driver;
		//		E_BASE_URL=baseUrl;
		Elements.E_BASE_URL = baseUrl;
		Elements.wait = wait;
		//		WebDriverWait wait = new WebDriverWait(driver,30);

		driver.get(baseUrl);
	}
	/**
	 * SP_001: check Add to cart button
	 */
	public static void testbtnAddToCart(){
		//		driver.manage().deleteAllCookies();

		//		if (!driver.getCurrentUrl().equals(E_BASE_URL)){
		//			driver.get(E_BASE_URL);
		//		}
		String productnameContains = "Samsung";
		waitElement(By.xpath("//a[contains(text(),'"+productnameContains+"')]/../../..//button"));
		WebElement btnAddtocart = driver.findElement(By.xpath("//a[contains(text(),'"+productnameContains+"')]/../../..//button"));		
		String realProductName = driver.findElement(By.xpath("//a[contains(text(),'"+productnameContains+"')]/../../..//button/../..//a")).getAttribute("title");
		btnAddtocart.click();
		//		System.out.println("realproductname:\t"+realProductName);
		waitElement(By.xpath(".//span[text()='"+realProductName +" was added to your shopping cart.']"));
		driver.findElement(By.xpath(".//span[text()='"+realProductName +" was added to your shopping cart.']")).isDisplayed();
	}
	/**
	 * SP_002: check [add to wishlist] link
	 */
	public static void testAddToWishList(){
		//		fail: switch to login screen, not switch to mobile shopping page
	}
	/**
	 * SP_003: Check [add to compare] link
	 */
	public static void testAddToWishCompare(){
		//		fail: switch to login screen, not switch to mobile shopping page
	}
	/**
	 * SP_004: Check btn Add to Cart when user is logined
	 * @throws InterruptedException 
	 */
	public static void testAddToCart_UserIsLogined() throws InterruptedException{
		driver.manage().deleteAllCookies();
		login("nguyenpham90913@gmail.com", "123456");
		waitElement(E_MOBILE_LINK);
		driver.findElement(E_MOBILE_LINK).click();

		String productnameContains = "Samsung";
		Thread.sleep(3000);
		//		waitElement(By.xpath("//a[contains(text(),'Samsung')]/../../..//button"));
		WebElement btnAddtocart = driver.findElement(By.xpath("//a[contains(text(),'"+productnameContains+"')]/../../..//button"));		
		String realProductName = driver.findElement(By.xpath("//a[contains(text(),'"+productnameContains+"')]/../../..//button/../..//a")).getAttribute("title");
		btnAddtocart.click();
		waitElement(By.xpath(".//span[text()='"+realProductName +" was added to your shopping cart.']"));
		driver.findElement(By.xpath(".//span[text()='"+realProductName +" was added to your shopping cart.']")).isDisplayed();
		findProductInProductList(productnameContains);
		System.out.println("passed");
	}
	/**
	 * SP_005
	 * @throws InterruptedException
	 */
	public static void testAddToWishlist_UserIsLogined() throws InterruptedException{
		driver.manage().deleteAllCookies();
		login("nguyenpham90913@gmail.com","123456");
		waitElement(E_MOBILE_LINK);
		driver.findElement(E_MOBILE_LINK).click();
		String productname = "Sony";
		String realProductName = driver.findElement(By.xpath("//a[contains(text(),'"+productname+"')]/../../..//button/../..//a")).getAttribute("title");
		System.out.println("productname\t"+realProductName);
		Thread.sleep(3000);
		WebElement btnAddToWishlist = driver.findElement(By.xpath(".//*[@class='product-name']/*[contains(.,'Sony Xperia')]/../..//*[@class='link-wishlist']"));
		btnAddToWishlist.click();
		waitElement(By.xpath(".//span[.='"+realProductName+" has been added to your wishlist. Click here to continue shopping.']"));
		driver.findElement(By.xpath(".//*[@id='wishlist-table']//*[@title = '"+realProductName+"']"));
		System.out.println("Passed");
	}
}
