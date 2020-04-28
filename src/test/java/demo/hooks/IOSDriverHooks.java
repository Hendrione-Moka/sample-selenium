package demo.hooks;

import demo.webdriver.IOSDriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class IOSDriverHooks {

  @Before(value = "@iOS")
  public void initializeWebdriver() {
    IOSDriverInstance.initialize();
  }

  @After(value = "@iOS")
  public void quitWebdriver() {
    IOSDriverInstance.quit();
  }

}
