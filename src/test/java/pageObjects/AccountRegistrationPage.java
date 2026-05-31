package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	//Constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver); 
	}
	
	//Locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="(//input[@type='checkbox'])")
	WebElement chkPrivacybox;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement msgConfirmation;
	
	
	//Action Methods
	public void setFirstName(String fname) {
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setMobile(String telephone) {
		txtTelephone.sendKeys(telephone);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void confirmPassword(String confirmpassword) { 
		txtConfirmPassword.sendKeys(confirmpassword);
	}
//	public void clickCheckbox() {
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    wait.until(ExpectedConditions.visibilityOf(chkPrivacybox));
//
//	    if(!chkPrivacybox.isSelected()) {
//	        chkPrivacybox.click();
//	    }
//	}
	public void clickCheckbox() {
		chkPrivacybox.click();
	}
	
	public void clickContinuebtn() {
		btnContinue.click();
	}
	
	//This does not do any validation, it just get the confirmation message
	public String getConfirmationmsg() {
		try {
			return (msgConfirmation.getText());
		}catch (Exception e) {
			return (e.getMessage());
		}
	}
	
}
