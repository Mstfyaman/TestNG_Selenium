package com.krafttechnologie.tests.day9_WebElements3;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithNoSelect {

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

        // Dropdown kutusunu locate ediyoruz
        WebElement dropDownMenu = driver.findElement(By.xpath("(//div[@class=' css-1wa3eu0-placeholder'])[1]"));
        System.out.println("dropDownMenu.getText() = " + dropDownMenu.getText());

        // kutudaki ilk elementi assert edelim
        String expectedOption= "Select Option";
        String actualOption= dropDownMenu.getText();


        Assert.assertEquals(actualOption,expectedOption,"FAIL");

        // Dropdown içerisinde Group 2 Option 1 seçeneğini çağıralım
        // burdaki sorun inspect yapmak istediğimizde menunun gizlenmesi
        // bunu aşmak için Event Listeners dan Blur un altındaki ögeler remove edilir


        dropDownMenu.click();
        WebElement group2Option1 = driver.findElement(By.cssSelector("#react-select-2-option-1-0"));
        group2Option1.click();

        // Group 2 Option 1 seçildikten sonra verify etmek için tekrar locate ediyoruz
        WebElement selectedOption = driver.findElement(By.xpath("//div[@class=' css-1uccc91-singleValue']"));
        System.out.println("selectedOption.getText() = " + selectedOption.getText());

        String expectedOption2 = "Group 2, option 1";
        String actualOption2= selectedOption.getText();

        Assert.assertEquals(expectedOption2,selectedOption.getText(),"FAIL");


    }

}
