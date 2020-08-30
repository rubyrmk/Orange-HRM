package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecifiedMethods;
import pages.LoginPage;

public class ApplyLeave extends ProjectSpecifiedMethods{
	@BeforeTest
	public void getData() {
		testName = "Verify Leave page";
		testDescription = "Verify Apply Leave on Leave page";
		testCategory = "Functional";
		testAuthor = "Karthi";
	}
	@Test
	public void applyLeave() throws IOException {
		new LoginPage()
		.enterUsername("Admin")
		.enterPassword("admin123")
		.clickLoginButton()
		.clickLeave()
		.clickApply()
		.chooseLeaveType()
		.checkLeaveBalance()
		.chooseFromDate()
		.chooseToDate()
		.clickApplyButton();
	}
}
