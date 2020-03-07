package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args) {
        List<String> urls = Arrays.asList("https://lulugandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com," +
                        "https://westelm.com/");
        WebDriver driver = BrowserFactory.createDriver("chrome");
        driver.get("https://google.com");
        driver.navigate().to("https://lulugandgeorgia.com");

    }
}
