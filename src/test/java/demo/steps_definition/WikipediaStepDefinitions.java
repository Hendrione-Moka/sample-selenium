package demo.steps_definition;

import demo.pages.ArticlePage;
import demo.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WikipediaStepDefinitions {

  private ArticlePage articlePage = new ArticlePage();
  private HomePage homePage = new HomePage();


  @Given("User open wikipedia homepage")
  public void userOpenWikipediaHomepage() {
    homePage.openHomePage();

  }

  @When("User input keyword {string} on wikipedia homepage")
  public void userInputKeywordOnWikipediaHomepage(String keyword) {
    homePage.inputSearch(keyword);
  }

  @When("User click button search on wikipedia homepage")
  public void userClickButtonSearchOnWikipediaHomepage() {
    homePage.clickSearch();
  }

  @Then("User see title {string} on wikipedia article page")
  public void userSeeTitlOnWikipediaArticlePage(String title) {
    String actual = articlePage.getTitle();
    Assert.assertEquals(title, actual);

  }

}
