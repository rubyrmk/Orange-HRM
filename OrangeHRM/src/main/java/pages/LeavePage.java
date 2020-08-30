package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethods;

public class LeavePage extends ProjectSpecifiedMethods{
	public LeavePage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "menu_leave_applyLeave")
	WebElement apply;
	public ApplyLeavePage clickApply() throws IOException {
		try {
			apply.click();
			reportStep("Apply leave inner tab is clicked sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to click Apply Leave inner tab", "fail");
		}
		return new ApplyLeavePage();
	}
}
