package tests.c_batteryAlarmApk;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import pages.c_batteryAlarmApk.LanguagesDropdownMenu;
import pages.c_batteryAlarmApk.MainPage;
import tests._baseTests.BatteryAlarmBaseTest;
import org.testng.annotations.Test;
import tests.a_sauceLabApk.LoginTests;
import utils.AppiumActions;

@Listeners(TestListener.class)
public class LanguagesTests extends BatteryAlarmBaseTest {
    private static final Logger log = LogManager.getLogger(LoginTests.class);
    String LOG_MESSAGE1 = "We check whether the app switches to the selected language";
    String LOG_MESSAGE2 = "The displayed language is correct";
    String LOG_MESSAGE3 = "The displayed language is not correct";

    @Test
    public void testLanguages() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        if (!mainPage.getSelectedLanguage().equals("English")) {
            languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            AppiumActions appiumActions = new AppiumActions();
            appiumActions.scrollWithFreeCoordinates(driver, 2, 112, 700, 112, 1900, "We scroll up in the dropdown menu");
        } else {
            languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        }

        languagesDropdownMenu.chooseEnglishOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningEnglishText = mainPage.getVoiceWarningEnglishText();
        String expectedEnglishText = "Voice Warning";
        if (voiceWarningEnglishText.equals(expectedEnglishText))
            log.info(LOG_MESSAGE2);
        else
            log.error(LOG_MESSAGE3);
        Assert.assertEquals(voiceWarningEnglishText, expectedEnglishText, "The displayed language should be English, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseCestinaOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningCzechText = mainPage.getVoiceWarningCzechText();
        String expectedCzechText = "Hlasové varování";
        if (voiceWarningCzechText.equals(expectedCzechText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningCzechText, expectedCzechText, "The displayed language should be Czech, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseDanskOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningDanishText = mainPage.getVoiceWarningDanishText();
        String expectedDanishText = "Stemmeadvarsel";
        if (voiceWarningDanishText.equals(expectedDanishText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningDanishText, expectedDanishText, "The displayed language should be Danish, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseDeutschOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningGermanText = mainPage.getVoiceWarningGermanText();
        String expectedGermanText = "Sprach warnung";
        if (voiceWarningGermanText.equals(expectedGermanText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningGermanText, expectedGermanText, "The displayed language should be German, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseEspanolOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningSpanishText = mainPage.getVoiceWarningSpanishText();
        String expectedSpanishText = "Advert. de voz";
        if (voiceWarningSpanishText.equals(expectedSpanishText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningSpanishText, expectedSpanishText, "The displayed language should be Spanish, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseFrancaisOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningFranchiseText = mainPage.getVoiceWarningFranchiseText();
        String expectedFranchiseText = "Avertiss. vocal";
        if (voiceWarningFranchiseText.equals(expectedFranchiseText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningFranchiseText, expectedFranchiseText, "The displayed language should be French, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseIndonesiaOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningIndonesiaText = mainPage.getVoiceWarningIndonesiaText();
        String expectedIndonesiaText = "Pering. Suara";
        if (voiceWarningIndonesiaText.equals(expectedIndonesiaText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningIndonesiaText, expectedIndonesiaText, "The displayed language should be Indonesian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseItalianoOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningItalianText = mainPage.getVoiceWarningItalianText();
        String expectedItalianText = "Avviso vocale";
        if (voiceWarningItalianText.equals(expectedItalianText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningItalianText, expectedItalianText, "The displayed language should be Italian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseMagyarOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningHungarianText = mainPage.getVoiceWarningHungarianText();
        String expectedHungarianText = "Hang figyelmeztetés";
        if (voiceWarningHungarianText.equals(expectedHungarianText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningHungarianText, expectedHungarianText, "The displayed language should be Hungarian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseNederlandsOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningDutchText = mainPage.getVoiceWarningDutchText();
        String expectedDutchText = "Gesproken waarsch.";
        if (voiceWarningDutchText.equals(expectedDutchText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningDutchText, expectedDutchText, "The displayed language should be Dutch, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.choosePolskiOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningPolishText = mainPage.getVoiceWarningPolishText();
        String expectedPolishText = "Alert głosowe";
        if (voiceWarningPolishText.equals(expectedPolishText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningPolishText, expectedPolishText, "The displayed language should be Polish, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.choosePortuguesOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningPortugueseText = mainPage.getVoiceWarningPortugueseText();
        String expectedPortugueseText = "Aviso de voz";
        if (voiceWarningPortugueseText.equals(expectedPortugueseText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningPortugueseText, expectedPortugueseText, "The displayed language should be Portuguese, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseRomanaOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningRomanText = mainPage.getVoiceWarningRomanText();
        String expectedRomanText = "Avert. vocal";
        if (voiceWarningRomanText.equals(expectedRomanText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningRomanText, expectedRomanText, "The displayed language should be Romanian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSlovencinaOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningSlovenianText = mainPage.getVoiceWarningSlovenianText();
        String expectedSlovenianText = "Hlasové varov.";
        if (voiceWarningSlovenianText.equals(expectedSlovenianText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningSlovenianText, expectedSlovenianText, "The displayed language should be Slovenian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSvenskaOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningSwedishText = mainPage.getVoiceWarningSwedishText();
        String expectedSwedishText = "Röstvarning";
        if (voiceWarningSwedishText.equals(expectedSwedishText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningSwedishText, expectedSwedishText, "The displayed language should be Swedish, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSrpskiOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningSerbianText = mainPage.getVoiceWarningSerbianText();
        String expectedSerbianText = "Glasovno upozorenje";
        if (voiceWarningSerbianText.equals(expectedSerbianText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningSerbianText, expectedSerbianText, "The displayed language should be Serbian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSuomiOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningFinnishText = mainPage.getVoiceWarningFinnishText();
        String expectedFinnishText = "Ihmisen ääni Varoitus";
        if (voiceWarningFinnishText.equals(expectedFinnishText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningFinnishText, expectedFinnishText, "The displayed language should be Finnish, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseTürkceOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningTurkishText = mainPage.getVoiceWarningTurkishText();
        String expectedTurkishText = "Sesli uyarı";
        if (voiceWarningTurkishText.equals(expectedTurkishText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningTurkishText, expectedTurkishText, "The displayed language should be Turkish, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseBulgarianOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningBulgarianText = mainPage.getVoiceWarningBulgarianText();
        String expectedBulgarianText = "Гласово пред.";
        if (voiceWarningBulgarianText.equals(expectedBulgarianText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningBulgarianText, expectedBulgarianText, "The displayed language should be Bulgarian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseRussianOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningRussianText = mainPage.getVoiceWarningRussianText();
        String expectedRussianText = "Голосовое пред.";
        if (voiceWarningRussianText.equals(expectedRussianText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningRussianText, expectedRussianText, "The displayed language should be Russian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseUkrainianOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningUkrainianText = mainPage.getVoiceWarningUkrainianText();
        String expectedUkrainianText = "Голосове сповіщ.";
        if (voiceWarningUkrainianText.equals(expectedUkrainianText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningUkrainianText, expectedUkrainianText, "The displayed language should be Ukrainian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseGreekOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningGreekText = mainPage.getVoiceWarningGreekText();
        String expectedGreekText = "Φωνητική ειδοποίηση";
        if (voiceWarningGreekText.equals(expectedGreekText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningGreekText, expectedGreekText, "The displayed language should be Greek, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseVietnameseOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningVietnameseText = mainPage.getVoiceWarningVietnameseText();
        String expectedVietnameseText = "Cảnh báo bằng giọng nói";
        if (voiceWarningVietnameseText.equals(expectedVietnameseText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningVietnameseText, expectedVietnameseText, "The displayed language should be Vietnamese, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseJapaneseOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningJapaneseText = mainPage.getVoiceWarningJapaneseText();
        String expectedJapaneseText = "音声警告";
        if (voiceWarningJapaneseText.equals(expectedJapaneseText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningJapaneseText, expectedJapaneseText, "The displayed language should be Japanese, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseChineseOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningChineseText = mainPage.getVoiceWarningChineseText();
        String expectedChineseText = "语音警告";
        if (voiceWarningChineseText.equals(expectedChineseText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningChineseText, expectedChineseText, "The displayed language should be Chinese, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseKoreanOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningKoreanText = mainPage.getVoiceWarningKoreanText();
        String expectedKoreanText = "음성 경고";
        if (voiceWarningKoreanText.equals(expectedKoreanText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningKoreanText, expectedKoreanText, "The displayed language should be Korean, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseThaiOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningThaiText = mainPage.getVoiceWarningThaiText();
        String expectedThaiText = "คำเตือนด้วยเสียง";
        if (voiceWarningThaiText.equals(expectedThaiText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningThaiText, expectedThaiText, "The displayed language should be Thai, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseArabicOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningArabicText = mainPage.getVoiceWarningArabicText();
        String expectedArabicText = "تحذیر بالصوت";
        if (voiceWarningArabicText.equals(expectedArabicText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningArabicText, expectedArabicText, "The displayed language should be Arabic, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseFarsiOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningFarsiText = mainPage.getVoiceWarningFarsiText();
        String expectedFarsiText = "هشدار صوتی";
        if (voiceWarningFarsiText.equals(expectedFarsiText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningFarsiText, expectedFarsiText, "The displayed language should be Farsi, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseHebrewOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningHebrewText = mainPage.getVoiceWarningHebrewText();
        String expectedHebrewText = "אזהרה קולית";
        if (voiceWarningHebrewText.equals(expectedHebrewText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningHebrewText, expectedHebrewText, "The displayed language should be Hebrew, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseHindiOption();
        log.info(LOG_MESSAGE1);
        String voiceWarningHindiText = mainPage.getVoiceWarningHindiText();
        String expectedHindiText = "आवाज चेतावनी";
        if (voiceWarningHindiText.equals(expectedHindiText)) {
            log.info(LOG_MESSAGE2);
        } else {
            log.error(LOG_MESSAGE3);
        }
        Assert.assertEquals(voiceWarningHindiText, expectedHindiText, "The displayed language should be Hindi, but it is not.");
    }
}
