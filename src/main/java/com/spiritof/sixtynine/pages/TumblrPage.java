package com.spiritof.sixtynine.pages;

import org.openqa.selenium.*;
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
        List<WebElement> postContainers  = webDriver.findElements(By.cssSelector("li[class='post_container']"));
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
            WebElement span = div.findElement(By.className("note_link_current"));
            span.click();
            WebElement postNotes = div.findElement(By.className("post_notes"));
            WebElement notes = postNotes.findElement(By.className("notes"));
            List<WebElement> links = notes.findElements(By.tagName("li"));
            Notes notesDetail = new Notes(webDriver, webDriverWait, links);
            notesDetail.click();
        }

    }

}
