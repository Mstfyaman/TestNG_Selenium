package com.krafttechnologie.tests.day18_ExtentReports;

import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {    // 25.11.2022


    @Test
    public void loginTest1() {
        LoginPages loginPages = new LoginPages();

        extentLogger = report.createTest("Test1");
        loginPages.loginUser();
        System.out.println("1");
    }

    @Test
    public void loginTest2() {
        LoginPages loginPages = new LoginPages();

        extentLogger = report.createTest("Test2");
        loginPages.loginUser();
        System.out.println("2");
    }







}
