package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");
        WebDriver driver = BrowserFactory.createDriver("chrome");
        driver.get("https://google.com");
        driver.navigate().to("http://practice.cybertekschool.com/");
        String title1 = driver.getTitle();
        driver.navigate().back();
        driver.navigate().to("http://practice.cybertekschool.com/dropdown");
        String title2 = driver.getTitle();
        driver.navigate().back();
        driver.navigate().to("http://practice.cybertekschool.com/login");
        String title3 = driver.getTitle();
        StringUtility.verifyEquals(title1,title2);
        StringUtility.verifyEquals(title2,title3);
        StringUtility.verifyEquals(title1,title3);
        driver.quit();





    }
}
