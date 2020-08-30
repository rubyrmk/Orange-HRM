package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethods;

public class DashboardPage extends ProjectSpecifiedMethods{
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//div[@id='branding']/a)[2]")
	WebElement verifyLogin;
	public DashboardPage verifyLogin() throws IOException {
		try {
			String actualText = verifyLogin.getText();
			if(actualText.contains("welcome")) {
				System.out.println("Login success");
			}else {
				System.out.println("Failed to Login");
			}
			reportStep("Sucessfully logged in", "pass");
		} catch (Exception e) {
			reportStep("Failed to Login", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "menu_pim_viewMyDetails")
	WebElement myInfo;
	public MyInfoPage clickMyInfo() throws IOException {
		try {
			myInfo.click();
			reportStep("My Info page clicked sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to click MyInfo page", "fail");
		}
		return new MyInfoPage();
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "menu_leave_viewLeaveModule")
	WebElement leave;
	public LeavePage clickLeave() throws IOException {
		try {
			leave.click();
			reportStep("Leave page clicked sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to click leave page", "fail");
		}
		return new LeavePage();
	}
}
