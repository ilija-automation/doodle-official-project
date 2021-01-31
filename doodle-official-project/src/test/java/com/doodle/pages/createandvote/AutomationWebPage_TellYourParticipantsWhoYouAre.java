package com.doodle.pages.createandvote;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.doodle.core.web.AutomationWebManager;

public class AutomationWebPage_TellYourParticipantsWhoYouAre extends AutomationWebPage_Base {

    public AutomationWebPage_TellYourParticipantsWhoYouAre(AutomationWebManager automation) throws Exception {
        super(automation);
    }

    @FindBy(xpath = "//h2[contains(., 'Tell your participants who you are')]")
    private WebElement title_tell_your_participants_who_you_are;

    @FindBy(xpath = "//h1[contains(., 'Step 4 of 4')]")
    private WebElement lbl_4_of_4;

    @FindBy(id = "d-initiatorName")
    private WebElement field_name;

    @FindBy(id = "d-initiatorEmail")
    private WebElement field_email;

    @FindBy(xpath = "//div[@class = 'd-text'][contains(., 'Finish')]")
    private WebElement btn_finish;

    public AutomationWebPage_TellYourParticipantsWhoYouAre isLoadedTellYourParticipantsWhoYouArePage() {
        wait.until(ExpectedConditions.visibilityOf(title_tell_your_participants_who_you_are));

        System.out.println(" ===== The TELL YOUR PARTICIPANTS WHO YOU ARE page is DISPLAYED!!! ===== ");

        return this;
    }

    public AutomationWebPage_TellYourParticipantsWhoYouAre validateTellYourParticipantsWhoYouArePageContent() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(lbl_4_of_4));
        wait.until(ExpectedConditions.visibilityOf(field_name));

        softAssertions.assertThat(extendedDriver.isElementDisplayed(logo_doodle))
                .as("Logo Doodle Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_english))
                .as("Button English Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_sign_up))
                .as("Button Sign Up Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_log_in))
                .as("Button Log In Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_back))
                .as("Button Back Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(field_email))
                .as("Field Email Visibility").isEqualTo(true);

        softAssertions.assertAll();

        wait.until(ExpectedConditions.visibilityOf(btn_finish));

        System.out.println(" ===== The TELL YOUR PARTICIPANTS WHO YOU ARE page is VALIDATED!!! ===== ");

        return this;
    }

    public AutomationWebPage_TellYourParticipantsWhoYouAre verifyTellYourParticipantsWhoYouAreFunctionality() throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(btn_finish)).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class,'d-errorMessage')][contains(., 'Value missing')]"), 2));

        typeValueIntoElementField(field_name, "Test Testerovic");
        typeValueIntoElementField(field_email, "testerovic12@yopmail.com");

        wait.until(ExpectedConditions.elementToBeClickable(btn_finish)).click();

        System.out.println(" ===== The TELL YOUR PARTICIPANTS WHO YOU ARE page funtionality is VERIFIED!!! ===== ");

        return this;

    }

}
