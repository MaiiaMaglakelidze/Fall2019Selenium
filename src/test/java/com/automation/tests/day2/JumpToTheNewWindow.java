package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);
        // every window has some ID, this ID calls window handle
        // based on window handle , we can switch in between windows
        String windowHandle = driver.getWindowHandle();
        System.out.println("windowHandle = " + windowHandle);
        // set doesn't allow dublicates
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("windowHandles = " + windowHandles);
        for (String windowId:windowHandles) {
            // if its not old window, then switch
            if(!windowId.equals(windowHandle)){
                // to jump to new window
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("driver after switch = " + driver.getCurrentUrl());
        driver.close();
    }
 //=============================METHOD FOR 2 WINDOWS=======================================
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
      Set<String> windows = driver.getWindowHandles();
      for(String window:windows){
          driver.switchTo().window(window);
          if(driver.getTitle().equals(pageTitle)){
              break;
          }
      }
}
}
