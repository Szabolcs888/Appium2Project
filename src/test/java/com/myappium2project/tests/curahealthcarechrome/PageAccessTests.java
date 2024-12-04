package com.myappium2project.tests.curahealthcarechrome;

import com.myappium2project.logging.pagelogmessages.CuraPageLogMessages;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataCura;
import com.myappium2project.utils.AppiumActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarechrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarechrome.HistoryPage;
import com.myappium2project.pages.curahealthcarechrome.LoginPage;
import com.myappium2project.pages.curahealthcarechrome.ProfilePage;

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
        loginPage.pressLoginButton();

        AppiumActions.scrollWithFixCoordinates(driver, 1, "UP", 0.5);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressProfileButton();

        String profilePageName = "Profile";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, profilePageName);
        ProfilePage profilePage = new ProfilePage(driver);
        boolean isProfilePageLoaded = profilePage.isPageLoaded();
        if (isProfilePageLoaded) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, profilePageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, profilePageName);
        }
        Assert.assertTrue(isProfilePageLoaded, CuraPageLogMessages.getPageLoadValidationAssertLog(profilePageName));
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
        loginPage.pressLoginButton();

        AppiumActions.scrollWithFixCoordinates(driver, 1, "UP", 0.5);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressHistoryButton();

        String historyPageName = "History";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, historyPageName);
        HistoryPage historyPage = new HistoryPage(driver);
        boolean isHistoryPageLoaded = historyPage.isPageLoaded();
        if (isHistoryPageLoaded) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, historyPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, historyPageName);
        }
        Assert.assertTrue(isHistoryPageLoaded, CuraPageLogMessages.getPageLoadValidationAssertLog(historyPageName));
    }
}