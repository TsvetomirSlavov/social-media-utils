package com.cromagnon.pinterest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by badiere.eric on 8/9/14.
 */
public class Login {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public Login(WebDriver webDriver, WebDriverWait webDriverWait){
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String value = webDriver.findElement(By.tagName("h1")).getText();
        if (!value.equals("Log In to Pinterest")){

            throw new IllegalStateException("This is not the login page!");

        }
    }

    public Login typeUserEmail(String userEmail){
        webDriver.findElement(By.className("email")).sendKeys(userEmail);
        return this;
    }

    public Login typeUserPassword(String userPassword){
        webDriver.findElement(By.name("password")).sendKeys(userPassword);
        return this;
    }

    public PinterestPage submitLogin(){
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
        return new PinterestPage(webDriver, webDriverWait);
    }
}
