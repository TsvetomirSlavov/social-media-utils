package com.cromagnon.pinterest.pages.buttons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by badiere.eric on 8/11/14.
 */
public class FollowButton {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private WebElement followButton;

    public FollowButton(WebDriver webDriver, WebDriverWait webDriverWait, WebElement webElement){
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        this.followButton = webElement;
        if (!followButton.getText().equals("Follow")){
            if (!followButton.getText().equals(("Unfollow"))){
                throw new IllegalStateException("This is not a follow button!");
            }
        }
    }

    public String getState(){
        System.out.println("Text: " + followButton.getText());
        return followButton.getText();
    }

    public FollowButton click(){
        followButton.click();
        return this;
    }

    public WebElement getWebElement(){
        return followButton;
    }

}
