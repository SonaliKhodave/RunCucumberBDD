package com.stepdef;

import com.pages.CustomerPageObject;
import com.pages.LoginPageObject;
import com.pages.SearchCustomerPageObj;
import com.utils.readConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;

//child class of base class
public class stepdef extends BaseClass{
    // Logger log= LogManager.getLogger("stepdef");
    @Before("@sanity")
    public void  setup1() {
        //initialize propertise class
        readcnfg= new readConfig();
        String browser=readcnfg.getBrowser();
    //launch browser
        switch (browser.toLowerCase())
        {

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/appledev/Documents/SonaliJavaProject/runcucumber/drivers/chromedriver");
                // WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "edge":
                System.setProperty("webdriver.edge.driver", "/Users/appledev/Documents/SonaliJavaProject/runcucumber/drivers/chromedriver");
//                 WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "/Users/appledev/Documents/SonaliJavaProject/runcucumber/drivers/geckodriver 6");
                // WebDriverManager.chromedriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                System.setProperty("webdriver.chrome.driver", "/Users/appledev/Documents/SonaliJavaProject/runcucumber/drivers/chromedriver");
                // WebDriverManager.chromedriver().setup();
                driver = new SafariDriver();
                break;
            default:
                driver=null;
                break;
        }


        //initialize logger
        log= LogManager.getLogger("stepdef");
        System.out.println("====setup1 sanity  method executed=====");
        log.info("===Setup1_Executed====");
    }
    @Before("@regression")
    public void  setup2() {
        log= LogManager.getLogger("stepdef");
        System.out.println("====setup2 method executed=====");
        System.setProperty("webdriver.chrome.driver", "/Users/appledev/Documents/SonaliJavaProject/runcucumber/drivers/chromedriver");
        // WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        log.info("===setup2_executed===");

    }
    @Given("user launch the chrome browser")
    public void user_launch_the_chrome_browser() {
        loginPageObj= new LoginPageObject(driver);
        log.info("chrome browser launched");
    }
    @When("user opens the url {string}")
    public void user_opens_the_url(String url) {
        driver.get(url);
        log.info("url opened");
    }
    @Then("user enters the email as {string} and password as {string}")
    public void user_enters_the_email_as_and_password_as(String email, String pwd) throws InterruptedException {
        loginPageObj.enterEmail(email);
        loginPageObj.EnterPassword(pwd);
        log.info("email and password entered");
    }
    @Then("click on login")
    public void click_on_login() {
        loginPageObj.clickOnLoginButton();
        log.info("Login button clicked ");
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String expectedTitle) throws InterruptedException {
        String actualTitle = driver.getTitle();
        System.out.println("Actual title is -------"+actualTitle);
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("page title is verified");
    }
    @When("user clicks on log out link")
    public void user_clicks_on_log_out_link() {
        loginPageObj.clickOnLogOutButton();
    }
//    @Then("user close the browser")
//    public void user_close_the_browser() {
//        driver.close();
//        driver.quit();
//    }
//     ==============customer StepDef==================
    @Then("user can see Dashboard page")
    public void user_can_see_dashboard_page() {
        custPgObj=new CustomerPageObject (driver);
        String ActualTitle=custPgObj.getPageTitle();
        String ExpectedTitle="Dashboard / nopCommerce administration";
        Assert.assertEquals(ActualTitle,ExpectedTitle);
    }
    @When("user clicks on Customers menu")
    public void user_clicks_on_customers_menu() {
        custPgObj.clickOnCustomersMenu();
    }
    @When("click on Customer menu item")
    public void click_on_customer_menu_item() {
        custPgObj.clickOnCustomersItem();
    }
    @When("click on Add new  button")
    public void click_on_add_new_button() {
        custPgObj.clickOnAddItemButton();
    }
    @Then("user can view add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",custPgObj.getPageTitle());
    }
    @When("user enter the customer info")
    public void user_enter_the_customer_info() throws InterruptedException
    {
        String email=RandomString()+"@gmail.com";
        Thread.sleep(1000);
        custPgObj.enterEmail(email);
        custPgObj.enterPassword("test123");
        custPgObj.enterFirstName("Swami Samartha");
        custPgObj.selectGender("Female");
        Thread.sleep(1000);
        custPgObj.clickOnCustomerRole("Vendors");
        custPgObj.EnterDob("11/12/1990");
        custPgObj.selectMAnagerOfVendors("Vendor 1");
    }
    @When("click on save button")
    public void click_on_save_button() {
        custPgObj.clickOnSaveButton();
    }
    @Then("user see a confirmation message As The new customer has been added successfully")
    public void user_see_a_confirmation_message_as_the_new_customer_has_been_added_successfully() {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains("The new customer has been added successfully."));
    }
//    ===========search customer by email step def==========
    @When("enter email to search customer by email")
    public void enter_email_to_search_customer_by_email()
    {
        srchPgObj=new SearchCustomerPageObj(driver);
        srchPgObj.setEmailtosearch("uiLHG@gmail.com");
    }
    @When("click on search button")
    public void click_on_search_button()
    {
        srchPgObj.ClickOnSearchButton();
    }
    @Then("user found email in the search table")
    public void user_found_email_in_the_search_table()
    {
        boolean status= srchPgObj.searchCustomerByEmail("uiLHG@gmail.com");
        Assert.assertEquals(true,status);
    }
//    ===========search customer by name ==================
    @When("Enter customer firstname")
    public void enter_customer_firstname() {
        srchPgObj= new SearchCustomerPageObj(driver);
        srchPgObj.enterFirstnameOfcustomer("Virat");
    }
    @When("Enter customer Lastname")
    public void enter_customer_lastname() {
        srchPgObj.enterLastNameOfCustomer("Kohli");
    }
    @Then("user found name in the search table")
    public void user_found_name_in_the_search_table() throws InterruptedException {
        Thread.sleep(1000);
        srchPgObj.searchCustomerByName("Virat Kohli");
    }
    @After
    public void teardown(Scenario sc) {
        System.out.println("======TearDown method executed=====");
        if(sc.isFailed()==true)
        {
            //convert webdriver object to take screenshot
            String filePath="/Users/appledev/Documents/SonaliJavaProject/runcucumber/Screenshot/failedtestscreenshot.png";

            TakesScreenshot scrShot= (TakesScreenshot) driver;

            //call get screenshot method
           File srcfile= scrShot.getScreenshotAs(OutputType.FILE);

           //move file to new destination
           File destFile= new File(filePath);

           //copy file at destination
            try {
                FileUtils.copyFile(srcfile,destFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        driver.quit();
    }
//    @BeforeStep
//    public void  beforestep()
//    {
//        System.out.println("======Before step=====");
//    }

//    @AfterStep
//    public void  afterStep()
//    {
//        System.out.println("======After step=====");
//    }
}
