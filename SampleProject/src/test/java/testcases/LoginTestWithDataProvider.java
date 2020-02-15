package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProviderFactorry.DataProviderFactory;
import helper.BaseClass;
import pages.Login;
import pages.UserManagement;

public class LoginTestWithDataProvider extends BaseClass {
	
	Login login;//inherite log in page
	LogOut logout;
	UserManagement UserManagement;
	
	
	@Test(dataProvider="Login")//Login Data will be the sheetnanme
	public void loginToAP(String uname, String pword){
		login = PageFactory.initElements(driver, Login.class); //we need page factory because we need all the locator from that oage
		
		logger= report.createTest("Login Test for AP");//logger is a verifiacation of that page
		
		login.validateHomepage();
		
		logger.pass("Home page Validadte");
		
		login.enterUserName(uname);
		
		logger.info("User name entered");
		
		login.enterPassword(pword);
		
		logger.info("password entered");
		
		login.clickonSubmitButton();
		
		logger.info("clicked on log in button");
		
	}	
		@DataProvider(name="LoginData")
		public  Object[][] getDataFromSource()
		{
			System.out.println("LOG: INFO Running Data provider First to generate the data");
			
			int rows= DataProviderFactory.getExcel().getRows("Login");//go to dataprov fac get to excel and taking the info from rows Login is the sheetname
			
			System.out.println("Total row in Excel"+rows);
			
			Object[][]arr = new Object[rows-1][2];//-1 mean starting from 0
			
			for(int i= 0; i<rows-1; i++){
				
				arr[i][0]=DataProviderFactory.getExcel().getCellData("Login",i+1,0);//this means sheet from excel which name is Login getting the first column info
				arr[i][1]=DataProviderFactory.getExcel().getCellData("Login", i+1, 1);// getting the 2nd column info
			}
			
			System.out.println("LOG: INFO Data provider is ready for usage" );
		
			return arr;
		}
			
			@Test(dataProvider="userManagement")
			public void userManagement(String userRoll, String empName, String username, String status, String passw, String Cpassw){
				
				UserManagement = PageFactory.initElements(driver, UserManagement.class);
				
				logger= report.createTest("Land on User Management page");
				
				UserManagement.hoverOnAdmin();
				
				logger.info("Hovered on Admin");
				
				UserManagement.hoverOnUserManagement();
				
				logger.info("Hovered on User Manangement");
				
				UserManagement.clickOnUsers();
				
				logger.info("Click on user");
				
				UserManagement.addButton();
				
				logger.info("Click on add button");
				
				UserManagement.selectDropdown();
				
				logger.info("ESS");
				
				UserManagement.enterEmployeeName(empName);
				
				logger.info("Entered employee name");
				
				UserManagement.enterUserName(username);
				
				logger.info("User name entered");
				
				UserManagement.enterPassword(passw);
				
				logger.info("Password entered");
				
				UserManagement.confirmPassword(Cpassw);
				
				logger.info("Password confirmed");
					
			}
	
		
		@DataProvider(name="userManagement")
		public Object[][] getDataFromsource(){
			
			System.out.println("LOG: INFO Generate data after running the DataProvider ");
			
			int rows = DataProviderFactory.getExcel().getRows("userManagement");
			
			System.out.println("Total row in Excel"+rows);
			
			Object[][]arr =new Object[rows-1][5];
			
			for(int i=0; i<rows-1; i++){
				
				arr[i][0]= DataProviderFactory.getExcel().getCellData("userManagement", i+1, 0);
				arr[i][1]= DataProviderFactory.getExcel().getCellData("userManagement", i+1, 1);
				arr[i][0]= DataProviderFactory.getExcel().getCellData("userManagement", i+1, 2);
				arr[i][1]= DataProviderFactory.getExcel().getCellData("userManagement", i+1, 3);
				arr[i][0]= DataProviderFactory.getExcel().getCellData("userManagement", i+1, 4);
				arr[i][1]= DataProviderFactory.getExcel().getCellData("userManagement", i+1, 5);
			}
			
			System.out.println("LOG: INFO Data Provider is ready for usage");
			
			return arr;
			
			
		}

}
