package com.myappium2project.tests.nativeapps.batteryalarm;

import com.myappium2project.pages.nativeapps.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.nativeapps.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmAppTestBase;
import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.batteryalarmapp.LanguageUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PopupAccessTests extends BatteryAlarmAppTestBase {
    private static final String CHECK_POPUP_VISIBILITY_LOG = "We check if the '{}' popup window {}";
    private static final String POPUP_VISIBILITY_LOG = "The '{}' popup window {}";

    private static String popupAppearsAssertLog(String popupTitle, String expectedPopupState) {
        return String.format("The '%s' popup window should %s, but it does not.", popupTitle, expectedPopupState);
    }

    @Test(groups = {TestGroups.SMOKE})
    public void testWarningPopupAlertAccess() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        mainPage.pressCloseAppButton();

        String popupTitle = "Warning";
        boolean isDisplayedExitWarningPopup = mainPage.isDisplayedExitWarningPopupWindow();
        verifyPopupVisible(popupTitle, isDisplayedExitWarningPopup);

        mainPage.pressNoButtonOnWarningPopupWindow();

        isDisplayedExitWarningPopup = mainPage.isDisplayedExitWarningPopupWindow();
        verifyPopupNotVisible(popupTitle, isDisplayedExitWarningPopup);
    }

    private void verifyPopupVisible(String popupTitle, boolean isDisplayed) {
        String popupVisibilityStatus = "appears";
        LOG.info(CHECK_POPUP_VISIBILITY_LOG, popupTitle, popupVisibilityStatus);
        if (isDisplayed) {
            LOG.info(POPUP_VISIBILITY_LOG, popupTitle, popupVisibilityStatus);
        } else {
            popupVisibilityStatus = "does not appear";
            LOG.error(POPUP_VISIBILITY_LOG, popupTitle, popupVisibilityStatus);
        }
        String expectedPopupState = "appear";

        Assert.assertTrue(isDisplayed, popupAppearsAssertLog(popupTitle, expectedPopupState));
    }

    private void verifyPopupNotVisible(String popupTitle, boolean isDisplayed) {
        String popupVisibilityStatus = "disappears";
        LOG.info(CHECK_POPUP_VISIBILITY_LOG, popupTitle, popupVisibilityStatus);
        if (!isDisplayed) {
            LOG.info(POPUP_VISIBILITY_LOG, popupTitle, popupVisibilityStatus);
        } else {
            popupVisibilityStatus = "does not disappear";
            LOG.error(POPUP_VISIBILITY_LOG, popupTitle, popupVisibilityStatus);
        }
        String expectedPopupState = "disappear";

        Assert.assertFalse(isDisplayed, popupAppearsAssertLog(popupTitle, expectedPopupState));
    }
}