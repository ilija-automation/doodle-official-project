package tests.doodle.createandvote;

import org.testng.annotations.Test;

import com.doodle.core.web.AutomationWebTestBase;

public class CreatePollAndVote extends AutomationWebTestBase {

    @Test(priority = 1)
    public void createPollAndVoteTest() throws Exception {
        automation().pages().homepage().isLoadedHomepagePage()
                .createADoodle();
        automation().pages().whatsTheOccasion().isLoadedWhatsTheOccasionPage()
                .validateWhatsTheOccasionPageContent()
                .fillWhatsTheOccasionPageFields();
        automation().pages().whatAreTheOptions().isLoadedWhatAreTheOptionsPage()
                .validateWhatAreTheOptionsPageContent()
                .addTheOptions();
        automation().pages().poolSettings().isLoadedPollSettingsPage()
                .validatePollSettingsPageContent()
                .verifyCheckboxesFunctionality();
        automation().pages().tellYourParticipantsWhoYouAre().isLoadedTellYourParticipantsWhoYouArePage()
                .validateTellYourParticipantsWhoYouArePageContent()
                .verifyTellYourParticipantsWhoYouAreFunctionality();
        automation().pages().voteOnPoll().isLoadedVoteOnPollPage()
                .validateInputedInformation()
                .selectOptionAndVote()
                .validateSelectedVote();
    }

}
