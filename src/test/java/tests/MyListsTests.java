package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {
    private static final String name_of_folder = "Learning programming";
    private static final String
            login = "Vdiyarova",
            password = "WikiTest";


    @Test
    public void testSaveArticleToMyList(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.saveArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        if (Platform.getInstance().isMw()){
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();
            ArticlePageObject.waitForTitleElement();
            assertEquals(
                    "We are not on the same page after login",
                    article_title,
                    ArticlePageObject.getArticleTitle()
            );
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigation();
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
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String first_article_title = ArticlePageObject.getArticleTitle(); // check first article title
        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.saveArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        if (Platform.getInstance().isMw()){
            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();
            ArticlePageObject.waitForTitleElement();
            assertEquals(
                    "We are not on the same page after login",
                    first_article_title,
                    ArticlePageObject.getArticleTitle()
            );
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.clickSearchButton(); // search second article
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("High-level programming language");
        ArticlePageObject.waitForTitleElement();
        String title_before_saving = ArticlePageObject.getArticleTitle(); //check second article title
        if(Platform.getInstance().isAndroid()){
            ArticlePageObject.saveArticleToAlreadyCreatedFolder(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();
        }
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver); // go to my list
        NavigationUI.openNavigation();
        NavigationUI.clickMyList();

        MyListsPageObject MyListsPageObject = MyListPageObjectFactory.get(driver);
        if(Platform.getInstance().isAndroid()){
            MyListsPageObject.openFolderByName(name_of_folder); // open created folder
        }
        MyListsPageObject.swipeByArticleToDelete(first_article_title);  // delete first article

        assertTrue("The second saved article is not in the saved", MyListsPageObject.isSavedArticle(title_before_saving)); // check saved article in my saved
    }
}
