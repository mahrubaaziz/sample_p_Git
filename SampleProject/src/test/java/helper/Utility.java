package helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility {

	
		//we are using method overloading
	//wait for the webelement
		public static WebElement waitForWebElement(WebDriver driver, By element)
		{//we initialize webdriverwait element
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return driver.findElement(element);
		}
		public static WebElement waitForWebElement(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return element; //till this line method overloading
		}
		//validating message we are providing the locator as parameter
		public static void validateMessage( WebElement element, String msg)
		{//"Credit Line Approve" suppose this messssage need to be pass so we are verifying the msg
			Assert.assertEquals(element.getText(), msg);
		}
		public static void validatePartialText( WebElement element, String msg)//we are validating the partial msg we are in the page so 
		//we dont need the driver
		{
			Assert.assertTrue(element.getText().contains(msg));
		}
		public static void validateContainTitle(WebDriver driver,String title)
		{
			boolean status = new WebDriverWait(driver,30).until(ExpectedConditions.titleIs(title));
			Assert.assertTrue(status);
		}
		public static void validateContainsTitle(WebDriver driver,String url)//we are just gonna capture the title and validate  it
		{
			boolean status =new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains(url));
			Assert.assertTrue(status);
		}
		public static void verrifyCurrentURL(WebDriver driver,String url)//verifying are we in a correct page or not
		{
			boolean status= new WebDriverWait(driver, 30).until(ExpectedConditions.urlContains(url));
			Assert.assertTrue(status);
		}
		public void dismissAlert(WebDriver driver)//if there is any alert this msg will dismiss 
		{
			new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent()).dismiss();
		}		
		public void acceptAlert(WebDriver driver)//this will always change that's why we put void only
		{
			new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent()).accept();
		}
		public void verifyAlertMsg(WebDriver driver, String msg)
		{
			boolean status = new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent()).getText().equalsIgnoreCase(msg);
			Assert.assertTrue(status);
			//way 1-String veri=new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent()).getText();
			//Assert.assertTrue(true, veri);
			/*way 2-String expected= new WebDriverWait(driver,30).until(ExpectedConditions.alertIsPresent()).getText();
			 * //Assert.assertTrue(True, ver); //do not need the boolean when we  are using string ,hrodoy's method
			 * need not to declare String as parameter
			System.out.println(expected);
			String actual="";
			Assert.assertEquals(actual, expected);// we can compare the expected vs actual so 
			
			//way2-*/
		}
		public void handleFrame(WebDriver driver, int index)	
		{
			new WebDriverWait(driver, 30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
		}
		public static String captureScreenshot(WebDriver driver)
		{
			String time =getTime();
			String dest =System.getProperty("user.dir")+"ScreenShot/AP"+time+".png";//create screenshot obj
			TakesScreenshot ts =(TakesScreenshot)driver;
			
			File src=ts.getScreenshotAs(OutputType.FILE);//we create a method and put the file
			
			try{// if fail ,want to see why fail
				FileHandler.copy(src, new File(dest));
			}catch(IOException e){
				System.out.println("Screenshot Failed"+e.getMessage());
			}
			return dest;//returning the obj
		}
		
		public static String getTime()// we create a method for gettime
		{
			DateFormat dateFormat= new SimpleDateFormat("HH_mm_ss_MM_yyyy");
			return dateFormat.format(new Date());
		}
	}


