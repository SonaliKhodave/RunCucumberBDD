package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerPageObject {

    WebDriver ldriver;
    public CustomerPageObject(WebDriver rdriver)
    {
        ldriver=rdriver;
        PageFactory.initElements(rdriver,this);
    }


    @FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]")
    static
    WebElement customer_menu;

    @FindBy(xpath = "/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
    WebElement customer_item;
    @FindBy(xpath = "//a[@href='/Admin/Customer/Create']")
    WebElement Add_NEW_BUTTON;
    @FindBy(id = "Email")
    WebElement enterEmailTextBox;

    @FindBy(id = "Password")
    WebElement enterPasswordinTExtBox;
    @FindBy(id = "FirstName")
    WebElement enteFrstName;
    @FindBy(xpath = "//input[@id='Gender_Female']")
    WebElement radioButtonFemale;

    @FindBy(xpath = "//input[@id='Gender_Male']")
    WebElement radioButtonMale;

    //    @FindBy(xpath = "//span[@aria-controls='DateOfBirth_dateview']")
//            WebElement datePicker;
    @FindBy(xpath =  "/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[10]/div[2]/div/div[1]/div/div")
    WebElement customer_role_listbox;
    @FindBy(xpath =  "//select[@id='VendorId']")
    WebElement manager_OF_Vendor_Select_option;
    @FindBy(xpath =  "//button[@name='save']")
    WebElement save_button;

    @FindBy(xpath = "//input[@id='DateOfBirth']")
    WebElement DOB;


    public String getPageTitle()

    {
        return ldriver.getTitle();
    }

    public  void clickOnCustomersMenu()
    {
        customer_menu.click();
    }

    public  void clickOnCustomersItem()
    {
        customer_item.click();
    }
    public void clickOnAddItemButton()
    {
        Add_NEW_BUTTON.click();
    }
    public void enterEmail(String email)
    {
        enterEmailTextBox.sendKeys(email);
    }
    public void enterPassword(String password)
    {
        enterPasswordinTExtBox.sendKeys(password);
    }
    public void enterFirstName(String firstName)
    {
        enteFrstName.sendKeys(firstName);
    }

    public void selectRadiobutton()
    {
        radioButtonFemale.click();
    }
    public  void EnterDob(String dob)
    {
        DOB.sendKeys(dob);
    }

    public void clickOnCustomerRole(String value)
    {
        Actions action = new Actions(ldriver);
        action.moveToElement(customer_role_listbox).sendKeys(value);
//        customer_role_listbox.sendKeys(value);
//        Select dropDownforCustomerRole= new Select(customer_role_listbox);
//        dropDownforCustomerRole.selectByVisibleText(value);
    }
    public void selectMAnagerOfVendors(String value)
    {
        Select dropdownlist= new Select(manager_OF_Vendor_Select_option);
        dropdownlist.selectByVisibleText(value);
    }
    public void clickOnSaveButton()
    {
        save_button.click();
    }

    public void selectGender( String gender)
    {
        if(gender.equals("Male"))
        {
            radioButtonMale.click();
        }
        else
        {
            radioButtonFemale.click();
        }

    }

}
