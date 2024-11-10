package tests.c_batteryAlarmApk;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.c_batteryAlarmApk.InformationPage;
import pages.c_batteryAlarmApk.LanguagesDropdownMenu;
import pages.c_batteryAlarmApk.MainPage;
import tests._baseTests.BatteryAlarmBaseTest;
import utils.AppiumActions;

@Listeners(TestListener.class)
public class PageAccessTests extends BatteryAlarmBaseTest {
    private static final Logger log = LogManager.getLogger(PageAccessTests.class);

    @Test(priority = 1,
            groups = {"smoke"})
    public void testMainPageAccess() {
        MainPage mainPage = new MainPage(driver);
        if (!mainPage.getSelectedLanguage().equals("English")) {
            LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
            languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            AppiumActions appiumActions = new AppiumActions();
            appiumActions.scrollWithFreeCoordinates(driver, 2, 112, 700, 112, 1900, "We scroll up in the dropdown menu");
            languagesDropdownMenu.chooseEnglishOption();
        }

        log.info("We check whether we are on the 'Main' page");
        String voiceWarningText = mainPage.getVoiceWarningEnglishText();
        String chooseASoundText = mainPage.getChooseASoundText();
        String expectedVoiceWarningText = "Voice Warning";
        String expectedChooseASoundText = "Choose a sound";
        if (voiceWarningText.equals(expectedVoiceWarningText) && chooseASoundText.equals(expectedChooseASoundText)) {
            log.info("We are on the 'Main' page");
        } else {
            log.error("We are not on the 'Main' page");
        }
        Assert.assertEquals(voiceWarningText, expectedVoiceWarningText, "The voice warning text should be '" + expectedVoiceWarningText + "', but it is '" + voiceWarningText + "'.");
        Assert.assertEquals(chooseASoundText, expectedChooseASoundText, "The 'Choose a sound' text should be '" + expectedChooseASoundText + "', but it is '" + chooseASoundText + "'.");
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testInformationPageAccess() {
        MainPage mainPage = new MainPage(driver);
        if (!mainPage.getSelectedLanguage().equals("English")) {
            LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
            languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            AppiumActions appiumActions = new AppiumActions();
            appiumActions.scrollWithFreeCoordinates(driver, 2, 112, 700, 112, 1900, "We scroll up in the dropdown menu");
            languagesDropdownMenu.chooseEnglishOption();
        }

        mainPage.pressInformationButton();

        log.info("We check whether we are on the 'Information' page");
        InformationPage informationPage = new InformationPage(driver);
        String informationText = informationPage.getInformationText();
        String expectedTextFragment = "In order to avoid issue, find the power";
        if (informationText.contains(expectedTextFragment)) {
            log.info("We are on the 'Information' page");
        } else {
            log.error("We are not on the 'Information' page");
        }
        Assert.assertTrue(informationText.contains(expectedTextFragment), "The information text should contain '" + expectedTextFragment + "', but it does not.");
    }

    @Test(priority = 3,
            groups = {"smoke"})
    public void testWarningPopupAlertAccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.pressCloseAppButton();

        log.info("We check whether the 'Warning' popup window appears");
        boolean isDisplayedExitWarningPopup = mainPage.isDisplayedExitWarningPopupWindow();
        if (isDisplayedExitWarningPopup) {
            log.info("The 'Warning' popup window appears");
        } else {
            log.error("The 'Warning' popup window does not appears");
        }
        Assert.assertTrue(isDisplayedExitWarningPopup, "The 'Warning' popup window should appear, but it does not.");

        mainPage.pressNoButtonOnWarningPopupWindow();

        log.info("We check whether the popup window 'Warning' disappears");
        isDisplayedExitWarningPopup = mainPage.isDisplayedExitWarningPopupWindow();
        if (isDisplayedExitWarningPopup) {
            log.info("The 'Warning' popup window is available");
        } else {
            log.error("The 'Warning' popup window is not available");
        }
        Assert.assertFalse(isDisplayedExitWarningPopup, "The 'Warning' popup window should disappear, but it is still available.");
    }
}
