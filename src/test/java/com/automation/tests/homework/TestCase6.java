package com.automation.tests.homework;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://www.tempmailaddress.com/");
        driver.manage().window().maximize();
    }

    @Test
        public void testCase6(){
        String email = driver.findElement(By.xpath("//span[@id=\"email\"]")).getText();
      //  BrowserUtils.wait(2);

        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[@href=\"/sign_up\"]")).click();
        driver.findElement(By.name("full_name")).sendKeys("Jon Smith");
        driver.findElement(By.name("email")).sendKeys(email);
        BrowserUtils.wait(2);

        driver.findElement(By.name("wooden_spoon")).click();
        WebElement signUpMessage = driver.findElement(By.xpath("//h3[@name=\"signup_message\"]"));
        Assert.assertTrue(signUpMessage.isDisplayed());

      //  BrowserUtils.wait(2);

        driver.navigate().to("https://www.tempmailaddress.com/");
        WebElement emailResponse = driver.findElement(By.xpath("//table//td[text()='do-not-reply@practice.cybertekschool.com']"));
       // BrowserUtils.wait(3);
        emailResponse.getText();
        Assert.assertTrue(emailResponse.isDisplayed());
        emailResponse.click();
        BrowserUtils.wait(2);

        Assert.assertTrue(driver.findElement(By.xpath("//span[@id=\"odesilatel\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@id=\"predmet\"]")).isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        com.cbt.utilities.BrowserUtils.wait(3);
        driver.quit();
    }

    }

