package demo.pages;

import demo.webdriver.WebdriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {

  public String getTitle() {
    WebElement titleArticle = WebdriverInstance.webdriver.findElement(By.id("firstHeading"));
    return titleArticle.getText();
  }

}
