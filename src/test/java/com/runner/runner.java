package com.runner;

//import io.cucumber.testng.CucumberOptions;

//import io.cucumber.testng.CucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".//Features/login.feature"},//".//Features/customer.feature"},
        glue = "com.stepdef",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        dryRun = false,
        tags = "@sanity", //scenario under regression  or  regression tag will get executed
        monochrome = true)

public class runner {
}
