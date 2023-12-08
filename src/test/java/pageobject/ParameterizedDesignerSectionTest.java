package pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.constants.SectionName;

import static org.junit.Assert.assertEquals;

import static pageobject.constants.SectionName.*;
import static pageobject.constants.TextsMessagesButtons.*;

@RunWith(Parameterized.class)
public class ParameterizedDesignerSectionTest extends BaseTest{

    private final SectionName sectionName;
    private By button;
    private String selected;

    public ParameterizedDesignerSectionTest(SectionName sectionName, By button, String selected){
        this.sectionName = sectionName;
        this.button = button;
        this.selected = selected;
    }

    @Parameterized.Parameters(name = "{index}: sectionName={0}, button={1}, selected={2}")
    public static Object[][] getData(){
        return new Object[][]{
                {BUNS, SECTION_BUNS_BUTTON, SECTION_BUNS_ATTRIBUTE},
                {SAUCES, SECTION_SAUCES_BUTTON, SECTION_SAUCES_ATTRIBUTE},
                {FILLINGS, SECTION_FILLINGS_BUTTON, SECTION_FILLINGS_ATTRIBUTE}
        };
    }

    void chooseSection(SectionName sectionName){
        switch(sectionName){
            case BUNS:
                homePage.sectionSaucesClick();
                homePage.waitForLoadMenuContainerData();
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
        WebElement chosenSection = driver.findElement(button);
        String nameOfTheClass = chosenSection.getAttribute("class");
        assertEquals(selected, nameOfTheClass);
    }
}