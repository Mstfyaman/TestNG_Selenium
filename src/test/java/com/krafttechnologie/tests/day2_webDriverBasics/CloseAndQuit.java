package com.krafttechnologie.tests.day2_webDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        // close : sadece belli bir sekmeyi kapatır.
        // quite : tüm sekmeleri kapatır.


        WebDriverManager.chromedriver().setup();
        WebDriver driver4 = new ChromeDriver();
        driver4.get("https://www.krafttechnologie.com/");

        Thread.sleep(2000);

        driver4.close();  // close current tab --> geçerli sekmeyi kapattık, diğer sekmeler açık kalır.


        // kapatma işlemi yaptıktan sonra tekrar driver4=new chtormeDriver();  koymamız gerekir. aksi takdirde kod kapatmadan sonra çalışmaz.
        driver4 = new ChromeDriver();


        // go to https://www.facebook.com web adress git.
        driver4.get("https://www.facebook.com");

        Thread.sleep(3000);

        driver4.quit();  // close all tab --> bütün tabları ( browser ) kapatır.



    }
}
