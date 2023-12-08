package pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.constants.NameOfTheButton;

import static org.junit.Assert.assertEquals;
import static pageobject.constants.NameOfTheButton.*;
import static pageobject.constants.TextsMessagesButtons.*;

@RunWith(Parameterized.class)
public class ParameterizedAuthorizationTest extends BaseTest{

    private final NameOfTheButton nameOfTheButton;

    public ParameterizedAuthorizationTest(NameOfTheButton nameOfTheButton){
        this.nameOfTheButton = nameOfTheButton;
    }

    @Parameterized.Parameters(name = "{index}: buttons that lead to opening of Login Page={0}")
    public static Object[][] getData(){
        return new Object[][]{
                {LOGIN_ON_HOME_PAGE_THROUGH_ENTER_ACCOUNT_BUTTON},
                {LOGIN_ON_HOME_PAGE_THROUGH_PERSONAL_CABINET_BUTTON},
                {LOGIN_ON_REGISTRATION_PAGE_BUTTON},
                {LOGIN_ON_FORGOT_PASSWORD_PAGE_BUTTON}
        };
    }

    void chooseButtonForAuthourization(NameOfTheButton nameOfTheButton){
        switch(nameOfTheButton){
            case LOGIN_ON_HOME_PAGE_THROUGH_ENTER_ACCOUNT_BUTTON:
                homePage.accountButtonClick(ENTER_ACCOUNT_ON_MAIN_PAGE_BUTTON);
                break;
            case LOGIN_ON_HOME_PAGE_THROUGH_PERSONAL_CABINET_BUTTON:
                homePage.accountButtonClick(PERSONAL_CABINET_BUTTON);
                break;
            case LOGIN_ON_REGISTRATION_PAGE_BUTTON:
                homePage.accountButtonClick(PERSONAL_CABINET_BUTTON);
                loginPage.waitForLoadLoginPageData();
                loginPage.registerButtonClick(REGISTER_ON_LOGIN_PAGE_BUTTON);
                registrationPage.waitForLoadRegistrationPageData();
                registrationPage.loginButtonClick();
                break;
            case LOGIN_ON_FORGOT_PASSWORD_PAGE_BUTTON:
                homePage.accountButtonClick(ENTER_ACCOUNT_ON_MAIN_PAGE_BUTTON);
                loginPage.waitForLoadLoginPageData();
                loginPage.resetPasswordButtonClick();
                String forgotPasswordPageUrl = driver.getCurrentUrl();
                assertEquals(FORGOT_PASSWORD_PAGE_URL, forgotPasswordPageUrl);
                forgotPasswordPage.loginButtonClick();
                break;
        }
    }

    @Test
    @DisplayName("Authorization on the site")
    @Description("Possibility to authorize through parameterization using four ways")
    public void parameterizationAuthorizationTest(){
        registerUser();
        homePage.waitForLoadMainPageData();
        chooseButtonForAuthourization(nameOfTheButton);
        loginPage.waitForLoadLoginPageData();
        loginPage.insertingLoginInformation(EMAIL, PASSWORD);
        loginPage.loginButtonClick();
        homePage.waitForLoadMainPageData();
        homePage.accountButtonClick(PERSONAL_CABINET_BUTTON);
        profilePage.waitForLoadProfilePageData();
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        assertEquals(PROFILE_PAGE_URL, currentURL);
    }
}