package com.automation.tests.day12;

import com.automation.tests.day3.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADriver("chrome");
    }

    @Test
    public void fluentWaitTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
        WebElement submitBtn = wait.until(driver -> driver.findElement(By.xpath("//button[text()='Submit']")));
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        submitBtn.click();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
