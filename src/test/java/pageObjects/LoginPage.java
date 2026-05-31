package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	//constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}
		
		//Locator
		@FindBy(xpath="//input[@id='input-email']")
		WebElement emailid;
		
		@FindBy(xpath="//input[@id='input-password']")
		WebElement login_password;
		
		@FindBy(xpath="//input[@class='btn btn-primary']")
		WebElement loginpage_bttn;
		
	
		//Action Method
		public void set_email(String email) {
			emailid.sendKeys(email);
		}
		
		public void set_login_password(String pwd) {
			login_password.sendKeys(pwd);
		}
		
		public void loginpage_bttn_click() {
			loginpage_bttn.click();
		}
		
		

}
