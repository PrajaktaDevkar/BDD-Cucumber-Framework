
package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {

	
@Given("^User launch chrome browser$")
public void user_launch_chrome_browser() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\praja\\OneDrive\\Documents\\Selenium\\ChromeDriver\\chromedriver.exe");
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    lp=new LoginPage(driver);
}

@When("user open URL {string}")
public void user_open_URL(String url) throws InterruptedException {
    driver.get(url);
    Thread.sleep(2000);
}

@When("user enter Email as {string} and password as {string}")
public void user_enter_Email_as_and_password_as(String email, String pass) {
    lp.setEmail(email);
   lp.setPass(pass);
}

@When("click on login")
public void click_on_login() throws InterruptedException {
    lp.clickLoginBtn();
 
}

@Then("page title should be {string}")
public void page_title_should_be(String title) throws InterruptedException {
	String txtTitle=driver.getTitle();
	System.out.println(title);
    Assert.assertEquals(title, txtTitle);
}

@When("user click on log out link")
public void user_click_on_log_out_link() throws InterruptedException {
   Thread.sleep(2000);
	lp.clickLogoutBtn();
   
}

@Then("close browser")
public void close_browser() {
    driver.quit();
}

/* Customer Scenario
	Add New User
*/


@Then("User can view Dashboard")
public void user_can_view_Dashboard() {
   addCust=new AddCustomerPage(driver);
   Assert.assertEquals("Dashboard / nopCommerce administration", driver.getTitle());
   
}

@When("User click on customers Menu")
public void user_click_on_customers_Menu() {
    addCust.clickOnCustomerMenu();
}

@When("click on customer Menu Item")
public void click_on_customer_Menu_Item() {
   addCust.clickOnCustomerMenuItem();
}

@When("click on Add new button")
public void click_on_Add_new_button() {
  addCust.clickOnAddNew();
}

@Then("User can view add new customer page")
public void user_can_view_add_new_customer_page() throws InterruptedException {
	Thread.sleep(2000);
   Assert.assertEquals("Add a new customer / nopCommerce administration", driver.getTitle());
}

@When("User enter customer info")
public void user_enter_customer_info() throws InterruptedException {
	Thread.sleep(2000);
	String email= randomstring()+"@gmail.com";
	addCust.setEmail(email);
	addCust.setPass("admin1234");
	addCust.setCompany("virtusa");
	addCust.setDOB("07/10/2022");
	addCust.setFirstName("Virat");
	addCust.setLastName("kholi");
	addCust.setGeneder("Male");
	addCust.setCustomerRole("Administrators");
	addCust.setManager("Vendor 1");
	addCust.setAdminContent("This is for testing");
	
   
}

@When("click on save button")
public void click_on_save_button() throws InterruptedException {
   addCust.clickOnSave();
   Thread.sleep(2000);
}

@Then("User can view confirmation message {string}")
public void user_can_view_confirmation_message(String msg) {
   Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
}

//Search Customer By Email


@When("Enter customer Email")
public void enter_customer_Email() throws InterruptedException {
	searchCust=new SearchCustomerPage(driver);
    searchCust.setEmail("kiyjcycyhjc676008@gmail.com");
}

@When("click on search button")
public void click_on_search_button() throws InterruptedException {
    searchCust.clickOnSearch();
}

@Then("user should found email in the search table")
public void user_should_found_email_in_the_search_table() {
   boolean status = searchCust.searchCustomerByEmail("kiyjcycyhjc676008@gmail.com");
   System.out.println("flag:"+status);
   Assert.assertEquals(true, status);
}



}
