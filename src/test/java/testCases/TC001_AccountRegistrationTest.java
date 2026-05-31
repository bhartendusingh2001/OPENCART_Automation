package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;


public class TC001_AccountRegistrationTest extends BaseClass{

	
	
	@Test(groups={"Sanity","Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("****Starting of the TC001_AccountRegistration*****");
		
		try {
		//creating objects of the HomePage to call methods available in it
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on the My Account");
		hp.clickRegister();
		logger.info("Clicked on the Registration Page");
		
		//creating objects of the AccountRegistrationPage to call methods available in it
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing Customer Details");
		regpage.setFirstName(randomString().toUpperCase());
		logger.info("First Name Done");
		regpage.setLastname(randomString().toUpperCase());
		logger.info("Last Name Done");
		regpage.setEmail(randomAlphaNumeric()+"@gmail.com");
		logger.info("Email Id Done");
		regpage.setMobile(randomNumber());
		logger.info("Mobile NumberDone");
	
		String generatedpassword = randomAlphaNumeric();
		regpage.setPassword(generatedpassword);
		logger.info("Set Password Done");
		regpage.confirmPassword(generatedpassword);
		logger.info("Confirm Password Done");
		regpage.clickCheckbox();
		logger.info("Click on Check box");
		regpage.clickContinuebtn();
		logger.info("Click on continue button");
		
		logger.info("Validating the message");
		String cfmsg = regpage.getConfirmationmsg();
		if(cfmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test failed");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) {
		Assert.fail();
		}
		logger.info("*****Finished TC001_AccountRegistrationTest*****");
	}
	
	
}
