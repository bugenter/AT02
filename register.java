package Package_1;

import java.security.SecureRandom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class register {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://live.guru99.com/index.php/customer/account/create/";
		//open browser
		driver.get(baseUrl);
		//maximize browser
		driver.manage().window().maximize();
		//nhap thong tin dang ky
		driver.findElement(By.id("firstname")).sendKeys("Phuong");
		driver.findElement(By.id("lastname")).sendKeys("Nguyen");
		String abc = nextSessionId(3);
		String email = "phuongnt_" + abc + "@abc.com";		
		driver.findElement(By.id("email_address")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("confirmation")).sendKeys("123456");
		driver.findElement(By.xpath(".//span[text()='Register']/../..")).click();
		//verify truong hop dang ky thanh cong
		Thread.sleep(300);
		driver.findElement(By.xpath(".//*[text()='Thank you for registering with Main Website Store.']"));
		//log out
		driver.findElement(By.xpath(".//a/*[text()='Account']")).click();		
		driver.findElement(By.xpath(".//a[text()='Log Out']")).click();
		//close browser
		driver.close();


	}

	/**
	 * ham random 1
	 * @return
	 */
	//	private static String nextSessionId() {
	//		// TODO Auto-generated method stub
	//		SecureRandom random = new SecureRandom();
	//		return new BigInteger(30, random).toString(10); 
	//	}

	/**
	 * ham random 2
	 * @param length do dai cua chuoi random
	 * @return
	 */
	public static String nextSessionId(int length) {
		String alphabet = new String("0123456789");
		int n = alphabet.length();

		String result = new String();
		SecureRandom r = new SecureRandom();
		for (int i = 0; i < length; i++) {
			result = result + alphabet.charAt(r.nextInt(n));
		}
		return result;
	}

}
