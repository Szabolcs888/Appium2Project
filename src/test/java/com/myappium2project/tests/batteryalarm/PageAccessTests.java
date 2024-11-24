package com.myappium2project.tests.batteryalarm;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.batteryalarm.InformationPage;
import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmBaseTest;
import com.myappium2project.utils.AppiumActions;

public class PageAccessTests extends BatteryAlarmBaseTest {

    @Test(priority = 1,
            groups = {"smoke"})
    public void testMainPageAccess() {
        MainPage mainPage = new MainPage(driver);
        if (!mainPage.getSelectedLanguage().equals("English")) {
            LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
            languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            AppiumActions.scrollWithFreeCoordinates(driver, 2, 112, 700, 112, 1900,
                    "We scroll up in the dropdown menu");
            languagesDropdownMenu.chooseEnglishOption();
        }

        LOG.info("We check whether we are on the 'Main' page");
        String voiceWarningText = mainPage.getVoiceWarningEnglishText();
        String chooseASoundText = mainPage.getChooseASoundText();
        String expectedVoiceWarningText = "Voice Warning";
        String expectedChooseASoundText = "Choose a sound";
        if (voiceWarningText.equals(expectedVoiceWarningText) && chooseASoundText.equals(expectedChooseASoundText)) {
            LOG.info("We are on the 'Main' page");
        } else {
            LOG.error("We are not on the 'Main' page");
        }
        Assert.assertEquals(voiceWarningText, expectedVoiceWarningText,
                "The voice warning text should be '" + expectedVoiceWarningText + "', but it is '" + voiceWarningText + "'.");
        Assert.assertEquals(chooseASoundText, expectedChooseASoundText,
                "The 'Choose a sound' text should be '" + expectedChooseASoundText + "', but it is '" + chooseASoundText + "'.");
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testInformationPageAccess() {
        MainPage mainPage = new MainPage(driver);
        if (!mainPage.getSelectedLanguage().equals("English")) {
            LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
            languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            AppiumActions.scrollWithFreeCoordinates(driver, 2, 112, 700, 112, 1900,
                    "We scroll up in the dropdown menu");
            languagesDropdownMenu.chooseEnglishOption();
        }

        mainPage.pressInformationButton();

        LOG.info("We check whether we are on the 'Information' page");
        InformationPage informationPage = new InformationPage(driver);
        String informationText = informationPage.getInformationText();
        String expectedTextFragment = "In order to avoid issue, find the power";
        if (informationText.contains(expectedTextFragment)) {
            LOG.info("We are on the 'Information' page");
        } else {
            LOG.error("We are not on the 'Information' page");
        }
        Assert.assertTrue(informationText.contains(expectedTextFragment),
                "The information text should contain '" + expectedTextFragment + "', but it does not.");
    }

    @Test(priority = 3,
            groups = {"smoke"})
    public void testWarningPopupAlertAccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.pressCloseAppButton();

        LOG.info("We check whether the 'Warning' popup window appears");
        boolean isDisplayedExitWarningPopup = mainPage.isDisplayedExitWarningPopupWindow();
        if (isDisplayedExitWarningPopup) {
            LOG.info("The 'Warning' popup window appears");
        } else {
            LOG.error("The 'Warning' popup window does not appears");
        }
        Assert.assertTrue(isDisplayedExitWarningPopup,
                "The 'Warning' popup window should appear, but it does not.");

        mainPage.pressNoButtonOnWarningPopupWindow();

        LOG.info("We check whether the popup window 'Warning' disappears");
        isDisplayedExitWarningPopup = mainPage.isDisplayedExitWarningPopupWindow();
        if (isDisplayedExitWarningPopup) {
            LOG.info("The 'Warning' popup window is available");
        } else {
            LOG.error("The 'Warning' popup window is not available");
        }
        Assert.assertFalse(isDisplayedExitWarningPopup,
                "The 'Warning' popup window should disappear, but it is still available.");
    }
}
