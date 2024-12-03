package com.myappium2project.tests.batteryalarm;

import com.myappium2project.utils.batteryalarm.LanguageUtils;
import org.testng.Assert;
import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmBaseTest;
import org.testng.annotations.Test;

public class LanguagesTests extends BatteryAlarmBaseTest {
    private static final String CHECK_LANGUAGE_LOG = "We check if the app switches to the selected language";
    private static final String LANGUAGE_CORRECT_LOG = "The displayed language is correct";
    private static final String LANGUAGE_INCORRECT_ERRORLOG = "The displayed language is not correct";

    public static String getLanguageValidationAssertLog(String language) {
        return String.format("The displayed language should be %s, but it is not.", language);
    }

    @Test
    public void testLanguages() {
        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.scrollToEnglishLanguage(driver, mainPage, languagesDropdownMenu);

        languagesDropdownMenu.chooseEnglishOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningEnglishText = mainPage.getVoiceWarningEnglishText();
        String expectedEnglishText = "Voice Warning";
        if (voiceWarningEnglishText.equals(expectedEnglishText))
            LOG.info(LANGUAGE_CORRECT_LOG);
        else
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        Assert.assertEquals(voiceWarningEnglishText, expectedEnglishText, getLanguageValidationAssertLog("English"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseCestinaOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningCzechText = mainPage.getVoiceWarningCzechText();
        String expectedCzechText = "Hlasové varování";
        if (voiceWarningCzechText.equals(expectedCzechText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningCzechText, expectedCzechText, getLanguageValidationAssertLog("Czech"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseDanskOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningDanishText = mainPage.getVoiceWarningDanishText();
        String expectedDanishText = "Stemmeadvarsel";
        if (voiceWarningDanishText.equals(expectedDanishText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningDanishText, expectedDanishText, getLanguageValidationAssertLog("Danish"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseDeutschOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningGermanText = mainPage.getVoiceWarningGermanText();
        String expectedGermanText = "Sprach warnung";
        if (voiceWarningGermanText.equals(expectedGermanText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningGermanText, expectedGermanText, getLanguageValidationAssertLog("German"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseEspanolOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningSpanishText = mainPage.getVoiceWarningSpanishText();
        String expectedSpanishText = "Advert. de voz";
        if (voiceWarningSpanishText.equals(expectedSpanishText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningSpanishText, expectedSpanishText, getLanguageValidationAssertLog("Spanish"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseFrancaisOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningFranchiseText = mainPage.getVoiceWarningFranchiseText();
        String expectedFranchiseText = "Avertiss. vocal";
        if (voiceWarningFranchiseText.equals(expectedFranchiseText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningFranchiseText, expectedFranchiseText, getLanguageValidationAssertLog("French"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseIndonesiaOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningIndonesiaText = mainPage.getVoiceWarningIndonesiaText();
        String expectedIndonesiaText = "Pering. Suara";
        if (voiceWarningIndonesiaText.equals(expectedIndonesiaText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningIndonesiaText, expectedIndonesiaText, getLanguageValidationAssertLog("Indonesian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseItalianoOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningItalianText = mainPage.getVoiceWarningItalianText();
        String expectedItalianText = "Avviso vocale";
        if (voiceWarningItalianText.equals(expectedItalianText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningItalianText, expectedItalianText, getLanguageValidationAssertLog("Italian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseMagyarOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningHungarianText = mainPage.getVoiceWarningHungarianText();
        String expectedHungarianText = "Hang figyelmeztetés";
        if (voiceWarningHungarianText.equals(expectedHungarianText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningHungarianText, expectedHungarianText, getLanguageValidationAssertLog("Hungarian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseNederlandsOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningDutchText = mainPage.getVoiceWarningDutchText();
        String expectedDutchText = "Gesproken waarsch.";
        if (voiceWarningDutchText.equals(expectedDutchText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningDutchText, expectedDutchText, getLanguageValidationAssertLog("Dutch"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.choosePolskiOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningPolishText = mainPage.getVoiceWarningPolishText();
        String expectedPolishText = "Alert głosowe";
        if (voiceWarningPolishText.equals(expectedPolishText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningPolishText, expectedPolishText, getLanguageValidationAssertLog("Polish"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.choosePortuguesOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningPortugueseText = mainPage.getVoiceWarningPortugueseText();
        String expectedPortugueseText = "Aviso de voz";
        if (voiceWarningPortugueseText.equals(expectedPortugueseText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningPortugueseText, expectedPortugueseText, getLanguageValidationAssertLog("Portuguese"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseRomanaOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningRomanText = mainPage.getVoiceWarningRomanText();
        String expectedRomanText = "Avert. vocal";
        if (voiceWarningRomanText.equals(expectedRomanText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningRomanText, expectedRomanText, getLanguageValidationAssertLog("Romanian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSlovencinaOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningSlovenianText = mainPage.getVoiceWarningSlovenianText();
        String expectedSlovenianText = "Hlasové varov.";
        if (voiceWarningSlovenianText.equals(expectedSlovenianText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningSlovenianText, expectedSlovenianText, getLanguageValidationAssertLog("Slovenian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSvenskaOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningSwedishText = mainPage.getVoiceWarningSwedishText();
        String expectedSwedishText = "Röstvarning";
        if (voiceWarningSwedishText.equals(expectedSwedishText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningSwedishText, expectedSwedishText, getLanguageValidationAssertLog("Swedish"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSrpskiOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningSerbianText = mainPage.getVoiceWarningSerbianText();
        String expectedSerbianText = "Glasovno upozorenje";
        if (voiceWarningSerbianText.equals(expectedSerbianText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningSerbianText, expectedSerbianText, getLanguageValidationAssertLog("Serbian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSuomiOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningFinnishText = mainPage.getVoiceWarningFinnishText();
        String expectedFinnishText = "Ihmisen ääni Varoitus";
        if (voiceWarningFinnishText.equals(expectedFinnishText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningFinnishText, expectedFinnishText, getLanguageValidationAssertLog("Finnish"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseTurkceOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningTurkishText = mainPage.getVoiceWarningTurkishText();
        String expectedTurkishText = "Sesli uyarı";
        if (voiceWarningTurkishText.equals(expectedTurkishText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningTurkishText, expectedTurkishText, getLanguageValidationAssertLog("Turkish"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseBulgarianOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningBulgarianText = mainPage.getVoiceWarningBulgarianText();
        String expectedBulgarianText = "Гласово пред.";
        if (voiceWarningBulgarianText.equals(expectedBulgarianText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningBulgarianText, expectedBulgarianText, getLanguageValidationAssertLog("Bulgarian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseRussianOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningRussianText = mainPage.getVoiceWarningRussianText();
        String expectedRussianText = "Голосовое пред.";
        if (voiceWarningRussianText.equals(expectedRussianText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningRussianText, expectedRussianText, getLanguageValidationAssertLog("Russian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseUkrainianOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningUkrainianText = mainPage.getVoiceWarningUkrainianText();
        String expectedUkrainianText = "Голосове сповіщ.";
        if (voiceWarningUkrainianText.equals(expectedUkrainianText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningUkrainianText, expectedUkrainianText, getLanguageValidationAssertLog("Ukrainian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseGreekOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningGreekText = mainPage.getVoiceWarningGreekText();
        String expectedGreekText = "Φωνητική ειδοποίηση";
        if (voiceWarningGreekText.equals(expectedGreekText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningGreekText, expectedGreekText, getLanguageValidationAssertLog("Greek"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseVietnameseOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningVietnameseText = mainPage.getVoiceWarningVietnameseText();
        String expectedVietnameseText = "Cảnh báo bằng giọng nói";
        if (voiceWarningVietnameseText.equals(expectedVietnameseText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningVietnameseText, expectedVietnameseText, getLanguageValidationAssertLog("Vietnamese"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseJapaneseOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningJapaneseText = mainPage.getVoiceWarningJapaneseText();
        String expectedJapaneseText = "音声警告";
        if (voiceWarningJapaneseText.equals(expectedJapaneseText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningJapaneseText, expectedJapaneseText, getLanguageValidationAssertLog("Japanese"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseChineseOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningChineseText = mainPage.getVoiceWarningChineseText();
        String expectedChineseText = "语音警告";
        if (voiceWarningChineseText.equals(expectedChineseText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningChineseText, expectedChineseText, getLanguageValidationAssertLog("Chinese"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseKoreanOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningKoreanText = mainPage.getVoiceWarningKoreanText();
        String expectedKoreanText = "음성 경고";
        if (voiceWarningKoreanText.equals(expectedKoreanText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningKoreanText, expectedKoreanText, getLanguageValidationAssertLog("Korean"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseThaiOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningThaiText = mainPage.getVoiceWarningThaiText();
        String expectedThaiText = "คำเตือนด้วยเสียง";
        if (voiceWarningThaiText.equals(expectedThaiText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningThaiText, expectedThaiText, getLanguageValidationAssertLog("Thai"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseArabicOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningArabicText = mainPage.getVoiceWarningArabicText();
        String expectedArabicText = "تحذیر بالصوت";
        if (voiceWarningArabicText.equals(expectedArabicText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningArabicText, expectedArabicText, getLanguageValidationAssertLog("Arabic"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseFarsiOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningFarsiText = mainPage.getVoiceWarningFarsiText();
        String expectedFarsiText = "هشدار صوتی";
        if (voiceWarningFarsiText.equals(expectedFarsiText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningFarsiText, expectedFarsiText, getLanguageValidationAssertLog("Farsi"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseHebrewOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningHebrewText = mainPage.getVoiceWarningHebrewText();
        String expectedHebrewText = "אזהרה קולית";
        if (voiceWarningHebrewText.equals(expectedHebrewText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningHebrewText, expectedHebrewText, getLanguageValidationAssertLog("Hebrew"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseHindiOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningHindiText = mainPage.getVoiceWarningHindiText();
        String expectedHindiText = "आवाज चेतावनी";
        if (voiceWarningHindiText.equals(expectedHindiText)) {
            LOG.info(LANGUAGE_CORRECT_LOG);
        } else {
            LOG.error(LANGUAGE_INCORRECT_ERRORLOG);
        }
        Assert.assertEquals(voiceWarningHindiText, expectedHindiText, getLanguageValidationAssertLog("Hindi"));
    }
}