package demo.pages;

import demo.webdriver.AndroidDriverInstance;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToDoHomePage {

  public void clickButtonAdd() {
    AndroidElement buttonAdd = AndroidDriverInstance.androidDriver
        .findElement(By.id("fab_add_task"));
    buttonAdd.click();
  }

  public boolean isOnPage() {
    WebDriverWait wait = new WebDriverWait(AndroidDriverInstance.androidDriver, 15);
    return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fab_add_task")))
        .isDisplayed();
  }

  public String getTaskName() {
    AndroidElement labelTask = AndroidDriverInstance.androidDriver.findElement(By.id("title"));
    return labelTask.getText();
  }


}
