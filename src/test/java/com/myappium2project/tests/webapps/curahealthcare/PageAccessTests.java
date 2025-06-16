package com.myappium2project.tests.webapps.curahealthcare;

import com.myappium2project.configdata.models.accounts.CuraHealthcareAccount;
import com.myappium2project.configdata.providers.accounts.CuraHealthcareAccountProvider;
import com.myappium2project.tests.basetests.BrowserTestBase;
import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.common.AppiumActions;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import com.myappium2project.pages.webapps.curahealthcare.HamburgerMenu;
import com.myappium2project.pages.webapps.curahealthcare.HistoryPage;
import com.myappium2project.pages.webapps.curahealthcare.ProfilePage;

public class PageAccessTests extends BrowserTestBase {
    private static final CuraHealthcareAccount CURA_ACC1 = CuraHealthcareAccountProvider.getAccount(0);

    @Test(priority = 1,
            groups = {TestGroups.SMOKE})
    public void testProfilePageAccess() {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        CuraCommonSteps.loginToCura(driver, hamburgerMenu, CURA_ACC1);
        scrollUp(driver);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressProfileButton();

        String profilePageName = "Profile";
        ProfilePage profilePage = new ProfilePage(driver);
        boolean isProfilePageLoaded = profilePage.isPageLoaded();
        CuraCommonAssertions.verifyPageLoaded(isProfilePageLoaded, profilePageName);
    }

    @Test(priority = 2,
            groups = {TestGroups.SMOKE})
    public void testHistoryPageAccess() {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        CuraCommonSteps.loginToCura(driver, hamburgerMenu, CURA_ACC1);
        scrollUp(driver);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressHistoryButton();

        String historyPageName = "History";
        HistoryPage historyPage = new HistoryPage(driver);
        boolean isHistoryPageLoaded = historyPage.isPageLoaded();
        CuraCommonAssertions.verifyPageLoaded(isHistoryPageLoaded, historyPageName);
    }

    private void scrollUp(AndroidDriver driver) {
        AppiumActions.scrollWithFixCoordinates(driver, 1, "UP", 0.5);
    }
}