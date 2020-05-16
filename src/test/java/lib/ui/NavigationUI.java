package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject{
    protected static String
            MY_LIST,
            OPEN_NAVIGATION;
    public NavigationUI(RemoteWebDriver driver){
        super(driver);
    }

    public void openNavigation(){
        if (Platform.getInstance().isMw()){
            this.waitForElementAndClick(
                    OPEN_NAVIGATION,
                    "Cannot find open navigation button",
                    5
            );
        } else {
            System.out.println("Method 'openNavigation()' do nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickMyList(){
        if (Platform.getInstance().isMw()){
            this.tryClickElementWithFewAttempts(
                    MY_LIST,
                    "Cannot find and click button 'My list'",
                    5
            );
        } else {
            this.waitForElementAndClick(
                    MY_LIST,
                    "Cannot find button and click 'My list'",
                    5
            );
        }
    }
}
