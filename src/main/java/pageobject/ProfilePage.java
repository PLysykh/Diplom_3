package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static pageobject.constants.TextsMessagesButtons.*;

public class ProfilePage {

    private final By emailField = By.xpath("//label[contains(text(), 'Email')]//parent::div//input[@name='name']");
    private final By passwordField = By.xpath(".//*[@name = 'Пароль']");

    private final WebDriver driver;

    private final By accountContent = By.xpath("//*[contains(@class, 'Account_contentBox')]");

    public ProfilePage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Waiting for Profile Page to be loaded")
    public void waitForLoadProfilePageData() {
        new WebDriverWait(driver, Duration.ofMillis(3000))
                .until(ExpectedConditions.visibilityOfElementLocated(accountContent));
    }

    @Step("Clicking on the designer button on the profile page")
    public void designerButtonClick(){
        driver.findElement(DESIGNER_BUTTON).click();
    }

    @Step("Clicking on the logo button on the Profile Page")
    public void logoButtonClick(){
        driver.findElement(LOGO_BUTTON).click();
    }

    @Step("Clicking on the button")
    public void buttonClick(By button){
        driver.findElement(button).click();
    }

    @Step("Clicking on the logout button")
    public void logoutButtonClick(){
        driver.findElement(LOGOUT_BUTTON).click();
    }
}