package com.krafttechnologie.tests.day10_WebElements4;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

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
    public void twoWindows() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick= driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        Thread.sleep(2000);

        String titleAfterClick =driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);

        // yeni pencere açıldıktan sonra selenium eski sayfada kaldı, yeni sayfaya geçmedi
        // yeni sayfaya geçmesi için bizden talimat istiyor

        String currentTab = driver.getWindowHandle();  // getWindowHandle current( the internet) pencereyin id sini getirir.
        System.out.println("currentTab = " + currentTab);
        // currentTab = CDwindow-3A5F2458A32BCD23EAE0400C7A91E04F


        //  bu bütün pencelererin id lerini tutar. Set olmasının sebebi id lerin benzersiz olmasını istemesi

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) { // go and check one by one
            if (!tab.equals(currentTab)){
                driver.switchTo().window(tab);
            }
        }

        System.out.println("driver.getTitle() = " + driver.getTitle());

    }


    @Test
    public void multipleWindow() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");

        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());
        // current sayfanın id yazdırdık

        WebElement clickHere = driver.findElement(By.linkText("Click Here"));
        clickHere.click();
        Thread.sleep(2000);

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);    // tablar arası geçiş sağlar
            if (driver.getTitle().equals("New Window")){  // hangisine gideceğimizi belirler ve 82. satırdaki setten alır.
                break;
            }

        }

        System.out.println("after click = " + driver.getTitle());


    }



















}
