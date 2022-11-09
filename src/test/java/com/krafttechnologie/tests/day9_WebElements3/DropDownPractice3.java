package com.krafttechnologie.tests.day9_WebElements3;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownPractice3 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }


    @Test
    public void test() throws InterruptedException {

/*
    1. go to http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
    2. Radio Button  kutusundaki elementlerin sayisini bul ve tum elementleri yazdir
    3. Blue elementini sec

        */

        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

        List<WebElement> Options=driver.findElements(By.xpath("//input[@type='radio'] [@name='color']"));
        System.out.println("Options.size() = " + Options.size());
        Options.get(2).click();
        Thread.sleep(2000);

        for (WebElement Optionss: Options){
            System.out.println("button.getText() = " + Optionss.getAttribute("value"));  // yazdırdık
        }

        WebElement blue = driver.findElement(By.xpath("//input[@value='blue']"));
        blue.click();


    }


 }









