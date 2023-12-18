package pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobject.constants.HeaderButtons;

import static org.junit.Assert.assertEquals;
import static pageobject.constants.HeaderButtons.*;
import static pageobject.constants.TextsMessagesButtons.*;

@RunWith(Parameterized.class)
public class ParameterizedTransitionTest extends BaseTest{

    private final HeaderButtons headerButtons;

    public ParameterizedTransitionTest(HeaderButtons headerButtons){
        this.headerButtons = headerButtons;
    }

    @Parameterized.Parameters(name = "{index}: nameOfTheButton={0}")
    public static Object[][] getData(){
        return new Object[][]{
                {CONSTRUCTOR},
                {LOGO}
        };
    }

    @Test
    @DisplayName("Redirection on the Home Page")
    @Description("Possibility to be redirected on the Home Page by clicking two signs")
    public void parametrizationConstructorRedirectTest(){
        registerUser();
        homePage.waitForLoadMainPageData();
        homePage.accountButtonClick(PERSONAL_CABINET_BUTTON);
        loginPage.waitForLoadLoginPageData();
        loginPage.insertingLoginInformation(EMAIL, PASSWORD);
        chooseButtonForRedirect(headerButtons);
        homePage.waitForLoadMainPageData();

        String currentURL = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL+"/", currentURL);
    }
}