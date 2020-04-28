package demo.webdriver;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IOSDriverInstance {

  public static IOSDriver<IOSElement> IOSDriver;

  public static void initialize() {
    String appiumUrl = "http://127.0.0.1:4723/wd/hub/";
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("platformName", "iOS");
    caps.setCapability("platformVersion", "13.4.1");
    caps.setCapability("deviceName", "iPhone 11 Pro Max");
    caps.setCapability("udid", "6D67A1F6-9A28-4A59-94EF-5BA4D984D8A3");
    caps.setCapability("app", "/Users/hendrione/Code/SampleSelenium/APP/TestingApp.app");
    caps.setCapability("automationName", "XCUITest");
    try {
      IOSDriver = new IOSDriver<>(new URL(appiumUrl), caps);
      IOSDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  public static void quit() {
    IOSDriver.quit();
  }

}
