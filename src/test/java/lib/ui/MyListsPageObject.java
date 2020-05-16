package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject{
    protected static String
            FOLDER_BY_NAME_TPL,
            ARTICLE_TITLE_TPL,
            REMOVE_FROM_SAVED_BUTTON_TPL;

    public MyListsPageObject(RemoteWebDriver driver){
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getFolderXpathByName(String name_of_folder){
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getArticleTitleXpath (String article_title){
        return ARTICLE_TITLE_TPL.replace("{ARTICLE_TITLE}", article_title);
    }

    private static String getRemoveButtonByTitle (String article_title){
        return REMOVE_FROM_SAVED_BUTTON_TPL.replace("{ARTICLE_TITLE}", article_title);
    }
    /*  TEMPLATES METHODS */

    public void openFolderByName(String name_of_folder){
        String folder_nam_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_nam_xpath,
                "Cannot find folder by name " + name_of_folder,
                10
        );
    }

    public void waitForArticleToAppearByTitle(String article_title){
        String article_title_xpath = getArticleTitleXpath(article_title);
        this.waitForElementPresent(
                article_title_xpath,
                "Cannot find saved article by title " + article_title,
                5
        );
    }

    public void swipeByArticleToDelete(String article_title){
        this.waitForArticleToAppearByTitle(article_title);
        String article_title_xpath = getArticleTitleXpath(article_title);
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()){
            this.swipeElementToLeft(
                    article_title_xpath,
                    "Cannot find saved article"
            );
        } else {
            String remove_locator = getRemoveButtonByTitle(article_title);
            this.waitForElementAndClick(
                    remove_locator,
                    "Cannot click button to remove from saved",
                    10
            );
        }

        if (Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(article_title_xpath, "Cannot find article title");
        }
        if (Platform.getInstance().isMw()){
            driver.navigate().refresh();
        }
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void waitForArticleToDisappearByTitle(String article_title){
        String article_title_xpath = getArticleTitleXpath(article_title);
        this.waitForElementNotPresent(
                article_title_xpath,
                "Saved article still present with title " + article_title,
                5
        );
    }

    public boolean isSavedArticle(String article_title){
        String article_title_xpath = getArticleTitleXpath(article_title);
        return  this.isElementPresent(article_title_xpath);
    }

    public void openArticleByTitle(String article_title){
        String article_title_xpath = getArticleTitleXpath(article_title);
        this.waitForElementAndClick(
                article_title_xpath,
                "Cannot find saved article 'JavaScript' ",
                15
        );
    }
}
