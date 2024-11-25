package com.myappium2project.tests.batteryalarm;

import com.myappium2project.utils.batteryalarm.LanguageUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.common.PhoneDesktop;
import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmBaseTest;

public class AlarmTests extends BatteryAlarmBaseTest {

    @Test(description = "The prerequisite for the test is that the phone is charging.")
    public void testMaxAlarm() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.scrollToEnglishLanguage(driver, mainPage, languagesDropdownMenu);
        languagesDropdownMenu.chooseEnglishOption();

        LOG.info("We ask for the battery charge and 'Max Alarm' values");
        int currentBatteryChargeValue = mainPage.getCurrentBatteryChargeValue();
        int currentMaxAlarmValue = mainPage.getCurrentMaxAlarmValue();
        if (currentBatteryChargeValue < currentMaxAlarmValue) {
            int byWhichToReduceTheMaxAlarmValue = currentMaxAlarmValue - currentBatteryChargeValue + 2;
            LOG.info("In order for the phone to alarm, we need to reduce the 'Max Alarm' value by {}", byWhichToReduceTheMaxAlarmValue);
            mainPage.pressMaxAlarmMinusButton(byWhichToReduceTheMaxAlarmValue);
        }

        LOG.info("We check whether the Max Alarm function is working (whether the countdown has started)");
        boolean isCountdownActive = mainPage.isTheCountdownGoing();
        if (isCountdownActive) {
            LOG.info("The alarm works");
        } else {
            LOG.error("The alarm does not work");
        }
        Assert.assertTrue(isCountdownActive, "The countdown should be active, but it is not.");
    }

    @Test(description = "The prerequisite for the test is that the phone is not charging.")
    public void testMinAlarm() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.scrollToEnglishLanguage(driver, mainPage, languagesDropdownMenu);
        languagesDropdownMenu.chooseEnglishOption();

        LOG.info("We ask for the battery charge and 'Min Alarm' values");
        int currentBatteryChargeValue = mainPage.getCurrentBatteryChargeValue();
        int currentMinAlarmValue = mainPage.getCurrentMinAlarmValue();
        if (currentBatteryChargeValue >= currentMinAlarmValue) {
            int byWhichToIncreaseTheMinAlarmValue = currentBatteryChargeValue - currentMinAlarmValue;
            LOG.info("In order for the phone to alarm, we need to increase the 'Min Alarm' value by {}", byWhichToIncreaseTheMinAlarmValue);
            mainPage.pressMinAlarmPlusButton(byWhichToIncreaseTheMinAlarmValue);
        }

        LOG.info("We check whether the Min Alarm function is working (whether the countdown has started)");
        mainPage.pressPutItOnTheTrayButton();                 /** These two steps are necessary because if we stay in the application, **/
        PhoneDesktop phoneDesktop = new PhoneDesktop(driver); /** the alarm will not go off. That's why we have to put**/
        phoneDesktop.pressBatteryAlarmAppIcon();              /** it on the tray and then go back to the application.**/
        boolean isCountdownActive = mainPage.isTheCountdownGoing();
        if (isCountdownActive) {
            LOG.info("The alarm works");
        } else {
            LOG.error("The alarm does not work");
        }
        Assert.assertTrue(isCountdownActive, "The countdown should be active, but it is not.");
    }
}
