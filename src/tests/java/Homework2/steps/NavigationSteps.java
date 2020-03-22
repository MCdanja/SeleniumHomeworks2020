package Homework2.steps;

import aquality.selenium.browser.Browser;
import aquality.selenium.browser.BrowserManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import project.enums.Pages;
import project.pages.BasePage;

public class NavigationSteps {

    private Browser browser;

    public NavigationSteps() {
        browser = BrowserManager.getBrowser();
    }

    private void navigate(String url) {
        browser.getDriver().navigate().to(url);
        browser.waitForPageToLoad();
    }

    @Given("^I navigate to the \"([^\"]*)\" page$")
    public void iNavigateToThePage(String pageName) {
        navigate(Pages.getPageByName(pageName).getUrl());
    }

    @Then("^The \"([^\"]*)\" page is opened$")
    public void checkPageIsOpened(String pageName) throws IllegalAccessException, InstantiationException {
        browser.waitForPageToLoad();
        Pages page = Pages.getPageByName(pageName);
        Assert.assertTrue(((BasePage) page.getPageClass().newInstance()).isExists(),
                String.format("Page %s not opened", pageName));
    }
}
