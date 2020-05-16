package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListPageObject extends MyListsPageObject {
    static {
                FOLDER_BY_NAME_TPL = "xpath://android.widget.TextView[@text='{FOLDER_NAME}']";
                ARTICLE_TITLE_TPL = "xpath://*[@text='{ARTICLE_TITLE}']";
    }

    public AndroidMyListPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
