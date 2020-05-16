package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View page in browser";
        OPTIONS_ADD_TO_MY_LIST = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Back";
        SEARCH_ARTICLE_BUTTON = "id:org.wikipedia:id/menu_page_search"; /// изменить для иос
    }

    public IOSArticlePageObject (RemoteWebDriver driver){
        super(driver);
    }
}
