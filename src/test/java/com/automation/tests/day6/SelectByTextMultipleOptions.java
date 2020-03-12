package com.automation.tests.day6;

import com.automation.utilities.DriverFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select languageSelect = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = languageSelect.isMultiple();
        System.out.println(isMultiple);
        languageSelect.selectByVisibleText("Java");
        languageSelect.selectByVisibleText("JavaScript");
        languageSelect.selectByVisibleText("Python");
        List<WebElement> selectLang = languageSelect.getAllSelectedOptions();
        for(WebElement selectedLanguages:selectLang){
            System.out.println(selectedLanguages.getText());
            languageSelect.deselectAll();
        }

        BrowserUtils.wait(3);
        driver.quit();


    }
}
