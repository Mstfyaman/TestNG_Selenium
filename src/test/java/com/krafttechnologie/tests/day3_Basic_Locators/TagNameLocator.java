package com.krafttechnologie.tests.day3_Basic_Locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        // driver.get("https://www.krafttechexlab.com/login");

        driver.get("https://the-internet.herokuapp.com/inputs");

//        Thread.sleep(2000);
//
//        WebElement emailInputBox= driver.findElement(By.name("email"));
//        emailInputBox.sendKeys("mike@gmail.com");
//
//        WebElement passwordInputBox=driver.findElement(By.name("password"));
//        passwordInputBox.sendKeys("12345");
//
//        driver.findElement(By.cssSelector(".btn.btn-primary.w-100")).click();
//
//        Thread.sleep(2000);

         //------------------------bu class a burdan başladık yukarısı NameLocator ile aynı

        // verify   that you are on the dashboard page

      //  System.out.println("driver.findElement(By.tagName(\"h1\")).getText() = " + driver.findElement(By.tagName("h1")).getText());

        System.out.println("driver.findElement(By.tagName(\"h3\")).getText() = " + driver.findElement(By.tagName("h3")).getText());
        System.out.println("driver.findElement(By.tagName(\"p\")).getText() = " + driver.findElement(By.tagName("p")).getText());


        driver.close();

    }
}
