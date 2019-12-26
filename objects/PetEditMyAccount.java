package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PetEditMyAccount {

	public static void wait2() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static final String XPATH_MYACCOUNT = "//a[contains(text(),'My Account')]";
	public static final String XPATH_SAVE = "//input[@name='editAccount']";
	public static final String XPATH_MYORDERS = "//a[contains(text(),'My Orders')]";

	// method to check if it's an existing user

	public static void logIn(WebDriver driver, String username, String password) {

		boolean titleTextField = driver.findElement(By.linkText("Sign In")).isDisplayed();

		if (titleTextField == true) {

			PetSignIn.clickUsername(driver);
			PetSignIn.inputUsername(driver, username);

			PetSignIn.clickPassword(driver);
			PetSignIn.inputPassword(driver, password);

			PetSignIn.clickButton(driver);

		}

		else {
			PetSignIn.clickButton(driver);
		}

	}

	// Method to change MyList selection
	public static void myList2(WebDriver driver) {

		WebElement check1 = driver.findElement(By.xpath(PetRegistrationProfileInfo.XPATH_ENMYLIST));
		// Check whether the Check box is toggled on
		if (check1.isSelected()) {
			check1.click();
		}

		else {
			check1.click();
		}

	}

	// Method to change MyBanner selection
	public static void myBanner2(WebDriver driver) {

		WebElement check1 = driver.findElement(By.xpath(PetRegistrationProfileInfo.XPATH_ENMYBAN));
		// Check whether the check box is toggled on. If it is on, deselect and then
		
		if (check1.isSelected()) {
			check1.click();
		}

		else {
			check1.click();
		}

	}

	public static Select getCateg(WebDriver driver) {
		return new Select(driver.findElement(By.xpath(PetRegistrationProfileInfo.XPATH_FAV_CATEGORY)));
	}

	public static void inputCateg(WebDriver driver) {
		getCateg(driver).selectByVisibleText("DOGS");
	}

	// After the user is signed in, s/he can change the data.

	public static void changeData(WebDriver driver) {

		excelU.ExcelUtils.setExcell("src\\UserRandomData.xls");
		excelU.ExcelUtils.setWorkSheet(0);

		String password = excelU.ExcelUtils.getDataStr(2, 1);
		String name = excelU.ExcelUtils.getDataStr(2, 2);
		String last = excelU.ExcelUtils.getDataStr(2, 3);
		String email = excelU.ExcelUtils.getDataStr(2, 4);
		String phone = excelU.ExcelUtils.getDataStr(2, 5);
		String adr1 = excelU.ExcelUtils.getDataStr(2, 6);
		String adrs2 = excelU.ExcelUtils.getDataStr(2, 7);
		String city = excelU.ExcelUtils.getDataStr(2, 8);
		String state = excelU.ExcelUtils.getDataStr(2, 9);
		int zip = excelU.ExcelUtils.getDataNum(2, 10);
		String country = excelU.ExcelUtils.getDataStr(2, 11);
		String language = "japanese";

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
		inputCateg(driver);

		wait2();

		myList2(driver);
		wait2();

		myBanner2(driver);

		wait2();

	}

	// Method to click My Account to edit info

	public static void getMyAccountButton(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_MYACCOUNT)).click();
	}

	// Method to click save info

	public static void saveInfo(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_SAVE)).click();
	}

	// Method to view orders

	public static void orders(WebDriver driver) {
		driver.findElement(By.xpath(XPATH_MYORDERS)).click();
	}
}
