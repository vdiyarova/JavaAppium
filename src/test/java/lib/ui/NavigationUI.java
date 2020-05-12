package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUI extends MainPageObject{
    protected static String MY_LIST;
    public NavigationUI(AppiumDriver driver){
        super(driver);
    }

    public void clickMyList(){
        this.waitForElementAndClick(
                MY_LIST,
                "Cannot find button 'My lists'",
                5
        );
    }
}
