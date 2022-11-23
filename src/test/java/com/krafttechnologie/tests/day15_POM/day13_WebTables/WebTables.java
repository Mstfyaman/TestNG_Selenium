package com.krafttechnologie.tests.day15_POM.day13_WebTables;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        // driver.close();
        driver.quit();
    }

    @Test
    public void printTable() {   // sitedeki tabloyu yazdırma - lacatede parentten locate etmek gerekiyor.

        WebElement table= driver.findElement(By.xpath("//table[@class='table table-light traversal-table']"));

        System.out.println("table.getText() = " + table.getText());

    }


    @Test
    public void printAllheaders() {

        WebElement headers = driver.findElement(By.xpath("//table[@class='table table-light traversal-table'] /thead"));
        System.out.println("headers.getText() = " + headers.getText());
        // tabloya ait başlıkları getirdi 3 tane = headers.getText() = # First Last

    }

    @Test
    public void printTableSize() {

        // th tag indeki elementlerin size ni alalım
        // önce list içerisine atacağız


   List<WebElement> rowSize = driver.findElements(By.xpath("//table[@class='table table-light traversal-table'] //th"));
        System.out.println("rowSize.size() = " + rowSize.size());
                // rowSize.size() = 6


        // sows( satirlarin size ni bulalım
        List<WebElement> trSize = driver.findElements(By.xpath("//table[@class='table table-light traversal-table'] //tr"));
        System.out.println("trSize.size() = " + trSize.size());


        // Headers ( basliklar ) haric rows ( satirların ) size ni blularım
        List<WebElement> allRowsWithoutHeaders = driver.findElements(By.xpath("//table[@class='table table-light traversal-table'] //tbody//tr"));
        System.out.println("allRowsWithoutHeaders = " + allRowsWithoutHeaders.size());

    }

    @Test
    public void getRow() {

        WebElement row2 = driver.findElement(By.xpath("//table[@class='table table-light traversal-table'] //tbody//tr[2]"));
        System.out.println("row2.getText() = " + row2.getText());

        // row2.getText() = 2 Jacob Jones
    }


    @Test
    public void getAllRows() throws InterruptedException {

        List <WebElement> allRows = driver.findElements(By.xpath("//table[@class='table table-light traversal-table'] //tbody//tr"));

        Thread.sleep(2000);

        for (int i=1; i<= allRows.size(); i++){
            WebElement row=driver.findElement(By.xpath("//table[@class='table table-light traversal-table'] //tbody//tr["+i+"]"));
            System.out.println("row.getText() = " + row.getText());
        }  // locatorun sonuna bak dinamik hale getirdik. !!!!

        // row.getText() = 1 Andy Otto
        //row.getText() = 2 Jacob Jones
        //row.getText() = 3 Larry Scott
    }

    @Test
    public void getAllCellsOneRow() {

    List <WebElement> allCells= driver.findElements(By.xpath("//table[@class='table table-light traversal-table'] //tbody//tr[2]/td"));

    for (WebElement element : allCells){
        System.out.println("element.getText() = " + element.getText());
    }
            // element.getText() = Jacob
            //element.getText() = Jones
    }

    @Test
    public void tek () {

        List<WebElement> thirdCells=driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[3]//td"));
        System.out.println("thirdCells.get(1).getText() = " + thirdCells.get(1).getText());

    }






}
