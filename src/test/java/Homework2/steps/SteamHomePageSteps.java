package Homework2.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import project.pages.steam.SteamHomePage;

public class SteamHomePageSteps {

    private SteamHomePage steamHomePage;

    public SteamHomePageSteps() {
        steamHomePage = new SteamHomePage();
    }

    @When("^I type \"([^\"]*)\" text in the search field$")
    public void typeTextInTheSearchField(String text) {
        steamHomePage.typeSearchText(text);
    }

    @And("^I click \"([^\"]*)\" button$")
    public void clickSearchButton(String buttonName) {
        switch (buttonName) {
            case "Search":
                steamHomePage.clickSearch();
                break;
            case "Sign up":
                steamHomePage.clickSignUp();
                break;
            default:
                break;
        }
    }
}
