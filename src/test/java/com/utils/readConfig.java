package com.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {

    Properties properties;
    String path = "config.properties";
//constructor
    public  readConfig()
    {
        properties =new Properties();
        //to open the config.properties file in input mode and load the file
        try {
            FileInputStream fis = new FileInputStream(path);
            properties.load(fis);
           }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getBrowser()
    {

        String value=properties.getProperty("browser");
        System.out.println("-------"+value+"=============");
        if(value!=null)
            return value;
        else
            throw new RuntimeException("url not specified in config file.");

    }
}
