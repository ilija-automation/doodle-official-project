package com.doodle.common.core;

import org.openqa.selenium.WebDriver;

import com.doodle.core.AutomationManager;
import com.doodle.core.web.AutomationWebManager;

public class AppManager {

    private WebDriver driver;
    private AutomationManager automationManager;
    private AutomationWebManager automationWebManager;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() throws Exception {
        return driver;
    }

    public AutomationManager getAutomationManager() {
        if(automationManager == null) {
            automationManager = new AutomationManager(this);
        }

        return automationManager;
    }

    public AutomationWebManager getAutomationWebManager() {
        if(automationWebManager == null) {
            automationWebManager = new AutomationWebManager(this);
        }

        return automationWebManager;
    }

}
