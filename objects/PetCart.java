package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PetCart {

	
	public static final String URL = "https://petstore.octoperf.com/actions/Catalog.action";	
	
	//counter to check how many times we have added this item
	public static int countAngelfishSmall = 0;
	
	
	//fish menu
	public static final String XPATH_ANGELFISH = "//a[contains(text(),'FI-SW-01')]";
	public static final String XPATH_TIGERSHARK = "//a[contains(text(),'FI-SW-02')]";
	public static final String XPATH_KOI = "//a[contains(text(),'FI-FW-01')]";
	public static final String XPATH_GOLDFISH = "//a[contains(text(),'FI-FW-02')]";
	
	
	//fish submenu
	public static final String XPATH_ADD_LAFISH="//html[1]/body[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[5]/a[1]";
	public static final String XPATH_ADD_SAFISH="/html[1]/body[1]/div[2]/div[2]/table[1]/tbody[1]/tr[3]/td[5]/a[1]";	
	public static final String XPATH_ADD_SHARK= "//a[@class='Button']";
	public static final String XPATH_ADD_SPOTTED_KOI= "/html[1]/body[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[1]/a[1]";
	public static final String XPATH_ADD_SPOTLESS_KOI= "/html[1]/body[1]/div[2]/div[2]/table[1]/tbody[1]/tr[3]/td[1]/a[1]";
	public static final String XPATH_ADD_MALE_GOLDFISH= "/html[1]/body[1]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[1]/a[1]";
	public static final String XPATH_ADD_FEMALE_GOLDFISH= "/html[1]/body[1]/div[2]/div[2]/table[1]/tbody[1]/tr[3]/td[1]/a[1]";
	
			
	public static final String XPATH_BACK = "//a[contains(text(),'Return to Main Menu')]";
	public static final String XPATH_REMOVE_ITEM = "/html[1]/body[1]/div[2]/div[2]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[8]/a[1]";
	
	
	//Methods to open items
	public static void openAngelfish(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_ANGELFISH)).click();
	}
				
	public static void openTigershark(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_TIGERSHARK)).click();
	}
	public static void openKoi(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_KOI)).click();
	}
	
	public static void openGoldfish(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_GOLDFISH)).click();
	}
	
	
	//Methods to add items to a cart
	public static void addShark(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_ADD_SHARK)).click();
	}
	
	public static void addSpottedKoit(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_ADD_SPOTTED_KOI)).click();
	}
	
	public static void addSpotlessKoit(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_ADD_SPOTLESS_KOI)).click();
	}
	
	public static void addMaleGoldfish(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_ADD_MALE_GOLDFISH)).click();
	}
	
	public static void addFemaleGoldFish(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_ADD_FEMALE_GOLDFISH)).click();
	}
	
	public static void addAngelfishLarge(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_ADD_LAFISH)).click();
			}
	
	public static void addAngelfishSmall(WebDriver driver) {
		countAngelfishSmall++;
		driver.findElement(By.xpath(XPATH_ADD_SAFISH)).click();
	}
	
	
	//Method to remove item from cart	
	public static void removeItem(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_REMOVE_ITEM)).click();
	}
	
	
	//Method to navigate back using the button on the page
	public static void navigateBack(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_BACK)).click();
	}
	
}
