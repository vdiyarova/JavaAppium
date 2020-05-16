package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class CoreTestCase extends TestCase {
    protected RemoteWebDriver driver;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.skipWelcomePageForIOSApp();
        this.getWikiWebPageForMobileWeb();
    }

//    @Override
//    protected void tearDown() throws Exception{
//        super.tearDown();
//        driver.quit();
//    }

    protected void rotateScreenPortrait(){
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("Method 'rotateScreenPortrait()' does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void rotateScreenLandscape(){
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("Method 'rotateScreenLandscape()' does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void backgroundApp(Duration seconds){
        if (driver instanceof AppiumDriver){
            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.runAppInBackground(seconds);
        } else {
            System.out.println("Method 'backgroundApp()' does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    private void skipWelcomePageForIOSApp(){
        if (driver instanceof AppiumDriver){
            if(Platform.getInstance().isIOS()){
                AppiumDriver driver = (AppiumDriver) this.driver;
                WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
                WelcomePageObject.clickSkipButton();
            }
        } else {
            System.out.println("Method 'skipWelcomePageForIOSApp()' does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    protected void getWikiWebPageForMobileWeb(){
        if (Platform.getInstance().isMw()){
            driver.get("https://en.m.wikipedia.org");
        } else {
            System.out.println("Method 'setWikiWebPageForMobileWeb()' does nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }
}

