
package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//a[@href='#']/i[@class='nav-icon far fa-user']")
	WebElement customerMenu;
	
	@FindBy(xpath="//a[@href=\"/Admin/Customer/List\"]/i[@class='nav-icon far fa-dot-circle']")
	WebElement customerMenuItem;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement addNewBtn;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtpass;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement rdMale;
	
	@FindBy(xpath="//input[@id='Gender_Female']")
	WebElement rdFemale;
	
	@FindBy(xpath="//input[@id='DateOfBirth']")
	WebElement dob;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement txtCompany;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']/input[@class='k-input']")
	WebElement txtCustomerRole;
	
	@FindBy(xpath="//li[text()='Administrators']")
	WebElement admin;
	
	@FindBy(xpath="//li[text()='Forum Moderators']")
	WebElement forumMode;
	
	@FindBy(xpath="//li[text()='Guests']")
	WebElement guest;

	@FindBy(xpath="//li[text()='Vendors']")
	WebElement vendors;
	
	@FindBy(xpath="//li[text()='Registered']")
	WebElement reg;
	
	@FindBy(xpath="//select[@id='VendorId']")
	WebElement drpMgr;
	
	@FindBy(xpath="//textarea[@name='AdminComment']")
	WebElement adContent;
	
	@FindBy(xpath="//button[@name='save']")
	WebElement	saveBtn;
	
	@FindBy(xpath="//li[@role='option']/span[@title='delete']")
	WebElement regCancelBtn;
	
	public void clickOnCustomerMenu() {
		customerMenu.click();
	}
	
	public void clickOnCustomerMenuItem() {
		customerMenuItem.click();
	}
	
	public void clickOnAddNew() {
		addNewBtn.click();
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setPass(String pass) {
		txtpass.sendKeys(pass);
	}
	
	public void setCustomerRole(String role) throws InterruptedException {
		
		txtCustomerRole.click();
		
		Boolean flag=false;
		WebElement listItem;
		Thread.sleep(2000);
		
		if(role.equals("Administrators")) {
			listItem=admin;
		}
		else if(role.equals("Forum Moderators")) {
			listItem=forumMode;
		}
		else if(role.equals("Guests")) {
			regCancelBtn.click();
			listItem=guest;
		}
		else if(role.equals("Vendors")) {
			listItem=vendors;
		}
		else {
			listItem=reg;
		}
		listItem.click();
		
		JavascriptExecutor js= (JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].click", listItem);
		
	}

	public void setManager(String value) {
		Select s=new Select(drpMgr);
		s.selectByVisibleText(value);
	}
	
	public void setGeneder(String gender) {
		if(gender.equals("Male")) {
			rdMale.click();
		}
		else {
			rdFemale.click();
		}
	}

	public void setFirstName(String fname){
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname){
		txtLastName.sendKeys(lname);
	}
	
	public void setDOB(String dobInput){
		dob.sendKeys(dobInput);
	}
	
	public void setCompany(String company){
		txtCompany.sendKeys(company);
	}
	
	public void setAdminContent(String content){
		adContent.sendKeys(content);
	}
	
	public void clickOnSave() {
		saveBtn.click();
	}
	
}
