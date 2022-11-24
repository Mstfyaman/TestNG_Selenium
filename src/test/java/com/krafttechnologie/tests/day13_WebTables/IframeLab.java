package com.krafttechnologie.tests.day13_WebTables;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeLab {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
        driver.quit();
    }

    @Test
    public void iframe_(){

        driver.get("https://www.krafttechexlab.com/components/iframe");

       // WebElement iframe = driver.findElement(By.tagName("iframe"));
           // iframe yi locate ederek swicthTo yada yazabilirdik.

        driver.switchTo().frame(0);

        WebElement button = driver.findElement(By.xpath("(//button[@type='button'])[4]"));
        button.click();

        driver.switchTo().defaultContent();

        WebElement text=driver.findElement(By.xpath("//h1[.='Iframe']"));
        System.out.println("text.getText() = " + text.getText());


    }



}
