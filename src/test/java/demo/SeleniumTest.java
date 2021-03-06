package demo;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

  @Test
  public void searchOnWikipedia() throws InterruptedException {
    ChromeOptions options = new ChromeOptions();
    //set chromeOptions. You can check here:
    // https://peter.sh/experiments/chromium-command-line-switches/
    options.addArguments("--incognito", "--start-maximized");
    //set desired capabilities
    options.setCapability(CapabilityType.PLATFORM_NAME, Platform.MAC);
    options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
    //initialize the webdriver
    WebDriver driver = new ChromeDriver(options);
    //set implicit wait
    driver.manage().timeouts()
        .implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    //open the new tab and go to wikipedia.com
    driver.get("https://www.wikipedia.org/");
    //finding elements
    WebElement inputSearch = driver.findElement(By.id("searchInput"));
    inputSearch.sendKeys("apple");
    WebElement buttonSearch = driver.findElement(By.xpath("//button[@type = 'submit']"));
    buttonSearch.click();

    //check the result
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement titleArticle = wait
        .until(ExpectedConditions.presenceOfElementLocated(By.id("firstHeading")));
//    WebElement titleArticle = driver.findElement(By.id("firstHeading"));
    String title = titleArticle.getText();
    //quit driver
    Thread.sleep(5000);
    driver.quit();
  }
}
