package com.krafttechnologie.tests.day4_Xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathWithStartsAndContainsWith {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://hepsiburada.com/");

        WebElement searchBox= driver.findElement(By.xpath("//input[starts-with(@class,'desktopOld')]"));
                    // .... ile başlayan
            searchBox.sendKeys("Selenium");   // .... yi yaz

        WebElement searchHbtn= driver.findElement(By.xpath("//div[contains(@class,'SearchBoxOld-cH')]"));
                  //  bir kısmını içeren
            searchHbtn.click();


         // KALIP ; //TagName[starts-with(@Attribute,‘value’)]

    }
}
