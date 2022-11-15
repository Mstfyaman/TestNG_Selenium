package com.krafttechnologie.tests.day12_Actions_FileUpload_ISExecutor;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutor {

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
    public void clickWithJS() throws InterruptedException {

        // Selenium ile çözemediğimiz bazı sorunlarda javascript executer kullanarak çözebiliriz
        // Bu sorunlar neler olabilir? : clicking, sendkeys, scroll down or scroll up
        // javscriptexecutor bir interface olduğu için new kullanarak yeni bir obje oluşturuyoruz
        // bu nedenle driver i casting yaparak kullanıyoruz

        driver.get("https://the-internet.herokuapp.com/floating_menu");

        WebElement button = driver.findElement(By.linkText("Elemental Selenium"));

       JavascriptExecutor js = (JavascriptExecutor) driver;
       Thread.sleep(2000);
       js.executeScript("arguments[0].scrollIntoView(true)"+"arguments[0].click()",button);
       Thread.sleep(2000);




    }
}