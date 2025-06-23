package com.myappium2project.utils.batteryalarmapp;

import com.myappium2project.pages.nativeapps.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.nativeapps.batteryalarm.MainPage;
import com.myappium2project.utils.common.AppiumActions;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;

/**
 * Utility class for managing language selection in the Battery Alarm application.
 * <p>
 * Ensures that the app is set to English language before tests proceed.
 */
public final class LanguageUtils {

    private LanguageUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Ensures that the selected language is English. If not, it scrolls and selects it.
     *
     * @param driver                the Android driver instance
     * @param mainPage              the main page object of the Battery Alarm app
     * @param languagesDropdownMenu the dropdown menu page object for language selection
     */
    public static void ensureEnglishLanguageSelected(
            AndroidDriver driver, MainPage mainPage,
            LanguagesDropdownMenu languagesDropdownMenu) {
        if (!"English".equals(mainPage.getSelectedLanguage())) {
            scrollToEnglishLanguage(driver, mainPage, languagesDropdownMenu);
            languagesDropdownMenu.chooseLanguageOption("English");
        }
    }

    /**
     * Scrolls through the language dropdown until the English option is visible.
     * If not already selected, it interacts with the dropdown menu to perform the scroll.
     *
     * @param driver                the Android driver instance
     * @param mainPage              the main page object
     * @param languagesDropdownMenu the language dropdown menu object
     */
    public static void scrollToEnglishLanguage(
            AndroidDriver driver, MainPage mainPage,
            LanguagesDropdownMenu languagesDropdownMenu) {
        do {
            if ("English".equals(mainPage.getSelectedLanguage())) {
                languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            } else {
                try {
                    languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
                } catch (NoSuchElementException _) {
                }
                AppiumActions.scrollWithFreeCoordinates(
                        driver, 2, 112,
                        700, 112, 1900,
                        "We scroll up in the dropdown menu");
            }
        } while (!"English".equals(mainPage.getSelectedLanguage()));
    }
}