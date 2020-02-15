package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import helper.Utility;


public class UserManagement {
	
	WebDriver driver;
	
	public UserManagement(WebDriver IDriver)
	{
		this.driver = IDriver;
	}
	
	@FindBy(id="menu_admin_viewAdminModule") WebElement Admin;
	@FindBy(id="menu_admin_UserManagement") WebElement UserManagement;
	@FindBy(id="menu_admin_viewSystemUsers") WebElement Users;
	@FindBy(name="btnAdd") WebElement Add;
	@FindBy(id="systemUser_userType") WebElement userRoll;//dropdown list ESS
	@FindBy(id="systemUser_employeeName_empName") WebElement EmployeeName;
	@FindBy(xpath="//*[@id='systemUser_userName']") WebElement UserName;
	@FindBy(id="systemUser_status") WebElement status;
	@FindBy(id="systemUser_password") WebElement password;
	@FindBy(id="systemUser_confirmPassword") WebElement confirmPassword;
	@FindBy(id="btnSave") WebElement Save;



public void validateahomePage()
{
	Utility.validateContainsTitle(driver, "OrangeHRM");
}

public void hoverOnAdmin(){
	Actions action =new Actions(driver);
	action.moveToElement(Admin).build().perform();
	System.out.println("LOG: INFO Hover on Admin");
	Utility.waitForWebElement(driver, Admin);
}

public void hoverOnUserManagement(){
	Actions action=new Actions(driver);
	action.moveToElement(UserManagement).build().perform();
	System.out.println("LOG: INFO Hover on User Management");
	Utility.waitForWebElement(driver, UserManagement);
}

public void clickOnUsers(){
	Utility.waitForWebElement(driver, Users).click();
	System.out.println("LOG: INFO Click on Users");
}

public void addButton(){
	Utility.waitForWebElement(driver, Add).click();
	System.out.println("LOG: INFO Click on Add button");
}

public void selectDropdown(){
	Select dropdown=new Select(userRoll);
	dropdown.selectByVisibleText("ESS");
	Utility.waitForWebElement(driver, userRoll).getText();
	System.out.println("LOG: INFO ESS from dropdown list been selected");
}

public void enterEmployeeName(String empName){
	Utility.waitForWebElement(driver, EmployeeName).sendKeys(empName);
	System.out.println("LOG: INFO Employee name entered");
}

public void enterUserName(String username){
	Utility.waitForWebElement(driver, UserName).sendKeys(username);
	System.out.println("LOG: INFO User name entered");
}

public void selectStatus(){
	Select dropdown1= new Select(status);
	dropdown1.selectByVisibleText("Enabled");
	Utility.waitForWebElement(driver, status).getText();
	System.out.println("LOG: INFO Enable been selected");
}

public void enterPassword(String passw){
	Utility.waitForWebElement(driver, password).sendKeys(passw);
	System.out.println("LOG: INFO Password entered");
}

public void confirmPassword(String Cpassw){
	Utility.waitForWebElement(driver, confirmPassword).sendKeys(Cpassw);
	System.out.println("LOG: INFO Password confirmed");
}

public void saveButton(){
	Utility.waitForWebElement(driver, Save).click();
	System.out.println("LOG: INFO Information saved");
}

}
