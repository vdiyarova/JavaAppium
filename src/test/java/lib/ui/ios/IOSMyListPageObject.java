package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IOSMyListPageObject extends MyListsPageObject {
    static {
        ARTICLE_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name='{ARTICLE_TITLE}')]";
    }

    public IOSMyListPageObject(AppiumDriver driver){
        super(driver);
    }
}
