package com.krafttechnologie.tests.day9_WebElements3;

import com.krafttechnologie.utilities.WebDriverFactory;
import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownPractice2 {

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
    2. Checkboxes kutusundan sadece option 1  ve 4 u sec
    */

        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");


        List<WebElement> Options=driver.findElements(By.xpath("//input[@type='checkbox']"));
            // ortak bulduk ve hepsini içine attık

        Thread.sleep(2000);

        if ( ! Options.get(0).isSelected()){
            Options.get(0).click();
        }if ( ! Options.get(3).isSelected()){
            Options.get(3).click();
        }if (Options.get(2).isSelected()){
            Options.get(2).click();
        }









    }



}
