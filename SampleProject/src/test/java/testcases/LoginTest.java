package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helper.BaseClass;
import pages.Login;
import pages.UserManagement;


public class LoginTest extends BaseClass {
	
	Login login;
	//LogOut logout;
	UserManagement UserManagement;
	
	@Test(description="", priority=1)
	public void loginToApp(){
		login = PageFactory.initElements(driver, Login.class);
		
		logger = report.createTest("Login test for AP");
		
		login.validateHomepage();
		
		logger.pass("Home Page validate");
		
		login.enterUserName("Admin");//need to put the value here username like "nebulajones@gmail.com" for automation practice
		
		logger.info("Userename entered");
		
		login.enterPassword("admin123");//need to put the value here like password "nebula123"
		
		logger.info("Password entered");
		
		login.clickonSubmitButton();
		
		logger.info("Clicked on login button");
		
	}
	
	
	
	   @Test(description="", priority=2)
		public void userManagement(){
			
					
			UserManagement = PageFactory.initElements(driver, UserManagement.class);
			
			logger= report.createTest("User Management page open");
			
			UserManagement.hoverOnAdmin();
			
			logger.info("Hover on Admin");
			
			UserManagement.hoverOnUserManagement();
			
			logger.info("Hover on user management");
			
			UserManagement.clickOnUsers();
			
			logger.info("Clicked on users");
			
			UserManagement.addButton();
			
			logger.info("clickeed on add button");
			
			UserManagement.selectDropdown();
			
			logger.info("ESS");
			
			UserManagement.enterEmployeeName("Hannah Flores");
			
			logger.info("Entered employee name");
			
			UserManagement.enterUserName("hannah.hannah");
			
			logger.info("User Name entered");
			
			UserManagement.selectStatus();
			
			logger.info("Select Enabled");
			
			UserManagement.enterPassword("hannah123");
			
			logger.info("Password entered");
			
			UserManagement.confirmPassword("hannah123");
			
			logger.info("Password confirmed");
			
			UserManagement.saveButton();
			
			logger.info("Clicked on save button");
			
			
			
			
			
		}

	
	
	

}
