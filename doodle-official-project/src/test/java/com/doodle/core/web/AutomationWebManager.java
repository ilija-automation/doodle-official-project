package com.doodle.core.web;

import com.doodle.common.core.AppManager;
import com.doodle.core.AutomationManager;
import com.doodle.helpers.SettingsHelper;
import com.doodle.helpers.web.AutomationWebPagesHelper;

public class AutomationWebManager extends AutomationManager {

    private AutomationWebPagesHelper pages;
    private SettingsHelper settings;

    public AutomationWebManager(AppManager app) {
        super(app);
    }

    public AutomationWebPagesHelper pages() throws Exception {
        if(pages == null) {
            pages = new AutomationWebPagesHelper(this);
        }

        return pages;
    }

    public SettingsHelper settings() throws Exception {
        if(settings == null) {
            settings = new SettingsHelper(this);
        }

        return settings;
    }

}
