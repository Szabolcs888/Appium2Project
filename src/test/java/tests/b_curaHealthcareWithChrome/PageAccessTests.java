package tests.b_curaHealthcareWithChrome;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.b_curaHealthcareWithChrome.HamburgerMenu;
import pages.b_curaHealthcareWithChrome.HistoryPage;
import pages.b_curaHealthcareWithChrome.LoginPage;
import pages.b_curaHealthcareWithChrome.ProfilePage;
import tests._baseTests.ChromeBrowserBaseTest;
import utils.AppiumActions;
import utils.CommonUtils;

import java.util.List;

@Listeners(TestListener.class)
public class PageAccessTests extends ChromeBrowserBaseTest {
    private static final Logger log = LogManager.getLogger(PageAccessTests.class);
    private static final String testDataPath = "src/test/resources/testData/CuraHealthcareCredentials.txt";

    @Test(priority = 1,
            groups = {"smoke"})
    public void testProfilPageAccessCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        AppiumActions appiumActions = new AppiumActions();
        appiumActions.scrollWithFixCoordinates(driver, 1, "UP", 0.5);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressProfileButton();

        log.info("We check whether we are on the 'Profile' page");
        ProfilePage profilePage = new ProfilePage(driver);
        boolean isProfilePageLoaded = profilePage.isPageLoaded();
        if (isProfilePageLoaded) {
            log.info("We are on the 'Profile' page");
        } else {
            log.error("We are not on the 'Profile' page");
        }
        Assert.assertTrue(isProfilePageLoaded);
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testHistoryPageAccessCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        AppiumActions appiumActions = new AppiumActions();
        appiumActions.scrollWithFixCoordinates(driver, 1, "UP", 0.5);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressHistoryButton();

        log.info("We check whether we are on the 'History' page");
        HistoryPage historyPage = new HistoryPage(driver);
        boolean isHistoryPageLoaded = historyPage.isPageLoaded();
        if (isHistoryPageLoaded) {
            log.info("We are on the 'History' page");
        } else {
            log.error("We are not on the 'History' page");
        }
        Assert.assertTrue(isHistoryPageLoaded);
    }
}
