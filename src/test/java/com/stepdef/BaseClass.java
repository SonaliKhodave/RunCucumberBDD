package com.stepdef;

import com.pages.CustomerPageObject;
import com.pages.LoginPageObject;
import com.pages.SearchCustomerPageObj;
import com.utils.readConfig;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class BaseClass {

   public LoginPageObject loginPageObj;
   public CustomerPageObject custPgObj;
   public SearchCustomerPageObj srchPgObj;
    public static Logger log;
    public readConfig readcnfg;
  public static   WebDriver driver;

    public static String RandomString()
    {
        String generateString = RandomStringUtils.randomAlphabetic(5);
        return generateString;
    }

}
