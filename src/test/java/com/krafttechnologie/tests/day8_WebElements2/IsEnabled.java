package com.krafttechnologie.tests.day8_WebElements2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IsEnabled {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() {
        driver.get("https://www.krafttechexlab.com/forms/checkbox");
        WebElement checkBox= driver.findElement(By.cssSelector("#gridCheck3"));

        System.out.println("checkBox.isEnabled() = " + checkBox.isEnabled());
        // etkin mi?  biz orda işlem yapabiliyor muyuz?

        Assert.assertFalse(checkBox.isEnabled(),"FAIL");
    }

    @Test
    public void test1() {
        driver.get("https://www.krafttechexlab.com/forms/checkbox");
        WebElement checkBox2= driver.findElement(By.xpath("//label[@for='gridCheck3']"));

        System.out.println("checkBox2.isEnabled() = " + checkBox2.isEnabled());
        // etkin mi?  biz orda işlem yapabiliyor muyuz?

        Assert.assertTrue(checkBox2.isEnabled(),"FAIL");
    }





}
