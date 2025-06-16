package com.myappium2project.tests.nativeapps.batteryalarm;

import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.batteryalarmapp.LanguageUtils;
import org.testng.Assert;
import com.myappium2project.pages.nativeapps.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.nativeapps.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmAppTestBase;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

@Test(groups = {TestGroups.INTEGRATION})
public class LanguagesTests extends BatteryAlarmAppTestBase {

    /**
     * Verifies that the app correctly switches its UI to each available language.
     * For each supported language, the test:
     * - selects it from the dropdown menu,
     * - retrieves the localized "Voice Warning" label,
     * - and compares it to the expected translation.
     * <p>
     * This ensures that language switching reflects properly in the user interface.
     */
    @Test
    public void testLanguages() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.ensureEnglishLanguageSelected(driver, mainPage, languagesDropdownMenu);

        Map<String, Runnable> languageSelectors = new LinkedHashMap<>();
        languageSelectors.put("English", languagesDropdownMenu::chooseEnglishOption);
        languageSelectors.put("Czech", languagesDropdownMenu::chooseCestinaOption);
        languageSelectors.put("Danish", languagesDropdownMenu::chooseDanskOption);
        languageSelectors.put("German", languagesDropdownMenu::chooseDeutschOption);
        languageSelectors.put("Spanish", languagesDropdownMenu::chooseEspanolOption);
        languageSelectors.put("French", languagesDropdownMenu::chooseFrancaisOption);
        languageSelectors.put("Indonesian", languagesDropdownMenu::chooseIndonesiaOption);
        languageSelectors.put("Italian", languagesDropdownMenu::chooseItalianoOption);
        languageSelectors.put("Hungarian", languagesDropdownMenu::chooseMagyarOption);
        languageSelectors.put("Dutch", languagesDropdownMenu::chooseNederlandsOption);
        languageSelectors.put("Polish", languagesDropdownMenu::choosePolskiOption);
        languageSelectors.put("Portuguese", languagesDropdownMenu::choosePortuguesOption);
        languageSelectors.put("Romanian", languagesDropdownMenu::chooseRomanaOption);
        languageSelectors.put("Slovenian", languagesDropdownMenu::chooseSlovencinaOption);
        languageSelectors.put("Swedish", languagesDropdownMenu::chooseSvenskaOption);
        languageSelectors.put("Serbian", languagesDropdownMenu::chooseSrpskiOption);
        languageSelectors.put("Finnish", languagesDropdownMenu::chooseSuomiOption);
        languageSelectors.put("Turkish", languagesDropdownMenu::chooseTurkceOption);
        languageSelectors.put("Bulgarian", languagesDropdownMenu::chooseBulgarianOption);
        languageSelectors.put("Russian", languagesDropdownMenu::chooseRussianOption);
        languageSelectors.put("Ukrainian", languagesDropdownMenu::chooseUkrainianOption);
        languageSelectors.put("Greek", languagesDropdownMenu::chooseGreekOption);
        languageSelectors.put("Vietnamese", languagesDropdownMenu::chooseVietnameseOption);
        languageSelectors.put("Japanese", languagesDropdownMenu::chooseJapaneseOption);
        languageSelectors.put("Chinese", languagesDropdownMenu::chooseChineseOption);
        languageSelectors.put("Korean", languagesDropdownMenu::chooseKoreanOption);
        languageSelectors.put("Thai", languagesDropdownMenu::chooseThaiOption);
        languageSelectors.put("Arabic", languagesDropdownMenu::chooseArabicOption);
        languageSelectors.put("Farsi", languagesDropdownMenu::chooseFarsiOption);
        languageSelectors.put("Hebrew", languagesDropdownMenu::chooseHebrewOption);
        languageSelectors.put("Hindi", languagesDropdownMenu::chooseHindiOption);

        Map<String, Supplier<String>> expectedTexts = new LinkedHashMap<>();
        expectedTexts.put("English", () -> "Voice Warning");
        expectedTexts.put("Czech", () -> "Hlasové varování");
        expectedTexts.put("Danish", () -> "Stemmeadvarsel");
        expectedTexts.put("German", () -> "Sprach warnung");
        expectedTexts.put("Spanish", () -> "Advert. de voz");
        expectedTexts.put("French", () -> "Avertiss. vocal");
        expectedTexts.put("Indonesian", () -> "Pering. Suara");
        expectedTexts.put("Italian", () -> "Avviso vocale");
        expectedTexts.put("Hungarian", () -> "Hang figyelmeztetés");
        expectedTexts.put("Dutch", () -> "Gesproken waarsch.");
        expectedTexts.put("Polish", () -> "Alert głosowe");
        expectedTexts.put("Portuguese", () -> "Aviso de voz");
        expectedTexts.put("Romanian", () -> "Avert. vocal");
        expectedTexts.put("Slovenian", () -> "Hlasové varov.");
        expectedTexts.put("Swedish", () -> "Röstvarning");
        expectedTexts.put("Serbian", () -> "Glasovno upozorenje");
        expectedTexts.put("Finnish", () -> "Ihmisen ääni Varoitus");
        expectedTexts.put("Turkish", () -> "Sesli uyarı");
        expectedTexts.put("Bulgarian", () -> "Гласово пред.");
        expectedTexts.put("Russian", () -> "Голосовое пред.");
        expectedTexts.put("Ukrainian", () -> "Голосове сповіщ.");
        expectedTexts.put("Greek", () -> "Φωνητική ειδοποίηση");
        expectedTexts.put("Vietnamese", () -> "Cảnh báo bằng giọng nói");
        expectedTexts.put("Japanese", () -> "音声警告");
        expectedTexts.put("Chinese", () -> "语音警告");
        expectedTexts.put("Korean", () -> "음성 경고");
        expectedTexts.put("Thai", () -> "คำเตือนด้วยเสียง");
        expectedTexts.put("Arabic", () -> "تحذیر بالصوت");
        expectedTexts.put("Farsi", () -> "هشدار صوتی");
        expectedTexts.put("Hebrew", () -> "אזהרה קולית");
        expectedTexts.put("Hindi", () -> "आवाज चेतावनी");

        Map<String, Supplier<String>> actualTexts = new LinkedHashMap<>();
        actualTexts.put("English", mainPage::getVoiceWarningEnglishText);
        actualTexts.put("Czech", mainPage::getVoiceWarningCzechText);
        actualTexts.put("Danish", mainPage::getVoiceWarningDanishText);
        actualTexts.put("German", mainPage::getVoiceWarningGermanText);
        actualTexts.put("Spanish", mainPage::getVoiceWarningSpanishText);
        actualTexts.put("French", mainPage::getVoiceWarningFranchiseText);
        actualTexts.put("Indonesian", mainPage::getVoiceWarningIndonesiaText);
        actualTexts.put("Italian", mainPage::getVoiceWarningItalianText);
        actualTexts.put("Hungarian", mainPage::getVoiceWarningHungarianText);
        actualTexts.put("Dutch", mainPage::getVoiceWarningDutchText);
        actualTexts.put("Polish", mainPage::getVoiceWarningPolishText);
        actualTexts.put("Portuguese", mainPage::getVoiceWarningPortugueseText);
        actualTexts.put("Romanian", mainPage::getVoiceWarningRomanText);
        actualTexts.put("Slovenian", mainPage::getVoiceWarningSlovenianText);
        actualTexts.put("Swedish", mainPage::getVoiceWarningSwedishText);
        actualTexts.put("Serbian", mainPage::getVoiceWarningSerbianText);
        actualTexts.put("Finnish", mainPage::getVoiceWarningFinnishText);
        actualTexts.put("Turkish", mainPage::getVoiceWarningTurkishText);
        actualTexts.put("Bulgarian", mainPage::getVoiceWarningBulgarianText);
        actualTexts.put("Russian", mainPage::getVoiceWarningRussianText);
        actualTexts.put("Ukrainian", mainPage::getVoiceWarningUkrainianText);
        actualTexts.put("Greek", mainPage::getVoiceWarningGreekText);
        actualTexts.put("Vietnamese", mainPage::getVoiceWarningVietnameseText);
        actualTexts.put("Japanese", mainPage::getVoiceWarningJapaneseText);
        actualTexts.put("Chinese", mainPage::getVoiceWarningChineseText);
        actualTexts.put("Korean", mainPage::getVoiceWarningKoreanText);
        actualTexts.put("Thai", mainPage::getVoiceWarningThaiText);
        actualTexts.put("Arabic", mainPage::getVoiceWarningArabicText);
        actualTexts.put("Farsi", mainPage::getVoiceWarningFarsiText);
        actualTexts.put("Hebrew", mainPage::getVoiceWarningHebrewText);
        actualTexts.put("Hindi", mainPage::getVoiceWarningHindiText);

        for (String language : languageSelectors.keySet()) {
            languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            languageSelectors.get(language).run();

            LOG.info("We check if the app switches to the selected language");
            String expectedText = expectedTexts.get(language).get();
            String actualText = actualTexts.get(language).get();
            if (expectedText.equals(actualText)) {
                LOG.info("The displayed language is correct: {}", language);
            } else {
                LOG.error("The displayed language is not correct");
            }
            Assert.assertEquals(actualText, expectedText, "The displayed language should be " + language + ", but it is not.");
        }
    }
}