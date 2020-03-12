package com.automation.tests.day6;

import com.automation.utilities.DriverFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByIndex(9); // -> 9 is index for DC
        BrowserUtils.wait(2);

        stateSelect.selectByIndex(stateSelect.getOptions().size()-1); // to select last option


        BrowserUtils.wait(2);
        driver.quit();
    }
}
