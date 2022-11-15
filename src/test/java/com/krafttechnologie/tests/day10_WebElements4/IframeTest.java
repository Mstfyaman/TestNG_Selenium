package com.krafttechnologie.tests.day10_WebElements4;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("edge");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
        driver.quit();
    }

    @Test
    public void iframe() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/iframe");

        // how to switch the frame
        // first way using NAME or ID

        driver.switchTo().frame("mce_0_ifr");   // frame yi değiştir dedik.

        WebElement textArea = driver.findElement(By.cssSelector("#tinymce"));
        textArea.clear();    // burası yazılı bir alandı orayı temizledik.
        Thread.sleep(2000);
        textArea.sendKeys("Batch 2 was here");


        // second way switchTo INDEX

        driver.switchTo().parentFrame();   // first we should go back to parent  / geri gelmemiz gerekir
        driver.switchTo().frame(0);
        textArea.clear();
        textArea.sendKeys("Batch 2 was here Two Times");


        driver.switchTo().parentFrame();
        // thirt wat using WEB ELEMENT
        WebElement iframe = driver.findElement(By.tagName("iframe"));  // burda web element olarak tagname kullandık
        driver.switchTo().frame(iframe);
        textArea.clear();
        textArea.sendKeys("This Is Thirt Way");

    }

    @Test
    public void nestedIframe() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // switch to middle frame and get MİDDLE text

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        System.out.println("driver.findElement(By.cssSelector(\"#content\")).getText() = " + driver.findElement(By.cssSelector("#content")).getText());

        // got to Right frame and get text

      //  driver.switchTo().parentFrame(); // selenium switch to parent
        driver.switchTo().defaultContent();  // grand parent e gider
        driver.switchTo().frame("frame-top"); // if we use defaultContent(), we should start first step

        driver.switchTo().frame(2);
        System.out.println("driver.findElement(By.tagName(\"Body\")).getText() = " + driver.findElement(By.tagName("Body")).getText());


        // go to bottom frame and get text

        driver.switchTo().defaultContent();
     // driver.switchTo().parentFrame().switchTo().parentFrame() // another way go to grandparent
        driver.switchTo().frame("frame-bottom");
        System.out.println("driver.findElement(By.tagName(\"Body\")).getText() = " + driver.findElement(By.tagName("Body")).getText());
            // yazdırırken tagname(burdaki body) kullanacaksın BOTTOM değil !!!!!!!!! dikkat et.


    }




}
