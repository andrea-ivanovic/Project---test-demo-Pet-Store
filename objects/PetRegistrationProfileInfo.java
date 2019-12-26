package objects;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PetRegistrationProfileInfo {

	public static final String URL_REG = "https://petstore.octoperf.com/actions/Account.action?newAccountForm=";

	// profile information fields

	public static final String XPATH_LANG = "//select[@name='account.languagePreference']";
	public static final String XPATH_FAV_CATEGORY = "//select[@name='account.favouriteCategoryId']";
	public static final String XPATH_ENMYLIST = "//input[@name='account.listOption']";
	public static final String XPATH_ENMYBAN = "//input[@name='account.bannerOption']";

	// Methods:

	// language

	public static Select getLang(WebDriver driver) {
		return new Select(driver.findElement(By.xpath(XPATH_LANG)));
	}

	public static void inputLang(WebDriver driver, String data) {
		getLang(driver).selectByVisibleText(data);
	}

	// Favourite category

	public static Select getCateg(WebDriver driver) {
		return new Select(driver.findElement(By.xpath(XPATH_FAV_CATEGORY)));
	}

	public static void inputCateg(WebDriver driver, String data) {
		getCateg(driver).selectByVisibleText(data);
	}

	public static void inputRandomCat(WebDriver driver) {
		List<WebElement> itemsInDrpDwn = driver.findElements(By.xpath("//select[@name='account.favouriteCategoryId']"));

		int size = itemsInDrpDwn.size();

		int randnMumber = ThreadLocalRandom.current().nextInt(0, size);

		itemsInDrpDwn.get(randnMumber).click();
	}

	// Enable My List

	public static void myList(WebDriver driver) {

		WebElement check1 = driver.findElement(By.xpath(XPATH_ENMYLIST));
		// Check whether the Check box is toggled on
		if (check1.isSelected()) {
			check1.click();
			check1.click();
		}

		else {
			check1.click();
		}

	}

	// Enable My Banner

	public static void myBanner(WebDriver driver) {

		WebElement check1 = driver.findElement(By.xpath(XPATH_ENMYBAN));
		// Check whether the check box is toggled on. If it is on, deselect and then
		// select it

		if (check1.isSelected()) {
			check1.click();
			check1.click();
		}

		else {
			check1.click();
		}

	}

}
