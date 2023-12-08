package pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import pageobject.constants.SectionName;

import static org.junit.Assert.assertEquals;

import static pageobject.constants.SectionName.*;
import static pageobject.constants.TextsMessagesButtons.*;

@RunWith(Parameterized.class)
public class ParameterizedDesignerSectionTest extends BaseTest{

    private final SectionName sectionName;
    private By button;
    private String sectionText;

    public ParameterizedDesignerSectionTest(SectionName sectionName, By button, String sectionText){
        this.sectionName = sectionName;
        this.button = button;
        this.sectionText = sectionText;
    }

    @Parameterized.Parameters(name = "{index}: sectionName={0}, button={1}, sectionText={2}")
    public static Object[][] getData(){
        return new Object[][]{
                {BUNS, SECTION_BUNS_BUTTON, "Булки"},
                {SAUCES, SECTION_SAUCES_BUTTON, "Соусы"},
                {FILLINGS, SECTION_FILLINGS_BUTTON, "Начинки"}
        };
    }

    void chooseSection(SectionName sectionName){
        switch(sectionName){
            case BUNS:
                homePage.sectionFillingsClick();
                homePage.sectionBunsClick();
                break;
            case SAUCES:
                homePage.sectionSaucesClick();
                break;
            case FILLINGS:
                homePage.sectionFillingsClick();
                break;
        }
    }

    @Test
    @DisplayName("Test for clicking on section")
    @Description("Possibility click on all three sections")
    public void parametrizationDesignerTest(){
        homePage.waitForLoadMainPageData();
        chooseSection(sectionName);
        String chosenSection = driver.findElement(button).getText();
        assertEquals(chosenSection, sectionText);
    }
}