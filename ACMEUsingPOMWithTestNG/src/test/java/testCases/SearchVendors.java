package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethods;
import pages.LoginPage;

public class SearchVendors extends ProjectSpecifiedMethods{
	@BeforeTest
	public void getWorkbook() {
		workBook = "SearchVendor";
		testName = "Search Vendors";
		testDescription = "Search Vendors using valid data";
		testAuthor = "Karthi";
		testCategory = "functionality";
	}
	@Test(dataProvider = "sendData")
	public void verifySearchVendors(String email, String password, String vendor, String expectedCountryName) throws IOException {
		new LoginPage()
		.enterEmail(email)
		.enterPassword(password)
		.clickLoginButton()
		.mousehoverOnVendors()
		.clickSearchForVendors()
		.enterVendorName(vendor)
		.clickSearchButton()
		.getContryName()
		.verifyCountryName(expectedCountryName)
		.clickLogout()
		.stopApplication();
	}
}
