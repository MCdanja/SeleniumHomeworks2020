package Homework2.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import project.functions.CommonFunctions;
import project.pages.steam.SteamSignUpPage;

public class SteamSignUpPageSteps {

    private SteamSignUpPage steamSignUpPage;

    public SteamSignUpPageSteps() {
        steamSignUpPage = new SteamSignUpPage();
    }

    @When("^I click main logo on the Sign up page$")
    public void clickMainLogo() {
        steamSignUpPage.clickMainLogo();
    }

    @When("^I fill \"([^\"]*)\" email$")
    public void iFillMail(String email) {
        if (email.equals("Random")) {
            email = CommonFunctions.getRandomMail(10);
        }
        steamSignUpPage.enterEmail(email);
        steamSignUpPage.reenterEmail(email);
    }

    @And("^I agree with terms$")
    public void iAgreeWithTerms() {
        steamSignUpPage.agreeTerms();
    }

    @And("^I click register button$")
    public void iClickRegisterButton() {
        steamSignUpPage.clickRegisterBtn();
    }

    @Then("^Error message shown$")
    public void errorMessageShown() {
        Assert.assertTrue(steamSignUpPage.isErrorLabelPresent(), "Error message not shown");
    }
}
