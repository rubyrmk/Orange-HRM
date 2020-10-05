package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecifiedMethods;

public class SearchResult extends ProjectSpecifiedMethods{
	public SearchResult() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//table//tr[2]/td[5]")
	WebElement eleGetCountryName;
	public SearchResult getContryName() throws IOException {
		try {
			eleGetCountryName.getText();			
			reportStep("Sucessfully got the Country Name", "pass");
		} catch (Exception e) {
			reportStep("Failed to get Country Name", "fail");
		}
		return this;
	}
	public SearchResult verifyCountryName(String data) throws IOException {
		String expectedCountryName = data;
		String actualCountryName = eleGetCountryName.getText();
		try {
			Assert.assertEquals(actualCountryName, expectedCountryName, "Country Name is not matched");
			reportStep("Country Name is matched", "pass");
		} catch (Exception e) {
			reportStep("Country Name is not matched", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Log Out")
	WebElement eleLogoutButton;
	public LoginPage clickLogout() throws IOException {
		try {
			eleLogoutButton.click();
			reportStep("Logout button clicked Sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to click Logout button", "fail");
		}
		return new LoginPage();
	}
}
