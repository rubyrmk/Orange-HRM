package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethods;
import pages.LoginPage;

public class VerifyLoginWithInvalidCredential extends ProjectSpecifiedMethods{
	@BeforeTest
	public void getData() {
		workBook = "Login";
		testName = "Verify Login Page";
		testDescription = "Verify Login with Invalid Credential";
		testCategory = "Functional";
		testAuthor = "Karthi";
	}
	@Test(dataProvider = "sendData")
	public void verifyLoginPage(String username, String password) throws IOException {
		new LoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.verifyLogin()
		.verifyErrorMessage();
	}
}
