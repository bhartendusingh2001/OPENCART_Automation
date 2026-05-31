package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.My_Account_Page;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class,groups="Datadriven")//getting data provider from different 
	public void verify_loginDDT(String email, String pwd, String exp) {
		logger.info("***Starting of the TC003_LoginDDT***");
		
		try {
		//HomePage Object for calling
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickloginbttn();
				
		//LoginPage Object for calling
		LoginPage lp = new LoginPage(driver);
		lp.set_email(email);
		lp.set_login_password(pwd);
		lp.loginpage_bttn_click();
				
		//My_Account_Page object for calling
		My_Account_Page macc = new My_Account_Page(driver);
		boolean targetPage = macc.isMyAccountPageExists();
//		Assert.assertTrue(targetPage);
//		
		/*  valid data ---> able to login ---> successfull ---> logout
		    valid data ---> not able to login ---> Unsuccessfull
			Invalid data ----> able to login ---> unsuccessfull
		    Invalid data ---> not able to login ----> successfull*/
		
		if(exp.equalsIgnoreCase("valid")) {
			if(targetPage ==true) {
				macc.logoutclick();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage == true) {
				macc.logoutclick();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("*** Ending of the TC003_LoginDDT ***");
	}
}
