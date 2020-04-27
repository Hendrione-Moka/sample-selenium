package demo.pages;

import demo.webdriver.WebdriverInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage {

  public void openHomePage() {
    WebdriverInstance.webdriver.get("https://www.wikipedia.org/");
  }

  public void inputSearch(String keyword) {
    WebElement inputSearch = WebdriverInstance.webdriver.findElement(By.id("searchInput"));
    inputSearch.sendKeys("apple");
  }

  public void clickSearch() {
    WebElement buttonSearch = WebdriverInstance.webdriver
        .findElement(By.xpath("//button[@type = 'submit']"));
    buttonSearch.click();
  }


}
