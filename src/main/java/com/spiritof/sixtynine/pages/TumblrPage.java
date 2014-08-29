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

    public void clickFollowers(){
        List<WebElement> postContainers  = webDriver.findElements(By.cssSelector("li[class='post_container']"));
        for (WebElement postContainer : postContainers){
            //Must handle no div element.  It's legit.
            WebElement div = null;
            try {
                div = postContainer.findElement(By.cssSelector("div"));
                System.out.println("tumblr blog name: " + div.getAttribute("data-tumblelog-name"));
            }
            catch(NoSuchElementException nsee){
                continue;
            }
           // ((Locatable)div).g
            WebElement span = div.findElement(By.className("note_link_current"));
            span.click();
            WebElement postNotes = div.findElement(By.className("post_notes"));
            WebElement notes = postNotes.findElement(By.className("notes"));
            List<WebElement> follows = notes.findElements(By.className("follow"));
            List<WebElement> links = notes.findElements(By.tagName("li"));
            Notes notesDetail = new Notes(webDriver, webDriverWait, follows);
            // cheap scroll
            notesDetail.click();
            List<WebElement> followsUpdated = notes.findElements(By.className("follow"));
            while (followsUpdated.size() > follows.size()){
                Notes notesDetail2 = new Notes(webDriver, webDriverWait, followsUpdated);
                notesDetail2.click();
                follows = followsUpdated;
                followsUpdated = notes.findElements(By.className("follow"));
            }
        }

    }

}
