package project.pages.google;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GoogleHomePage extends Form {
    
    private final static String PAGE_LOC = "//*[@id='hplogo']";
    
    private ITextBox searchTb = getElementFactory().getTextBox(By.xpath("//input[contains(@title,'Поиск')]"), "Search field");
    
    public GoogleHomePage() {
        super(By.xpath(PAGE_LOC), "Google home page");
    }
    
    public void search(String text) {
        searchTb.clearAndType(text);
        searchTb.submit();
        BrowserManager.getBrowser().waitForPageToLoad();
    }
}
