package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethods;

public class DashboardPage extends ProjectSpecifiedMethods{
	public static Actions builder;
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[text()=' Vendors']")
	WebElement eleMousehoverOnVendors;
	public DashboardPage mousehoverOnVendors() throws IOException {
		try {
			builder = new Actions(driver);
			builder.moveToElement(eleMousehoverOnVendors).perform();
			reportStep("Sucessfully mousehovered on Vendors", "pass");
		} catch (Exception e) {
			reportStep("Failed to mousehover on Vendors", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Search for Vendor")
	WebElement eleSearchForVendors;
	public SearchVendors clickSearchForVendors() throws IOException {
		try {
			eleSearchForVendors.click();
			reportStep("Search for Vendors link clicked Sucesfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to click search for Vendors Link", "fail");
		}
		return new SearchVendors();
	}
}
