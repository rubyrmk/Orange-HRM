package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.ReadExcel;

public class ProjectSpecifiedMethods {
	public static ChromeDriver driver;	
	public static ExtentHtmlReporter reporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	public String workBook, testName, testDescription, testAuthor, testCategory;
	@BeforeSuite
	public void startReport() {
		reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
	}
	@BeforeClass
	public void reportTest() {
		test = reports.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);
	}
	public long takeSnap() throws IOException {
		long number = (long)Math.floor((Math.random()*98776565L)+7896665L);
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/image"+number+".png");
		FileUtils.copyFile(src, des);
		return number;
	}
	public void reportStep(String message, String status) throws IOException {
		if(status.equals("pass")) {
			test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/image"+takeSnap()+".png").build());
		}else {
			test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/image"+takeSnap()+".png").build());
		}
	}
	@Parameters("url")
	@BeforeMethod
	public void startApplication(String data) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver83.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(data);
	}
	@AfterMethod
	public void stopApplication() {
		driver.quit();
	}
	@AfterSuite
	public void stopReport() {
		reports.flush();
	}
	@DataProvider
	public String [][] sendData() throws IOException {
		return ReadExcel.sendData(workBook);
	}
}
