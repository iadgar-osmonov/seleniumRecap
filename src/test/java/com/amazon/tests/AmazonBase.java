package com.amazon.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.DriverHelper;

public class AmazonBase {
    WebDriver driver;
    @BeforeMethod
    public void setDriver(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("amazonURL"));

    }

}
