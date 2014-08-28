package com.spiritof.sixtynine.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by badiere.eric on 8/24/14.
 */
public class Notes {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;
    private List<WebElement> followLinks;

    public Notes(WebDriver webDriver, WebDriverWait webDriverWait, List<WebElement> followLinks){
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        this.followLinks = followLinks;
    }


    public void click(){
        int cellCount = 0;
        for (WebElement follow : followLinks) {
            if (follow.isDisplayed()) {
                cellCount++;
                follow.click();
                System.out.println("Log Click " + cellCount);
            }
        }
    }

}
