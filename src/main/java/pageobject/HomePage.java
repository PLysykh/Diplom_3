package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pageobject.constants.TextsMessagesButtons.*;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private final By homePageHeader = By.xpath(".//main[contains(@class, 'componentContainer')]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Waiting for Main Page to be loaded")
    public void waitForLoadMainPageData() {
        new WebDriverWait(driver, Duration.ofMillis(5000))
                .until(ExpectedConditions.visibilityOfElementLocated(homePageHeader));
    }

    @Step("Clicking on account button on Main Page")
    public void accountButtonClick(By accountButton) {
        driver.findElement(accountButton).click();
    }

    @Step("Clicking on Bun section button")
    public void sectionBunsClick(){
        driver.findElement(SECTION_BUNS_BUTTON).click();
    }

    @Step("Clicking on Sauce section button")
    public void sectionSaucesClick(){
        driver.findElement(SECTION_SAUCES_BUTTON).click();
    }

    @Step("Clicking on Filling section button")
    public void sectionFillingsClick(){
        driver.findElement(SECTION_FILLINGS_BUTTON).click();
    }
}
