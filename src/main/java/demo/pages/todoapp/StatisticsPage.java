package demo.pages.todoapp;

import demo.webdriver.AndroidDriverInstance;
import org.openqa.selenium.By;

public class StatisticsPage {

  public String getStatisticData() {
    return AndroidDriverInstance.androidDriver.findElement(By.id("statistics")).getText();
  }

}
