package com.amazon.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonMainPage {
    public AmazonMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#twotabsearchtextbox")
    WebElement searchBar;

    public void enterProduct(String text){
        searchBar.sendKeys(text, Keys.ENTER);
    }

}
