package tests.c_batteryAlarmApk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PhoneDesktop;
import pages.c_batteryAlarmApk.LanguagesDropdownMenu;
import pages.c_batteryAlarmApk.MainPage;
import tests._baseTests.BatteryAlarmBaseTest;
import utils.AppiumActions;

public class AlarmTests extends BatteryAlarmBaseTest {
    private static final Logger LOG = LogManager.getLogger(AlarmTests.class);

    @Test(description = "The prerequisite for the test is that the phone is charging.")
    public void testMaxAlarm() {
        MainPage mainPage = new MainPage(driver);
        if (!mainPage.getSelectedLanguage().equals("English")) {
            LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
            languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            AppiumActions.scrollWithFreeCoordinates(driver, 2, 112, 700, 112, 1900, "We scroll up in the dropdown menu");
            languagesDropdownMenu.chooseEnglishOption();
        }

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
        if (!mainPage.getSelectedLanguage().equals("English")) {
            LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
            languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            AppiumActions.scrollWithFreeCoordinates(driver, 2, 112, 700, 112, 1900, "We scroll up in the dropdown menu");
            languagesDropdownMenu.chooseEnglishOption();
        }

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
