package com.cbt.tests;

import com.automation.tests.homework.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) {
        chrome();
        firefox();
        edge();


    }

    public static void chrome(){
        WebDriver driver= BrowserFactory.createDriver("chrome");
        driver.get("https://google.com");
        String firstTitle=driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String secondTitle=driver.getTitle();
        driver.navigate().back();
        String firstTitleSecond=driver.getTitle();
        StringUtility.verifyEquals(firstTitle,firstTitleSecond);
        driver.navigate().forward();
        String secondTitleSecond=driver.getTitle();
        StringUtility.verifyEquals(secondTitle,secondTitleSecond);
        driver.quit();

    }

    public static void firefox(){
        WebDriver driver= BrowserFactory.createDriver("firefox");
        driver.get("https://google.com");
        String firstTitle=driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String secondTitle=driver.getTitle();
        driver.navigate().back();
        String firstTitleSecond=driver.getTitle();
        StringUtility.verifyEquals(firstTitle,firstTitleSecond);
        driver.navigate().forward();
        String secondTitleSecond=driver.getTitle();
        StringUtility.verifyEquals(secondTitle,secondTitleSecond);
        driver.quit();
    }

    public static void edge(){
        WebDriver driver= BrowserFactory.createDriver("edge");
        driver.get("https://google.com");
        String firstTitle=driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String secondTitle=driver.getTitle();
        driver.navigate().back();
        String firstTitleSecond=driver.getTitle();
        StringUtility.verifyEquals(firstTitle,firstTitleSecond);
        driver.navigate().forward();
        String secondTitleSecond=driver.getTitle();
        StringUtility.verifyEquals(secondTitle,secondTitleSecond);
        driver.quit();
    }

}
