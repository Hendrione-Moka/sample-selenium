package demo;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {


  @Test
  public void searchOnWikitionary() {
    ChromeOptions options = new ChromeOptions();
    //set chromeOptions. You can check here: https://peter.sh/experiments/chromium-command-line-switches/
    options.addArguments("--incognito", "--start-maximized");
    //instantiate webdriver
    WebDriver driver = new ChromeDriver();
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

}
