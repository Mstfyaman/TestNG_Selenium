package com.krafttechnologie.tests.day11_Waits;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitlyWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // 20 saniyelik bekleme süresi belirledik veyeteri kadar bekleyecek.
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
        driver.quit();
    }

    @Test
    public void test1() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start>button")).click();

        //*** How to wait explicitly ***

        // Create an explicity object wait

        WebDriverWait wait = new WebDriverWait(driver,15);
        // loading yüklenene kadar istenilen text i bulsada interaktif olmadığı için kabul edilmediğinden bu objeyi kullanıyoruz


        WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        wait.until(ExpectedConditions.visibilityOf(hello)); // hello gözükene kadar bekle dedik.
        // it will wait up to 15 second until hello element is visible

        System.out.println("hello.getText() = " + hello.getText());

        Assert.assertEquals(hello.getText(),"Hello World!");
    }

    @Test
    public void test2() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[text()='Enable']")).click();

       // driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Batch 2 was here");
            // burda wait olmadığından text i bulsa bile interactive olmadığından görmüyor. hata veriyor
            // o yüzden aşağıdaki wait objesi kullanıyoruz.


        WebDriverWait wait = new WebDriverWait(driver,10); // wait objemizi oluşturuyoruz

        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        // loading yüklenene kadar istenilen text i bulsada interaktif olmadığı için kabul edilmediğinden bu objeyi kullanıyoruz

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        // it will wait up to 10 second until hello element is visible

        inputBox.sendKeys("Batch 2 was here");

        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertEquals(message.getText(),"It's enabled!");

    }






}
