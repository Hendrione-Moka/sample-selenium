package demo.pages.google;

import demo.webdriver.WebdriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchPage {

  public void openPage() {
    WebdriverInstance.webdriver.get("https://www.google.com");
  }

  public void search(String keyword) {
    WebElement inputSearch = WebdriverInstance.webdriver
        .findElement(By.name("q"));
    inputSearch.sendKeys(keyword + Keys.ENTER);
  }

}
