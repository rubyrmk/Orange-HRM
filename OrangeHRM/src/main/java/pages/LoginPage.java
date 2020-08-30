package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecifiedMethods;
//Login Page
public class LoginPage extends ProjectSpecifiedMethods{
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "txtUsername")
	WebElement username;
	public LoginPage enterUsername(String data) throws IOException {
		try {			
			username.sendKeys(data);
			reportStep("Username is entered succesfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to enter Username", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "txtPassword")
	WebElement password;
	public LoginPage enterPassword(String data) throws IOException {
		try {
			password.sendKeys(data);
			reportStep("Password  is entered succesfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to enter Password", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "btnLogin")
	WebElement login;
	public DashboardPage clickLoginButton() throws IOException {
		try {
			login.click();
			reportStep("Login button clicked sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to click login button", "fail");
		}
		return new DashboardPage();
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "btnLogin")
	WebElement invalidLogin;
	public LoginPage verifyLogin() throws IOException {
		try {
			invalidLogin.click();
			reportStep("Login button clicked sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to click login button", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using ="spanMessage")
	WebElement errorMessage;
	public LoginPage verifyErrorMessage() throws IOException {
		try {
			String actualError = errorMessage.getText();
			String expectedInvalidCredentialError = "Invalid credentials";
			String expectedEmptyUsernameError = "Username cannot be empty";
			String expectedEmptyPasswordError = "Password cannot be empty";
			if(actualError.contentEquals(expectedEmptyUsernameError)) {
				Assert.assertEquals(actualError, expectedEmptyUsernameError);
				reportStep("Empty Usernmae field Error message is displayed sucessfully", "pass");
			}else if(actualError.contentEquals(expectedEmptyPasswordError)) {
				Assert.assertEquals(actualError, expectedEmptyPasswordError);
				reportStep("Empty Password field Error message is displayed sucessfully", "pass");
			}else {
			Assert.assertEquals(actualError, expectedInvalidCredentialError);
			reportStep("Invalid Credential Error message is displayed sucessfully", "pass");
			}
		} catch (Exception e) {
			reportStep("Failed to display the error message", "fail");
		}
		return this;
	}
}
