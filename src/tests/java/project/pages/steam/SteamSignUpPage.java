package project.pages.steam;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.functions.CommonFunctions;

import static java.lang.Integer.parseInt;

public class SteamSignUpPage extends BaseSteamPage {

    private final static String PAGE_LOC = "//div[contains(@class,'join_form')]/div";

    private ITextBox emailTb = getElementFactory().getTextBox(By.id("email"), "Email text box");
    private ITextBox reenterEmailTb = getElementFactory().getTextBox(By.id("reenter_email"), "Reenter email text box");
    private ICheckBox agreeTermsChbx = getElementFactory().getCheckBox(By.id("i_agree_check"), "Agree terms check box");
    private IButton registerBtn = getElementFactory().getButton(By.id("createAccountButton"), "Create account button");
    private ILabel errorLbl = getElementFactory().getLabel(By.id("error_display"), "Error label");

    private WebDriver driver = BrowserManager.getBrowser().getDriver();

    public SteamSignUpPage() {
        super(By.xpath(PAGE_LOC), "Steam search page");
    }

    public void enterEmail(String email) {
        emailTb.clearAndType(email);
    }

    public void reenterEmail(String email) {
        reenterEmailTb.clearAndType(email);
    }

    public void agreeTerms() {
        agreeTermsChbx.check();
    }

    public void clickRegisterBtn() {
        registerBtn.clickAndWait();
    }

    public boolean isErrorLabelPresent() {
        int waitSeconds = parseInt(CommonFunctions.getConfigValue("wait_seconds"));
        int sleepTime = parseInt(CommonFunctions.getConfigValue("sleep"));
        WebDriverWait wait = new WebDriverWait(driver, waitSeconds, sleepTime);
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(errorLbl.getLocator())));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }
}
