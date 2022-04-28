package com.guitarrascustom.stepdefinitions.setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

import static com.google.common.base.StandardSystemProperty.USER_DIR;
import static com.guitarrascustom.util.Log4jValues.LOG4J_LINUX_PROPERTIES_FILE_PATH;
import static com.guitarrascustom.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class SetUp {
    @Managed(options = "--whitelisted-ips=''")
    private WebDriver browser;
    protected static String operativeSystem = System.getProperty("os.name").toLowerCase();

    private void setupBrowser(WebDriver browser) {
        soSystem();
        browser.manage().deleteAllCookies();
        browser.manage().window().maximize();
    }

    private void setupUser(String name, WebDriver browser) {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(name).can(BrowseTheWeb.with(browser));
    }

    protected void actorSetupTheBrowser(String actorName) {
        setUpLog4j2();
        setupBrowser(browser);
        setupUser(actorName, browser);
    }

    private void soSystem() {
        if (operativeSystem.contains("nux")) {
            WebDriverManager.chromedriver().linux().setup();
        } else {
            WebDriverManager.chromedriver().win().setup();
        }
    }

    protected void setUpLog4j2() {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT).substring(0, 3);
        if ("lin".equals(os)) {
            PropertyConfigurator.configure(USER_DIR.value()
                    + LOG4J_LINUX_PROPERTIES_FILE_PATH.getValue());
        } else if ("win".equals(os)) {
            PropertyConfigurator.configure(USER_DIR.value()
                    + LOG4J_PROPERTIES_FILE_PATH.getValue());
        }
    }
}
