package com.spiritof.sixtynine.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by badiere.eric on 8/24/14.
 */
public class Notes {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public Notes(WebDriver webDriver, WebDriverWait webDriverWait){
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

}
