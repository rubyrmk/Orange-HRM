package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethods;
import pages.LoginPage;

public class AddAttachment extends ProjectSpecifiedMethods{
	@BeforeTest
	public void getData() {
		testName = "Verify My Info Page";
		testDescription = "Verify add Attachment";
		testCategory = "Functional";
		testAuthor = "Karthi";
	}
	@Test
	public void addAttachment() throws IOException {
		new LoginPage()
		.enterUsername("Admin")
		.enterPassword("admin123")
		.clickLoginButton()
		.clickMyInfo()
		.clcikAddAttachment()
		.clickChooseFile()
		.clickUpload();
	}
}
