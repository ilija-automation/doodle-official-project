package com.doodle.pages.createandvote;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.doodle.core.web.AutomationWebManager;

public class AutomationWebPage_WhatAreTheOptions extends AutomationWebPage_Base {

    public AutomationWebPage_WhatAreTheOptions(AutomationWebManager automation) throws Exception {
        super(automation);
    }

    @FindBy(xpath = "//h2[contains(., 'What are the options?')]")
    private WebElement title_what_are_the_options;

    @FindBy(xpath = "//h1[contains(., 'Step 2 of 4')]")
    private WebElement lbl_2_of_4;

    @FindBy(xpath = "//a[@href = '#text']")
    private WebElement link_text;

    @FindBy(xpath = "//a[@href = '#week']")
    private WebElement link_week;

    @FindBy(xpath = "//a[@href = '#month']")
    private WebElement link_month;

    @FindBy(id = "d-wizardChoicesView0")
    private WebElement field_first_add_option;

    @FindBy(id = "d-wizardChoicesView1")
    private WebElement field_second_add_option;

    @FindBy(id = "d-wizardChoicesView2")
    private WebElement field_third_add_option;

    public AutomationWebPage_WhatAreTheOptions isLoadedWhatAreTheOptionsPage() {
        wait.until(ExpectedConditions.visibilityOf(title_what_are_the_options));

        System.out.println(" ===== The WHAT ARE THE OPTIONS page is DISPLAYED!!! ===== ");

        return this;
    }

    public AutomationWebPage_WhatAreTheOptions validateWhatAreTheOptionsPageContent() {
        wait.until(ExpectedConditions.elementToBeClickable(link_text)).click();
        wait.until(ExpectedConditions.visibilityOf(field_first_add_option));

        softAssertions.assertThat(extendedDriver.isElementDisplayed(logo_doodle))
                .as("Logo Doodle Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_english))
                .as("Button English Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_sign_up))
                .as("Button Sign In Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_log_in))
                .as("Button Log In Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(lbl_2_of_4))
                .as("Label 2 of 4 Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(link_week))
                .as("Link Week Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(link_month))
                .as("Link Month Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(field_second_add_option))
                .as("Field Second Add Option Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_back))
                .as("Button Back Visibility").isEqualTo(true);

        softAssertions.assertAll();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//button[contains(@aria-label, 'Remove option')]"), 2));

        WebElement buttonContinue = driver.findElement(By.xpath("//div[@class='d-actionButtons']/button[contains(.,'Continue')][not(ancestor::*[contains(@class, 'd-hideView')])]"));
        assertEquals(buttonContinue.isEnabled(), false);

        System.out.println(" ===== The WHAT ARE THE OPTIONS page is VALIDATED!!! ===== ");

        return this;
    }

    public AutomationWebPage_WhatAreTheOptions addTheOptions() {
        typeValueIntoElementField(field_first_add_option, "Dog");
        typeValueIntoElementField(field_second_add_option, "Cat");

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//button[contains(@aria-label, 'Remove option')]"), 3));

        typeValueIntoElementField(field_third_add_option, "Both");

        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//button[contains(@aria-label, 'Remove option')]"), 4));

        WebElement button = driver.findElement(By.xpath("//div[@class='d-actionButtons']/button[contains(.,'Continue')][not(ancestor::*[contains(@class, 'd-hideView')])]"));
        assertEquals(button.isEnabled(), true);

        wait.until(ExpectedConditions.elementToBeClickable(btn_continue)).click();

        System.out.println(" ===== The OPTIONS Are ADDED!!! ===== ");

        return this;
    }

}
