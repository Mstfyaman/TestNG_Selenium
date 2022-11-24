package com.krafttechnologie.tests.day14_Properties_Singleton;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPages loginPages = new LoginPages();
    DashboardPage dashboardPage = new DashboardPage();


    @Test
    public void openBrowserUsingConfigurationReader() {



        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.xpath("//input[@name='password']"))
                .sendKeys(ConfigurationReader.get("password")+ Keys.ENTER);
    }


    @Test
    public void loginWithMethod(){  // 22.11.2022

        loginPages.loginUser();

        String actualTitle= dashboardPage.DashboardPageTitle("Dashboard");
        String exceptedTitle = "Dashboard";
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals(actualTitle,exceptedTitle);
    }





}
