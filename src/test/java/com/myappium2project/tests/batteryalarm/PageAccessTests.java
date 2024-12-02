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

    @Test(priority = 1,
            groups = {"smoke"})
    public void testMainPageAccess() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        String mainPageName = "Main";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), mainPageName);
        String voiceWarningText = mainPage.getVoiceWarningEnglishText();
        String chooseASoundText = mainPage.getChooseASoundText();
        String expectedVoiceWarningText = "Voice Warning";
        String expectedChooseASoundText = "Choose a sound";
        if (voiceWarningText.equals(expectedVoiceWarningText) && chooseASoundText.equals(expectedChooseASoundText)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), mainPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), mainPageName);
        }
        Assert.assertEquals(voiceWarningText, expectedVoiceWarningText,
                "The voice warning text should be '" + expectedVoiceWarningText + "', but it is '" + voiceWarningText + "'.");
        Assert.assertEquals(chooseASoundText, expectedChooseASoundText,
                "The '" + expectedChooseASoundText + "' text should be '" +
                        expectedChooseASoundText + "', but it is '" + chooseASoundText + "'.");
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testInformationPageAccess() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        mainPage.pressInformationButton();

        String informationPageName = "Information";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), informationPageName);
        InformationPage informationPage = new InformationPage(driver);
        String informationText = informationPage.getInformationText();
        String expectedTextFragment = "In order to avoid issue, find the power";
        if (informationText.contains(expectedTextFragment)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), informationPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), informationPageName);
        }
        Assert.assertTrue(informationText.contains(expectedTextFragment),
                "The information text should contain '" + expectedTextFragment + "', but it does not.");
    }
}