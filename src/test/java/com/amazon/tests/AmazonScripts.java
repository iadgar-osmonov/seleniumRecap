package com.amazon.tests;

import com.amazon.pages.AmazonMainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonScripts extends AmazonBase{
    @Parameters("product")
    @Test
    public void validateMainPage(String product){
        AmazonMainPage mainPage=new AmazonMainPage(driver);
        mainPage.enterProduct(product);

    }
}
