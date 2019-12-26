package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PetRegistrationUserInfo {

	public static final String URL_REG = "https://petstore.octoperf.com/actions/Account.action?newAccountForm=";

	// user information fields

	public static final String XPATH_USER_ID = "/html[1]/body[1]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]";
	public static final String XPATH_NEW_PASSWORD = "//input[@name='password']";
	public static final String XPATH_REPEAT_PASSWORD = "//input[@name='repeatedPassword']";

	// Save Account Info Button

	public static final String XPATH_SAVE = "//input[@name='newAccount']";

	// Methods for user info

	// username
	public static WebElement getUsername(WebDriver driver) {
		return driver.findElement(By.xpath(XPATH_USER_ID));
	}

	public static void clickUsername(WebDriver driver) {
		getUsername(driver).click();
		getUsername(driver).clear();
		getUsername(driver).click();
	}

	public static void inputUsername(WebDriver driver, String data) {
		getUsername(driver).sendKeys(data);
	}

	// password
	public static WebElement getPass(WebDriver driver) {
		return driver.findElement(By.xpath(XPATH_NEW_PASSWORD));
	}

	public static void clickPass(WebDriver driver) {
		getPass(driver).click();
		getPass(driver).clear();
		getPass(driver).click();
	}

	public static void inputPass(WebDriver driver, String data) {
		getPass(driver).sendKeys(data);
	}

	// repeat password
	public static WebElement getRepeatPass(WebDriver driver) {
		return driver.findElement(By.xpath(XPATH_REPEAT_PASSWORD));
	}

	public static void clickRepeatPass(WebDriver driver) {
		getRepeatPass(driver).click();
		getRepeatPass(driver).clear();
		getRepeatPass(driver).click();
	}

	public static void inputRepeatPass(WebDriver driver, String data) {
		getRepeatPass(driver).sendKeys(data);
	}

	// Method for submitting the form
	public static void save(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_SAVE)).click();
	}

}
