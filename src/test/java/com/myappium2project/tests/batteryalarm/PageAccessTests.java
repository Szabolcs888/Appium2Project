package com.myappium2project.tests.batteryalarm;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.utils.batteryalarm.LanguageUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.batteryalarm.InformationPage;
import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmBaseTest;

public class PageAccessTests extends BatteryAlarmBaseTest {

    public static String getTextValidationAssertLog(String actualText, String expectedText) {
        return String.format("The expected text on the page should be '%s', but it is '%s'.", expectedText, actualText);
    }

    @Test(priority = 1,
            groups = {"smoke"})
    public void testMainPageAccess() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        String mainPageName = "Main";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, mainPageName);
        String voiceWarningText = mainPage.getVoiceWarningEnglishText();
        String chooseASoundText = mainPage.getChooseASoundText();
        String expectedVoiceWarningText = "Voice Warning";
        String expectedChooseASoundText = "Choose a sound";
        if (voiceWarningText.equals(expectedVoiceWarningText) && chooseASoundText.equals(expectedChooseASoundText)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, mainPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, mainPageName);
        }
        Assert.assertEquals(chooseASoundText, expectedChooseASoundText,
                getTextValidationAssertLog(chooseASoundText, expectedChooseASoundText));
        Assert.assertEquals(voiceWarningText, expectedVoiceWarningText,
                getTextValidationAssertLog(voiceWarningText, expectedVoiceWarningText));
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testInformationPageAccess() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        mainPage.pressInformationButton();

        String informationPageName = "Information";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, informationPageName);
        InformationPage informationPage = new InformationPage(driver);
        String informationText = informationPage.getInformationText();
        String expectedTextFragment = "In order to avoid issue, find the power";
        if (informationText.contains(expectedTextFragment)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, informationPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, informationPageName);
        }
        Assert.assertTrue(informationText.contains(expectedTextFragment),
                "The information text should contain '" + expectedTextFragment + "', but it does not.");
    }
}