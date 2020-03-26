package project.hooks;

import aquality.selenium.browser.BrowserManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BrowserHooks {

    @Before
    public void startBrowser() {
        BrowserManager.getBrowser().maximize();
    }

    @After
    public void closeBrowser() {
        BrowserManager.getBrowser().quit();
    }
}
