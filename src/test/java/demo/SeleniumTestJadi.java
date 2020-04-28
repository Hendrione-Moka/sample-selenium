package demo;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

public class SeleniumTestJadi {


  @Test
  public void searchOnWikitionary2() {
    ChromeOptions options = new ChromeOptions();
    //set chromeOptions. You can check here: https://peter.sh/experiments/chromium-command-line-switches/
    options.addArguments("--incognito", "--start-maximized");
    //set desired capabilities
    options.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
    options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
    //instantiate webdriver
    WebDriver driver = new ChromeDriver(options);
    //maximize kalo pake mac gbisa maximize
    driver.manage().window().maximize();
    //set implicit wait
    driver.manage().timeouts()
        .implicitlyWait(5, TimeUnit.SECONDS);
    //open website
    driver.get("https://www.wikipedia.org/");
    //finding elements
    WebElement inputSearch = driver.findElement(By.id("searchInput"));
    inputSearch.sendKeys("apple");
    WebElement buttonSearch = driver.findElement(By.xpath("//button[@type = 'submit']"));
    buttonSearch.click();

    //check the result
    WebElement titleArticle = driver.findElement(By.id("firstHeading"));
    String title = titleArticle.getText();
    Assert.assertEquals("Apple", title);
    driver.quit();


  }

  @Test
  public void searchOnWikitionary() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.wikipedia.org/");
  }

}
