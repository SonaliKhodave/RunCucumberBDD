package com.pages;

import com.utils.waitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerPageObj {


    WebDriver rdriver;
    waitHelper waithelper;

    public SearchCustomerPageObj(WebDriver ldriver)
    {
        rdriver=ldriver;
        PageFactory.initElements(ldriver,this);
        waithelper =new waitHelper(ldriver);
    }

    @FindBy(xpath = "//input[@id='SearchEmail']")
    WebElement SearchEmail;
    @FindBy(xpath = "//input[@id='SearchFirstName']")
    WebElement SearchByFirstName;
    @FindBy(xpath = "//button[@id='search-customers']")
    WebElement search_customers_button;
    @FindBy(xpath = "//input[@id='SearchLastName']")
    WebElement SearchByLasttName;

//    @FindBy(xpath = "//table[@id='customers-grid'] /tbody/tr/td[2]")
//    WebElement seacrhed_email;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> tableColumn;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    //@FindBy(xpath = "//table[@id='customers-grid']")
    @FindBy(xpath ="//div[@class='dataTables_scroll']")
    WebElement Table;
    public void setEmailtosearch(String email)
    {
        waithelper.WaitForElement(SearchEmail,10);
        SearchEmail.sendKeys(email);
    }
    public void enterFirstnameOfcustomer(String fname)
    {
        SearchByFirstName.sendKeys(fname);
    }
    public void enterLastNameOfCustomer(String lName)
    {
        SearchByLasttName.sendKeys(lName);
    }
    public void ClickOnSearchButton()
    {
        waithelper.WaitForElement(search_customers_button,10);
        search_customers_button.click();
    }
    public boolean searchCustomerByEmail(String email)
    {
        boolean flag = false;
        for(int i=1;i<=(tableRows.size());i++)
        {
            String EmailIDtext=Table.findElement(By.xpath(
                    "//table[@id='customers-grid']//tbody/tr/td[2]")).getText();
            System.out.println(EmailIDtext);
            if(email.equals(EmailIDtext))
            {
                flag=true;
            }
        }
        return  flag;
    }

    public boolean searchCustomerByName(String name)
    {
        boolean flag=false;
        System.out.println("====="+tableRows.size());
        for(int i=1;i<=(tableRows.size());i++)
        {
            String textName= Table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr/td[3]"))
                    .getText();
            String textNames[]=textName.split(" ");

            System.out.println(textName);

            if(textNames[0].equals("Virat") && textNames[1].equals("Kohli"))
            {
                flag=true;
            }
        }
        return flag;

    }




}


