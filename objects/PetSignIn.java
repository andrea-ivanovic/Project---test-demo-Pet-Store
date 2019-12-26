package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PetSignIn {

	// signin fields

	public static final String URL_SIGNIN = "https://petstore.octoperf.com/actions/Account.action?signonForm=";
	public static final String XPATH_USERNAME = "/html[1]/body[1]/div[2]/div[1]/form[1]/p[2]/input[1]"; 
																										
	public static final String XPATH_PASSWORD = "//input[@name='password']";
	public static final String XPATH_LOGIN_BUTTON = "//input[@name='signon']";

	// signout field

	public static final String XPATH_SIGN_OUT = "//a[contains(text(),'Sign Out')]";

	// Methods to input username

	public static WebElement getUsername(WebDriver driver) {
		return driver.findElement(By.xpath(XPATH_USERNAME));
	}

	public static void clickUsername(WebDriver driver) {
		getUsername(driver).click();
	}

	public static void inputUsername(WebDriver driver, String data) {
		getUsername(driver).sendKeys(data);
	}

	// Methods to input password

	public static WebElement getPassword(WebDriver driver) {
		return driver.findElement(By.xpath(XPATH_PASSWORD));
	}

	public static void clickPassword(WebDriver driver) {
		getPassword(driver).click();
		getPassword(driver).clear();
		getPassword(driver).click();
	}

	public static void inputPassword(WebDriver driver, String data) {
		getPassword(driver).sendKeys(data);
	}

	// Method to click Login Button

	public static void clickButton(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_LOGIN_BUTTON)).click();
	}

	// Method to SignOut

	public static void signOut(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_SIGN_OUT)).click();
	}
}
