package pageobject;

import io.restassured.http.ContentType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import pageobject.constants.HeaderButtons;

import static io.restassured.RestAssured.given;

import static pageobject.constants.TextsMessagesButtons.*;

public class BaseTest extends WebDrivers{
    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected RegistrationPage registrationPage;
    protected ForgotPasswordPage forgotPasswordPage;
    protected ProfilePage profilePage;

    @Before
    public void open(){
        driver = getDriver(BrowserType.CHROME);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        profilePage = new ProfilePage(driver);

        // opening page for test
        driver.get(HOME_PAGE_URL);
    }

    @After
    public void teardown() {
        String json = "{\"email\": \"" + EMAIL + "\", \"password\": \"" + PASSWORD + "\"}";
        if(given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post(HOME_PAGE_URL + "/api/auth/login")
                .body()
                .path("success").equals(true)) {
            driver.quit();
            deleteUser();
        } else {
            driver.quit();
        }
    }

    public void deleteUser() {
        String json = "{\"email\": \"" + EMAIL + "\", \"password\": \"" + PASSWORD + "\"}";
        String accessToken = given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post(HOME_PAGE_URL + "/api/auth/login")
                .body()
                .path("accessToken")
                .toString();
        given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .delete(HOME_PAGE_URL + "/api/auth/user");
    }

    public void registerUser(){
        String json = "{\"email\": \"" + EMAIL + "\", \"password\": \"" + PASSWORD + "\", \"name\": \"" + NAME + "\"}";
        given()
                .header("Content-type", "application/json")
                .body(json)
                .when()
                .post(HOME_PAGE_URL + "/api/auth/register");
    }

    public void chooseButtonForRedirect(HeaderButtons headerButtons){
        switch(headerButtons) {
            case CONSTRUCTOR:
                profilePage.buttonClick(DESIGNER_BUTTON);
                break;
            case LOGO:
                profilePage.buttonClick(LOGO_BUTTON);
                break;
        }
    }
}