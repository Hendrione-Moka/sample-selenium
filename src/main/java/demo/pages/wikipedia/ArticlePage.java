package demo.pages.wikipedia;

import demo.webdriver.WebdriverInstance;
import org.openqa.selenium.By;

public class ArticlePage {

  public String getPokemonNumber() {
    return WebdriverInstance.webdriver.findElement(By.xpath("//big//abbr")).getText();
  }

  public String getPokemonName() {
    return WebdriverInstance.webdriver.findElement(By.id("firstHeading")).getText();
  }

}
