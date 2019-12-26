package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import objects.PetSignIn;


public class PetTestSignIn {

	WebDriver driver;
	SoftAssert sa;

	// method to wait 3 seconds before next command
	public static void wait3() {
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	@BeforeClass
	private void tools() {
		System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");

		driver = new ChromeDriver();
		sa = new SoftAssert();
	
		driver.get(PetSignIn.URL_SIGNIN);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
		
	@Test (priority = 1)
	//this test often fails due to jsession. My regex knowledge is limited and I can't fix it at the moment.
	public void urlTest () {
		driver.getCurrentUrl();
		sa.assertEquals(driver.getCurrentUrl(), "https://petstore.octoperf.com/actions/Catalog.action");
	}
	
	
	@Test
	// method to test page sign in
	public void signIn() {

		excelU.ExcelUtils.setExcell("src\\UserRandomData.xls");
		excelU.ExcelUtils.setWorkSheet(0);

		
		PetSignIn.inputUsername(driver, excelU.ExcelUtils.getDataStr(3, 0));
		wait3();

		PetSignIn.clickPassword(driver);
		PetSignIn.inputPassword(driver, excelU.ExcelUtils.getDataStr(3, 1));
		wait3();

		PetSignIn.clickButton(driver);
		wait3();
		
		PetSignIn.signOut(driver);
		wait3();

		boolean titleTextField = driver.findElement(By.linkText("Sign In")).isDisplayed();
		sa.assertTrue(titleTextField);

		sa.assertAll();

	}

	@AfterClass
	// close webdriver and Excell at the end
	public void close() {
		driver.close();
		excelU.ExcelUtils.closeExcell();
	}

}
