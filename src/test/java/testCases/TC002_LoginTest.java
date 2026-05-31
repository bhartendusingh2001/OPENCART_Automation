package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.My_Account_Page;

public class TC002_LoginTest extends BaseClass {
	@Test(groups={"Sanity","Master"})
	public void verifyLogin() {
		logger.info("*****Start the TC002*****");
		
		try {
		//HomePage Object for calling
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickloginbttn();
		
		//LoginPage Object for calling
		LoginPage lp = new LoginPage(driver);
		lp.set_email(p.getProperty("email_id"));
		lp.set_login_password(p.getProperty("password"));
		lp.loginpage_bttn_click();
		
		//My_Account_Page object for calling
		My_Account_Page macc = new My_Account_Page(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		Assert.assertTrue(targetPage);
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*****TC002_Finished*****");
	}
}
