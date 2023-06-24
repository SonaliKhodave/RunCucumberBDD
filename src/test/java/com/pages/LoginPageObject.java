package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {





    WebDriver LocalDriver;

    public LoginPageObject(WebDriver RemoteDriver){
        LocalDriver= RemoteDriver;
        PageFactory.initElements(RemoteDriver,this);

    }

    @FindBy(id="Email")
    WebElement email;

    @FindBy(id="Password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement LoginButton;
    @FindBy(linkText = "Logout")
    WebElement LogOutButton;

    public void enterEmail(String emailAddress) throws InterruptedException {
        email.clear();
        Thread.sleep(2000);
        email.sendKeys(emailAddress);

    }
    public void EnterPassword(String pwd) throws InterruptedException {
        password.clear();
        Thread.sleep(2000);

        password.sendKeys(pwd);
    }
    public void clickOnLoginButton(){
        LoginButton.click();
    }
    public void clickOnLogOutButton(){
        LogOutButton.click();
    }
}
