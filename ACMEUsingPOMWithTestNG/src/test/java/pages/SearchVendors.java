package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethods;

public class SearchVendors extends ProjectSpecifiedMethods{
	public SearchVendors() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "vendorName")
	WebElement eleVendorName;
	public SearchVendors enterVendorName(String data) throws IOException {
		try {
			eleVendorName.sendKeys(data);
			reportStep("Vendor Name enterted Sucesfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to enter Vendor Name", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "buttonSearch")
	WebElement eleSearchButton;
	public SearchResult clickSearchButton() throws IOException {
		try {
			eleSearchButton.click();
			reportStep("Search button is clicked sucesfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to click Search Button", "fail");
		}
		return new SearchResult();
	}
}
