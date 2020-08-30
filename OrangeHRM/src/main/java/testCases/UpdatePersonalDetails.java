package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethods;
import pages.LoginPage;

public class UpdatePersonalDetails extends ProjectSpecifiedMethods{
	@BeforeTest
	public void getData() {
		testName = "Verify My Info tab";
		testDescription = "Verify Update Personal Details";
		testCategory = "Functional";
		testAuthor = "Karthi";
	}
	@Test
	public void updatePersonalDetails() throws IOException {
		new LoginPage()
		.enterUsername("Admin")
		.enterPassword("admin123")
		.clickLoginButton()
		.clickMyInfo()
		.clickEdit()
		.changeEmployeeId()
		.changeNationality()
		.clickEdit();
	}
}
