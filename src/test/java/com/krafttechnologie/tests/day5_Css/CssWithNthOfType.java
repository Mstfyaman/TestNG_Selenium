package com.krafttechnologie.tests.day5_Css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithNthOfType {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com");

        WebElement text= driver.findElement(By.cssSelector("div[class='row']:nth-of-type(1)"));
        System.out.println("text.getText() = " + text.getText());


        Thread.sleep(3000);

        driver.close();



        // KALIP ;  tagname[attribute='value']:nth-of-type(index)    // çok fazla olduğunda 1. index e git dedik.
    }
}
