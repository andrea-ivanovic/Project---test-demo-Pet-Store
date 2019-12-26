package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.PetStoreMenu_Catalog;

public class PetTestStoreMenu {

	WebDriver driver;
	SoftAssert sa;

	// method to wait 2 seconds before next command
	public static void wait2() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@BeforeClass
	private void tools() {
		System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");

		driver = new ChromeDriver();
		sa = new SoftAssert();
	}

	@BeforeMethod
	private void page() {
		driver.get(PetStoreMenu_Catalog.URL);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test 
	//this test often fails due to jsession. My regex knowledge is limited and I can't fix it at the moment.
	public void urlTest () {
		driver.getCurrentUrl();
		sa.assertEquals(driver.getCurrentUrl(), "https://petstore.octoperf.com/actions/Catalog.action");
	}
	
	
	@Test(priority = 1)

	// Methods to test fish links

	public void fish() {

		PetStoreMenu_Catalog.getFish_SB(driver);
		String cur = driver.getCurrentUrl();
		cur = cur.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur, PetStoreMenu_Catalog.URL_FISH);
		wait2();

		driver.navigate().to(PetStoreMenu_Catalog.URL);
		wait2();

		PetStoreMenu_Catalog.getFish_QL(driver);
		String cur1 = driver.getCurrentUrl();
		cur1 = cur1.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur1, PetStoreMenu_Catalog.URL_FISH);
		wait2();

		driver.navigate().to(PetStoreMenu_Catalog.URL);
		wait2();

		PetStoreMenu_Catalog.getFish_D(driver);
		String cur2 = driver.getCurrentUrl();
		cur2 = cur2.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur2, PetStoreMenu_Catalog.URL_FISH);
		wait2();

		sa.assertAll();
	}

	@Test(priority = 2)

	// Methods to test dog link

	public void dog() {

		PetStoreMenu_Catalog.getDogs_SB(driver);
		String cur = driver.getCurrentUrl();
		cur = cur.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur, PetStoreMenu_Catalog.URL_DOG);
		wait2();

		driver.navigate().to(PetStoreMenu_Catalog.URL);
		wait2();

		PetStoreMenu_Catalog.getDogs_QL(driver);
		String cur1 = driver.getCurrentUrl();
		cur1 = cur1.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur1, PetStoreMenu_Catalog.URL_DOG);
		wait2();

		driver.navigate().to(PetStoreMenu_Catalog.URL);
		wait2();

		PetStoreMenu_Catalog.getDogs_D(driver);
		String cur2 = driver.getCurrentUrl();
		cur2 = cur2.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur2, PetStoreMenu_Catalog.URL_DOG);
		wait2();

		sa.assertAll();
	}

	@Test(priority = 3)

	// Methods to test cat links
	public void cat() {

		PetStoreMenu_Catalog.getCats_SB(driver);
		String cur = driver.getCurrentUrl();
		cur = cur.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur, PetStoreMenu_Catalog.URL_CAT);
		wait2();

		driver.navigate().to(PetStoreMenu_Catalog.URL);
		wait2();

		PetStoreMenu_Catalog.getCats_QL(driver);
		String cur1 = driver.getCurrentUrl();
		cur1 = cur1.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur1, PetStoreMenu_Catalog.URL_CAT);
		wait2();

		driver.navigate().to(PetStoreMenu_Catalog.URL);
		wait2();

		PetStoreMenu_Catalog.getCats_D(driver);
		String cur2 = driver.getCurrentUrl();
		cur2 = cur2.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur2, PetStoreMenu_Catalog.URL_CAT);
		wait2();

		sa.assertAll();

	}

	@Test(priority = 4)

	// Methods to test reptile links
	public void reptiles() {

		PetStoreMenu_Catalog.getReptiles_SB(driver);
		String cur = driver.getCurrentUrl();
		cur = cur.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur, PetStoreMenu_Catalog.URL_REPTILES);
		wait2();

		driver.navigate().to(PetStoreMenu_Catalog.URL);
		wait2();

		PetStoreMenu_Catalog.getReptiles_QL(driver);
		String cur1 = driver.getCurrentUrl();
		cur1 = cur1.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur1, PetStoreMenu_Catalog.URL_REPTILES);
		wait2();

		driver.navigate().to(PetStoreMenu_Catalog.URL);
		wait2();

		PetStoreMenu_Catalog.getReptiles_D(driver);
		String cur2 = driver.getCurrentUrl();
		cur2 = cur2.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur2, PetStoreMenu_Catalog.URL_REPTILES);
		wait2();

		sa.assertAll();

	}

	@Test(priority = 5)

	// Methods to test birds links
	public void birds() {

		PetStoreMenu_Catalog.getBirds_SB(driver);
		String cur = driver.getCurrentUrl();
		cur = cur.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur, PetStoreMenu_Catalog.URL_BIRDS);
		wait2();

		driver.navigate().to(PetStoreMenu_Catalog.URL);
		wait2();

		PetStoreMenu_Catalog.getBirds_QL(driver);
		String cur1 = driver.getCurrentUrl();
		cur1 = cur1.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur1, PetStoreMenu_Catalog.URL_BIRDS);
		wait2();

		driver.navigate().to(PetStoreMenu_Catalog.URL);
		wait2();

		PetStoreMenu_Catalog.getBirds_D_Small(driver);
		String cur2 = driver.getCurrentUrl();
		cur2 = cur2.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur2, PetStoreMenu_Catalog.URL_BIRDS);

		driver.navigate().to(PetStoreMenu_Catalog.URL);
		wait2();

		PetStoreMenu_Catalog.getBirds_D_Large(driver);
		String cur3 = driver.getCurrentUrl();
		cur3 = cur3.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur3, PetStoreMenu_Catalog.URL_BIRDS);
		wait2();

		sa.assertAll();

	}

	@Test(priority = 6)
	// Method to test SignIN button
	public void signin() {

		PetStoreMenu_Catalog.getSignIn(driver);
		String cur = driver.getCurrentUrl();
		cur = cur.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur, PetStoreMenu_Catalog.URL_SIGNIN);
		wait2();

		sa.assertAll();

	}

	@Test(priority = 7)

	// Method to test help link

	public void help() {

		PetStoreMenu_Catalog.getHelp(driver);
		String cur = driver.getCurrentUrl();
		cur = cur.replaceAll(";jsessionid=[^?]*", "");
		sa.assertEquals(cur, PetStoreMenu_Catalog.URL_HELP);
		wait2();

		sa.assertAll();

	}

	@Test(priority = 8)

	// Method to test cart

	public void cart() {

		PetStoreMenu_Catalog.getCart(driver);
		String cur = driver.getCurrentUrl();
		cur = cur.replaceAll(";jsessionid=[^?]*", "");
		
		sa.assertEquals(cur, PetStoreMenu_Catalog.URL_CART);
		wait2();

		sa.assertAll();

	}

	@AfterClass
	public void close() {
		driver.close();

	}

}
