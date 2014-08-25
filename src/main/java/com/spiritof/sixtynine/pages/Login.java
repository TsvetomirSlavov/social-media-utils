package com.spiritof.sixtynine.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by badiere.eric on 8/23/14.
 */
public class Login {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public Login(WebDriver webDriver, WebDriverWait webDriverWait){
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      //  String value = webDriver.findElement(By.name("title")).getText();
        if (!webDriver.getTitle().equals("Log in | Tumblr")){

            throw new IllegalStateException("This is not the login page!");

        }
    }

    public Login typeUserEmail(String userEmail){
        webDriver.findElement(By.id("signup_email")).sendKeys(userEmail);
        return this;
    }

    public Login typeUserPassword(String userPassword){
        webDriver.findElement(By.id("signup_password")).sendKeys(userPassword);
        return this;
    }

    public TumblrPage submitLogin(){
        webDriver.findElement(By.id("signup_forms_submit")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("post_avatar")));
        return new TumblrPage(webDriver, webDriverWait);
    }
}
