package demo.webdriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidDriverInstance {

  public static AndroidDriver<AndroidElement> androidDriver;
  public static String userName = "hendriantomy1";
  public static String accessKey = "MTHxpb2rRxpzyRpkLmnJ";

  public static void initialize() {
    String appiumUrl = "http://127.0.0.1:4723/wd/hub/";
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("platformName", "Android");
    caps.setCapability("platformVersion", "8.1.0");
    caps.setCapability("deviceName", "device");
    caps.setCapability("udid", "emulator-5554");
    caps.setCapability("app",
        System.getProperty("user.dir") + File.separator + "APP" + File.separator + "TodoApp.apk");
    caps.setCapability("automationName", "UiAutomator2");
    try {
      androidDriver = new AndroidDriver<>(new URL(appiumUrl), caps);
      androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  public static void quit() {
    androidDriver.quit();
  }

}
