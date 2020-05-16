package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MwArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST = "css:#page-actions-watch a#ca-watch.mw-ui-icon-wikimedia-star-base20";
        SEARCH_ARTICLE_BUTTON = "css:button#searchIcon";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON = "css:#page-actions-watch a#ca-watch.mw-ui-icon-wikimedia-unStar-progressive";
    }

    public MwArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }


}
