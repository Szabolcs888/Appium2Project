package com.myappium2project.tests.curahealthcarechrome;

import com.myappium2project.logging.pagelogmessages.CuraPageLogMessages;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.tests.basetests.ChromeBrowserTestBase;
import com.myappium2project.testsdata.CuraHealthcareData;
import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.AppiumActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarechrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarechrome.HistoryPage;
import com.myappium2project.pages.curahealthcarechrome.LoginPage;
import com.myappium2project.pages.curahealthcarechrome.ProfilePage;

public class PageAccessTests extends ChromeBrowserTestBase {

    @Test(priority = 1,
            groups = {TestGroups.SMOKE})
    public void testProfilePageAccessCura() {
        driver.get(CuraHealthcareData.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(CuraHealthcareData.VALID_USERNAME_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(CuraHealthcareData.VALID_PASSWORD_ACC1, CommonTestLogMessages.VALID_LOG);
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
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, profilePageName);
        }
        Assert.assertTrue(isProfilePageLoaded, CuraPageLogMessages.pageNotLoadAssertLog(profilePageName));
    }

    @Test(priority = 2,
            groups = {TestGroups.SMOKE})
    public void testHistoryPageAccessCura() {
        driver.get(CuraHealthcareData.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(CuraHealthcareData.VALID_USERNAME_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(CuraHealthcareData.VALID_PASSWORD_ACC1, CommonTestLogMessages.VALID_LOG);
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
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, historyPageName);
        }
        Assert.assertTrue(isHistoryPageLoaded, CuraPageLogMessages.pageNotLoadAssertLog(historyPageName));
    }
}