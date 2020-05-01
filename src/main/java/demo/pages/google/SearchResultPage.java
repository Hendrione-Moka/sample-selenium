package demo.pages.google;

import demo.webdriver.WebdriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

  public void clickFirstSearchResult() {
    WebElement firstResult = WebdriverInstance.webdriver
        .findElement(By.xpath("(//h3)[1]"));
    firstResult.click();
  }

}
