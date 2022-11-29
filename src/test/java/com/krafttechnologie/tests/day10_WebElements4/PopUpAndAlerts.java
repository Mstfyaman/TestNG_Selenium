package com.krafttechnologie.tests.day10_WebElements4;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("edge");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void PopUp() throws InterruptedException {

        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");

        // click the confirm button
        WebElement confirm = driver.findElement(By.xpath("(//span[text()='Confirm'])[1]"));
        confirm.click();
        Thread.sleep(1000);

        // click the yes button
        WebElement yes = driver.findElement(By.xpath("(//span[text()='Yes'])[2]"));
        yes.click();
        Thread.sleep(2000);

        // verify that confirm is accepted
        String expectedMessage ="You have accepted";
        WebElement actualMessage = driver.findElement(By.xpath("//p[text()='You have accepted']"));
        Assert.assertEquals(actualMessage.getText(),expectedMessage,"FAIL");
            // actualMessage burda WebElement olduğundan getText() ile string aldık.

    }

    @Test
    public void jsAlerts() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(5000);

        // click-Click For JS Alert
        WebElement jsForAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        jsForAlert.click();

        // e.g.:1  switch to JS alert pop up
        Alert alert = driver.switchTo().alert();
        //  alarmı inpect edemediğimizden böyle yapmak mecburiyetindeyiz ve böylece ortam değiştiriyoruz.
        Thread.sleep(1000);
        // click ok
        alert.accept();  // click eder.


        // e.g:2 click - Click For JS Confirm
        WebElement jsConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        jsConfirm.click();
        Thread.sleep(2000);
        alert.dismiss();  // clik  cancel    bu reddetme seçeneğini işaretler


        // e.g.:3 click - Click For Js Prompt
        WebElement jsPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        jsPrompt.click();
        Thread.sleep(2000);
        // send key to Js Prompt
        alert.sendKeys("KraftTech Batch 2 was here");
        Thread.sleep(4000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();  // kabul ettik

        // Task : verify all result above JS Alerts



    }








}
