package com.krafttechnologie.tests.day5_Css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithId {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("CSS Selector ");

        WebElement searchButton =driver.findElement(By.cssSelector("#nav-search-submit-button"));
        searchButton.click();

        Thread.sleep(3000);





         // KALIP ; Syntax: id icin # isareti kullanilir. Locate edreken # isareti konulup
             //  value yazilir: #id





    }
}
