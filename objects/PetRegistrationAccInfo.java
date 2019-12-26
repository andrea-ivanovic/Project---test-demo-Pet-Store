package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PetRegistrationAccInfo {
	
	public static final String URL_REG="https://petstore.octoperf.com/actions/Account.action?newAccountForm=";
	
	//account information fields
	
		public static final String XPATH_FIRST_NAME= "//input[@name='account.firstName']";
		public static final String XPATH_LAST_NAME= "//input[@name='account.lastName']";
		public static final String XPATH_EMAIL= "//input[@name='account.email']";
		public static final String XPATH_PHONE = "//input[@name='account.phone']";
		public static final String XPATH_ADR1= "//input[@name='account.address1']";
		public static final String XPATH_ADR2= "//input[@name='account.address2']";
		public static final String XPATH_CITY= "//input[@name='account.city']";
		public static final String XPATH_STATE= "//input[@name='account.state']";
		public static final String XPATH_ZIP= "//input[@name='account.zip']";
		public static final String XPATH_COUNTRY= "//input[@name='account.country']";
		

	//first name 
		
		public static WebElement getName(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_FIRST_NAME));
		}

		public static void clickName(WebDriver driver) {
			getName(driver).click();
			getName(driver).clear();
			getName(driver).click();
		}

		public static void inputName(WebDriver driver, String data) {
			getName(driver).sendKeys(data);
		}
		
		
	//last name 
		
		public static WebElement getLastName(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_LAST_NAME));
		}

		public static void clickLastName(WebDriver driver) {
			getLastName(driver).click();
			getLastName(driver).clear();
			getLastName(driver).click();
		}

		public static void inputLastName(WebDriver driver, String data) {
			getLastName(driver).sendKeys(data);
		}
		
	//email
		
		public static WebElement getEmail(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_EMAIL));
		}

		public static void clickEmail(WebDriver driver) {
			getEmail(driver).click();
			getEmail(driver).clear();
			getEmail(driver).click();
		}

		public static void inputEmail(WebDriver driver, String data) {
			getEmail(driver).sendKeys(data);
		}
		
	//phone 
		
		public static WebElement getPhone(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_PHONE));
		}

		public static void clickPhone(WebDriver driver) {
			getPhone(driver).click();
			getPhone(driver).clear();
			getPhone(driver).click();
		}

		public static void inputPhone(WebDriver driver, String data) {
			getPhone(driver).sendKeys(String.valueOf(data));
		}
		
	//address 1 		

		public static WebElement getAdrs1(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_ADR1));
		}

		public static void clickAdrs1(WebDriver driver) {
			getAdrs1(driver).click();
			getAdrs1(driver).clear();
			getAdrs1(driver).click();
		}

		public static void inputAdrs1(WebDriver driver, String data) {
			getAdrs1(driver).sendKeys(data);
		}
		
	//address 2 
		
		public static WebElement getAdrs2(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_ADR2));
		}

		public static void clickAdrs2(WebDriver driver) {
			getAdrs2(driver).click();
			getAdrs2(driver).clear();
			getAdrs2(driver).click();
		}

		public static void inputAdrs2(WebDriver driver, String data) {
			getAdrs2(driver).sendKeys(data);
		}
	
	//city 
		
		public static WebElement getCity(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_CITY));
		}

		public static void clickCity(WebDriver driver) {
			getCity(driver).click();
			getCity(driver).clear();
			getCity(driver).click();
		}

		public static void inputCity(WebDriver driver, String data) {
			getCity(driver).sendKeys(data);
		}
		
		
	//state
		
		public static WebElement getState(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_STATE));
		}

		public static void clickState(WebDriver driver) {
			getState(driver).click();
			getState(driver).clear();
			getState(driver).click();
		}

		public static void inputState(WebDriver driver, String data) {
			getState(driver).sendKeys(data);
		}
		
	//zip 
		
		public static WebElement getZip(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_ZIP));
		}

		public static void clickZip(WebDriver driver) {
			getZip(driver).click();
			getZip(driver).clear();
			getZip(driver).click();
		}

		public static void inputZip(WebDriver driver, String data) {
			getZip(driver).sendKeys(String.valueOf(data));
		}
		
	//country
		
		public static WebElement getCountry(WebDriver driver) {
			return driver.findElement(By.xpath(XPATH_COUNTRY));
		}

		public static void clickCountry(WebDriver driver) {
			getCountry(driver).click();
			getCountry(driver).clear();
			getCountry(driver).click();
		}

		public static void inputCountry(WebDriver driver, String data) {
			getCountry(driver).sendKeys(data);
		}
				
}
