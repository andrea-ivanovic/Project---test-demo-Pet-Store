package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PetTestRegistration {

	@Test
	//Test to see if one user can be registered 
	public void register() {

		
		SoftAssert sa = new SoftAssert();
		excelU.ExcelUtils.setExcell("src\\UserRandomData.xls");
		excelU.ExcelUtils.setWorkSheet(0);

		String userId = excelU.ExcelUtils.getDataStr(1, 0);
		String password = excelU.ExcelUtils.getDataStr(1, 1);
		String name = excelU.ExcelUtils.getDataStr(1, 2);
		String last = excelU.ExcelUtils.getDataStr(1, 3);
		String email = excelU.ExcelUtils.getDataStr(1, 4);
		String phone = excelU.ExcelUtils.getDataStr(1, 5);
		String adr1 = excelU.ExcelUtils.getDataStr(1, 6);
		String adrs2 = excelU.ExcelUtils.getDataStr(1, 7);
		String city = excelU.ExcelUtils.getDataStr(1, 8);
		String state = excelU.ExcelUtils.getDataStr(1, 9);
		int zip = excelU.ExcelUtils.getDataNum(1, 10);
		String country = excelU.ExcelUtils.getDataStr(1, 11);

		sa.assertEquals(userId, "yiMVAZ");
		sa.assertEquals(password, "QsukPSnFA");
		sa.assertEquals(name, "Daytona");
		sa.assertEquals(last, "Andersean");
		sa.assertEquals(email, "Robusta@gmail.com");
		sa.assertEquals(phone, "(341) 336-1500");
		sa.assertEquals(adr1, "263 Fordhaam Road");
		sa.assertEquals(adrs2, "95 Claark Drive");
		sa.assertEquals(city, "Ruaskin");
		sa.assertEquals(state, "Nebraska");
		sa.assertEquals(zip, 33101);
		sa.assertEquals(country, "USA");
		
		sa.assertAll();
		
		excelU.ExcelUtils.closeExcell();
		
	}
	
		
}
