package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pageobject.constants.TextsMessagesButtons.*;

public class LoginPage {

    private final WebDriver driver;

    //FIELDS
    private final By emailfield = By.xpath("//label[contains(text(), 'Email')]//parent::div//input[@name='name']");
    private final By passwordfield = By.xpath(".//*[@name = 'Пароль']");
    private final By resetPasswordButton = By.cssSelector("[href='/forgot-password']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Waiting for Login Page to be loaded")
    public void waitForLoadLoginPageData() {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOfElementLocated(LOGIN_PAGE_TEXT));
    }

    @Step("Waiting for wrong password text to be present")
    public void waitForWrongPasswordTextAppearance(){
        new WebDriverWait(driver,Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(WRONG_PASSWORD_TEXT_SIGN));
    }

    @Step("Input of email")
    public void insertEmail(String email){
        driver.findElement(emailfield).click();
        driver.findElement(emailfield).sendKeys(email);
    }

    @Step("Input of password")
    public void insertPassword(String password){
        driver.findElement(passwordfield).click();
        driver.findElement(passwordfield).sendKeys(password);
    }

    @Step("Input of email & password")
    public void insertingLoginInformation(String email, String password){
        insertEmail(email);
        insertPassword(password);
    }

    @Step("Clicking on the login button on the Login Page")
    public void loginButtonClick(){
        driver.findElement(AUTHORIZE_BUTTON).click();
    }

    @Step("Clicking on the register button on the Login Page")
    public void registerButtonClick(By loginButton){
        driver.findElement(loginButton).click();
    }

    @Step("Clicking on the reset button on the Login Page")
    public void resetPasswordButtonClick(){
        driver.findElement(resetPasswordButton).click();
    }
}