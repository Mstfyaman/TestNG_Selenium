package com.krafttechnologie.tests.day2_webDriverBasics;

import com.krafttechnologie.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {  // thread.sleep i exception yaptık.


        // day2 deki WebDriverFactory i çağırıyoruz. mainde


        WebDriver driver = WebDriverFactory.getDriver("chrome");
       // driver.get("https://www.krafttechnologie.com/");

       // Thread.sleep(3000);
      //  driver.close();

        /**
         * Task
         * go to http://www.krafttechexlab.com website
         * excepted title = Dashboard- Kraft Techex Lab - aFm
         * get title and verify that title expected title equal actual title
         */



        driver.get("http://www.krafttechexlab.com/");               // üstteki methodu kullanarak bunu calıştırdık.
        String exceptedTitle ="Dashboard- Kraft Techex Lab - aFm";
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("exceptedTitle = " + exceptedTitle);


        if (driver.getTitle()==exceptedTitle){
            System.out.println("title beklendigi GIBIDIR.");
        }else {
            System.out.println("title beklendigi gibi DEGIL");
        }






    }
}
