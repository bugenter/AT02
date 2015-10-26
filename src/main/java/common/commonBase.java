package common;

import java.security.SecureRandom;

import org.openqa.selenium.WebElement;

public class commonBase {
	/**
	 * nhap gia tri a vao phan tu element
	 * @param element
	 * @param a
	 */
	public static void typeText(WebElement element, String a){
		if (a != null)
		{
			element.sendKeys(a);
		}
	}

	/**
	 * Get random string
	 * @param length
	 * @return
	 */

	public static String getRandomString(int length) {
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