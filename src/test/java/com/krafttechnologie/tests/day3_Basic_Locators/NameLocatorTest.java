package com.krafttechnologie.tests.day3_Basic_Locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        Thread.sleep(2000);

        WebElement emailİnputBox = driver.findElement(By.name("email"));  // name türünde email bul dedik.
        emailİnputBox.sendKeys("mike@gmail.com");

        // password 12345

        // 1. yol  bu işlemi yapmak için
        WebElement passWord = driver.findElement(By.name("password"));  // name türünde password bul dedik.
        passWord.sendKeys("12345");

  //       // 2. yol   Lazy way
  //      driver.findElement(By.name("password")).sendKeys("12345");   // 22. satırdakinin diğer yolur

        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".btn.btn-primary.w-100")).click();
        // logib tuşu ( button ) a basmak için. Daha sonra CSS dersinde anlatılacak.(noktaların olduğu yerler boşluktu.)



        Thread.sleep(2000);

        driver.close();







    }
}
