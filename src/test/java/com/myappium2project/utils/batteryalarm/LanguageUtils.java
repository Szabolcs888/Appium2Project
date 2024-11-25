package com.myappium2project.utils.batteryalarm;

import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.utils.AppiumActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;

public class LanguageUtils {

    public static void scrollToEnglishLanguage(AndroidDriver driver, MainPage mainPage, LanguagesDropdownMenu languagesDropdownMenu) {
        do {
            if (!mainPage.getSelectedLanguage().equals("English")) {
                try {
                    languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
                } catch (NoSuchElementException e) {
                }
                AppiumActions.scrollWithFreeCoordinates(driver, 2, 112, 700, 112, 1900,
                        "We scroll up in the dropdown menu");
            } else {
                languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            }
        } while (!mainPage.getSelectedLanguage().equals("English"));
    }
}
