package Utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {

    @Test
    public AndroidDriver<MobileElement> getAndroidDriver() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"RealDevice");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        caps.setCapability(MobileCapabilityType.APP,"C:\\Users\\Yvz\\IdeaProjects\\Appium\\src\\Apps\\Etsy.apk");

        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),caps);
        return driver;

    }

}
