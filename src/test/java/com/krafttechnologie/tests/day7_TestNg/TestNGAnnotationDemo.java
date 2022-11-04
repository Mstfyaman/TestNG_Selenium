package com.krafttechnologie.tests.day7_TestNg;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationDemo {

    @BeforeMethod
    public void setUp() {
        System.out.println("Open Browser");
    }

    @Test
    public void test1() {
        System.out.println("First Test First Assertion");
        Assert.assertEquals("title","title");

        System.out.println("First Test Second Assertion");
        Assert.assertEquals("url ","url");
    }

    @Test
    public void test2() {
        System.out.println("Second Test Assertion");
        Assert.assertEquals("test2","test2");
    }

    @Test
    public void test3() {
        String exceptedTitle = "Kraft";
        String actualTitle = "Kraftech";
        Assert.assertTrue(actualTitle.contains(exceptedTitle),"verify title starting Kraft");
    }

    @Test
    public void test4() {
        // verify that email contains @ sign
        String email = "kraftTech@gmail.com";

//        if (email.contains("@")){
//            System.out.println("PASS");
//        }else {
//            System.out.println("FAİLED");
//        }

        Assert.assertTrue(email.contains("@"));  // bu durm ile yukarıdaki if durumu aynı şey. yöntemler farklı
            // true olunca method pass oluyor false olursa exception atıyor
    }

    @Test
    public void test5() {
        Assert.assertFalse(0>1,"verify that = is not greater than 1");
                // burda ters mantık var koşul false olduğu için asssert false çalıştıracak
    }

    @Test
    public void test6() {
        Assert.assertNotEquals("two","one");
                // burda ters mantık var koşul false olduğu için asssert false çalıştıracak
    }




    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }





}
