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
        WebElement follow = null;
        int cellCount = 0;
        for (WebElement link : followLinks) {
            try {
                follow = link.findElement(By.className("follow"));
                cellCount++;
                System.out.println("Log: cellCount: " + cellCount);
            } catch (NoSuchElementException nsee){
                cellCount++;
                System.out.println("Log: cellCount: " + cellCount);
                continue;
            } catch (StaleElementReferenceException sree){
                cellCount++;
                System.out.println("Log: cellCount: " + cellCount);
                continue;
            }

            if (follow.isDisplayed()) follow.click();
            System.out.println("DEBUG: CLick");
        }
    }

}
