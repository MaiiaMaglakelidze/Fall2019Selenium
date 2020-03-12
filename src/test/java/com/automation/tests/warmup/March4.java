package com.automation.tests.warmup;

import com.automation.tests.day3.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class March4 {

    public static void main(String[] args) throws Exception {
    ebayTest();
    amazonTest();
//    wikiTest();


    }


 public static void ebayTest() throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.ebay.com");
            WebElement searchBar = driver.findElement(By.id("gh-ac"));
            searchBar.sendKeys("iPhone X");
            WebElement searchButton = driver.findElement(By.id("gh-btn"));
            searchButton.click();

            Thread.sleep(2000);
            WebElement searchresult = driver.findElement(By.tagName("h1"));
            System.out.println("searchresult on Ebay = " + searchresult.getText());
            driver.close();
        }

 public static void amazonTest() throws InterruptedException {
             WebDriverManager.chromedriver().setup();
             WebDriver driver = new ChromeDriver();
             driver.get("https://www.amazon.com");
             driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone X");
             Thread.sleep(3000);
             driver.findElement(By.className("nav-input")).click();
             WebElement searchResult = driver.findElement(By.className("sg-col-inner"));
             System.out.println("searchResult on Amazon = " + searchResult.getText());
             driver.close();

 }

    public static void wikiTest() throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        //enter search term `selenium webdriver` & click on search button
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.RETURN);
        Thread.sleep(3000);
        //click on search result `Selenium (software)`
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(2000);
        String link = driver.getCurrentUrl(); // to get link as a String
        //verify url ends with `Selenium_(software)`
        if(link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        Thread.sleep(4000);
        driver.quit();
    }
}




