package com.doodle.pages.createandvote;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.doodle.core.web.AutomationWebManager;

public class AutomationWebPage_VoteOnPoll extends AutomationWebPage_Base {

    public AutomationWebPage_VoteOnPoll(AutomationWebManager automation) throws Exception {
        super(automation);
    }

    @FindBy(xpath = "//h1[contains(., 'Are you a dog person or a cat person?')]")
    private WebElement lbl_are_you_dog_or_cat_person;

    @FindBy(xpath = "//span[@class = 'd-locationName'][contains(., 'To be defined')]")
    private WebElement lbl_to_be_defined;

    @FindBy(xpath = "//div[@class='d-content'][contains(.,'Testing purposes')]")
    private WebElement lbl_testing_purposes;

    @FindBy(xpath = "//div[@class = 'd-text'][contains(., 'Dog')]")
    private WebElement option_dog;

    @FindBy(xpath = "//div[@class = 'd-text'][contains(., 'Cat')]")
    private WebElement option_cat;

    @FindBy(xpath = "//div[@class = 'd-text'][contains(., 'Both')]")
    private WebElement option_both;

    @FindBy(xpath = "//div[@class = 'd-subtext'][contains(., 'None of the above')]")
    private WebElement btn_send_non_of_the_above;

    @FindBy(xpath = "//div[@class = 'd-text'][contains(., 'Send')][not(ancestor::*[contains(@class, 'd-silentButton')])]")
    private WebElement btn_send;

    @FindBy(xpath = "//div[@class='d-premiumHookNag'][contains(.,'You have successfully voted')]")
    private WebElement msg_you_have_successfully_voted;

    @FindBy(xpath = "//div[@class = 'd-text'][contains(., 'Back to poll')]")
    private WebElement link_back_to_poll;

    @FindBy(xpath = "//li[contains(@class, 'd-option')]//li[contains(@class, ' d-yesPreference')]")
    private WebElement checkmark_vote_is_noted;

    public AutomationWebPage_VoteOnPoll isLoadedVoteOnPollPage() {
        wait.until(ExpectedConditions.visibilityOf(lbl_are_you_dog_or_cat_person));

        System.out.println(" ===== The VOTE ON POLL page is DISPLAYED!!! ===== ");

        return this;
    }

    public AutomationWebPage_VoteOnPoll validateInputedInformation() {
        softAssertions.assertThat(extendedDriver.isElementDisplayed(lbl_to_be_defined))
                .as("Label To Be Defined Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(lbl_testing_purposes))
                .as("Label Testing Purposes Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(option_dog))
                .as("Option Dog Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(option_cat))
                .as("Option Cat Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(option_both))
                .as("Option Both Visibility").isEqualTo(true);
        softAssertions.assertThat(extendedDriver.isElementDisplayed(btn_send_non_of_the_above))
                .as("Button Send Non Of The Above Visibility").isEqualTo(true);

        softAssertions.assertAll();

        assertEquals(wait.until(ExpectedConditions.visibilityOf(lbl_are_you_dog_or_cat_person)).getText(), "Are you a dog person or a cat person?");

        System.out.println(" ===== The INPUTED VALUES are VALIDATED!!! ===== ");

        return this;
    }

    public AutomationWebPage_VoteOnPoll selectOptionAndVote() {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class, 'd-noPreference')]"), 3));

        List<WebElement> numberOfCheckboxes = driver.findElements(By.xpath("//div[contains(@class, 'd-noPreference')]//input[contains(@id, 'participantPreference')]"));
        for(int i = 1; i < numberOfCheckboxes.size(); i++) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'd-noPreference')]//*[@class = 'd-checkmark'])[" + i + "]"))).click();
            int NumberOfUncheckedCheckboxes = driver.findElements(By.xpath("//div[contains(@class, 'd-noPreference')]//*[@class = 'd-checkmark']")).size();
            Assert.assertEquals(NumberOfUncheckedCheckboxes, 3 - i);
        }

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'd-yesPreference')]//*[@class = 'd-checkmark'])[2]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(btn_send)).click();

        String messageVoted = wait.until(ExpectedConditions.visibilityOf(msg_you_have_successfully_voted)).getText();

        System.out.println(" ===== '"+ messageVoted.toUpperCase() +"'!!! ===== ");

        return this;
    }

    public AutomationWebPage_VoteOnPoll validateSelectedVote() {
        wait.until(ExpectedConditions.elementToBeClickable(link_back_to_poll)).click();
        wait.until(ExpectedConditions.visibilityOf(checkmark_vote_is_noted));

        String selectedVote = driver.findElement(By.xpath("(//li[contains(@class, 'd-option')]//li[contains(@class, ' d-yesPreference')]//../..//div[@class = 'd-text'])[1]")).getText();
        Assert.assertEquals(selectedVote, "Dog");

        System.out.println(" ===== The User VOTED for '"+ selectedVote.toUpperCase() +"'!!! ===== ");

        return this;
    }
}
