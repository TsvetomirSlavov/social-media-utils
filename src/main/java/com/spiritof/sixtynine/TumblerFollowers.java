package com.spiritof.sixtynine;

import com.spiritof.sixtynine.pages.Login;
import com.spiritof.sixtynine.pages.TumblrPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by badiere.eric on 8/23/14.
 */
public class TumblerFollowers {

    public static void main (String[] args) throws InterruptedException {

        WebDriver webDriver = new FirefoxDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10000);
        // Keep the selenium IDE for now
       // webDriver.manage().deleteAllCookies();

        webDriver.get("https://www.tumblr.com/login");


        Login login = new Login(webDriver, webDriverWait);
        login.typeUserEmail("estar6302@gmail.com");
        login.typeUserPassword("Zosia2014");
        TumblrPage tumblrPage = login.submitLogin();
        tumblrPage.clickFollowers(args[0]);
        System.out.println("DEBUG: Whooohoo");
    }



}
