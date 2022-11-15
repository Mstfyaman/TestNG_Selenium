package com.krafttechnologie.tests.day11_Waits;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class implicitlyWaitExample {

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
    public void test() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.cssSelector("#checkbox-example>button")).click();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  // 20 saniyelik bekleme süresi belirledik veyeteri kadar bekleyecek.

        WebElement message = driver.findElement(By.id("message")); // bekleme süresinden sonra çıkan mesajı aldık, verify ediyoruz
        Assert.assertEquals(message.getText(),"It's gone!");


        // istediğimiz alan daha yok, belli bir süre sonra exist olacak. o yüzden beklenmesi gerekiyor
        // beklenmese java exception atıyor. belli süre beklendikten sonra exist oluyor ve buluyoruz
        // bunun için implicitlyWait kullanıyoruz

    }
}
