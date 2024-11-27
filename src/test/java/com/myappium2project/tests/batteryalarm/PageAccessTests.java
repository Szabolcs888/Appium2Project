package com.myappium2project.tests.batteryalarm;

import com.myappium2project.utils.batteryalarm.LanguageUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.batteryalarm.InformationPage;
import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmBaseTest;

public class PageAccessTests extends BatteryAlarmBaseTest {
    private static final String LOG_CHECK_PAGE = "We check whether we are on the '";
    private static final String LOG_PAGE_SUFFIX = "' page";
    private static final String LOG_ON_PAGE = "We are on the '";
    private static final String LOG_NOT_ON_PAGE = "We are not on the '";

    @Test(priority = 1,
            groups = {"smoke"})
    public void testMainPageAccess() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.scrollToEnglishLanguage(driver, mainPage, languagesDropdownMenu);
        languagesDropdownMenu.chooseEnglishOption();

        String pageName = "Main";
        LOG.info(LOG_CHECK_PAGE + pageName + LOG_PAGE_SUFFIX);
        String voiceWarningText = mainPage.getVoiceWarningEnglishText();
        String chooseASoundText = mainPage.getChooseASoundText();
        String expectedVoiceWarningText = "Voice Warning";
        String expectedChooseASoundText = "Choose a sound";
        if (voiceWarningText.equals(expectedVoiceWarningText) && chooseASoundText.equals(expectedChooseASoundText)) {
            LOG.info(LOG_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertEquals(voiceWarningText, expectedVoiceWarningText,
                "The voice warning text should be '" + expectedVoiceWarningText + "', but it is '" + voiceWarningText + "'.");
        Assert.assertEquals(chooseASoundText, expectedChooseASoundText,
                "The '" + expectedChooseASoundText + "' text should be '" + expectedChooseASoundText + "', but it is '" + chooseASoundText + "'.");
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testInformationPageAccess() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.scrollToEnglishLanguage(driver, mainPage, languagesDropdownMenu);
        languagesDropdownMenu.chooseEnglishOption();
        mainPage.pressInformationButton();

        String pageName = "Information";
        LOG.info(LOG_CHECK_PAGE + pageName + LOG_PAGE_SUFFIX);
        InformationPage informationPage = new InformationPage(driver);
        String informationText = informationPage.getInformationText();
        String expectedTextFragment = "In order to avoid issue, find the power";
        if (informationText.contains(expectedTextFragment)) {
            LOG.info(LOG_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
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