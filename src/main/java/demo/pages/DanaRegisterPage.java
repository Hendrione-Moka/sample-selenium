package demo.pages;

import demo.webdriver.IOSDriverInstance;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DanaRegisterPage {

  public void inputName(String name) {
    IOSElement inputName = IOSDriverInstance.IOSDriver
        .findElement(By.id("InputName"));
    inputName.sendKeys(name);
  }

  public boolean isOnPage() {
    WebDriverWait wait = new WebDriverWait(IOSDriverInstance.IOSDriver, 15);
    return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("InputEmail")))
        .isDisplayed();
  }

  public void inputEmail(String email) {
    IOSElement inputEmail = IOSDriverInstance.IOSDriver.findElement(MobileBy.id("InputEmail"));
    inputEmail.sendKeys(email);
  }

  public void inputAddress(String address) {
    IOSElement inputAddress = IOSDriverInstance.IOSDriver.findElement(MobileBy.id("InputAddress"));
    inputAddress.sendKeys(address);
  }

  public void clickSubmit() {
    IOSElement buttonSubmit = IOSDriverInstance.IOSDriver.findElement(By.id("ButtonSubmit"));
    buttonSubmit.click();
  }

  public String getMessage() {
    IOSElement labelMessage = IOSDriverInstance.IOSDriver.findElement(MobileBy.id("LabelData"));
    return labelMessage.getText();
  }

}
