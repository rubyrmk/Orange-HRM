package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecifiedMethods;

public class MyInfoPage extends ProjectSpecifiedMethods{
	public MyInfoPage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "btnSave")
	WebElement edit;
	public MyInfoPage clickEdit() throws IOException {
		try {
			edit.click();
			reportStep("Edit button clicked sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to click Edit button", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "personal_txtEmployeeId")
	WebElement employeeID;
	public MyInfoPage changeEmployeeId() throws IOException {
		try {
			employeeID.clear();
			employeeID.sendKeys("CML457");
			reportStep("Employee ID is entered sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to enter Employee ID", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "personal_cmbNation")
	WebElement nationality;
	public MyInfoPage changeNationality() throws IOException {
		try {
			nationality.click();
			selectByVisibleText(nationality, "Indian");
			reportStep("Nationality changed sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to change Nationality", "fail");
		}
		return this;
	}	
	public MyInfoPage scrollPage() {
		driver.executeScript("scroll(0,50);");
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "btnAddAttachment")
	WebElement addAttachment;
	public MyInfoPage clcikAddAttachment() throws IOException {
		try {
			addAttachment.click();
			reportStep("Attachment button clicked sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to click Attachment button", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "ufile")
	WebElement chooseFile;
	public MyInfoPage clickChooseFile() throws IOException {
		try {		
			chooseFile.sendKeys("C:\\Users\\QA\\Documents\\rmk.txt");
			reportStep("File choosed sucessfully", "pass");
		} catch (Exception e) {
			reportStep("Failed to choose file", "fail");
		}
		return this;
	}
	@CacheLookup
	@FindBy(how = How.ID, using = "btnSaveAttachment")
	WebElement upload;
	public MyInfoPage clickUpload() throws IOException {
		try {
			upload.click();
			reportStep("File Upload is sucess", "pass");
		} catch (Exception e) {
			reportStep("Failed to upload file", "fail");
		}
		return this;
	}
}
