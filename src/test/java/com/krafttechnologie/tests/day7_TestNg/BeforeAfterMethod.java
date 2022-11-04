package com.krafttechnologie.tests.day7_TestNg;

import org.testng.annotations.*;

public class BeforeAfterMethod {         // her testten önce ayrı ayrı before sonra ayrı ayrı after çalışır

    @BeforeClass                         //  beforeClass  clasla beraber ilk ve son çalışır.
    public void setUpClass() {
        System.out.println("---- Before Class ----");
    }

    @Test
    public void test1() {
        System.out.println("First Test Case");
    }

    @Test    @Ignore                        // burda @Ignore ekleyerek methodu saf dışı bıraktık
    public void test2() {
        System.out.println("Second Test Method");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Before Method");
    }

  //  @Test                                //   yorum satırına alarakta ignore edebiliyoruz
    public void comment() {
        System.out.println("test Cse Comment");

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("After Method");
    }

    @Test
    public void test3() {
        System.out.println("Third Test Case");
    }

   @AfterClass
    public void afterClass() {
       System.out.println("---- After Class ----");
   }



}
