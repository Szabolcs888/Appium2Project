package com.myappium2project.tests.batteryalarm;

import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmBaseTest;
import com.myappium2project.utils.batteryalarm.LanguageUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopupAccessTests extends BatteryAlarmBaseTest {

    private static String getCheckPopupVisibilityLog() {
        return "We check if the '{}' popup window {}";
    }

    private static String getPopupVisibilityLog() {
        return "The '{}' popup window {}";
    }

    private static String getPopupValidationErrorAssertLog(String popupTitle, String expectedPopupState) {
        return String.format("The '%s' popup window should %s, but it does not.", popupTitle, expectedPopupState);
    }

    @Test(groups = {"smoke"})
    public void testWarningPopupAlertAccess() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        mainPage.pressCloseAppButton();

        String popupTitle = "Warning";
        String popupVisibilityStatus = "appears";
        LOG.info(getCheckPopupVisibilityLog(), popupTitle, popupVisibilityStatus);
        boolean isDisplayedExitWarningPopup = mainPage.isDisplayedExitWarningPopupWindow();
        if (isDisplayedExitWarningPopup) {
            LOG.info(getPopupVisibilityLog(), popupTitle, popupVisibilityStatus);
        } else {
            popupVisibilityStatus = "does not appear";
            LOG.error(getPopupVisibilityLog(), popupTitle, popupVisibilityStatus);
        }
        String expectedPopupState = "appear";
        Assert.assertTrue(isDisplayedExitWarningPopup, getPopupValidationErrorAssertLog(popupTitle, expectedPopupState));

        mainPage.pressNoButtonOnWarningPopupWindow();

        popupVisibilityStatus = "disappears";
        LOG.info(getCheckPopupVisibilityLog(), popupTitle, popupVisibilityStatus);
        isDisplayedExitWarningPopup = mainPage.isDisplayedExitWarningPopupWindow();
        if (!isDisplayedExitWarningPopup) {
            LOG.info(getPopupVisibilityLog(), popupTitle, popupVisibilityStatus);
        } else {
            popupVisibilityStatus = "does not disappear";
            LOG.error(getPopupVisibilityLog(), popupTitle, popupVisibilityStatus);
        }
        expectedPopupState = "disappear";
        Assert.assertFalse(isDisplayedExitWarningPopup, getPopupValidationErrorAssertLog(popupTitle, expectedPopupState));
    }
}