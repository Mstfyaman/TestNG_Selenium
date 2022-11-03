package com.krafttechnologie.tests.day6_WebElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTask {
    public static void main(String[] args) throws InterruptedException {

        /** Class Task
         *  go to the amazon webpage
         *  write "selenium" to search box
         *  verify that the result of the search
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        String key="Selenium";

        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys(key);

        WebElement searchButton = driver.findElement(By.cssSelector("#nav-search-submit-button"));
        searchButton.click();

        String expected = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        System.out.println("expected = " + expected);

        if (expected.contains(key)){
            System.out.println("PASS");
        }else {
            System.out.println("WRONG");
        }


        Thread.sleep(2000);
        driver.close();





    }
}
