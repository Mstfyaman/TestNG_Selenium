package com.krafttechnologie.tests.day14_properties_Singleton;

import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void openBrowserUsingConfigurationReader() {



        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(ConfigurationReader.get("username"));
        driver.findElement(By.xpath("//input[@name='password']"))
                .sendKeys(ConfigurationReader.get("password")+ Keys.ENTER);

    }


}
