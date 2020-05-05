package demo.hooks;

import demo.webdriver.AndroidDriverInstance;
import demo.webdriver.WebdriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AndroidDriverHooks {

  @Before(value = "@Android")
  public void initializeWebdriver() {
    AndroidDriverInstance.initialize();
  }

  @After(value = "@Android")
  public void quitWebdriver(Scenario scenario) {
    if (scenario.isFailed()) {
      scenario
          .embed(((TakesScreenshot) AndroidDriverInstance.androidDriver)
                  .getScreenshotAs(OutputType.BYTES),
              "image/png");
      scenario.write("Scenario Fail");
    }
    AndroidDriverInstance.quit();
  }

}
