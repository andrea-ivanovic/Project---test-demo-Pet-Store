package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.PetCart;

import objects.PetStoreMenu_Catalog;

public class PetTestNavigation {
	WebDriver driver;
	SoftAssert sa;

	// method to wait 3 seconds before next command
	public static void wait3() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@BeforeClass
	private void tools() {
		System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");

		driver = new ChromeDriver();
		sa = new SoftAssert();

		driver.get(PetStoreMenu_Catalog.URL);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	// Test if button Return to Main Menu works when on submenu page
	public void navigateBack() {

		PetStoreMenu_Catalog.getDogs_D(driver);
		wait3();
		PetCart.navigateBack(driver);

		String cur = driver.getCurrentUrl();
		cur = cur.replaceAll(";jsessionid=[^?]*", "");

		sa.assertEquals(cur, "https://petstore.octoperf.com/actions/Catalog.action");
		sa.assertAll();

	}

	@AfterClass
	public void close() {
		driver.close();

	}

}
