package com.myappium2project.tests.nativeapps.batteryalarm;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.batteryalarmapp.LanguageUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.myappium2project.pages.nativeapps.batteryalarm.InformationPage;
import com.myappium2project.pages.nativeapps.batteryalarm.InformationSecondPage;
import com.myappium2project.pages.nativeapps.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.nativeapps.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmAppTestBase;

public class PageAccessTests extends BatteryAlarmAppTestBase {
    private MainPage mainPage;
    private LanguagesDropdownMenu languagesDropdownMenu;

    private static String incorrectTextAssertLog(String actualText, String expectedText) {
        return String.format("The expected text on the page should be '%s', but it is '%s'.", expectedText, actualText);
    }

    @BeforeMethod(alwaysRun = true)
    public void initializePageObjects() {
        mainPage = new MainPage(driver);
        languagesDropdownMenu = new LanguagesDropdownMenu(driver);
    }

    @Test(priority = 1,
            groups = {TestGroups.SMOKE})
    public void testMainPageAccess() {
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        String mainPageName = "Main";
        String actualVoiceWarningText = mainPage.getVoiceWarningText("English");
        String actualChooseASoundText = mainPage.getChooseASoundText();
        String expectedVoiceWarningText = "Voice Warning";
        String expectedChooseASoundText = "Choose a sound";
        verifyMainPageTexts(mainPageName, actualVoiceWarningText, expectedVoiceWarningText,
                actualChooseASoundText, expectedChooseASoundText);
    }

    @Test(priority = 2,
            groups = {TestGroups.SMOKE})
    public void testInformationPagesAccess() {
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        mainPage.pressInformationButton();

        String informationPageName = "Information";
        InformationPage informationPage = new InformationPage(driver);
        String informationText = informationPage.getInformationText();
        String expectedTextFragment = "In order to avoid issue, find the power";
        verifyInformationTextContains(informationPageName, informationText, expectedTextFragment);

        informationPage.pressNextPageButton();

        String informationSecondPageName = "second Information";
        InformationSecondPage informationSecondPage = new InformationSecondPage(driver);
        String secondInformationText = informationSecondPage.getInformationText();
        String expectedTextFragment2 = "If you have any problems, feel free To contact Me by email";
        verifyInformationTextContains(informationSecondPageName, secondInformationText, expectedTextFragment2);
    }

    private void verifyMainPageTexts(String pageName, String actualVoiceWarningText, String expectedVoiceWarningText,
                                     String actualChooseASoundText, String expectedChooseASoundText) {
        LOG.info(CommonTestLogMessages.CHECK_ON_PAGE_LOG, pageName);
        if (actualVoiceWarningText.equals(expectedVoiceWarningText) &&
                actualChooseASoundText.equals(expectedChooseASoundText)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, pageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, pageName);
        }

        Assert.assertEquals(actualVoiceWarningText, expectedVoiceWarningText,
                incorrectTextAssertLog(actualVoiceWarningText, expectedVoiceWarningText));
        Assert.assertEquals(actualChooseASoundText, expectedChooseASoundText,
                incorrectTextAssertLog(actualChooseASoundText, expectedChooseASoundText));
    }

    private void verifyInformationTextContains(String pageName, String actualText, String expectedFragment) {
        LOG.info(CommonTestLogMessages.CHECK_ON_PAGE_LOG, pageName);
        if (actualText.contains(expectedFragment)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, pageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, pageName);
        }

        Assert.assertTrue(actualText.contains(expectedFragment),
                "The information text should contain '" + expectedFragment + "', but it does not.");
    }
}