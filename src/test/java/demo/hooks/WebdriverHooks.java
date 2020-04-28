package demo.hooks;

import demo.webdriver.WebdriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebdriverHooks {


  @Before(value = "@Web")
  public void initializeWebdriver() {
    WebdriverInstance.initialize();
  }

  @After(value = "@Web")
  public void quitWebdriver() {
    WebdriverInstance.quit();
  }

}
