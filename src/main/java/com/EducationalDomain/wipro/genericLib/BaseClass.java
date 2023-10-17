package com.EducationalDomain.wipro.genericLib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author surajkumar
 *
 */
public class BaseClass {
	public WebDriver driver;
	public ExtentHtmlReporter htmlreport;
	public static ExtentReports reports;
	public static ExtentTest test;
	public WebdriverUtilities utilities= new WebdriverUtilities();
	public FileUtilities fu=new FileUtilities();
	
	@BeforeSuite
	public void configBS()
	{
		htmlreport=new ExtentHtmlReporter(AutoConstant.reportpath);
		htmlreport.config().setDocumentTitle("SkillraryReport");
		htmlreport.config().setTheme(Theme.DARK);
		reports=new ExtentReports();
		reports.attachReporter(htmlreport);
	}
	
	@BeforeMethod
	public void openApp() throws FileNotFoundException, IOException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(fu.getPropertyFile("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod()
	public void closeApp(ITestResult res)
	{
		int result = res.getStatus();
		if(result==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,res.getName()+"Test case failed");
			test.log(Status.FAIL,res.getThrowable()+"Test case failed exception");
		}
		else if(result==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,res.getName()+"Test case passed");

		}
		else if(result==ITestResult.SKIP)
		{
			test.log(Status.SKIP,res.getName()+"Test case skipped");

		}
		driver.quit();
	}
	
	@AfterSuite
	public void configAS()
	{
		//htmlreport.flush();
		reports.flush();
	}
}
