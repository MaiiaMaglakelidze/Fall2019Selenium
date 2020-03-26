package com.automation.tests.homework;

import com.automation.tests.day3.DriverFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestCases1to5 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createADriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.manage().window().maximize();
        WebElement regForm = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a"));
        regForm.click();
        BrowserUtils.wait(2);
    }

    @Test
    public void testCase1() {
        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        BrowserUtils.wait(2);

        String expected = "The date of birth is not valid";
        String actual = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]")).getText();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testCase2(){
        List<String> expectedLst = Arrays.asList("C++", "Java", "JavaScript");
        List<WebElement> actual = driver.findElements(By.className("col-sm-3 control-label"));
        for (WebElement each : actual) {
            System.out.println("each = " + each.getText());
        }
        for (int i = 0; i < actual.size(); i++) {
            Assert.assertEquals(actual.get(i).getText(), expectedLst.get(i));

    }
    }

    @Test
    public void testCase3(){
        driver.findElement(By.name("firstname")).sendKeys("a");
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]"));
        Assert.assertTrue(errorMsg.isDisplayed());

    }

@AfterMethod
    public void tearDown(){
        BrowserUtils.wait(3);
        driver.quit();
}
}
