package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject {
    private static final String
    STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT = "id:New ways to explore",
    STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK = "id:Add or edit preferred languages",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "id:Learn more about data collected",
    NEXT_LINK = "id:Next",
    GET_STARTED_BUTTON = "id:Get Started",
    SKIP = "id:Skip";

    public WelcomePageObject(RemoteWebDriver driver){
        super(driver);
    }

    public void waitForLearnMoreLink(){
        waitForElementPresent(
                STEP_LEARN_MORE_LINK,
                "Cannot find 'Learn more about Wikipedia' link",
                10
        );
    }

    public void waitForNewWayToExploreText(){
        waitForElementPresent(
                STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Cannot find 'New ways to explore' text",
                10
        );
    }

    public void waitForAddOrEditPreferredLangText(){
        waitForElementPresent(
                STEP_ADD_OR_EDIT_PREFERRED_LANG_LINK,
                "Cannot find 'Add or edit preferred languages' text",
                10
        );
    }

    public void waitForLearnMoreAboutDataCollectedLink(){
        waitForElementPresent(
                STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK,
                "Cannot find 'Learn more about data collected' link",
                10
        );
    }

    public void clickNextButton(){
        waitForElementAndClick(
                NEXT_LINK,
                "Cannot find and click 'Next' button",
                10
        );
    }

    public void clickGetStartedButton(){
        waitForElementAndClick(
                GET_STARTED_BUTTON,
                "Cannot find and click 'Get Started' button",
                10
        );
    }

    public void clickSkipButton(){
        waitForElementAndClick(
                SKIP,
                "Cannot find and click 'Skip' button",
                5
        );
    }
}
