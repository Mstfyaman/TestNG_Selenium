package com.krafttechnologie.tests.day9_WebElements3;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithSelect {

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
        driver.get("https://demoqa.com/select-menu");

        // 1. dropdown u diğer elementler gibi locate ediyoruz

        WebElement dropDownElement = driver.findElement(By.cssSelector("#oldSelectMenu"));

        // 2. Element i constructor gibi atayarak selenium classındaki select ten bir object oluşturuyoruz

        Select selectMenu = new Select(dropDownElement);

        // 3. seçilen ilk elementi test edelim.
        String expectedOption="Red";
        String actualOption=selectMenu.getFirstSelectedOption().getText();  // seçilen ilk elemanı getir dedik.
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");

//---------=============================================================

        // DropDown dan diğer optionları nasıl getiririz?
        // 1. select visibleText kullanacağız

        Thread.sleep(2000);
        selectMenu.selectByVisibleText("Black");  // çağırmak istediğimiz elementin textini yazıyoruz

        expectedOption="Black";
        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");

  //======================================================================

        // 2. Index kullanarak cagiriyoruz
        Thread.sleep(2000);
        selectMenu.selectByIndex(6);   // kaçıncı indexteyse onu yazdık, index numarası 0 dan başlar.

        expectedOption="White";
        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");


  //======================================================================

        // 3. valueden yapıyoruz
        Thread.sleep(2000);
        selectMenu.selectByValue("3");

        expectedOption="Yellow";
        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");



    }

}
