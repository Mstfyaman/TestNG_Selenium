package com.krafttechnologie.tests.day14_Properties_Singleton;

import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {

    // 18.11.2022
    // Class Task
    // go to url
    // enter username
    // enter password
    // click login button
    //

    @Test
    public void test1() {

        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.id("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.id("yourPassword")).sendKeys(ConfigurationReader.get("password"));

        WebElement login = driver.findElement(By.xpath("//button[@class=\"btn btn-primary w-100\"]"));
        login.click();


    }




}
