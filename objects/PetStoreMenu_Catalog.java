package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PetStoreMenu_Catalog {
	
	//urls 
	public static final String URL = "https://petstore.octoperf.com/actions/Catalog.action";
	public static final String URL_SIGNIN = "https://petstore.octoperf.com/actions/Account.action?signonForm=";
	public static final String URL_HELP = "https://petstore.octoperf.com/help.html";
	public static final String URL_CART = "https://petstore.octoperf.com/actions/Cart.action?viewCart=";

	// url for menu item landing page
	public static final String URL_FISH = "https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH";
	public static final String URL_DOG = "https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS";
	public static final String URL_CAT = "https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS";
	public static final String URL_REPTILES = "https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES";
	public static final String URL_BIRDS = "https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS";

	// sidebar fields

	public static final String XPATHFISH_SIDEBAR = "//div[@id='Content']//a[1]//img[1]";
	public static final String XPATHDOGS_SIDEBAR = "//div[@id='Content']//a[2]//img[1]";
	public static final String XPATHCATS_SIDEBAR = "//div[@id='Content']//a[3]//img[1]";
	public static final String XPATHREPTILES_SIDEBAR = "//div[@id='Content']//a[4]//img[1]";
	public static final String XPATHBIRDS_SIDEBAR = "//div[@id='Content']//a[5]//img[1]";

	// quicklinks fields

	public static final String XPATHFISH_QL = "//div[@id='QuickLinks']//a[1]//img[1]";
	public static final String XPATHDOGS_QL = "//div[@id='Header']//a[2]//img[1]";
	public static final String XPATHCATS_QL = "//div[@id='Header']//a[4]//img[1]";
	public static final String XPATHREPTILES_QL = "//div[@id='Header']//a[3]//img[1]";
	public static final String XPATHBIRDS_QL = "//div[@id='Header']//a[5]//img[1]";

	// Diagram fields

	public static final String XPATHFISH_D = "//body//area[2]";
	public static final String XPATHDOGS_D = "//body//area[3]";
	public static final String XPATHCATS_D = "//body//area[5]";
	public static final String XPATHREPTILES_D = "//body//area[4]";
	public static final String XPATHBIRDS_D = "//body//area[1]";
	public static final String XPATHBIRDS_DSMALL = "//body//area[6]";

	// Search fields

	public static final String XPATHSEARCH_BUTTON = "//input[@name='searchProducts']";
	public static final String XPATHSEARCH_BOX = "//input[@name='keyword']";

	// Menu Content fields

	public static final String XPATH_SIGNIN = "//a[contains(text(),'Sign In')]";
	public static final String XPATH_CART = "//div[@id='Menu']//a[1]";
	public static final String XPATH_HELP = "//a[contains(text(),'?')]";

	// Logo

	public static final String XPATH_LOGO = "//div[@id='LogoContent']//a";
	
	
	// Method to open Catalog page after entering the store
	
	public static void openMenu(WebDriver driver) {
		driver.navigate().to(URL);
	}

	// methods for sidebar menu - get and click

	public static void getFish_SB(WebDriver driver) {
		driver.findElement(By.xpath(XPATHFISH_SIDEBAR)).click();
	}

	public static void getDogs_SB(WebDriver driver) {
		driver.findElement(By.xpath(XPATHDOGS_SIDEBAR)).click();
	}

	public static void getCats_SB(WebDriver driver) {
		driver.findElement(By.xpath(XPATHCATS_SIDEBAR)).click();
	}

	public static void getReptiles_SB(WebDriver driver) {
		driver.findElement(By.xpath(XPATHREPTILES_SIDEBAR)).click();
	}

	public static void getBirds_SB(WebDriver driver) {
		driver.findElement(By.xpath(XPATHBIRDS_SIDEBAR)).click();
	}

	// methods for Quick links menu - get and click

	public static void getFish_QL(WebDriver driver) {
		driver.findElement(By.xpath(XPATHFISH_QL)).click();
	}

	public static void getDogs_QL(WebDriver driver) {
		driver.findElement(By.xpath(XPATHDOGS_QL)).click();
	}

	public static void getCats_QL(WebDriver driver) {
		driver.findElement(By.xpath(XPATHCATS_QL)).click();
	}

	public static void getReptiles_QL(WebDriver driver) {
		driver.findElement(By.xpath(XPATHREPTILES_QL)).click();
	}

	public static void getBirds_QL(WebDriver driver) {
		driver.findElement(By.xpath(XPATHBIRDS_QL)).click();
	}

	// Methods for Diagram menu - get and click

	public static void getFish_D(WebDriver driver) {
		driver.findElement(By.xpath(XPATHFISH_D)).click();
	}

	public static void getDogs_D(WebDriver driver) {
		driver.findElement(By.xpath(XPATHDOGS_D)).click();
	}

	public static void getCats_D(WebDriver driver) {
		driver.findElement(By.xpath(XPATHCATS_D)).click();
	}

	public static void getReptiles_D(WebDriver driver) {
		driver.findElement(By.xpath(XPATHREPTILES_D)).click();
	}

	public static void getBirds_D_Large(WebDriver driver) {
		driver.findElement(By.xpath(XPATHBIRDS_D)).click();
	}

	public static void getBirds_D_Small(WebDriver driver) {
		driver.findElement(By.xpath(XPATHBIRDS_DSMALL)).click();
	}

	// Methods for search bar

	public static WebElement getSearchBox(WebDriver driver) {
		return driver.findElement(By.xpath(XPATHSEARCH_BOX));
	}

	public static void inputItem(WebDriver driver, String data) {
		getSearchBox(driver).sendKeys(data);
	}

	public static void clickSearchButton(WebDriver driver) {
		driver.findElement(By.xpath(XPATHSEARCH_BUTTON)).click();
	}

	// Method to click logo

	public static void getLogo(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_LOGO)).click();
	}

	// help

	public static void getHelp(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_HELP)).click();
	}

	// cart
	public static void getCart(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_CART)).click();
	}

	// signin

	public static void getSignIn(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_SIGNIN)).click();
	}

}
