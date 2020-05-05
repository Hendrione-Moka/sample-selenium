package demo.hooks;

import demo.webdriver.WebdriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WebdriverHooks {


  @Before(value = "@Web")
  public void initializeWebdriver() {
    WebdriverInstance.initialize();
  }

  @After(value = "@Web")
  public void quitWebdriver(Scenario scenario) {
    if (scenario.isFailed()) {
      scenario
          .embed(((TakesScreenshot) WebdriverInstance.webdriver).getScreenshotAs(OutputType.BYTES),
              "image/png");
      scenario.write("Scenario Fail");
    }
    WebdriverInstance.quit();
  }

}
