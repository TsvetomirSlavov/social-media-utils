package com.spiritof.sixtynine.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by badiere.eric on 8/23/14.
 */
public class TumblrPage {
    private final WebDriver webDriver;
    private final WebDriverWait webDriverWait;

    public TumblrPage(WebDriver webDriver, WebDriverWait webDriverWait){
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    public void clickFollowers(String linkText){
        List<WebElement> postContainers = webDriver.findElements(By.cssSelector("li[class='post_container']"));
        System.out.println("DEBUG: number of caontainers: " + postContainers.size());
        for (WebElement postContainer : postContainers){
            //Must handle no div element.  It's legit.
            WebElement div = null;
            try {
                div = postContainer.findElement(By.cssSelector("div"));
                System.out.println("DEBUG: name: " + div.getAttribute("data-tumblelog-name"));
            }
            catch(NoSuchElementException nsee){
                    continue;

            }
            if (linkText.equals(div.getAttribute("data-tumblelog-name"))){
                System.out.println("DEBUG: FOund it");
                WebElement span = div.findElement(By.className("note_link_current"));
                System.out.println("DEBUG: span: ");
                span.click();
                List<WebElement> follows = span.findElements(By.cssSelector("li[class='follow']"));
                for (WebElement follow : follows){
                    follow.click();
                }

            }
        }

    }

}
