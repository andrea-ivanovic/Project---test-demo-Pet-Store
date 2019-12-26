package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.PetEditMyAccount;
import objects.PetSignIn;

public class PetTestManageAccountInfo {

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

		driver.get(PetSignIn.URL_SIGNIN);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Test
	public void accessAccount() {

		// get log in credentials for a user from the database (in this case Excel file)
		excelU.ExcelUtils.setExcell("src\\UserRandomData.xls");
		excelU.ExcelUtils.setWorkSheet(0);

		PetEditMyAccount.logIn(driver, excelU.ExcelUtils.getDataStr(1, 0), excelU.ExcelUtils.getDataStr(1, 1));

		wait3();

		// open My Account if info can be updated
		PetEditMyAccount.getMyAccountButton(driver);
		wait3();

		PetEditMyAccount.changeData(driver);
		wait3();
		
		PetEditMyAccount.saveInfo(driver);
		

		// check to see which info is displayed after updating data
		boolean password = driver.findElement(By.xpath("//input[@value='SPVbvnJtA']")).isDisplayed();
		boolean name = driver.findElement(By.xpath("//input[@value='Oscara']")).isDisplayed();
		boolean last = driver.findElement(By.xpath("//input[@value='Poweras']")).isDisplayed();
		boolean email = driver.findElement(By.xpath("//input[@value='Awfula@gmail.com']")).isDisplayed();
		boolean phone = driver.findElement(By.xpath("//input[@value='(203) 897-2522']")).isDisplayed();
		boolean adr1 = driver.findElement(By.xpath("//input[@value='Asatoria, NY 11102']")).isDisplayed();
		boolean adrs2 = driver.findElement(By.xpath("//input[@value='Dees Moines, IA 50310']")).isDisplayed();
		boolean city = driver.findElement(By.xpath("//input[@value='Woodlaand Beach']")).isDisplayed();
		boolean state = driver.findElement(By.xpath("//input[@value = 'Alaska' ]")).isDisplayed();
		boolean zip = driver.findElement(By.xpath("//input[@value='23308']")).isDisplayed();
		boolean country = driver.findElement(By.xpath("//input[@value='USA']")).isDisplayed();

		sa.assertEquals(password, true);
		sa.assertEquals(name, true);
		sa.assertEquals(last, true);
		sa.assertEquals(email, true);
		sa.assertEquals(phone, true);
		sa.assertEquals(adr1, true);
		sa.assertEquals(adrs2, true);
		sa.assertEquals(city, true);
		sa.assertEquals(state, true);
		sa.assertEquals(zip, true);
		sa.assertEquals(country, true);

		sa.assertAll();
	}

	@Test 
	
	public void getMyOrders() {
		
		PetEditMyAccount.orders(driver);
		wait3();
		
		boolean orders = driver.findElement(By.xpath("//h2[contains(text(),'My Orders')]")).isDisplayed();
				
		
		sa.assertEquals(orders, true);
		sa.assertAll();
	}
	
	
	
	@AfterClass
	// close webdriver and Excell at the end
	public void close() {
		driver.close();
		excelU.ExcelUtils.closeExcell();
	}
}