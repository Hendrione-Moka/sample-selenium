package demo.pages.todoapp;

import demo.webdriver.AndroidDriverInstance;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;

public class AddToDoPage {

  public void inputTitle(String title) {
    AndroidElement inputTitle = AndroidDriverInstance.androidDriver
        .findElement(MobileBy.id("add_task_title"));
    inputTitle.sendKeys(title);
  }

  public void inputDescription(String description) {
    AndroidElement inputDescription = AndroidDriverInstance.androidDriver
        .findElement(MobileBy.id("add_task_description"));
    inputDescription.sendKeys(description);
  }

  public void clickSubmit() {
    AndroidElement buttonSubmit = AndroidDriverInstance.androidDriver
        .findElement(MobileBy.id("fab_edit_task_done"));
    buttonSubmit.click();
  }

}
