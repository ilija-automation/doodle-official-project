package com.doodle.helpers.web;

import com.doodle.core.web.AutomationWebManager;
import com.doodle.pages.createandvote.AutomationWebPage_Base;
import com.doodle.pages.createandvote.AutomationWebPage_Homepage;
import com.doodle.pages.createandvote.AutomationWebPage_PollSettings;
import com.doodle.pages.createandvote.AutomationWebPage_TellYourParticipantsWhoYouAre;
import com.doodle.pages.createandvote.AutomationWebPage_VoteOnPoll;
import com.doodle.pages.createandvote.AutomationWebPage_WhatAreTheOptions;
import com.doodle.pages.createandvote.AutomationWebPage_WhatsTheOccasion;

public class AutomationWebPagesHelper {

    private final AutomationWebManager automation;
    private AutomationWebPage_Base base;
    private AutomationWebPage_Homepage homepage;
    private AutomationWebPage_PollSettings poolSettings;
    private AutomationWebPage_TellYourParticipantsWhoYouAre tellYourParticipantsWhoYouAre;
    private AutomationWebPage_WhatAreTheOptions whatAreTheOptions;
    private AutomationWebPage_WhatsTheOccasion whatsTheOccasion;
    private AutomationWebPage_VoteOnPoll voteOnPoll;

    public AutomationWebPagesHelper(AutomationWebManager automation) {
        this.automation = automation;
    }

    public AutomationWebPage_Base base() throws Exception {
        if(base == null) {
            base = new AutomationWebPage_Base(automation);
        }

        return base;
    }

    public AutomationWebPage_Homepage homepage() throws Exception {
        if(homepage == null) {
            homepage = new AutomationWebPage_Homepage(automation);
        }

        return homepage;
    }

    public AutomationWebPage_PollSettings poolSettings() throws Exception {
        if(poolSettings == null) {
            poolSettings = new AutomationWebPage_PollSettings(automation);
        }

        return poolSettings;
    }

    public AutomationWebPage_TellYourParticipantsWhoYouAre tellYourParticipantsWhoYouAre() throws Exception {
        if(tellYourParticipantsWhoYouAre == null) {
            tellYourParticipantsWhoYouAre = new AutomationWebPage_TellYourParticipantsWhoYouAre(automation);
        }

        return tellYourParticipantsWhoYouAre;
    }

    public AutomationWebPage_WhatAreTheOptions whatAreTheOptions() throws Exception {
        if(whatAreTheOptions == null) {
            whatAreTheOptions = new AutomationWebPage_WhatAreTheOptions(automation);
        }

        return whatAreTheOptions;
    }

    public AutomationWebPage_WhatsTheOccasion whatsTheOccasion() throws Exception {
        if(whatsTheOccasion == null) {
            whatsTheOccasion = new AutomationWebPage_WhatsTheOccasion(automation);
        }

        return whatsTheOccasion;
    }

    public AutomationWebPage_VoteOnPoll voteOnPoll() throws Exception {
        if(voteOnPoll == null) {
            voteOnPoll = new AutomationWebPage_VoteOnPoll(automation);
        }

        return voteOnPoll;
    }

}
