package com.doodle.helpers;

import com.doodle.common.core.MTFProperties;
import com.doodle.common.core.TestBase;
import com.doodle.core.web.AutomationWebManager;

public class SettingsHelper extends TestBase {

    public AutomationWebManager automationWebManager;

    public SettingsHelper(AutomationWebManager automationWebManager) {
        this.automationWebManager = automationWebManager;
    }

    public void setAutomationTestServer() throws Exception {
        if(MTFProperties.getServer().equals("int")) {
            driver.get("https://doodle.com/en/");
        }
    }

}
