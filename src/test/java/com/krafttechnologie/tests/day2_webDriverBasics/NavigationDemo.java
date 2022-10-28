package com.krafttechnologie.tests.day2_webDriverBasics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        // 1. go to google --> google a git
        // 2. go to facebook --> facabooka git
        // 3. back to goole --> goole geri dön

        WebDriverManager.chromedriver().setup();
        WebDriver driver2 = new ChromeDriver();  // polly kullandık.
        driver2.get("https://www.google.com");   // başına https  yazmak gerekli.  // 1.

        Thread.sleep(3000);
        // seleniumun senkronize problemini çözmek için wait 3 saniye bekletiyor.  throws exception u eklememiz gerekir.

        driver2.navigate().to("https://www.facebook.com");  // 2.
        // navigate to websitelerine erişim için kullandığımız diger bir selenium method dur

        Thread.sleep(3000);

        driver2.navigate().back(); // 3.
        // goes back to previous page --> önceki sayfaya dön

        Thread.sleep(3000);

        // goes bock to back --> ileri git
        driver2.navigate().forward();

        Thread.sleep(3000);

        // refresh to webpage --> sayfayı yenile
        driver2.navigate().refresh();



    }
}
