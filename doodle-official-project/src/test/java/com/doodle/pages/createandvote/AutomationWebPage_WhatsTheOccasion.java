package com.doodle.pages.createandvote;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.doodle.core.web.AutomationWebManager;

public class AutomationWebPage_WhatsTheOccasion extends AutomationWebPage_Base {

    public AutomationWebPage_WhatsTheOccasion(AutomationWebManager automation) throws Exception {
        super(automation);
    }

    @FindBy(xpath = "//h2[contains(., 'What’s the occasion?')]")
    private WebElement title_whats_the_occation;

    @FindBy(xpath = "//h1[contains(., 'Step 1 of 4')]")
    private WebElement lbl_1_of_4;

    @FindBy(id = "d-pollTitle")
    private WebElement field_enter_title;

    @FindBy(id = "d-pollLocation")
    private WebElement field_add_location;

    @FindBy(xpath = "//span[contains(., 'To be defined')]")
    private WebElement option_to_be_defined;

    @FindBy(id = "d-pollDescription")
    private WebElement field_add_note;

    @FindBy(xpath = "//*[name()='use'][contains(@*, 'short_text')]")
    private WebElement icon_enter_title;

    @FindBy(xpath = "//*[name()='use'][contains(@*, 'room')]")
    private WebElement icon_add_location;

    @FindBy(xpath = "//*[name()='use'][contains(@*, 'subject')]")
    private WebElement icon_add_note;

    public AutomationWebPage_WhatsTheOccasion isLoadedWhatsTheOccasionPage () {
        wait.until(ExpectedConditions.visibilityOf(title_whats_the_occation));

        System.out.println(" ===== The WHAT'S THE OCCASION page is DISPLAYED!!! ===== ");

        return this;
    }

    public AutomationWebPage_WhatsTheOccasion validateWhatsTheOccasionPageContent() {
        wait.until(ExpectedConditions.visibilityOf(lbl_1_of_4));
        wait.until(ExpectedConditions.visibilityOf(field_add_location));

        softAssertions.assertThat(extendedDriver.isElementDisplayed(logo_doodle))
                .as("Logo Doodle Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_english))
                .as("Button English Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_sign_up))
                .as("Button Sign In Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_log_in))
                .as("Button Log In Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(field_enter_title))
                .as("Field Enter Title Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(field_add_note))
                .as("Field Add Note Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(icon_enter_title))
                .as("Icon Enter Title Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(icon_add_location))
                .as("Icon Add Location Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(icon_add_note))
                .as("Icon Add Note Visibility").isEqualTo(true);

        softAssertions.assertAll();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class = 'd-optionalFlag'][contains(., 'optional')]"), 2));

        WebElement buttonContinue = driver.findElement(By.xpath("//div[@class='d-actionButtons']/button[contains(.,'Continue')][not(ancestor::*[contains(@class, 'd-hideView')])]"));
        assertEquals(buttonContinue.isEnabled(), false);

        System.out.println(" ===== The WHAT'S THE OCCASION page content is VALIDATED!!! ===== ");

        return this;
    }

    public AutomationWebPage_WhatsTheOccasion fillWhatsTheOccasionPageFields () {
        typeValueIntoElementField(field_enter_title, "Are you a dog person or a cat person?");
        typeValueIntoElementField(field_add_note, "Testing purposes");
        wait.until(ExpectedConditions.elementToBeClickable(field_add_location)).click();
        wait.until(ExpectedConditions.elementToBeClickable(option_to_be_defined)).click();

        WebElement buttonContinue = driver.findElement(By.xpath("//div[@class='d-actionButtons']/button[contains(.,'Continue')][not(ancestor::*[contains(@class, 'd-hideView')])]"));
        assertEquals(buttonContinue.isEnabled(), true);

        wait.until(ExpectedConditions.elementToBeClickable(btn_continue)).click();

        System.out.println(" ===== The WHAT'S THE OCCASION page is successfuly FILLED!!! ===== ");

        return this;
    }

}
