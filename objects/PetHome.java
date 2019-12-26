package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PetHome {

	public static final String URL = "https://petstore.octoperf.com/";

	public static String XPathHomePage = "/html[1]/body[1]/div[1]/p[1]/a[1]";

	// method to open home page
	public static void openHome(WebDriver driver) {

		driver.get(URL);
	}

	// method to get the Enter Store button
	public static WebElement getEnterStoreButton(WebDriver driver) {

		WebElement button = driver.findElement(By.xpath(XPathHomePage));

		return button;
	}

	// method to return to main menu using a button

	public static void back(WebDriver driver) {
		driver.findElement(By.xpath("//a[contains(text(),'Return to Main Menu')]"));
	}

	// method to click the Button to enter the store
	public static void enterStore(WebElement button) {

		button.click();
	}

}