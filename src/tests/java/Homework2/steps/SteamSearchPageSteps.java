package Homework2.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import project.pages.steam.SteamSearchPage;

public class SteamSearchPageSteps {

    private SteamSearchPage steamSearchPage;

    public SteamSearchPageSteps() {
        steamSearchPage = new SteamSearchPage();
    }

    @And("^The first game is \"([^\"]*)\" in results$")
    public void theFirstGameIsInResults(String gameName) {
        Assert.assertTrue(steamSearchPage.isFirstResultEquals(gameName));
    }

    @When("^I click main logo on the Search page$")
    public void clickMainLogo() {
        steamSearchPage.clickMainLogo();
    }

    @When("^I click find by \"([^\"]*)\" OS checkbox$")
    public void iClickFindByOSCheckbox(String OS) {
        steamSearchPage.clickOsFilterByOsName(OS);
    }

    @Then("^First \"([^\"]*)\" results support \"([^\"]*)\" OS$")
    public void firstResultsSupportOS(Integer resultsCount, String OS) {
        Assert.assertTrue(steamSearchPage.isAppsSupportByOs(resultsCount, OS));
    }
}
