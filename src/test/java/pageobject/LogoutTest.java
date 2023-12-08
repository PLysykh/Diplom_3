package pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static pageobject.constants.TextsMessagesButtons.*;

public class LogoutTest extends BaseTest {

    private final By emailField = By.xpath("//label[contains(text(), 'Email')]//parent::div//input[@name='name']");
    private final By passwordField = By.xpath("//input[@name = 'Пароль']");

    @Test
    @DisplayName("Logging out test")
    @Description("Possibility to log out")
    public void logoutTest(){

        registerUser();

        homePage.waitForLoadMainPageData();

        homePage.accountButtonClick(PERSONAL_CABINET_BUTTON);

        loginPage.waitForLoadLoginPageData();

        loginPage.insertingLoginInformation(EMAIL, PASSWORD);

        loginPage.loginButtonClick();

        homePage.waitForLoadMainPageData();

        homePage.accountButtonClick(PERSONAL_CABINET_BUTTON);
        profilePage.waitForLoadProfilePageData();

        profilePage.logoutButtonClick();

        loginPage.waitForLoadLoginPageData();

        String currentURL = driver.getCurrentUrl();
        assertEquals(LOGIN_PAGE_URL, currentURL);

        String emptyEmail = driver.findElement(emailField).getText();
        assertEquals("", emptyEmail);

        String emptyPassword = driver.findElement(passwordField).getText();
        assertEquals("", emptyPassword);
    }
}