package helper;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;//need AfterClass testNG
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dataProviderFactorry.DataProviderFactory;

public class BaseClass {
//we are creating obj so that we can reference back them
	//instead of calling the jar files everytimes
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupReport(){
		
		System.out.println("LOG:INFO - Before suite running- Setting up Report");
		//extension/impoprt from extent reporting, creating the report in html format
		//initializing user dir  AP is the name of the application , the report will generate here like AP day time AP_1_1:19
		//the report I want it as a html format
		ExtentHtmlReporter reporter= new ExtentHtmlReporter(new File(System.getProperty("user.dir")+ "/Reports/AP_ "+Utility.getTime()+".html"));
		//report will generate, take the screenshot
		report =new ExtentReports();
		report.attachReporter(reporter); // this will attach report
		
		System.out.println("LOG:INFO - After suite running- Reports are ready to use");
	}
		//it will execute before class 
		@BeforeClass
		public void setupBrowser(){
			// we are calling the  driver first from browser fctory
			// we have to deczlare what browser I want to work with
			System.out.println("LOG:INFO: Creating Browser Session");
			// we are getting the info from dataprovider factory
			driver = BrowserFactory.startApplication(
					DataProviderFactory.getConfig().getBrowser()
					,DataProviderFactory.getConfig().getStagingURL());
			System.out.println("LOG:INFO:Browser Session Created");
		}
		// it will execute after every method
		// calling the dependen from ITestResult
		
		@AfterMethod
		public void appendReport(ITestResult result){
			System.out.println("Test Name"+result.getName()); // we dont need to call   getname is class name
			
			System.out.println("LOG:INFO - After Method running- Generating Test Report");
			// crating a int of the status like binary number
			int status=result.getStatus();
			// I am creating condition if my 
			if(status==ITestResult.SUCCESS)
			{
				try{//trying to catch the error MediaEntityModelProvider.. 
					//picture type from java it will catch the if there is any problem to capture the screen shot  .. 
					//build is a action class method 
					//this will going to attach the result if it is not able to take the result
					logger.pass("Test Scenario pass",MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
				
				}catch(IOException e){ //if some type of error happening it will catch 
					System.out.println("Not able to attach Screenshot"+e.getMessage());
				}
			}// if the test get fail
			else if(status==ITestResult.FAILURE)
			{
				try{//throwable will catch what type of error it was is it IO? throwable? 
				logger.fail("Test Failed"+result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
			}catch(IOException e){
				System.out.println("Not able to attach screenshot"+ e.getMessage());
				}
			}//when test get skipped instead of failing basically it will generate rest of the report except th e failing
			else if(status==ITestResult.SKIP)
			{
				logger.skip("Test Scenario Skipper");
			}
			//flush is saying clean up after every class
			report.flush();
			System.out.println("LOG:INFO - After Method Executed - Test Result appened to");
			
		}
		@AfterClass
		public void CloseSessons()
		{
		System.out.println("LOG:INFO Closing Browser Sessioins");
		driver.quit();
		System.out.println("LOG:INFO Browser Sessions Closeed");
		
			}
		}
	

