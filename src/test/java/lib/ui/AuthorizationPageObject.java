package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject {
    private final static String
            LOGIN_BUTTON = "xpath://body/div//a[text()='Log in']",
            LOGIN_INPUT = "css:input[name='wpName']",
            PASSWORD_INPUT = "css:input[name='wpPassword']",
            SUBMIT_BUTTON = "css:button#wpLoginAttempt";

    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void clickAuthButton(){
        this.tryClickElementWithFewAttempts(
                LOGIN_BUTTON,
                "Cannot find and click login button",
                10
        );
    }

    public void enterLoginData(String login, String password){
        this.waitForElementAndSendKeys(
                LOGIN_INPUT,
                login,
                "Cannot find and put a login to the login input",
                5
        );
        this.waitForElementAndSendKeys(
                PASSWORD_INPUT,
                password,
                "Cannot find and put a password to the password input",
                5
        );
    }

    public void submitForm(){
        waitForElementAndClick(
                SUBMIT_BUTTON,
                "Cannot find and click submit button",
                5
        );
    }


}
