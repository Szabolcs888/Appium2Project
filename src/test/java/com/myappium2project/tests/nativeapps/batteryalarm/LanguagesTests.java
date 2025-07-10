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

        // Preserving insertion order is required
        Map<String, String> expectedTexts = new LinkedHashMap<>();
        expectedTexts.put("English", "Voice Warning");
        expectedTexts.put("Czech", "Hlasové varování");
        expectedTexts.put("Danish", "Stemmeadvarsel");
        expectedTexts.put("German", "Sprach warnung");
        expectedTexts.put("Spanish", "Advert. de voz");
        expectedTexts.put("French", "Avertiss. vocal");
        expectedTexts.put("Indonesian", "Pering. Suara");
        expectedTexts.put("Italian", "Avviso vocale");
        expectedTexts.put("Hungarian", "Hang figyelmeztetés");
        expectedTexts.put("Dutch", "Gesproken waarsch.");
        expectedTexts.put("Polish", "Alert głosowe");
        expectedTexts.put("Portuguese", "Aviso de voz");
        expectedTexts.put("Romanian", "Avert. vocal");
        expectedTexts.put("Slovenian", "Hlasové varov.");
        expectedTexts.put("Swedish", "Röstvarning");
        expectedTexts.put("Serbian", "Glasovno upozorenje");
        expectedTexts.put("Finnish", "Ihmisen ääni Varoitus");
        expectedTexts.put("Turkish", "Sesli uyarı");
        expectedTexts.put("Bulgarian", "Гласово пред.");
        expectedTexts.put("Russian", "Голосовое пред.");
        expectedTexts.put("Ukrainian", "Голосове сповіщ.");
        expectedTexts.put("Greek", "Φωνητική ειδοποίηση");
        expectedTexts.put("Vietnamese", "Cảnh báo bằng giọng nói");
        expectedTexts.put("Japanese", "音声警告");
        expectedTexts.put("Chinese", "语音警告");
        expectedTexts.put("Korean", "음성 경고");
        expectedTexts.put("Thai", "คำเตือนด้วยเสียง");
        expectedTexts.put("Arabic", "تحذیر بالصوت");
        expectedTexts.put("Farsi", "هشدار صوتی");
        expectedTexts.put("Hebrew", "אזהרה קולית");
        expectedTexts.put("Hindi", "आवाज चेतावनी");

        for (Map.Entry<String, String> entry : expectedTexts.entrySet()) {
            String language = entry.getKey();
            String expectedText = entry.getValue();

            languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            languagesDropdownMenu.chooseLanguageOption(language);

            LOG.info("We check if the app switches to the selected language");
            String actualText = mainPage.getVoiceWarningText(language);
            if (expectedText.equals(actualText)) {
                LOG.info("The displayed language is correct: {}", language);
            } else {
                LOG.error("The displayed language is not correct");
            }
            Assert.assertEquals(actualText, expectedText, "The displayed language should be " + language + ", but it is not.");
        }
    }
}