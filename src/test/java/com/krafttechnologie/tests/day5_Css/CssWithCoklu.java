package com.krafttechnologie.tests.day5_Css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithCoklu {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com");

        WebElement searchBox= driver.findElement(By.cssSelector("input[class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b'][type=\"text\"]"));
            searchBox.sendKeys("DataBase");

        WebElement searchButton = driver.findElement(By.cssSelector("div[class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']"));
            searchButton.click();

            Thread.sleep(3000);
            driver.close();





        // KALIP ; tagname[attribute1='value] [attribute="value"]
                // iki tane olmazsa bir tanesi yeter.  18. satırda öyle yaptık
    }
}
