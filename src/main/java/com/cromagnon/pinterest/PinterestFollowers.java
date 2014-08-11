package com.cromagnon.pinterest;

import com.cromagnon.pinterest.pages.Login;
import com.cromagnon.pinterest.pages.PinterestPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by badiere.eric on 8/7/14.
 */
public class PinterestFollowers{

    public static void main (String[] args){

        WebDriver webDriver = new FirefoxDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10000);
        webDriver.manage().deleteAllCookies();

        webDriver.get("http://www.pinterst.com/login");

        Login login = new Login(webDriver, webDriverWait);

        login.typeUserEmail("ebadiere@gmail.com");
        login.typeUserPassword("Zosia2014");
        PinterestPage pinterestPage = login.submitLogin();
        pinterestPage.typeInSearchString("Paleo recipes");
        pinterestPage.submitSearch();
        pinterestPage.clickPinners();

        System.out.println("DEBUG: WHOOHOO!");
    }
}


