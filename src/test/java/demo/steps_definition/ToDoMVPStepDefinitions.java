package demo.steps_definition;

import demo.pages.todoapp.AddToDoPage;
import demo.pages.todoapp.StatisticsPage;
import demo.pages.todoapp.ToDoHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ToDoMVPStepDefinitions {

  ToDoHomePage toDoHomePage = new ToDoHomePage();
  AddToDoPage addToDoPage = new AddToDoPage();
  StatisticsPage statisticsPage = new StatisticsPage();

  @Then("User see task {string} on to do list page")
  public void userSeeTaskOnToDoListPage(String taskName) {
    boolean actual = toDoHomePage.checkTaskShown(taskName);
    Assert.assertTrue(actual);
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

  @When("User {string} task {string}")
  public void userTask(String key, String taskName) {
    toDoHomePage.checkUncheckTaskName(taskName, key);
  }

  @Then("User see task {string} is {string}")
  public void userSeeTaskIs(String taskName, String key) {
    boolean actual = toDoHomePage.getCheckedStatus(taskName);
    if (key.equalsIgnoreCase("checked")) {
      Assert.assertTrue(actual);
    } else if (key.equalsIgnoreCase("unchecked")) {
      Assert.assertFalse(actual);
    }
  }

  @When("User click filter button")
  public void userClickFilterButton() {
    toDoHomePage.clickFilterButton();
  }

  @When("User select filter {string}")
  public void userSelectFilter(String filterName) {
    toDoHomePage.selectFilter(filterName);
  }

  @When("User didn't see task {string} on to do list page")
  public void userDidnTSeeTaskOnToDoListPage(String taskName) {
    boolean actual = toDoHomePage.checkTaskShown(taskName);
    Assert.assertFalse(actual);
  }

  @When("User click more options button")
  public void userClickMoreOptionsButton() {
    toDoHomePage.clickMoreOptionsButton();
  }

  @When("User select more options menu {string}")
  public void userSelectMoreOptionsMenu(String menu) {
    toDoHomePage.selectMoreOptionsMenu(menu);
  }

  @When("User click hamburger button")
  public void userClickHamburgerButton() {
    toDoHomePage.clickHamburgerButton();
  }

  @When("User select menu {string}")
  public void userSelectMenu(String menuName) {
    toDoHomePage.selectMenu(menuName);
  }

  @Then("User see statistics Active {int} Complete {int}")
  public void userSeeStatisticsActiveComplete(int active, int complete) {
    String text = "Active tasks: %d\nCompleted tasks: %d";
    String expected = String.format(text, active, complete);
    String actual = statisticsPage.getStatisticData();
    Assert.assertEquals(expected, actual);
  }

  @Then("User see list label {string}")
  public void userSeeListLabel(String labelText) {
    String actual = toDoHomePage.getListTaskName();
    Assert.assertEquals(labelText, actual);
  }
}
