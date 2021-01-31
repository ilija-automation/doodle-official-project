package com.doodle.core;

import com.doodle.common.core.TestBase;

public class AutomationTestBase extends TestBase {

    public AutomationManager automation() {
        return appManager.getAutomationManager();
    }

}
