package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private final WebDriver driver;

    private final By loginButton = By.cssSelector("[href='/login']");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Clicking on login button on ForgotPassword Page")
    public void loginButtonClick(){
        driver.findElement(loginButton).click();
    }
}