package main;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objects.PetCart;
import objects.PetHome;
import objects.PetRegistrationFillIn;
import objects.PetRegistrationUserInfo;
import objects.PetSignIn;
import objects.PetStoreMenu_Catalog;
import objects.PetStoreRegist;
import tests.PetTestNavigation;

public class Main {

	public static void wait4() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void wait3() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "src\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Welcome to our pet shop");

			PetHome.openHome(driver);
			PetHome.enterStore(PetHome.getEnterStoreButton(driver));

			System.out.println("Which animals would you like to see?");

			System.out.println(
					"For FISH enter 1. For Dogs enter 2. For Reptiles enter 3. For Cats enter 4. For Birds enter 5. If you need help, enter 6.");

			int animalChoice = sc.nextInt();

			wait4();

			switch (animalChoice) {

			case 1:
				PetStoreMenu_Catalog.getFish_QL(driver);
				System.out.println("We carry these fish:");
				break;

			case 2:
				PetStoreMenu_Catalog.getDogs_QL(driver);
				System.out.println("We carry these dogs:");
				break;

			case 3:
				PetStoreMenu_Catalog.getReptiles_QL(driver);
				System.out.println("We carry these reptiles:");
				break;

			case 4:
				PetStoreMenu_Catalog.getCats_QL(driver);
				System.out.println("We carry these cats:");
				break;

			case 5:
				PetStoreMenu_Catalog.getBirds_QL(driver);
				System.out.println("We carry these birds:");
				break;

			case 6:
				PetStoreMenu_Catalog.getHelp(driver);
				break;
			default:
				System.out.println("The chosen option is unavailable at the moment");

			}

			wait4();

			System.out.println("At the moment, we only have fish available for shopping online. ");

			driver.get("https://petstore.octoperf.com/actions/Catalog.action");
			wait3();
			PetStoreMenu_Catalog.getFish_QL(driver);
			wait3();
			PetCart.openTigershark(driver);
			wait3();
			PetCart.addShark(driver);
			wait3();

			PetCart.navigateBack(driver);
			wait4();

			System.out.println("Please email us your information and we will put you into our datebase. ");

			driver.get(PetRegistrationUserInfo.URL_REG);
			wait4();

			System.out.println("You will be able to log in here:");

			driver.get(PetSignIn.URL_SIGNIN);
			wait3();

			System.out.println("Thank you for visitng our store. Have a nice day!");

			driver.close();

			System.out.println("Enter number between 11 and 20");
			int input = sc.nextInt();

			if (input < 11 && input > 20)
				System.out.println("Wrong input!");

			else {
				PetStoreRegist.reg(input);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}