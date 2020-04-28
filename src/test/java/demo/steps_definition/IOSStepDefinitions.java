package demo.steps_definition;

import demo.pages.DanaRegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class IOSStepDefinitions {

  private DanaRegisterPage registerPage = new DanaRegisterPage();

  @Given("User is on Dana register page")
  public void userIsOnDanaRegisterPage() {
    boolean result = registerPage.isOnPage();
    Assert.assertTrue(result);
  }

  @When("User input name {string}")
  public void userInputName(String name) {
    registerPage.inputName(name);
  }

  @And("User input email {string}")
  public void userInputEmail(String email) {
    registerPage.inputEmail(email);
  }

  @And("User input address {string}")
  public void userInputAddress(String address) {
    registerPage.inputAddress(address);
  }

  @And("User click button submit")
  public void userClickButtonSubmit() {
    registerPage.clickSubmit();
  }

  @Then("User see message")
  public void userSeeMessage(String message) {
    String actual = registerPage.getMessage();
    Assert.assertEquals(message, actual);
  }
}
