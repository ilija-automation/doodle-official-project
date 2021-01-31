package com.doodle.pages.createandvote;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.doodle.core.web.AutomationWebManager;

public class AutomationWebPage_PollSettings extends AutomationWebPage_Base {

    public AutomationWebPage_PollSettings(AutomationWebManager automation) throws Exception {
        super(automation);
    }

    @FindBy(xpath = "//h2[contains(., 'Poll settings')]")
    private WebElement title_pool_settings;

    @FindBy(xpath = "//h2[contains(., 'Poll settings')]")
    private WebElement lbl_3_of_4;

    @FindBy(xpath = "//h2[contains(., 'Poll settings')]")
    private WebElement link_premium_account;

    @FindBy(xpath = "//label[@id = 'd-ifneedbeCheckboxContainer']//span[@class = 'd-action']")
    private WebElement cbox_if_need_be;

    @FindBy(xpath = "//label[@id = 'd-columnConstraintCheckboxContainer']//span[@class = 'd-action']")
    private WebElement cbox_limit_the_number;

    @FindBy(xpath = "//label[@id = 'd-rowConstraintCheckboxContainer']//span[@class = 'd-action']")
    private WebElement cbox_limit_to_single_vote;

    @FindBy(xpath = "//label[@id = 'd-hiddenCheckboxContainer']//span[@class = 'd-action']")
    private WebElement cbox_hidden_poll;

    @FindBy(xpath = "//*[name()='use'][contains(@*, 'hourglass')]")
    private WebElement icon_hourglass;

    @FindBy(xpath = "//*[name()='use'][contains(@*, 'questionmark')]")
    private WebElement icon_questionmark;

    @FindBy(xpath = "//*[name()='use'][contains(@*, 'cross')]")
    private WebElement icon_cross;

    @FindBy(id = "d-columnConstraintInput")
    private WebElement field_votes_per_option;

    public AutomationWebPage_PollSettings isLoadedPollSettingsPage() {
        wait.until(ExpectedConditions.visibilityOf(title_pool_settings));

        System.out.println(" ===== The POLL SETTINGS page is DISPLAYED!!! ===== ");

        return this;
    }

    public AutomationWebPage_PollSettings validatePollSettingsPageContent() throws Exception {
        wait.until(ExpectedConditions.visibilityOf(lbl_3_of_4));
        wait.until(ExpectedConditions.elementToBeClickable(cbox_if_need_be));

        softAssertions.assertThat(extendedDriver.isElementDisplayed(logo_doodle))
                .as("Logo Doodle Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_english))
                .as("Button English Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_sign_up))
                .as("Button Sign Up Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_log_in))
                .as("Button Log In Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(cbox_limit_the_number))
                .as("Checkbox Limit The Number Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(cbox_limit_to_single_vote))
                .as("Checkbox Limit To Single Vote Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(cbox_hidden_poll))
                .as("Checkbox Hidden Poll Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_back))
                .as("Button Back Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(link_premium_account))
                .as("Link Premium Account Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(icon_hourglass))
                .as("Icon Hourglass Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(icon_questionmark))
                .as("Icon Questionmark Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(icon_cross))
                .as("Icon Cross Visibility").isEqualTo(true);

        softAssertions.assertAll();

        WebElement buttonContinue = driver.findElement(By.xpath("//div[@class='d-actionButtons']/button[contains(.,'Continue')][not(ancestor::*[contains(@class, 'd-hideView')])]"));
        assertEquals(buttonContinue.isEnabled(), true);

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//*[name()='use'][contains(@*, 'mail')]"), 2));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class, 'disabled')]"), 9));

        System.out.println(" ===== The POLL SETTINGS page is DISPLAYED!!! ===== ");

        return this;
    }

    public AutomationWebPage_PollSettings verifyCheckboxesFunctionality() throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(cbox_limit_to_single_vote)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cbox_limit_the_number)).click();

        wait.until(ExpectedConditions.elementToBeClickable(field_votes_per_option)).clear();
        typeValueIntoElementField(field_votes_per_option, "5");

        wait.until(ExpectedConditions.elementToBeClickable(cbox_if_need_be)).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("input#d-columnConstraintCheckbox[disabled='disabled']"), 1));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("input#d-rowConstraintCheckbox[disabled='disabled']"), 1));

        wait.until(ExpectedConditions.elementToBeClickable(cbox_if_need_be)).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("input#d-columnConstraintCheckbox[disabled='disabled']"), 0));
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("input#d-rowConstraintCheckbox[disabled='disabled']"), 0));

        wait.until(ExpectedConditions.elementToBeClickable(btn_continue)).click();

        System.out.println(" ===== CHECKBOXES funcionality is VERIFIED!!! ===== ");

        return this;

    }
}
