package com.myappium2project.tests.curahealthcarewithchrome;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataCura;
import com.myappium2project.utils.AppiumActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarewithchrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarewithchrome.HistoryPage;
import com.myappium2project.pages.curahealthcarewithchrome.LoginPage;
import com.myappium2project.pages.curahealthcarewithchrome.ProfilePage;

public class PageAccessTests extends ChromeBrowserBaseTest {

    @Test(priority = 1,
            groups = {"smoke"})
    public void testProfilePageAccessCura() {
        driver.get(TestDataCura.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataCura.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataCura.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        AppiumActions.scrollWithFixCoordinates(driver, 1, "UP", 0.5);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressProfileButton();

        String profilePageName = "Profile";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), profilePageName);
        ProfilePage profilePage = new ProfilePage(driver);
        boolean isProfilePageLoaded = profilePage.isPageLoaded();
        if (isProfilePageLoaded) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), profilePageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), profilePageName);
        }
        Assert.assertTrue(isProfilePageLoaded, CommonTestLogMessages.getPageLoadErrorAssertLog(profilePageName));
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testHistoryPageAccessCura() {
        driver.get(TestDataCura.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataCura.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataCura.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        AppiumActions.scrollWithFixCoordinates(driver, 1, "UP", 0.5);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressHistoryButton();

        String historyPageName = "History";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), historyPageName);
        HistoryPage historyPage = new HistoryPage(driver);
        boolean isHistoryPageLoaded = historyPage.isPageLoaded();
        if (isHistoryPageLoaded) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), historyPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), historyPageName);
        }
        Assert.assertTrue(isHistoryPageLoaded, CommonTestLogMessages.getPageLoadErrorAssertLog(historyPageName));
    }
}