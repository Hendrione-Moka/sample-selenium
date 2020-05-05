package demo.pages.todoapp;

import demo.webdriver.AndroidDriverInstance;
import io.appium.java_client.android.AndroidElement;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToDoHomePage {

  public void clickButtonAdd() {
    AndroidElement buttonAdd = AndroidDriverInstance.androidDriver
        .findElement(By.id("fab_add_task"));
    buttonAdd.click();
  }

  public void checkUncheckTaskName(String taskName, String key) {
    if (key.equals("check") && !getCheckedStatus(taskName)) {
      getCheckElement(taskName).click();
    } else if (key.equals("uncheck") && getCheckedStatus(taskName)) {
      getCheckElement(taskName).click();
    }
  }

  public AndroidElement getCheckElement(String taskName) {
    Integer order = getTaskOrder(taskName);
    return AndroidDriverInstance.androidDriver.findElements(By.id("complete")).get(order);
  }

  public boolean checkTaskShown(String taskName) {
    Integer order = getTaskOrder(taskName);
    return order != null;
  }

  public Integer getTaskOrder(String taskName) {
    List<AndroidElement> tasks = AndroidDriverInstance.androidDriver
        .findElements(By.id("title"));
    for (int i = 0; i < tasks.size(); i++) {
      if (taskName.equalsIgnoreCase(tasks.get(i).getText())) {
        return i;
      }
    }
    return null;
  }

  public boolean getCheckedStatus(String taskName) {
    AndroidElement checked = getCheckElement(taskName);
    return Boolean.parseBoolean(checked.getAttribute("checked"));
  }

  public void clickHamburgerButton() {
    AndroidDriverInstance.androidDriver
        .findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
  }

  public void clickFilterButton() {
    AndroidDriverInstance.androidDriver.findElement(By.id("menu_filter")).click();
    waitForAnimation();
  }

  public void clickMoreOptionsButton() {
    AndroidDriverInstance.androidDriver
        .findElement(By.xpath("//android.widget.ImageView[@content-desc='More options']")).click();
    waitForAnimation();
  }

  public void selectFilter(String filterName) {
    selectDropdownMenu("title", "Active");
  }

  public void selectMoreOptionsMenu(String menuName) {
    selectDropdownMenu("title", menuName);
  }

  public void selectMenu(String menu) {
    selectDropdownMenu("design_menu_item_text", menu);
  }

  public void selectDropdownMenu(String locator, String name) {
    List<AndroidElement> filters = AndroidDriverInstance.androidDriver.findElements(By.id(locator));
    for (AndroidElement filter : filters) {
      if (filter.getText().equalsIgnoreCase(name)) {
        filter.click();
        break;
      }
    }
    waitForAnimation();
  }

  public void waitForAnimation() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public boolean isOnPage() {
    WebDriverWait wait = new WebDriverWait(AndroidDriverInstance.androidDriver, 15);
    return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fab_add_task")))
        .isDisplayed();
  }

  public String getListTaskName() {
    return AndroidDriverInstance.androidDriver.findElement(By.id("filteringLabel")).getText();
  }

}
