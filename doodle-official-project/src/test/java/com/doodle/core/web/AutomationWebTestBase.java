package com.doodle.core.web;

import com.doodle.core.AutomationTestBase;

public class AutomationWebTestBase extends AutomationTestBase {

    @Override
    public AutomationWebManager automation() {
        return appManager.getAutomationWebManager();
    }

}
