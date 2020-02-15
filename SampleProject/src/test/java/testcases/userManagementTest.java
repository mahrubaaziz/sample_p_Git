package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import helper.BaseClass;
import pages.Login;
import pages.UserManagement;

public class userManagementTest extends BaseClass {
	
UserManagement UserManagement;
Login login;

	/*@BeforeTest
	public void loginInitialize(){
		//create an object of login class and then initialize that
		
	}*/
	
	@Test(description="")
	public void userManagement(){
		
		login = PageFactory.initElements(driver, Login.class);
				
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
