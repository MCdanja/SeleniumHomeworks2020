package project.enums;

import project.functions.CommonFunctions;
import org.apache.commons.lang3.NotImplementedException;
import project.pages.steam.SteamHomePage;
import project.pages.steam.SteamSearchPage;
import project.pages.steam.SteamSignUpPage;

public enum Pages {
    STEAM_HOME_PAGE("Steam Home", SteamHomePage.class, CommonFunctions.getConfigValue("steam_url")),
    STEAM_SEARCH_PAGE("Steam Search", SteamSearchPage.class, CommonFunctions.getConfigValue("steam_url") + "search"),
    STEAM_SIGN_UP_PAGE("Steam Sign up", SteamSignUpPage.class, CommonFunctions.getConfigValue("steam_url") + "join");


    private String pageName;
    private Class<?> pageClass;
    private String url;

    Pages(String pageName, Class<?> pageClass, String url) {
        this.pageName = pageName;
        this.pageClass = pageClass;
        this.url = url;
    }

    public String getPageName() {
        return pageName;
    }

    public Class<?> getPageClass() {
        return pageClass;
    }

    public String getUrl() {
        return url;
    }

    public static Pages getPageByName(String pageName) {
        for (Pages page : Pages.values()) {
            if (page.pageName.equals(pageName.replace("\"", ""))) {
                return page;
            }
        }
        throw new NotImplementedException(String.format("Unknown page: %s", pageName));
    }
}
