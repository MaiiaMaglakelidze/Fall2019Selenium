package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    public static WebDriver createDriver(String driver) {
        String os=System.getProperty("os.name").toLowerCase();
        if((os.contains("windows") && driver.equalsIgnoreCase("safari") )
                || (os.contains("mac") && driver.equalsIgnoreCase("edge"))){
            System.out.println("Choosen web driver ( "+driver+ " ) not compatible with ( " + os+" )");
            return null;
        }
        switch (driver){
            case "chrome":{
                WebDriverManager.chromedriver().version("79.0").setup();
                return new ChromeDriver();
            }
            case "firefox":{
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case "edge":{
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            case "safari":{
                return new SafariDriver();
            }
            default:
                WebDriverManager.chromedriver().version("79.0").setup();
                return new ChromeDriver();
        }

    }
}