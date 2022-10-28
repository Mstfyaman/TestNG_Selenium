package com.krafttechnologie.tests.day1_Automationİntro_FrameWorkSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {

    public static void main(String[] args) {
        /*
            1. pomxml e yüklediğimiz webDriver manager kutuphanesinden chrome u hazir hale getirmesini isteyeceğiz
            2. WebDriver classından driver i hazır hale getirmesini isteyecegiz
            3. Driver a testini yapacağımız web sayfasina bizi geötürmesini isteyeceğiz
         */


//        WebDriverManager.firefoxdriver().setup();   // bu FireFox browser. için bana bende şu an yüklü değil.
//        WebDriver driver = new FirefoxDriver();

        WebDriverManager.chromedriver().setup();  //  1.

        WebDriver driver=new ChromeDriver();  //  2.

        driver.get("https://www.krafttechnologie.com/");  //  3.
        driver.manage().window().maximize();  // // bu sayfayı açtıktan sonra ekranı kaplayacak kadar büyüt.

        System.out.println("driver.getTitle() = " + driver.getTitle()); // gittiğimiz sayfanın başlığını yazdırır.
                //   driver.getTitle() = Kraft Technologie | Yazılım ve Bilişim Eğitimleri  Uzaktan Canlı Eğitim

        String exceptedTitle="Kraft Technologie | Yazılım ve Bilişim Eğitimleri – Uzaktan Canlı Eğitim";  // elde etmek istediğimiz başlık.

        String actualTitle=driver.getTitle();

        if (actualTitle.equals(exceptedTitle)){   // alınan başlık sitedeki ile aynı mı diye sorduk.
            System.out.println("Baslik beklendigi gibi geldi.Dogrulama gecti");
        }else {
            System.out.println("Baslik beklendigi gibi GELMEDI. Dogrulama GECMEDI.");
        }





    }
}
