package com.myappium2project.tests.webapps.curahealthcare;

import com.myappium2project.configdata.configpaths.AppConfig;
import com.myappium2project.configdata.models.accounts.CuraHealthcareAccount;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.pages.webapps.curahealthcare.HamburgerMenu;
import com.myappium2project.pages.webapps.curahealthcare.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class providing common reusable steps for the CURA Healthcare tests.
 * Currently includes login functionality using given credentials.
 */
public final class CuraCommonSteps {
    private static final Logger LOG = LoggerFactory.getLogger(CuraCommonSteps.class);

    private CuraCommonSteps() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    static void loginToCura(AndroidDriver driver, HamburgerMenu hamburgerMenu, CuraHealthcareAccount account) {
        driver.get(AppConfig.CURA_BASE_URL);
        LOG.info("We navigate to CURA base URL: {}", AppConfig.CURA_BASE_URL);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(account.getUsername(), CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(account.getPassword(), CommonTestLogMessages.VALID_LOG);
        loginPage.pressLoginButton();
    }
}