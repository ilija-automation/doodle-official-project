package com.doodle.common.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.doodle.core.web.AutomationWebTestBase;

public class TestBase {

    public static WebDriver driver;
    public static AppManager appManager;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void initialization() throws Exception {
        try {
            MTFProperties.init();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @BeforeClass
    public void initAppManager(ITestContext testContext) throws Exception {
        System.out.println("=== INIT APP MANAGER ===");
        appManager = new AppManager();
        driver = initWebDriver(testContext);
        appManager.setDriver(driver);

        AutomationWebTestBase webTestBase = new AutomationWebTestBase();
        System.out.println("=== Wait for web application to load===");
        webTestBase.automation().settings().setAutomationTestServer();
        System.out.println("=== Done!===");
    }

    public WebDriver initWebDriver(ITestContext testContext) throws Exception {
        WebDriver driver = null;
        String browser = MTFProperties.getBrowser();

        System.out.println("=== WEBDRIVER: local initialization started...");
        driver = initDriver(browser);
        System.out.println("=== WEBDRIVER: local initialization finished");

        return driver;
    }

    @AfterClass
    public void stopAppManager() {
        System.out.println("=== STOP WEBDRIVER");
        driver.quit();
        System.out.println("=== done! ");
    }

    private WebDriver initDriver(String browser) throws Exception {
        WebDriver newDriver = null;

        String path = System.getProperty("user.dir") + "\\windows-drivers";
        String exePath = path + "\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        newDriver = new ChromeDriver();

        newDriver.manage().window().maximize();

        System.out.println("Window size: " + newDriver.manage().window().getSize().toString());

        return newDriver;
    }

}
