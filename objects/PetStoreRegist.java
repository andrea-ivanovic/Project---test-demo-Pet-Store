package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PetStoreRegist {

	public static void wait2() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

//Method to register a user from Main class. Console input is used to select a person from Excel file which will be registered 
	public static void reg(int r) {

		System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get(PetRegistrationUserInfo.URL_REG);

		excelU.ExcelUtils.setExcell("src\\UserRandomData.xls");
		excelU.ExcelUtils.setWorkSheet(0);

		String userId = excelU.ExcelUtils.getDataStr(r, 0);
		String password = excelU.ExcelUtils.getDataStr(r, 1);
		String name = excelU.ExcelUtils.getDataStr(r, 2);
		String last = excelU.ExcelUtils.getDataStr(r, 3);
		String email = excelU.ExcelUtils.getDataStr(r, 4);
		String phone = excelU.ExcelUtils.getDataStr(r, 5);
		String adr1 = excelU.ExcelUtils.getDataStr(r, 6);
		String adrs2 = excelU.ExcelUtils.getDataStr(r, 7);
		String city = excelU.ExcelUtils.getDataStr(r, 8);
		String state = excelU.ExcelUtils.getDataStr(r, 9);
		int zip = excelU.ExcelUtils.getDataNum(r, 10);
		String country = excelU.ExcelUtils.getDataStr(r, 11);
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

		driver.get(PetSignIn.URL_SIGNIN);

		PetSignIn.inputUsername(driver, excelU.ExcelUtils.getDataStr(r, 0));

		PetSignIn.clickPassword(driver);
		PetSignIn.inputPassword(driver, excelU.ExcelUtils.getDataStr(r, 1));

		PetSignIn.clickButton(driver);

		PetSignIn.signOut(driver);
		wait2();

		driver.get(PetSignIn.URL_SIGNIN);
		driver.get(PetRegistrationUserInfo.URL_REG);

		driver.close();
	}

}
