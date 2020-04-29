package demo.steps_definition;

import demo.pages.AddToDoPage;
import demo.pages.ToDoHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ToDoMVPStepDefinitions {

  ToDoHomePage toDoHomePage = new ToDoHomePage();
  AddToDoPage addToDoPage = new AddToDoPage();

  @Then("User see task {string} on to do list page")
  public void userSeeTaskOnToDoListPage(String taskName) {
    String actual = toDoHomePage.getTaskName();
    Assert.assertEquals(taskName, actual);
  }

  @Given("User is on to do list page")
  public void userIsOnToDoListPage() {
    boolean result = toDoHomePage.isOnPage();
    Assert.assertTrue(result);
  }

  @When("User click button add on to do list page")
  public void userClickButtonAddOnToDoListPage() {
    toDoHomePage.clickButtonAdd();
  }

  @When("user input title {string} on add to do page")
  public void userInputTitleOnAddToDoPage(String title) {
    addToDoPage.inputTitle(title);
  }

  @When("User input description {string} on add to do page")
  public void userInputDescriptionOnAddToDoPage(String description) {
    addToDoPage.inputDescription(description);
  }

  @When("User click submit button on add to do page")
  public void userClickSubmitButtonOnAddToDoPage() {
    addToDoPage.clickSubmit();
  }
}
