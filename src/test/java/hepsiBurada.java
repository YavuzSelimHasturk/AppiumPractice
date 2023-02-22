import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class hepsiBurada {

    @Test
    public void setup() throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("platformVersion","11.0");
        caps.setCapability("appPackage","com.pozitron.hepsiburada");
        caps.setCapability("appActivity","com.hepsiburada.ui.startup.SplashActivity");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Thread.sleep(2000);
        driver.findElementById("com.pozitron.hepsiburada:id/etSearchBox").click();
        driver.findElementById("com.pozitron.hepsiburada:id/etSearchBox").sendKeys("iphone 14 ");
        driver.findElementByXPath("//android.widget.TextView[@text='iphone 14']").click();

        String actualUrun=driver.findElementByAccessibilityId("iphone 14 (10000) Ürün").getText();
        String expectedUrun = "iphone 14 (10.000+)";
        System.out.println(actualUrun);
        Assert.assertTrue(actualUrun.contains(expectedUrun));

        Thread.sleep(3000);

        driver.findElementByXPath("(//android.widget.Button[@content-desc='Sepete Ekle'])[1]").click();

        Thread.sleep(2000);

        String actualResult= driver.findElementByXPath("//*[@text='iPhone 14 Pro Max 128 GB']").getText();
        String expectedResult="iPhone";
        Assert.assertTrue(actualResult.contains(expectedResult));


    }



}
