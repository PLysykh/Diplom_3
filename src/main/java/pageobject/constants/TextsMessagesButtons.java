package pageobject.constants;

import org.openqa.selenium.By;

public class TextsMessagesButtons {

    //URLS
    public static final String HOME_PAGE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final String FORGOT_PASSWORD_PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final String PROFILE_PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    //BUTTONS
    public static final By PERSONAL_CABINET_BUTTON = By.cssSelector("[href = '/account']");
    public static final By ENTER_ACCOUNT_ON_MAIN_PAGE_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By REGISTER_ON_LOGIN_PAGE_BUTTON = By.cssSelector("[href='/register']");
    public static final By DESIGNER_BUTTON = By.xpath(".//*[text()='Конструктор']");
    public static final By LOGO_BUTTON = By.xpath(".//*[contains(@class, 'header__logo')]");
    public static final By LOGOUT_BUTTON = By.xpath("//*[contains(text(), 'Выход')]");
    public static final By SECTION_BUNS_BUTTON = By.xpath("//*[text()='Булки']//parent::div[contains(@class, 'tab_tab')]");
    public static final By SECTION_SAUCES_BUTTON = By.xpath("//*[text()='Соусы']//parent::div[contains(@class, 'tab_tab')]");
    public static final By SECTION_FILLINGS_BUTTON = By.xpath("//*[text()='Начинки']//parent::div[contains(@class, 'tab_tab')]");
    public static final By AUTHORIZE_BUTTON = By.xpath(".//button[contains(text(), 'Войти')]");

    //TEXTS
    public static final String WRONG_PASSWORD_ERROR_TEXT = "Некорректный пароль";
    public static final By WRONG_PASSWORD_TEXT_SIGN = By.xpath(".//*[text() = 'Некорректный пароль']");
    public static final By LOGIN_PAGE_TEXT = By.xpath(".//h2[text() = 'Вход']");

    //DATA
    public static final String NAME = "Robert";
    public static final String EMAIL = "oppenheimer@yandex.ru";
    public static final String PASSWORD = "QAtest123";
    public static final String WRONG_PASSWORD = "QAte";
}