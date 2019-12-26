package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.PetHome;
import objects.PetStoreMenu_Catalog;

public class PetTestEnterStore {

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
	
		PetHome.openHome(driver);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@Test 
	//this test often fails due to jsession. My regex knowledge is limited and I can't fix it at the moment.
	public void url() {
		
		sa.assertEquals(driver.getCurrentUrl(), "https://petstore.octoperf.com/actions/Catalog.action");
		sa.assertAll();
	}
	

	@Test

//Method to enter Store 
	public void enter() {

		PetHome.enterStore(PetHome.getEnterStoreButton(driver));

		sa.assertEquals(driver.getCurrentUrl(), PetStoreMenu_Catalog.URL);
		sa.assertAll();

		wait3();
	}
	
	@AfterClass
	//close webdriver at the end
	public void closeD() {
		driver.close();
	}
}
