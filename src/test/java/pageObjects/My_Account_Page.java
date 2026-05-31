package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_Account_Page extends BasePage{

	//constructor
	public My_Account_Page(WebDriver driver) {
		super(driver);
	}
	
		//locators
		@FindBy(xpath="//h2[contains(text(),'My Account')]")
		WebElement mssgHeading;
		
		@FindBy(xpath="(//a[contains(text(),'Logout')])[2]")
		WebElement logout;
	
		//Action methods
		//This is not the validation, we are returning true or false --> will apply validation in Test Page.
		public boolean isMyAccountPageExists() {
			try {
				return (mssgHeading.isDisplayed());
			}
			catch(Exception e) {
				return false;
			}
			
		}
		
		public void logoutclick() {
			logout.click();
		}
}

	

