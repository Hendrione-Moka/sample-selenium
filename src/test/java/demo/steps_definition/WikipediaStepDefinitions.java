package demo.steps_definition;

import demo.pages.api.pokeapi.PokemonController;
import demo.pages.wikipedia.ArticlePage;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;


public class WikipediaStepDefinitions {

  ArticlePage articlePage = new ArticlePage();
  PokemonController pokemonController = new PokemonController();

  @Then("User see pokemon data for {string} \\(pokemon number and name) are same with the poke API data")
  public void userSeePokemonDataForPokemonNumberAndNameAreSameWithThePokeAPIData(
      String pokemonName) {
    Response response = pokemonController.getPokemonData(pokemonName);
    int actualPokemonNumberApi = response.path("id");
    String actualPokemonNameApi = response.path("name");
    Assert.assertTrue(actualPokemonNameApi.equalsIgnoreCase(articlePage.getPokemonName()));
    Assert.assertEquals(Integer.parseInt(articlePage.getPokemonNumber()), actualPokemonNumberApi);
  }

}
