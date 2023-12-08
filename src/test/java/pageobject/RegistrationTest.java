package pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;
import static pageobject.constants.TextsMessagesButtons.*;

public class RegistrationTest extends BaseTest{

    @Test
    @DisplayName("Register new user")
    @Description("Possibility to be registered on the site")
    public void registrationTest(){

        homePage.waitForLoadMainPageData();

        homePage.accountButtonClick(PERSONAL_CABINET_BUTTON);

        loginPage.waitForLoadLoginPageData();

        loginPage.registerButtonClick(REGISTER_ON_LOGIN_PAGE_BUTTON);

        registrationPage.waitForLoadRegistrationPageData();

        registrationPage.insertingRegistrationInformation(NAME, EMAIL, PASSWORD);

        registrationPage.registrationButtonClick();

        loginPage.waitForLoadLoginPageData();

        String currentURL = driver.getCurrentUrl();

        assertEquals(LOGIN_PAGE_URL, currentURL);
    }

    @Test
    @DisplayName("Trying to register with invorrect password")
    @Description("Impossibility to register with too short password")
    public void registrationWithWrongPasswordImpossibleTest(){

        homePage.waitForLoadMainPageData();

        homePage.accountButtonClick(PERSONAL_CABINET_BUTTON);

        loginPage.waitForLoadLoginPageData();

        loginPage.registerButtonClick(REGISTER_ON_LOGIN_PAGE_BUTTON);

        registrationPage.waitForLoadRegistrationPageData();

        registrationPage.insertingRegistrationInformation(NAME, EMAIL, WRONG_PASSWORD);

        registrationPage.registrationButtonClick();

        loginPage.waitForWrongPasswordTextAppearance();

        String text = driver.findElement(By.xpath(".//*[text() = 'Некорректный пароль']")).getText();

        assertEquals(WRONG_PASSWORD_ERROR_TEXT, text);
    }
}