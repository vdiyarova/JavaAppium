package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MwSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class,'wikidata-description')][contains(text(),'{SUBSTRING}')]";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
        EMPTY_RESULT_LABEL = "css:p.without-results";
        //SEARCH_INPUT_TEXT = "xpath:input[@placeholder='Search Wikipedia']"; //// не менялось под web, проверить что это, назвать нормально
    }

    public MwSearchPageObject(RemoteWebDriver driver){
        super(driver);
    }
}
