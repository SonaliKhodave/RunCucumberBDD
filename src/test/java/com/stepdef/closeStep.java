package com.stepdef;

import io.cucumber.java.en.Then;

public class closeStep extends BaseClass {

    @Then("user close the browser")
    public void user_close_the_browser() {
        driver.close();
//        driver.quit();
    }
}
