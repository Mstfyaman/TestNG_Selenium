package com.krafttechnologie.tests.day5_Css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithStartsWith {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.cssSelector("input[id^='two']"));
        searchBox.sendKeys("Cucumber SoftWare");

        WebElement searchButton = driver.findElement(By.cssSelector("input[id^='nav-sea']"));
        searchButton.click();

        Thread.sleep(3000);

        driver.close();



        // KALIP ;  tagname[atrribute^='value']

    }
}
