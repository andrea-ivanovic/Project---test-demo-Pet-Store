package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.PetCart;

import objects.PetStoreMenu_Catalog;

public class PetTestCart {

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
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}
	
	@Test (priority = 1)
	//this test often fails due to jsession. My regex knowledge is limited and I can't fix it at the moment.
	public void urlTest () {
		driver.getCurrentUrl();
		sa.assertEquals(driver.getCurrentUrl(), "https://petstore.octoperf.com/actions/Catalog.action");
	}
	
	@Test
	public void addItem() {

		PetStoreMenu_Catalog.getFish_QL(driver);
		wait3();

		PetCart.openAngelfish(driver);
		wait3();

		PetCart.addAngelfishSmall(driver);
		wait3();

		if (PetCart.countAngelfishSmall > 1) {
			System.out.println("This item was added to the cart previously.");
		}

		boolean fish = driver.findElement(By.xpath("//tr[2]//td[1]")).isDisplayed();

		sa.assertEquals(fish, true);

		sa.assertAll();

	}
	
	@AfterClass
	// close webdriver 
	public void close() {
		driver.close();
		
	}

}
