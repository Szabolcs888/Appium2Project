package com.myappium2project.utils.batteryalarm;

import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.utils.AppiumActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;

/**
 * Utility class for handling language-related actions within the Battery Alarm app.
 * This class is not meant to be instantiated.
 */
public final class LanguageUtils {

    public static void ensureEnglishLanguageSelected(
            AndroidDriver driver, MainPage mainPage,
            LanguagesDropdownMenu languagesDropdownMenu) {
        if (!"English".equals(mainPage.getSelectedLanguage())) {
            scrollToEnglishLanguage(driver, mainPage, languagesDropdownMenu);
            languagesDropdownMenu.chooseEnglishOption();
        }
    }

    public static void scrollToEnglishLanguage(
            AndroidDriver driver, MainPage mainPage,
            LanguagesDropdownMenu languagesDropdownMenu) {
        do {
            if (!"English".equals(mainPage.getSelectedLanguage())) {
                try {
                    languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
                } catch (NoSuchElementException _) {
                }
                AppiumActions.scrollWithFreeCoordinates(
                        driver, 2, 112,
                        700, 112, 1900,
                        "We scroll up in the dropdown menu");
            } else {
                languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            }
        } while (!"English".equals(mainPage.getSelectedLanguage()));
    }

    private LanguageUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}