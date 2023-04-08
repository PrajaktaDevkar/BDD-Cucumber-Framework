
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtpass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutBtn;
	
	
	
	public void setEmail(String username) {
		txtemail.clear();
		txtemail.sendKeys(username);
	}
	
	public void setPass(String password) {
		txtpass.clear();
		txtpass.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void clickLogoutBtn() {
		logoutBtn.click();
	}

}
