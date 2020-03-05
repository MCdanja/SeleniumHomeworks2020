package Homework1;

import aquality.selenium.browser.Browser;
import aquality.selenium.browser.BrowserManager;
import aquality.selenium.utils.JsonFile;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.GoogleResultPage;

public class GoogleSearchTest {
    
    private static final String SEARCH_TEXT = "Политех";
    private static final String EXPECTED_TEXT = "Санкт-Петербургский политехнический университет Петра";
    
    private static Browser browser;
    private static JsonFile config;
    private static GoogleHomePage googleHomePage;
    private static GoogleResultPage googleResultPage;
    
    @BeforeMethod
    public void initAll() {
        browser = BrowserManager.getBrowser();
        browser.maximize();
        config = new JsonFile("config.json");
        googleHomePage = new GoogleHomePage();
        googleResultPage = new GoogleResultPage();
    }
    
    @Test
    public void testGoogleSearch() {
        //Open Google Home page
        String startUrl = config.getValue("/google_url").toString();
        browser.goTo(startUrl);
        browser.waitForPageToLoad();
        //Search some text
        googleHomePage.search(SEARCH_TEXT);
        //Check first result contains expected text
        Assert.assertTrue(googleResultPage.isFirstResultContains(EXPECTED_TEXT), "First result contains " + EXPECTED_TEXT);
    }
    
    @AfterMethod
    public void closeBrowser() {
        browser.quit();
    }
}
