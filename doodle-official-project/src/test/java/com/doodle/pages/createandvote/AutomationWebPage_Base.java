package com.doodle.pages.createandvote;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.doodle.common.core.WebPageBase;
import com.doodle.core.web.AutomationWebManager;

public class AutomationWebPage_Base extends WebPageBase {

    public AutomationWebPage_Base(AutomationWebManager automation) throws Exception {
        super(automation.appManager());
        this.automation = automation;
    }

    public AutomationWebManager automation;

    protected SoftAssertions softAssertions = new SoftAssertions();

    @FindBy(xpath = "//a[@class = 'd-logo'][not(ancestor::*[contains(@class, 'd-hideView')])]")
    protected WebElement logo_doodle;

    @FindBy(xpath = "//div[@class='d-activePage']//div[@class='d-fullHeader']//button[contains(.,'Sign up')]")
    protected WebElement btn_sign_up;

    @FindBy(xpath = "//div[@class='d-activePage']//div[@class='d-fullHeader']//button[contains(.,'Log in')]")
    protected WebElement btn_log_in;

    @FindBy(xpath = "//div[@class='d-activePage']//div[@class='d-fullHeader']//button[contains(.,'English')]")
    protected WebElement btn_english;

    @FindBy(xpath = "//div[@class='d-actionButtons']/button[contains(.,'Continue')][not(ancestor::*[contains(@class, 'd-hideView')])]")
    protected WebElement btn_continue;

    @FindBy(xpath = "//button[contains(@aria-label, 'Back to step')][not(ancestor::*[contains(@class, 'd-hideView')])]")
    protected WebElement btn_back;

    protected void typeValueIntoElementField(WebElement element, String value) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        element.clear();
        for(int i = 0; i < value.length(); i++) {
            char character = value.charAt(i);
            String currentString = new StringBuilder().append(character).toString();
            element.sendKeys(currentString);
        }
    }

}
