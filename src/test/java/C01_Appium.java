import Utils.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class C01_Appium {

    @Test
    public void app() throws MalformedURLException, InterruptedException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("platformVersion","11.0");
        desiredCapabilities.setCapability("deviceName","realDevice");
        desiredCapabilities.setCapability("automationName","UiAutomator2");
        desiredCapabilities.setCapability("app","C:\\Users\\Yvz\\Desktop\\GITHUB REPOSTORY\\Appium\\src\\Apps\\Calc.apk");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http:localhost:4723/wd/hub"),desiredCapabilities);

        // 9 sayisini id kullanilarak tikladik
        driver.findElementById("com.google.android.calculator:id/digit_9").click();
        Thread.sleep(2000);
        // carpma isaretine bastik
        driver.findElementById("com.google.android.calculator:id/op_mul").click();
        Thread.sleep(2000);
        // 8 sayisini id kullanilarak tikladik
        driver.findElementById("com.google.android.calculator:id/digit_8").click();
        Thread.sleep(2000);
        // esittire tikladik
        driver.findElementById("com.google.android.calculator:id/eq").click();

        // islem sonucunu String olarak aldik ve integer a cevirdik
        String sonucEkran = driver.findElementById("com.google.android.calculator:id/result_final").getText();
        int sonuc = Integer.parseInt(sonucEkran);

        System.out.println(sonuc);

        // asssertion ile test ettik
        Assert.assertEquals(sonuc, 72);



    }


}
