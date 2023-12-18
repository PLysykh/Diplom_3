package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    private final By registrationPageHeader = By.xpath(".//h2[text() = 'Регистрация']");
    private final By nameField = By.xpath("//label[contains(text(), 'Имя')]//parent::div//input[@name='name']");
    private final By emailField = By.xpath("//label[contains(text(), 'Email')]//parent::div//input[@name='name']");
    private final By passwordField = By.xpath(".//*[@name = 'Пароль']");
    private final By registrationButton = By.xpath(".//button[text() = 'Зарегистрироваться']");
    private final By loginButton = By.cssSelector("[href='/login']");

    @Step("Waiting for Registration Page to be loaded")
    public void waitForLoadRegistrationPageData() {
        new WebDriverWait(driver, Duration.ofMillis(5000)).until(driver -> (driver.findElement(registrationPageHeader).isDisplayed()
        ));
    }

    @Step("Input of name")
    public void insertName(String name){
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(name);
    }

    @Step("Input of email")
    public void insertEmail(String email){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Input of password")
    public void insertPassword(String password){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Input of name, email and password")
    public void insertingRegistrationInformation(String name, String email, String password){
        insertName(name);
        insertEmail(email);
        insertPassword(password);
    }

    @Step("Clicking on the registration button on the Registration Page")
    public void registrationButtonClick(){
        driver.findElement(registrationButton).click();
    }

    @Step("Clicking on the login button on the Registration Page")
    public void loginButtonClick(){
        driver.findElement(loginButton).click();
    }
}
