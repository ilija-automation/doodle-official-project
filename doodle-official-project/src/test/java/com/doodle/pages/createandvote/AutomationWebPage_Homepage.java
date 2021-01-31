package com.doodle.pages.createandvote;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.doodle.core.web.AutomationWebManager;

public class AutomationWebPage_Homepage extends AutomationWebPage_Base {

    public AutomationWebPage_Homepage(AutomationWebManager automation) throws Exception {
        super(automation);
    }

    @FindBy(xpath = "//button[contains(., 'Create a Doodle')]")
    private WebElement btn_create_a_doodle;

    @FindBy(xpath = "//div[@class = 'd-loadingScreen'][not(contains(@style, 'display: none'))]")
    private WebElement loadig_screen;

    public AutomationWebPage_Homepage isLoadedHomepagePage() {
        wait.until(ExpectedConditions.visibilityOf(btn_create_a_doodle));

        System.out.println(" ===== The HOMEPAGE page is DISPLAYED!!! ===== ");

        return this;
    }

    public AutomationWebPage_Homepage createADoodle() {
        wait.until(ExpectedConditions.visibilityOf(btn_create_a_doodle)).click();

        System.out.println(" ===== CREATE A DOODLE flow is STARTED!!! ===== ");

        return this;
    }

}
