package com.spiritof.sixtynine;

import com.spiritof.sixtynine.pages.Login;
import com.spiritof.sixtynine.pages.TumblrPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by badiere.eric on 8/23/14.
 */
public class TumblerFollowers {
    private static List<String> toSteal;

    public static void main (String[] args) throws InterruptedException, IOException {

        loadToSteal();

        WebDriver webDriver = new FirefoxDriver();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10000);
        // Keep the selenium IDE for now
       // webDriver.manage().deleteAllCookies();

        webDriver.get("https://www.tumblr.com/login");


        Login login = new Login(webDriver, webDriverWait);
        //login.typeUserEmail("estar6302@gmail.com");
        login.typeUserEmail(args[0]);
        //login.typeUserPassword("Zosia2014");
        login.typeUserPassword(args[1]);
        TumblrPage tumblrPage = login.submitLogin();
        tumblrPage.clickFollowers();
        System.out.println("DEBUG: Whooohoo");
    }


    private static void loadToSteal() throws IOException {

        toSteal = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader("./toSteal.txt"));
        String line = null;
        while ((line = reader.readLine()) != null) {
            toSteal.add(line);
        }
    }



}
