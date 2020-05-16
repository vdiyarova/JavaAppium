package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListPageObject extends MyListsPageObject {
    static {
        ARTICLE_TITLE_TPL = "xpath://XCUIElementTypeLink[contains(@name='{ARTICLE_TITLE}')]";
    }

    public IOSMyListPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
