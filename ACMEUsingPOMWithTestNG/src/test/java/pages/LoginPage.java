package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethods;

public class LoginPage extends ProjectSpecifiedMethods{
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "email")
	WebElement eleEmail;
	public LoginPage enterEmail(String data) throws IOException {
		try {
			eleEmail.sendKeys(data);
			reportStep("Email enterted sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to enter Email", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "password")
	WebElement elePassword;
	public LoginPage enterPassword(String data) throws IOException {
		try {
			elePassword.sendKeys(data);
			reportStep("Password enterted sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to enter Password", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement eleLoginButton;
	public DashboardPage clickLoginButton() throws IOException {
		try {
			eleLoginButton.click();
			reportStep("Login button clicked Sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to click Login button", "fail");
		}
		return new DashboardPage();
	}
}
