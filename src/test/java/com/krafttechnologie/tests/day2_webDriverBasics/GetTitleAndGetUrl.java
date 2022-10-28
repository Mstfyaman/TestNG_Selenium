package com.krafttechnologie.tests.day2_webDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {

        // Task open chrome and navigate to https://www.krafttechnologie.com/
        // get page title

        WebDriverManager.chromedriver().setup(); // chrome u hazır hale getir.
        WebDriver driver3 = new ChromeDriver();  // driver i etkinleiştir
        driver3.navigate().to("https://www.krafttechnologie.com/");  // bu adrese git
        System.out.println(driver3.getTitle()); // sayfa başlığını ver.


        // get the url from browser --> browserdan url alma
        String currentUrl = driver3.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        // get the source of page --> sayfanın kaynağını alma
        String pageSource= driver3.getPageSource();
        System.out.println("pageSource = " + pageSource);


    }
}
