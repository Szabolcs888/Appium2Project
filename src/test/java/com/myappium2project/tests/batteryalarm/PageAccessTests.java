package com.myappium2project.tests.batteryalarm;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.batteryalarm.LanguageUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.batteryalarm.InformationPage;
import com.myappium2project.pages.batteryalarm.InformationSecondPage;
import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmTestBase;

public class PageAccessTests extends BatteryAlarmTestBase {

    public static String incorrectTextAssertLog(String actualText, String expectedText) {
        return String.format("The expected text on the page should be '%s', but it is '%s'.", expectedText, actualText);
    }

    private static String incorrectInformationTextDetailAssertLog(String expectedTextFragment) {
        return String.format("The information text should contain '%s', but it does not.", expectedTextFragment);
    }

    @Test(priority = 1,
            groups = {TestGroups.SMOKE})
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
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, mainPageName);
        }
        Assert.assertEquals(chooseASoundText, expectedChooseASoundText,
                incorrectTextAssertLog(chooseASoundText, expectedChooseASoundText));
        Assert.assertEquals(voiceWarningText, expectedVoiceWarningText,
                incorrectTextAssertLog(voiceWarningText, expectedVoiceWarningText));
    }

    @Test(priority = 2,
            groups = {TestGroups.SMOKE})
    public void testInformationPagesAccess() {
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
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, informationPageName);
        }
        Assert.assertTrue(informationText.contains(expectedTextFragment),
                incorrectInformationTextDetailAssertLog(expectedTextFragment));

        informationPage.pressNextPageButton();

        String informationSecondPageName = "second Information";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, informationSecondPageName);
        InformationSecondPage informationSecondPage = new InformationSecondPage(driver);
        String secondInformationText = informationSecondPage.getInformationText();
        String expectedTextFragment2 = "If you have any problems, feel free To contact Me by email";
        if (secondInformationText.contains(expectedTextFragment2)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, informationSecondPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, informationSecondPageName);
        }
        Assert.assertTrue(secondInformationText.contains(expectedTextFragment2),
                incorrectInformationTextDetailAssertLog(expectedTextFragment2));
    }
}