package project.pages.steam;

import aquality.selenium.elements.interfaces.ILink;
import org.openqa.selenium.By;
import project.pages.BasePage;

public class BaseSteamPage extends BasePage {

    private ILink mainLogoLnk = getElementFactory().getLink(By.xpath("//span[contains(@id,'logo')]/a"), "Main logo link");

    BaseSteamPage(By locator, String name) {
        super(locator, name);
    }

    public void clickMainLogo() {
        mainLogoLnk.clickAndWait();
    }
}
