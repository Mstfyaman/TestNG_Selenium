package com.krafttechnologie.tests.day16_POM2;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTests extends TestBase {

    LoginPages loginPages = new LoginPages();

    DashboardPage dashboardPage = new DashboardPage();

    @Test
    public void navigateToTabAndModule() throws InterruptedException {

        loginPages.loginUser();
        dashboardPage.navigateToModule("Components","Charts");

        String actualSubTitle = dashboardPage.subTitle("Charts");

        Assert.assertEquals(actualSubTitle,"Charts");

        Thread.sleep(2000);

    }

    @Test
    public void  getUser(){

        loginPages.loginUser();
        String actualUser = dashboardPage.UsersNames("Jhon Nash");

        String exceptedUser = "Jhon Nash";
        Assert.assertEquals(actualUser,exceptedUser);
    }

    @Test
    public void myProfile(){
        loginPages.loginUser();
        dashboardPage.myProfile.click();

        BrowserUtils.waitFor(3000);
    }

    @Test
    public void aaFmTitle() {
        loginPages.loginUser();
        System.out.println("Title = " + dashboardPage.aFmTitle.getText());
    }

    @Test
    public void copyRight(){
        loginPages.loginUser();
        System.out.println("dashboardPage.copyright.getText() = " + dashboardPage.copyright.getText());
    }




}
