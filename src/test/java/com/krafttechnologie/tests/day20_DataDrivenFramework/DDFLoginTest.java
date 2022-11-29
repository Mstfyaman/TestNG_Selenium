package com.krafttechnologie.tests.day20_DataDrivenFramework;

import com.beust.ah.A;
import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDFLoginTest extends TestBase {


    @DataProvider
    public Object [][] userData(){

        // ExcelUtil class içerisinden bir object oluşturuyoruz
        // iki parametre giriyoruz; excel file path ve sayfa(sheet) adı

        ExcelUtil qaTeam3= new ExcelUtil("src/test/resources/LoginList.xlsx","QaTeam3");

        // exceldeki title bizim işimize yaramayacağı için onu haric bırakıyoruz ( your name, password gibi yerler )
        String [][] dataArray = qaTeam3.getDataArrayWithoutFirstRow();

        return dataArray;
    }


    @Test(dataProvider = "userData") // bu satırda üstteki methodu çağırdık. Method adı ve ya sonradan vereceğimiz isim ile
    public void loginTestWithDDF(String email, String password, String yourName){

        LoginPages loginPages= new LoginPages();
        DashboardPage dashboardPage = new DashboardPage();

        loginPages.loginWithParameter(email,password);
        String actualName = dashboardPage.getUserName();
        String exceptedName= yourName;

        Assert.assertEquals(actualName,exceptedName);


    }





}
