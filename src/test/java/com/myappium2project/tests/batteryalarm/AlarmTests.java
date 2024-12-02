package com.myappium2project.tests.batteryalarm;

import com.myappium2project.utils.batteryalarm.LanguageUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.common.PhoneDesktop;
import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmBaseTest;

public class AlarmTests extends BatteryAlarmBaseTest {
    private static final String ALARM_VALUE_CHANGE_LOG = "To trigger the alarm, we need to {} the '{}' value by {}";
    private static final String ALARM_WORKS_LOG = "The alarm works";
    private static final String ALARM_DOES_NOT_WORK_ERRORLOG = "The alarm does not work";
    private static final String COUNTDOWN_VALIDATION_ERROR_ASSERTLOG = "The countdown should be active, but it is not.";

    private static String getBatteryChargeAndAlarmLog() {
        return "We ask for the battery charge and '{}' values";
    }

    private static String getAlarmFunctionCheckLog() {
        return "We check if the '{}' function is working (if the countdown has started)";
    }

    @Test(description = "The prerequisite for the test is that the phone is charging.")
    public void testMaxAlarm() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        String maxAlarmText = "Max Alarm";
        LOG.info(getBatteryChargeAndAlarmLog(), maxAlarmText);
        int currentBatteryChargeValue = mainPage.getCurrentBatteryChargeValue();
        int currentMaxAlarmValue = mainPage.getCurrentMaxAlarmValue();
        if (currentBatteryChargeValue < currentMaxAlarmValue) {
            String actionType = "reduce";
            int byWhichToReduceMaxAlarmValue = currentMaxAlarmValue - currentBatteryChargeValue + 2;
            LOG.info(ALARM_VALUE_CHANGE_LOG, actionType, maxAlarmText, byWhichToReduceMaxAlarmValue);
            mainPage.pressMaxAlarmMinusButton(byWhichToReduceMaxAlarmValue);
        }

        LOG.info(getAlarmFunctionCheckLog(), maxAlarmText);
        boolean isCountdownActive = mainPage.isTheCountdownGoing();
        if (isCountdownActive) {
            LOG.info(ALARM_WORKS_LOG);
        } else {
            LOG.error(ALARM_DOES_NOT_WORK_ERRORLOG);
        }
        Assert.assertTrue(isCountdownActive, COUNTDOWN_VALIDATION_ERROR_ASSERTLOG);
    }

    @Test(description = "The prerequisite for the test is that the phone is not charging.")
    public void testMinAlarm() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        String minAlarmText = "Min Alarm";
        LOG.info(getBatteryChargeAndAlarmLog(), minAlarmText);
        int currentBatteryChargeValue = mainPage.getCurrentBatteryChargeValue();
        int currentMinAlarmValue = mainPage.getCurrentMinAlarmValue();
        if (currentBatteryChargeValue >= currentMinAlarmValue) {
            String actionType = "increase";
            int byWhichToIncreaseMinAlarmValue = currentBatteryChargeValue - currentMinAlarmValue;
            LOG.info(ALARM_VALUE_CHANGE_LOG, actionType, minAlarmText, byWhichToIncreaseMinAlarmValue);
            mainPage.pressMinAlarmPlusButton(byWhichToIncreaseMinAlarmValue);
        }

        LOG.info(getAlarmFunctionCheckLog(), minAlarmText);
        mainPage.pressPutItOnTheTrayButton();                 // These two steps are necessary because if we stay in the
        PhoneDesktop phoneDesktop = new PhoneDesktop(driver); // application, the alarm will not go off. That's why we have
        phoneDesktop.pressBatteryAlarmAppIcon();              // to put it on the tray and then go back to the application.
        boolean isCountdownActive = mainPage.isTheCountdownGoing();
        if (isCountdownActive) {
            LOG.info(ALARM_WORKS_LOG);
        } else {
            LOG.error(ALARM_DOES_NOT_WORK_ERRORLOG);
        }
        Assert.assertTrue(isCountdownActive, COUNTDOWN_VALIDATION_ERROR_ASSERTLOG);
    }
}