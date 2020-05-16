package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MwNavigationUIPageObject extends NavigationUI {
    static {
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";
        MY_LIST = "css:a[data-event-name='menu.unStar']";
    }
    public MwNavigationUIPageObject(RemoteWebDriver driver){
        super(driver);
    }
}

