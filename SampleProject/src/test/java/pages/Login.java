package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import helper.Utility;

public class Login {
	
	WebDriver driver;
	
	public Login(WebDriver Idriver)
	{
		this.driver=Idriver;
	}
	
	
	
	//locator for the new website opensource-demo.orangehrmlve.com
	
	@FindBy(name="txtUsername") WebElement username;
	@FindBy(name="txtPassword") WebElement password;
	@FindBy(name="Submit") WebElement Loginbutton;
	
	
	public void validateHomepage(){
		Utility.validateContainTitle(driver, "OrangeHRM");
	}
	
	/*public void clickonSignIn(){  //this was for automation practice website
		Utility.waitForWebElement(driver, SignIn).click();
		System.out.println("LOG: INFO Signed in");
		
	}*/
	
	public void enterUserName(String uname){
		System.out.println("LOG: INFO Username entered");
		Utility.waitForWebElement(driver, username).sendKeys(uname);
	}
	
	public void enterPassword(String pword){
		System.out.println("LOG: INFO Password entered");
		Utility.waitForWebElement(driver, password).sendKeys(pword);
	}
	
	public void clickonSubmitButton(){	
		Utility.waitForWebElement(driver, Loginbutton).click();
		System.out.println("LOG: INFO Login button clicked");
		
	}

}
