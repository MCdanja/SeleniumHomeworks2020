package project.pages.steam;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

public class SteamHomePage extends BaseSteamPage {

    private final static String PAGE_LOC = "//div[contains(@class ,'home_page_body')]";

    private ITextBox searchTb = getElementFactory().getTextBox(By.xpath("//input[contains(@id,'search_term')]"), "Search text box");
    private IButton searchBtn = getElementFactory().getButton(By.xpath("//div[@class='searchbox']/a"), "Search button");
    private IButton signUpBtn = getElementFactory().getButton(By.xpath("//div[@id='content_login']//a[contains(@href,'join')]"), "Sign Up button");

    public SteamHomePage() {
        super(By.xpath(PAGE_LOC), "Steam home page");
    }

    public void typeSearchText(String text) {
        searchTb.clearAndType(text);
    }

    public void clickSearch() {
        searchBtn.clickAndWait();
    }

    public void clickSignUp() {
        signUpBtn.clickAndWait();
    }
}
