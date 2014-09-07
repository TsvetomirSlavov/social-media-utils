package com.spiritof.sixtynine.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public void clickFollowers() throws InterruptedException {
        List<WebElement> postContainers  = webDriver.findElements(By.cssSelector("li[class='post_container']"));
        WebElement notes = null;
        for (WebElement postContainer : postContainers){
            try {
                WebElement div = postContainer.findElement(By.cssSelector("div"));
                System.out.println("tumblr blog name: " + div.getAttribute("data-tumblelog-name"));
                notes = getNotes(div);
            }
            catch(NoSuchElementException nsee){
                continue;
            }
            if (getFollows(notes)) continue;
            WebElement glassOverlay = webDriver.findElement(By.id("glass_overlay"));
            glassOverlay.click();
        }
    }

    private WebElement getNotes(WebElement div){
        //Must handle no div element.  It's legit.
        WebElement span = div.findElement(By.className("note_link_current"));
        if (span.isDisplayed()){
            span.click();
        }
        WebElement postNotes = div.findElement(By.className("post_notes"));
        return postNotes.findElement(By.className("notes"));
    }

    // change to a do while
    private boolean getFollows(WebElement notes) throws InterruptedException {
        List<WebElement> follows = null;
        List<WebElement> followsUpdated = null;
        do {
            try {
                follows = notes.findElements(By.className("follow"));
            } catch (StaleElementReferenceException sere) {
                System.out.println("Stale follows element, skipping...");
                return true;
            }
            Notes notesDetail = new Notes(webDriver, webDriverWait, follows);
            // cheap scroll
            notesDetail.click();
            webDriverWait.until(ExpectedConditions.elementToBeClickable(By.className("follow")));
            followsUpdated = notes.findElements(By.className("follow"));
        } while (followsUpdated.size() > follows.size());

        return false;
    }

}
