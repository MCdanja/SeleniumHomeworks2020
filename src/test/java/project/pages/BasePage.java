package project.pages;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public abstract class BasePage extends Form {

    private By locator;

    protected BasePage(By locator, String name) {
        super(locator, name);
        this.locator = locator;
    }

    public boolean isExists() {
        try {
            BrowserManager.getBrowser().getDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
