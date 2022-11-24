package com.krafttechnologie.tests.day18_ExtentReports;

import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUsernameTest extends TestBase {




    @Test
    public void wrongUsername(){
        LoginPages loginPages = new LoginPages();

        extentLogger=report.createTest("Wrong Username Test");

        BrowserUtils.waitFor(1);

        extentLogger.info("Enter wrong username");
        loginPages.userEmailInput_loc.sendKeys("yanlisName");

        extentLogger.info("Enter Correct password");
        loginPages.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("Click login button");
        loginPages.loginButton_loc.click();

        String actualMessage = loginPages.warningMessage_loc.getText();

        extentLogger.info("Verify that NOT log in");
        Assert.assertEquals(actualMessage,"Email address or password is incorrect. Please check");

        extentLogger.pass("PASSED");

    }

    @Test
    public void wrongPassword(){

        LoginPages loginPages = new LoginPages();

        extentLogger=report.createTest("Wrong Username Test");

        BrowserUtils.waitFor(1);

        extentLogger.info("Enter correct username");
        loginPages.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));

        extentLogger.info("Enter wrong password");
        loginPages.passwordInput_loc.sendKeys("yanlisPass");

        extentLogger.info("Click login button");
        loginPages.loginButton_loc.click();

        String actualMessage = loginPages.warningMessage_loc.getText();

        extentLogger.info("Verify that NOT log in");
       // Assert.assertEquals(actualMessage,"Email address or password is incorrect. Please check");
        Assert.assertEquals(actualMessage,"AAAEmail address or password is incorrect. Please checkAAA");

        extentLogger.pass("PASSED");

    }










}
