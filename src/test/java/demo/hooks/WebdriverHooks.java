package demo.hooks;

import demo.webdriver.WebdriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebdriverHooks {


  @Before
  public void initializeWebdriver() {
    WebdriverInstance.initialize();
  }

  @After
  public void quitWebdriver() {
    WebdriverInstance.quit();
  }

}
