package pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static pageobject.constants.TextsMessagesButtons.*;

public class ProfileTest extends BaseTest{

    @Test
    @DisplayName("Entering profile through personal cabinet button")
    @Description("Possibility to enter the profile")
    public void profileEnteringTest(){
        registerUser();
        homePage.waitForLoadMainPageData();
        homePage.accountButtonClick(PERSONAL_CABINET_BUTTON);
        loginPage.waitForLoadLoginPageData();
        loginPage.insertingLoginInformation(EMAIL, PASSWORD);
        loginPage.loginButtonClick();
        homePage.waitForLoadMainPageData();
        homePage.accountButtonClick(PERSONAL_CABINET_BUTTON);
        profilePage.waitForLoadProfilePageData();

        String currentURL = driver.getCurrentUrl();
        assertEquals(PROFILE_PAGE_URL, currentURL);
    }
}