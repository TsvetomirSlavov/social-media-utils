package com.cromagnon.pinterest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by badiere.eric on 8/9/14.
 */
public class PinterestPage {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public PinterestPage(WebDriver webDriver, WebDriverWait webDriverWait){
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;

        // Check that we're on the right page.
        if (!"Pinterest".equals(webDriver.getTitle())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the Pinterest page");
        }
    }

    public PinterestPage typeInSearchString(String searchString){

        WebElement inputForm = webDriver.findElement(By.name("search"));
        WebElement searchInputText = inputForm.findElement(By.xpath("//input[@placeholder='Search']"));
        searchInputText.sendKeys(searchString);

        return this;
    }

    public PinterestPage submitSearch(){
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        return this;
    }

    public PinterestPage clickPinners(){
        webDriver.findElement(By.linkText("Pinners")).click();
        return this;
    }
}
