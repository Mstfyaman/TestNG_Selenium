package com.krafttechnologie.tests.day3_Basic_Locators;

import com.github.javafaker.Faker;
import com.krafttechnologie.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        Faker faker = new Faker(); // faker classı içerisinde gerçek olmayan verileri üretecek classtır. iş yerlerinde kullandırmazlar


        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

       // driver.manage().window().maximize();  // ekranı büyütür

           WebElement inputUserName= driver.findElement(By.id("userName")); // id türünde password bul dedik.
           // kullanıcı adını gireceği yeri bulmasını sağladık-- id her zaman unique olmadı '#' ile

           // inputUserName.sendKeys("Ragnar LathBroth"); // kullanıcı adını girdik
                inputUserName.sendKeys(faker.name().firstName());  // sahte isim oluşturuyor

            Thread.sleep(2000);

            WebElement inputEmail = driver.findElement(By.id("userEmail")); // id türünde email girilecek yeri bulmasını sağladık
          //  inputEmail.sendKeys("blabla@gmail.com"); // e mail i böyle gir dedik
                inputEmail.sendKeys(faker.internet().emailAddress()); // sahte email adresi oluşturuyor

            Thread.sleep(2000);











        driver.close(); // pencereyi kapattık

    }
}
