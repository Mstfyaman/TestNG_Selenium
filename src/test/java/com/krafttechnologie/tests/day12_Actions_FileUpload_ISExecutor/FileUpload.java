package com.krafttechnologie.tests.day12_Actions_FileUpload_ISExecutor;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUpload {

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
    public void upLoadFile() {

        // choole file elementini locate ediyoruz
        // sonrasinda sendKeys( file path ) yazıyoruz
        // File Path
        // windos için: shift tuşu+dosya üzerinde sağ click yapip copy asPath seçiyoruz
        // Maç için : sağ click + option key +selecyion copy


        driver.get("https://demoqa.com/upload-download");

        WebElement chooseFİle = driver.findElement(By.cssSelector("#uploadFile"));

        chooseFİle.sendKeys("C:\\Users\\User\\Desktop\\Day06-Project_Task.pdf");
        // shift tuşu + sağ click ve yol olarak kopyala yapacağız path i ni almak için


        WebElement testMsj = driver.findElement(By.id("uploadedFilePath"));;

        System.out.println("testMsj.getText() = " + testMsj.getText());
        String actual = testMsj.getText();
        String excepted = "C:\\fakepath\\Day06-Project_Task.pdf";
        Assert.assertEquals(actual,excepted);


    }
}
