package com.krafttechnologie.tests.day3_Basic_Locators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextAndPartialLinkText {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");

        //--------------------LinkText------------------------
            //  Textin tamamını ile locate edebilir

        WebElement example1=driver.findElement(By.linkText("Example 1: Element on page that is hidden"));

        example1.click();

        String expectedText="Example 1: Element on page that is hidden";
        String accualText=driver.findElement(By.tagName("h4")).getText();  // aynı linkin başındaki tag' den yanı h4 ten karşılaştırma yaptık

        if (accualText.contains(expectedText)){
            System.out.println("PASS");
        }else {
            System.out.println("FAİLED");
        }

        Thread.sleep(2000);

        //---------------------PartialLinkText----------------------
            // Textin bir bölümü ile locat edebilir
        driver.navigate().back();  // bir sayfa geri döndük
        driver.findElement(By.partialLinkText("Example 2")).click();
        // partiallinktest te sadece linkliin başını aldık. aslında uzun hali (Example 2: Element rendered after the fact)  dir.
        // Examble 2  yerine sonundaki fact i yazdık daha sonra sadece 2 yazdık onuda kabul etti.  bu yazılan kelimeler unique olduğu için
        String expectedText2 ="Example 2: Element rendered after the fact";
        String accualText2 =driver.findElement(By.tagName("h4")).getText();


        if (accualText2.contains(expectedText2)){
            System.out.println("PASS");
        }else {
            System.out.println("FAİLED");
        }




        Thread.sleep(2000);

        driver.close();



    }
}
