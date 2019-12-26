package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import excelU.ExcelUtils;
import objects.PetRegistrationAccInfo;
import objects.PetRegistrationProfileInfo;
import objects.PetRegistrationUserInfo;


public class PetRegistrationFillIn {

	public static void wait2() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void register() {

		System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get(PetRegistrationUserInfo.URL_REG);

		excelU.ExcelUtils.setExcell("src\\UserRandomData.xls");
		excelU.ExcelUtils.setWorkSheet(0);

		// Fill in the registration page using data provided in Excell file
		//A user can only be registered once. I have registered the first 20 users so we need to start with the next unregistered user. 
		
		for (int i = 21;i < excelU.ExcelUtils.getColumnNumber() + 1; i++ ) {

			String userId = excelU.ExcelUtils.getDataStr(i, 0);
			String password = excelU.ExcelUtils.getDataStr(i, 1);
			String name = excelU.ExcelUtils.getDataStr(i, 2);
			String last = excelU.ExcelUtils.getDataStr(i, 3);
			String email = excelU.ExcelUtils.getDataStr(i, 4);
			String phone = excelU.ExcelUtils.getDataStr(i, 5);
			String adr1 = excelU.ExcelUtils.getDataStr(i, 6);
			String adrs2 = excelU.ExcelUtils.getDataStr(i, 7);
			String city = excelU.ExcelUtils.getDataStr(i, 8);
			String state = excelU.ExcelUtils.getDataStr(i, 9);
			int zip = excelU.ExcelUtils.getDataNum(i, 10);
			String country = excelU.ExcelUtils.getDataStr(i, 11);
			String language = "english";

			PetRegistrationUserInfo.clickUsername(driver);
			PetRegistrationUserInfo.inputUsername(driver, userId);

			wait2();
			PetRegistrationUserInfo.clickPass(driver);
			PetRegistrationUserInfo.inputPass(driver, password);

			wait2();

			PetRegistrationUserInfo.clickRepeatPass(driver);
			PetRegistrationUserInfo.inputRepeatPass(driver, password);

			wait2();

			PetRegistrationAccInfo.clickName(driver);
			PetRegistrationAccInfo.inputName(driver, name);

			wait2();

			PetRegistrationAccInfo.clickLastName(driver);
			PetRegistrationAccInfo.inputLastName(driver, last);

			wait2();

			PetRegistrationAccInfo.clickEmail(driver);
			PetRegistrationAccInfo.inputEmail(driver, email);

			wait2();

			PetRegistrationAccInfo.clickPhone(driver);
			PetRegistrationAccInfo.inputPhone(driver, phone);

			wait2();

			PetRegistrationAccInfo.clickAdrs1(driver);
			PetRegistrationAccInfo.inputAdrs1(driver, adr1);

			wait2();

			PetRegistrationAccInfo.clickAdrs2(driver);
			PetRegistrationAccInfo.inputAdrs2(driver, adrs2);

			wait2();

			PetRegistrationAccInfo.clickCity(driver);
			PetRegistrationAccInfo.inputCity(driver, city);

			wait2();

			PetRegistrationAccInfo.clickState(driver);
			PetRegistrationAccInfo.inputState(driver, state);

			wait2();

			PetRegistrationAccInfo.clickZip(driver);
			PetRegistrationAccInfo.inputZip(driver, String.valueOf(zip));

			wait2();

			PetRegistrationAccInfo.clickCountry(driver);
			PetRegistrationAccInfo.inputCountry(driver, country);

			wait2();

			PetRegistrationProfileInfo.inputLang(driver, language);

			wait2();
			PetRegistrationProfileInfo.inputRandomCat(driver);

			wait2();

			PetRegistrationProfileInfo.myList(driver);

			wait2();

			PetRegistrationProfileInfo.myBanner(driver);

			wait2();

			PetRegistrationUserInfo.save(driver);

			wait2();
			
			driver. get(PetSignIn.URL_SIGNIN);
					
			PetSignIn.inputUsername(driver, excelU.ExcelUtils.getDataStr(i, 0));
			

			PetSignIn.clickPassword(driver);
			PetSignIn.inputPassword(driver, excelU.ExcelUtils.getDataStr(i, 1));
			

			PetSignIn.clickButton(driver);
			
			
			PetSignIn.signOut(driver);
			wait2();
			
			driver. get(PetSignIn.URL_SIGNIN);
			driver.get(PetRegistrationUserInfo.URL_REG);
			
			
		}

		ExcelUtils.closeExcell();

		driver.close();
	}
}
