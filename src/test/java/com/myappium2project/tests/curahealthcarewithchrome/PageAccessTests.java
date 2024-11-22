package com.myappium2project.tests.curahealthcarewithchrome;

import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;
import com.myappium2project.utils.AppiumActions;
import com.myappium2project.utils.TestDataFilePaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarewithchrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarewithchrome.HistoryPage;
import com.myappium2project.pages.curahealthcarewithchrome.LoginPage;
import com.myappium2project.pages.curahealthcarewithchrome.ProfilePage;
import com.myappium2project.utils.CommonUtils;

import java.util.List;

public class PageAccessTests extends ChromeBrowserBaseTest {
    private static final Logger LOG = LogManager.getLogger(PageAccessTests.class);
    private static final String TEST_DATA_PATH = TestDataFilePaths.getCuraTestDataPath();

    @Test(priority = 1,
            groups = {"smoke"})
    public void testProfilPageAccessCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(TEST_DATA_PATH);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        AppiumActions.scrollWithFixCoordinates(driver, 1, "UP", 0.5);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressProfileButton();

        LOG.info("We check whether we are on the 'Profile' page");
        ProfilePage profilePage = new ProfilePage(driver);
        boolean isProfilePageLoaded = profilePage.isPageLoaded();
        if (isProfilePageLoaded) {
            LOG.info("We are on the 'Profile' page");
        } else {
            LOG.error("We are not on the 'Profile' page");
        }
        Assert.assertTrue(isProfilePageLoaded, "The 'Profile' page should be loaded, but it is not.");
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testHistoryPageAccessCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(TEST_DATA_PATH);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        AppiumActions.scrollWithFixCoordinates(driver, 1, "UP", 0.5);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressHistoryButton();

        LOG.info("We check whether we are on the 'History' page");
        HistoryPage historyPage = new HistoryPage(driver);
        boolean isHistoryPageLoaded = historyPage.isPageLoaded();
        if (isHistoryPageLoaded) {
            LOG.info("We are on the 'History' page");
        } else {
            LOG.error("We are not on the 'History' page");
        }
        Assert.assertTrue(isHistoryPageLoaded, "The 'History' page should be loaded, but it is not.");
    }
}
