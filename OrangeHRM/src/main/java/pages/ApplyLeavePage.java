package pages;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethods;

public class ApplyLeavePage extends ProjectSpecifiedMethods{
	public ApplyLeavePage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "applyleave_txtLeaveType")
	WebElement leaveType;
	public ApplyLeavePage chooseLeaveType() throws IOException {
		try {
			leaveType.click();
			selectByVisibleText(leaveType, "Vacation US");
			reportStep("Leave type is selected sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to select Leave Type", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "applyleave_leaveBalance")
	WebElement leaveBalance;
	public ApplyLeavePage checkLeaveBalance() throws IOException {
		try {
			String leaveAvailable = leaveBalance.getText();
			if(leaveAvailable.contentEquals("o.oo")) {
				System.out.println("All allocated leaves for the accounting year is taken");
				throw new RuntimeException();
			}
			reportStep("Leave balance is updated sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to get leave balance", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "applyleave_txtFromDate")
	WebElement fromDate;
	public ApplyLeavePage chooseFromDate() throws IOException {
		try {
			fromDate.click();
			driver.findElementByXPath("//td[@data-handler='selectDay']/a[text()='25']").click();
			reportStep("From date is choosed sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to choose from date", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "applyleave_txtToDate")
	WebElement toDate;
	public ApplyLeavePage chooseToDate() throws IOException {
		try {
			toDate.click();
			driver.findElementByXPath("//td[@data-handler='selectDay']/a[text()='26']").click();
			reportStep("To date is choosed sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to choose To date", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "applyBtn")
	WebElement applyButton;
	public ApplyLeavePage clickApplyButton() throws IOException {
		try {
			applyButton.click();
			reportStep("Apply button is clicked sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to click the Apply button", "fail");
		}
		return this;
	}
}
