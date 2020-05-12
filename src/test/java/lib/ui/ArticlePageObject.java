package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject{
    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            SEARCH_ARTICLE_BUTTON,
            MY_LIST_FOLDER_TPL;

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */

    private static String getNameFolder(String name_of_folder){
        return MY_LIST_FOLDER_TPL.replace("{NAME_OF_FOLDER}", name_of_folder);
    }
    /*  TEMPLATES METHODS */


    public WebElement waitForTitleElement(){
        return this.waitForElementPresent(
                TITLE,
                "Cannot find article title",
                15
        );
    }

    public String getArticleTitle(){
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter(){
        if (Platform.getInstance().isAndroid()){
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    20
            );
        } else {
            this.swipeUpTillElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        }

    }

    public void saveArticleToMyList(String name_of_folder){
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST,
                "Cannot find options to add article to read list",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find button 'Got it'",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot find input to set name of articles folder",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press 'OK' button fot create article folder",
                5
        );
    }

    public void saveArticleToAlreadyCreatedFolder(String name_of_folder){
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST,
                "Cannot find options to add article to read list",
                5
        );

        String my_list_xpath = getNameFolder(name_of_folder);
        this.waitForElementAndClick(
                my_list_xpath,
                "Cannot find folder " + name_of_folder,
                5
        );
    }

    public void closeArticle(){
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot find button to close article",
                5
        );
    }

    public void clickSearchButton(){
        this.waitForElementAndClick(
                SEARCH_ARTICLE_BUTTON,
                "Cannot find 'Search' button",
                5
        );
    }

    public void assertArticleTitlePresent(){
        this.assertElementPresent(
                TITLE,
                "Cannot find title"
        );
    }

    public void addArticlesToMySaved(){
        this.waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST,
                "Cannot find 'Add to my saved' button",
                10
        );
    }

}
