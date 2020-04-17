package project.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import project.functions.CommonFunctions;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverManager {

    static AppiumDriverLocalService appiumDriverLocalService = null;

    private static AndroidDriver driver;

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public AndroidDriver getDriver() {
        if (driver == null) {
            startService();
            createDriver();
        }
        return driver;
    }

    protected void startService() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingAnyFreePort();
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        AppiumDriverLocalService appiumDriverLocalService = builder.build();
        AndroidDriverManager.appiumDriverLocalService = appiumDriverLocalService;
        appiumDriverLocalService.start();
    }

    protected void createDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, CommonFunctions.getConfigValue("avd"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//        capabilities.setCapability("avd", CommonFunctions.getConfigValue("avd"));
        String applicationPath = System.getProperty("user.dir") + CommonFunctions.getConfigValue("android_app");
        capabilities.setCapability(MobileCapabilityType.APP, applicationPath);

        launchDriverWithStartedAppium(capabilities);
    }

    private void launchDriverWithStartedAppium(Capabilities capabilities) {
        try {
            driver = new AndroidDriver<MobileElement>(new URL(CommonFunctions.getConfigValue("appium_url")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
