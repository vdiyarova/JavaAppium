package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
    private static String name_of_folder = "Learning programming";

    @Test
    public void testSaveArticleToMyList(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWihSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.saveArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyList();
        MyListsPageObject MyListsPageObject = MyListPageObjectFactory.get(driver);
        if (Platform.getInstance().isAndroid()){
            MyListsPageObject.openFolderByName(name_of_folder);
        }
        MyListsPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testSaveTwoArticles() {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput(); // search first article
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWihSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String first_article_title = ArticlePageObject.getArticleTitle(); // check first article title
        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.saveArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.clickSearchButton(); // search second article
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWihSubstring("JavaScript");
        ArticlePageObject.waitForTitleElement();
        String title_before_saving = ArticlePageObject.getArticleTitle(); //check second article title
        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.saveArticleToAlreadyCreatedFolder(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver); // go to my list
        NavigationUI.clickMyList();

        MyListsPageObject MyListsPageObject = MyListPageObjectFactory.get(driver);
        if(Platform.getInstance().isAndroid()){
            MyListsPageObject.openFolderByName(name_of_folder); // open created folder
        }
        MyListsPageObject.swipeByArticleToDelete(first_article_title);  // delete first article
        MyListsPageObject.openArticleByTitle(title_before_saving); // open second article

        String title_after_saving = ArticlePageObject.getArticleTitle(); // get article title after saving

        assertEquals(
                "Title of saved article does not match title of open article",
                title_before_saving,
                title_after_saving
        );
    }
}
