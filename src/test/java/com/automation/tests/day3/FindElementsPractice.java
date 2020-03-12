package com.automation.tests.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementsPractice {
    public static void main(String[] args) throws InterruptedException {
//      we are writing same codes again and again
//      we will write a method and call it : DRY Principle
//      smth that support our code : utilities
//      under automation package
//      We created utilities package and DriverFactory class under automation package
//      we wrote reusable methods inside DriverFactory class named => createDriver
//      whenever we need to crate webDriver object
//      we will call our custom method
/*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
 */

        WebDriver driver = DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName = driver.findElement(By.name("full_name"));  // for name
        fullName.sendKeys("Mister Twister");
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.name("email")); // for email
        email.sendKeys("someemail@gmail.com");
        Thread.sleep(5000);

        WebElement signUp = driver.findElement(By.name("wooden_spoon")); // for submit button
        signUp.click();
        Thread.sleep(5000);

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement message = driver.findElement(By.className("subheader"));
        String actual = message.getText();
        if(expected.equals(actual)){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        driver.quit(); // to close all tabs



    }
}
