package project.pages.steam;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import project.functions.CommonFunctions;

import static java.lang.Integer.parseInt;

public class SteamSearchPage extends BaseSteamPage {

    private final static String PAGE_LOC = "//div[contains(@class,'page_header_ctn search')]";
    private final static String FILTER_OS_BY_NAME_LOC = "//div[contains(@data-param,'os') and contains(@data-loc,'%s')]";
    private final static String RESULT_APPLICATIONS_LOC = "//div[contains(@id,'search_resultsRows')]/a";
    private final static String RESULT_APPLICATIONS_BY_NUMBER_LOC = "(" + RESULT_APPLICATIONS_LOC + ")[%d]";
    private final static String SUPPORT_OS_BY_NAME_LOC = "//span[@class='platform_img %s']";

    private ILabel firstResultLbl = getElementFactory().getLabel(By.xpath(RESULT_APPLICATIONS_LOC + "//span[@class='title']"),
            "First result label");

    private WebDriver driver = BrowserManager.getBrowser().getDriver();

    public SteamSearchPage() {
        super(By.xpath(PAGE_LOC), "Steam search page");
    }

    public boolean isFirstResultEquals(String gameName) {
        return firstResultLbl.getText().equals(gameName);
    }

    public void clickOsFilterByOsName(String OS) {
        ICheckBox osFilterChbx = getElementFactory().getCheckBox(By.xpath(String.format(FILTER_OS_BY_NAME_LOC, OS)), "OS filter checkbox");
        osFilterChbx.clickAndWait();
    }

    public boolean isAppsSupportByOs(Integer appsCount, String OS) {
        String supportOsLoc;
        switch (OS) {
            case "Mac":
                supportOsLoc = String.format(SUPPORT_OS_BY_NAME_LOC, "mac");
                break;
            case "Windows":
                supportOsLoc = String.format(SUPPORT_OS_BY_NAME_LOC, "win");
                break;
            case "Linux":
                supportOsLoc = String.format(SUPPORT_OS_BY_NAME_LOC, "linux");
                break;
            default:
                supportOsLoc = String.format(SUPPORT_OS_BY_NAME_LOC, "win");
                break;
        }
        int waitSeconds = parseInt(CommonFunctions.getConfigValue("wait_seconds"));
        int sleepTime = parseInt(CommonFunctions.getConfigValue("sleep"));
        WebDriverWait wait = new WebDriverWait(driver, waitSeconds, sleepTime);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(RESULT_APPLICATIONS_LOC))));
        boolean appsAreSupport = true;
        for (int i = 1; i <= appsCount; i++) {
            try {
                ILabel application = getElementFactory().getLabel(By.xpath(String.format(RESULT_APPLICATIONS_BY_NUMBER_LOC, i)),
                        String.format("Application number %d", i));
                application.findChildElement(By.xpath(supportOsLoc), ILabel.class);
            } catch (NoSuchElementException e) {
                appsAreSupport = false;
                break;
            }
        }
        return appsAreSupport;
    }
}
