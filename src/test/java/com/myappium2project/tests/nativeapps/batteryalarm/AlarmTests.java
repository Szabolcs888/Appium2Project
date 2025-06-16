package com.myappium2project.tests.nativeapps.batteryalarm;

import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.batteryalarmapp.LanguageUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.myappium2project.pages.nativeapps.batteryalarm.PhoneDesktopPage;
import com.myappium2project.pages.nativeapps.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.nativeapps.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmAppTestBase;

@Test(groups = {TestGroups.INTEGRATION})
public class AlarmTests extends BatteryAlarmAppTestBase {
    private static final String BATTERY_CHARGE_AND_ALARM_LOG = "We ask for the battery charge and '{}' values";
    private static final String ALARM_VALUE_CHANGE_LOG = "To trigger the alarm, we need to {} the '{}' value by {}";
    private static final String ALARM_FUNCTION_CHECK_LOG = "We check if the '{}' function is working (if the countdown has started)";

    private MainPage mainPage;
    private LanguagesDropdownMenu languagesDropdownMenu;

    @BeforeMethod(alwaysRun = true)
    public void initializePageObjects() {
        mainPage = new MainPage(driver);
        languagesDropdownMenu = new LanguagesDropdownMenu(driver);
    }

    /**
     * Tests that the Max Alarm triggers when the device is charging and the battery level reaches the threshold.
     * <p>Precondition: the phone is charging, and the countdown should be set to 10 seconds.</p>
     */
    @Test
    public void testMaxAlarm() {
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        String maxAlarmText = "Max Alarm";
        LOG.info(BATTERY_CHARGE_AND_ALARM_LOG, maxAlarmText);
        int currentBatteryChargeValue = mainPage.getCurrentBatteryChargeValue();
        int currentMaxAlarmValue = mainPage.getCurrentMaxAlarmValue();
        if (currentBatteryChargeValue < currentMaxAlarmValue) {
            String actionType = "reduce";
            int byWhichToReduceMaxAlarmValue = currentMaxAlarmValue - currentBatteryChargeValue + 2;
            LOG.info(ALARM_VALUE_CHANGE_LOG, actionType, maxAlarmText, byWhichToReduceMaxAlarmValue);
            mainPage.pressMaxAlarmMinusButton(byWhichToReduceMaxAlarmValue);
        }

        LOG.info(ALARM_FUNCTION_CHECK_LOG, maxAlarmText);
        verifyAlarmCountdownStarted();
    }

    /**
     * Tests that the Min Alarm triggers when the device is discharging and the battery level drops below the threshold.
     * <p>Precondition: the phone is not charging, and the countdown should be set to 10 seconds.</p>
     */
    @Test
    public void testMinAlarm() {
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        String minAlarmText = "Min Alarm";
        LOG.info(BATTERY_CHARGE_AND_ALARM_LOG, minAlarmText);
        int currentBatteryChargeValue = mainPage.getCurrentBatteryChargeValue();
        int currentMinAlarmValue = mainPage.getCurrentMinAlarmValue();
        if (currentBatteryChargeValue >= currentMinAlarmValue) {
            String actionType = "increase";
            int byWhichToIncreaseMinAlarmValue = currentBatteryChargeValue - currentMinAlarmValue;
            LOG.info(ALARM_VALUE_CHANGE_LOG, actionType, minAlarmText, byWhichToIncreaseMinAlarmValue);
            mainPage.pressMinAlarmPlusButton(byWhichToIncreaseMinAlarmValue);
        }

        LOG.info(ALARM_FUNCTION_CHECK_LOG, minAlarmText);
        mainPage.pressPutItOnTheTrayButton();                         // These two steps are necessary because if we stay in the
        PhoneDesktopPage phoneDesktop = new PhoneDesktopPage(driver); // application, the alarm will not go off. That's why we have
        phoneDesktop.pressBatteryAlarmAppIcon();                      // to put it on the tray and then go back to the application.
        verifyAlarmCountdownStarted();
    }

    private void verifyAlarmCountdownStarted() {
        boolean isCountdownActive = mainPage.isTheCountdownGoing();
        if (isCountdownActive) {
            LOG.info("The alarm works");
        } else {
            LOG.error("The alarm does not work");
        }

        Assert.assertTrue(isCountdownActive, "The countdown should be active, but it is not.");
    }
}