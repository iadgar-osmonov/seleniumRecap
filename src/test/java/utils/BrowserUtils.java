package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void selectBy(WebElement webElement, String value, String methodName) {
        Select select = new Select(webElement);
        switch (methodName) {
            case "visibleText":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available,please use visibleText, Value or Index");
        }

    }

    public static List<WebElement> getAllOptionsSelect(WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        return options;
    }

    public static String getText(WebElement element) {

        return element.getText().trim();

    }

    public static String getTitle(WebDriver driver) {
        return driver.getTitle();

    }

    public static void switchDriverByID(WebDriver driver, String currentPageID) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String id : windowHandles) {
            driver.switchTo().window(id);
        }
    }


    public static void getScreenshot(WebDriver driver) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String location = System.getProperty("user.dir") + "/src/main/screenshots/";

        File directory = new File(location);
        if (!directory.exists()) {
            directory.mkdir();

        }
        try {
            FileUtils.copyFile(file, new File(location + System.currentTimeMillis() + ".png"));


        } catch (IOException e) {
            throw new RuntimeException();
        }


    }

    public static String getTitleWithJS(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();
    }

    public static void clickWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click", element);

    }

    public static void scrollWithJS(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);

    }

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    public static void switchWindowByTitle(WebDriver driver, String title) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String id : windowHandles) {
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }

    }

    public static void acceptAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public static String getText(WebDriver driver) {
        Alert alert = driver.switchTo().alert();

        return alert.getText();
    }

    public static void dismissAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();

    }

    public static void sendKeysAlert(WebDriver driver, String keys) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(keys);
    }

    //these methods below are overloaded
    public static void switchToIFrame(WebDriver driver, String nameOrID) {
        driver.switchTo().frame(nameOrID);


    }

    public static void switchToIFrame(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);

    }

    public static void switchToParentIFrameOrDefault(WebDriver driver, String frame) {
        switch (frame) {
            case "parent":
                driver.switchTo().parentFrame();
            case "default":
                driver.switchTo().defaultContent();
        }

    }

    public static void scrollWithPoint(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point point = element.getLocation();
        int xCoordinate = point.getX();
        int yCoordinate = point.getY();

        js.executeScript("window.scrollTo(" + xCoordinate + "," + yCoordinate + ")");


    }
    public static void scrollByAmount(WebDriver driver,int x,int y){
        Actions actions=new Actions(driver);

        actions.scrollByAmount(x,y).build().perform();

    }
    public static void DragAndDrop(WebDriver driver,WebElement source,WebElement target){
        Actions actions=new Actions(driver);
        actions.dragAndDrop(source,target).build().perform();
    }

    public static void clickWithActions(WebDriver driver,WebElement element){
        Actions actions=new Actions(driver);
        actions.click(element).build().perform();
    }
    public static void hoverOver(WebDriver driver,WebElement target){
        Actions actions=new Actions(driver);
        actions.moveToElement(target).perform();

    }

}