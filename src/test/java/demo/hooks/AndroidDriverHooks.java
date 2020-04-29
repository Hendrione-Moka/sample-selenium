package demo.hooks;

import demo.webdriver.AndroidDriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class AndroidDriverHooks {

  @Before(value = "@Android")
  public void initializeWebdriver() {
    AndroidDriverInstance.initialize();
  }

  @After(value = "@Android")
  public void quitWebdriver() {
    AndroidDriverInstance.quit();
  }

}
