package com.cromagnon.pinterest;

import com.cromagnon.pinterest.pages.Login;
import com.cromagnon.pinterest.pages.PinterestPage;
import com.cromagnon.pinterest.pages.buttons.FollowButton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by badiere.eric on 8/7/14.
 */
public class PinterestFollowers{

        public static void main (String[] args) throws InterruptedException {

        WebDriver webDriver = new FirefoxDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10000);
        webDriver.manage().deleteAllCookies();

        webDriver.get("http://www.pinterst.com/login");

        Login login = new Login(webDriver, webDriverWait);

        login.typeUserEmail("ebadiere@gmail.com");
        login.typeUserPassword("Zosia2014");
        PinterestPage pinterestPage = login.submitLogin();
        pinterestPage.typeInSearchString("paleo");
        pinterestPage.submitSearch();
        pinterestPage.clickPinners();
        while (pinterestPage.getNumberOfFollowButtons() < 100){
            Thread.sleep(10000);
        }
        List<FollowButton> followButtons = pinterestPage.getFollowButtons();

        int dailyCount = 0;
        for (FollowButton followButton : followButtons){
               if (followButton.getState().equals("Follow")){
                   followButton.click();
                   // webDriver.(2000);
                   webDriverWait.until(ExpectedConditions.textToBePresentInElement(followButton.getWebElement(), "Unfollow"));
                   if (followButton.getState().equals("Unfollow")) dailyCount++;
                   if (dailyCount == 300)break;
               }

        }

        webDriver.close();
    }
}


