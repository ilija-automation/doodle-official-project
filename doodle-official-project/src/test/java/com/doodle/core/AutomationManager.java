package com.doodle.core;

import org.openqa.selenium.WebDriver;

import com.doodle.common.core.AppManager;

public class AutomationManager {

    protected AppManager app;

    public AutomationManager(AppManager app) {
        this.app = app;
    }

    public AppManager appManager() {
        return app;
    }

    public WebDriver driver() throws Exception {
        return app.getDriver();
    }

}
