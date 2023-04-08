
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.BaseClass;

public class SearchCustomerPage extends BaseClass{
	
	WebDriver ldriver;
	public SearchCustomerPage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//input[@id='SearchEmail']")
	WebElement txtemail;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement searchBtn;
	
	@FindBy(xpath="//table[@id='customers-grid']/tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath="//table[@id='customers-grid']/tbody/tr/td")
	List<WebElement> tableCol;
	
	@FindBy(xpath="//table[@id='customers-grid']")
	WebElement table;
	
	public void setEmail(String email ) throws InterruptedException {
		Thread.sleep(2000);
		txtemail.clear();
		txtemail.sendKeys(email);
	}
	
	public void clickOnSearch() throws InterruptedException {
		Thread.sleep(2000);
		searchBtn.click();
	}
	
	public int getRow() {
		return tableRows.size();
	}
	
	public int getCol() {
		return tableCol.size();
	}
	
	public boolean searchCustomerByEmail(String email) {
		
		boolean flag=false;
		
		for(int i=1;i<=getRow();i++) 
		{
			
			String emailId=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr/td["+i+"]")).getText();
		
			if(emailId.equals(email)) {
				flag=true;
			}
		}
		return flag;
		
	}
	
	
	
	

}
