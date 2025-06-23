package com.myappium2project.tests.nativeapps.saucelabs;

import com.myappium2project.configdata.models.accounts.SauceLabsAppAccount;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;

import com.myappium2project.pages.nativeapps.saucelabs.HamburgerMenu;
import com.myappium2project.pages.nativeapps.saucelabs.LoginPage;
import com.myappium2project.utils.common.AppiumActions;
import io.appium.java_client.android.AndroidDriver;

/**
 * Common helper methods for SauceLabs App tests.
 * Provides reusable steps such as login and scroll actions.
 */
public class SauceLabsCommonSteps {

    private SauceLabsCommonSteps() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    static void loginToSauceLabs(AndroidDriver driver, HamburgerMenu hamburgerMenu, SauceLabsAppAccount account) throws InterruptedException {
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(account.getEmail(), CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(account.getPassword(), CommonTestLogMessages.VALID_LOG);
        loginPage.pressLoginButton();
    }

    static void logOutToSauceLabs(HamburgerMenu hamburgerMenu, LoginPage loginPage) throws InterruptedException {
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLogOutButton();
        hamburgerMenu.pressLogOutButtonOnLogOutAlert();
        loginPage.pressOkButtonOnSuccessfulLoggedOutAlert();
    }

    static void scrollDown(AndroidDriver driver) {
        AppiumActions.scrollWithFixCoordinates(driver, 1, "DOWN", 0.5);
    }

    static void scrollUp(AndroidDriver driver) {
        AppiumActions.scrollWithFixCoordinates(driver, 1, "UP", 0.5);
    }
}