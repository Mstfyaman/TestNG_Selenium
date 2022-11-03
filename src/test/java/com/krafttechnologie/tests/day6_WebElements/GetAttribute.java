package com.krafttechnologie.tests.day6_WebElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {

        // two ways get text from web element
        // 1. getText() --> it will work %99 end it will return string
        // 2. getAttribute("AttributeName") --> second way of getting text espicially input box


        String email ="mike@gmail.com";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        WebElement emailBox = driver.findElement(By.xpath("//input[@name='email']"));
       // emailBox.sendKeys(email);

        Thread.sleep(2000);

        String  value = emailBox.getAttribute("class"); // class represent attribute name of email input box
        System.out.println("value = " + value);   // value = form-control



        Thread.sleep(2000);
        driver.close();

    }
}
