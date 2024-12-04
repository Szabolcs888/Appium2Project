package com.myappium2project.tests.batteryalarm;

import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmBaseTest;
import com.myappium2project.utils.batteryalarm.LanguageUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopupAccessTests extends BatteryAlarmBaseTest {
    private static final String CHECK_POPUP_VISIBILITY_LOG = "We check if the '{}' popup window {}";
    private static final String POPUP_VISIBILITY_LOG = "The '{}' popup window {}";

    private static String getPopupValidationAssertLog(String popupTitle, String expectedPopupState) {
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
        LOG.info(CHECK_POPUP_VISIBILITY_LOG, popupTitle, popupVisibilityStatus);
        boolean isDisplayedExitWarningPopup = mainPage.isDisplayedExitWarningPopupWindow();
        if (isDisplayedExitWarningPopup) {
            LOG.info(POPUP_VISIBILITY_LOG, popupTitle, popupVisibilityStatus);
        } else {
            popupVisibilityStatus = "does not appear";
            LOG.error(POPUP_VISIBILITY_LOG, popupTitle, popupVisibilityStatus);
        }
        String expectedPopupState = "appear";
        Assert.assertTrue(isDisplayedExitWarningPopup, getPopupValidationAssertLog(popupTitle, expectedPopupState));

        mainPage.pressNoButtonOnWarningPopupWindow();

        popupVisibilityStatus = "disappears";
        LOG.info(CHECK_POPUP_VISIBILITY_LOG, popupTitle, popupVisibilityStatus);
        isDisplayedExitWarningPopup = mainPage.isDisplayedExitWarningPopupWindow();
        if (!isDisplayedExitWarningPopup) {
            LOG.info(POPUP_VISIBILITY_LOG, popupTitle, popupVisibilityStatus);
        } else {
            popupVisibilityStatus = "does not disappear";
            LOG.error(POPUP_VISIBILITY_LOG, popupTitle, popupVisibilityStatus);
        }
        expectedPopupState = "disappear";
        Assert.assertFalse(isDisplayedExitWarningPopup, getPopupValidationAssertLog(popupTitle, expectedPopupState));
    }
}