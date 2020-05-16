package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MwMyListPageObject extends MyListsPageObject {
    static {
        ARTICLE_TITLE_TPL = "xpath://h3[contains(text(),'{ARTICLE_TITLE}')]";
        REMOVE_FROM_SAVED_BUTTON_TPL = "xpath://h3[contains(text(),'{ARTICLE_TITLE}')]/../../a[contains(@class, 'watched')]";
    }

    public MwMyListPageObject(RemoteWebDriver driver){
            super(driver);
        }
}
