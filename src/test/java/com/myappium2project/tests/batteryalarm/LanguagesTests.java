package com.myappium2project.tests.batteryalarm;

import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.batteryalarm.LanguageUtils;
import org.testng.Assert;
import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmTestBase;
import org.testng.annotations.Test;

@Test(groups = {TestGroups.INTEGRATION})
public class LanguagesTests extends BatteryAlarmTestBase {
    private static final String CHECK_LANGUAGE_LOG = "We check if the app switches to the selected language";
    private static final String CORRECT_LANGUAGE_LOG = "The displayed language is correct";
    private static final String INCORRECT_LANGUAGE_LOG = "The displayed language is not correct";

    public static String incorrectLanguageAssertLog(String language) {
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
        if (voiceWarningEnglishText.equals(expectedEnglishText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningEnglishText, expectedEnglishText, incorrectLanguageAssertLog("English"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseCestinaOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningCzechText = mainPage.getVoiceWarningCzechText();
        String expectedCzechText = "Hlasové varování";
        if (voiceWarningCzechText.equals(expectedCzechText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningCzechText, expectedCzechText, incorrectLanguageAssertLog("Czech"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseDanskOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningDanishText = mainPage.getVoiceWarningDanishText();
        String expectedDanishText = "Stemmeadvarsel";
        if (voiceWarningDanishText.equals(expectedDanishText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningDanishText, expectedDanishText, incorrectLanguageAssertLog("Danish"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseDeutschOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningGermanText = mainPage.getVoiceWarningGermanText();
        String expectedGermanText = "Sprach warnung";
        if (voiceWarningGermanText.equals(expectedGermanText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningGermanText, expectedGermanText, incorrectLanguageAssertLog("German"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseEspanolOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningSpanishText = mainPage.getVoiceWarningSpanishText();
        String expectedSpanishText = "Advert. de voz";
        if (voiceWarningSpanishText.equals(expectedSpanishText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningSpanishText, expectedSpanishText, incorrectLanguageAssertLog("Spanish"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseFrancaisOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningFranchiseText = mainPage.getVoiceWarningFranchiseText();
        String expectedFranchiseText = "Avertiss. vocal";
        if (voiceWarningFranchiseText.equals(expectedFranchiseText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningFranchiseText, expectedFranchiseText, incorrectLanguageAssertLog("French"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseIndonesiaOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningIndonesiaText = mainPage.getVoiceWarningIndonesiaText();
        String expectedIndonesiaText = "Pering. Suara";
        if (voiceWarningIndonesiaText.equals(expectedIndonesiaText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningIndonesiaText, expectedIndonesiaText, incorrectLanguageAssertLog("Indonesian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseItalianoOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningItalianText = mainPage.getVoiceWarningItalianText();
        String expectedItalianText = "Avviso vocale";
        if (voiceWarningItalianText.equals(expectedItalianText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningItalianText, expectedItalianText, incorrectLanguageAssertLog("Italian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseMagyarOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningHungarianText = mainPage.getVoiceWarningHungarianText();
        String expectedHungarianText = "Hang figyelmeztetés";
        if (voiceWarningHungarianText.equals(expectedHungarianText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningHungarianText, expectedHungarianText, incorrectLanguageAssertLog("Hungarian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseNederlandsOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningDutchText = mainPage.getVoiceWarningDutchText();
        String expectedDutchText = "Gesproken waarsch.";
        if (voiceWarningDutchText.equals(expectedDutchText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningDutchText, expectedDutchText, incorrectLanguageAssertLog("Dutch"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.choosePolskiOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningPolishText = mainPage.getVoiceWarningPolishText();
        String expectedPolishText = "Alert głosowe";
        if (voiceWarningPolishText.equals(expectedPolishText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningPolishText, expectedPolishText, incorrectLanguageAssertLog("Polish"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.choosePortuguesOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningPortugueseText = mainPage.getVoiceWarningPortugueseText();
        String expectedPortugueseText = "Aviso de voz";
        if (voiceWarningPortugueseText.equals(expectedPortugueseText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningPortugueseText, expectedPortugueseText, incorrectLanguageAssertLog("Portuguese"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseRomanaOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningRomanText = mainPage.getVoiceWarningRomanText();
        String expectedRomanText = "Avert. vocal";
        if (voiceWarningRomanText.equals(expectedRomanText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningRomanText, expectedRomanText, incorrectLanguageAssertLog("Romanian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSlovencinaOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningSlovenianText = mainPage.getVoiceWarningSlovenianText();
        String expectedSlovenianText = "Hlasové varov.";
        if (voiceWarningSlovenianText.equals(expectedSlovenianText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningSlovenianText, expectedSlovenianText, incorrectLanguageAssertLog("Slovenian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSvenskaOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningSwedishText = mainPage.getVoiceWarningSwedishText();
        String expectedSwedishText = "Röstvarning";
        if (voiceWarningSwedishText.equals(expectedSwedishText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningSwedishText, expectedSwedishText, incorrectLanguageAssertLog("Swedish"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSrpskiOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningSerbianText = mainPage.getVoiceWarningSerbianText();
        String expectedSerbianText = "Glasovno upozorenje";
        if (voiceWarningSerbianText.equals(expectedSerbianText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningSerbianText, expectedSerbianText, incorrectLanguageAssertLog("Serbian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSuomiOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningFinnishText = mainPage.getVoiceWarningFinnishText();
        String expectedFinnishText = "Ihmisen ääni Varoitus";
        if (voiceWarningFinnishText.equals(expectedFinnishText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningFinnishText, expectedFinnishText, incorrectLanguageAssertLog("Finnish"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseTurkceOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningTurkishText = mainPage.getVoiceWarningTurkishText();
        String expectedTurkishText = "Sesli uyarı";
        if (voiceWarningTurkishText.equals(expectedTurkishText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningTurkishText, expectedTurkishText, incorrectLanguageAssertLog("Turkish"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseBulgarianOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningBulgarianText = mainPage.getVoiceWarningBulgarianText();
        String expectedBulgarianText = "Гласово пред.";
        if (voiceWarningBulgarianText.equals(expectedBulgarianText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningBulgarianText, expectedBulgarianText, incorrectLanguageAssertLog("Bulgarian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseRussianOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningRussianText = mainPage.getVoiceWarningRussianText();
        String expectedRussianText = "Голосовое пред.";
        if (voiceWarningRussianText.equals(expectedRussianText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningRussianText, expectedRussianText, incorrectLanguageAssertLog("Russian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseUkrainianOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningUkrainianText = mainPage.getVoiceWarningUkrainianText();
        String expectedUkrainianText = "Голосове сповіщ.";
        if (voiceWarningUkrainianText.equals(expectedUkrainianText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningUkrainianText, expectedUkrainianText, incorrectLanguageAssertLog("Ukrainian"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseGreekOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningGreekText = mainPage.getVoiceWarningGreekText();
        String expectedGreekText = "Φωνητική ειδοποίηση";
        if (voiceWarningGreekText.equals(expectedGreekText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningGreekText, expectedGreekText, incorrectLanguageAssertLog("Greek"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseVietnameseOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningVietnameseText = mainPage.getVoiceWarningVietnameseText();
        String expectedVietnameseText = "Cảnh báo bằng giọng nói";
        if (voiceWarningVietnameseText.equals(expectedVietnameseText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningVietnameseText, expectedVietnameseText, incorrectLanguageAssertLog("Vietnamese"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseJapaneseOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningJapaneseText = mainPage.getVoiceWarningJapaneseText();
        String expectedJapaneseText = "音声警告";
        if (voiceWarningJapaneseText.equals(expectedJapaneseText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningJapaneseText, expectedJapaneseText, incorrectLanguageAssertLog("Japanese"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseChineseOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningChineseText = mainPage.getVoiceWarningChineseText();
        String expectedChineseText = "语音警告";
        if (voiceWarningChineseText.equals(expectedChineseText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningChineseText, expectedChineseText, incorrectLanguageAssertLog("Chinese"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseKoreanOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningKoreanText = mainPage.getVoiceWarningKoreanText();
        String expectedKoreanText = "음성 경고";
        if (voiceWarningKoreanText.equals(expectedKoreanText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningKoreanText, expectedKoreanText, incorrectLanguageAssertLog("Korean"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseThaiOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningThaiText = mainPage.getVoiceWarningThaiText();
        String expectedThaiText = "คำเตือนด้วยเสียง";
        if (voiceWarningThaiText.equals(expectedThaiText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningThaiText, expectedThaiText, incorrectLanguageAssertLog("Thai"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseArabicOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningArabicText = mainPage.getVoiceWarningArabicText();
        String expectedArabicText = "تحذیر بالصوت";
        if (voiceWarningArabicText.equals(expectedArabicText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningArabicText, expectedArabicText, incorrectLanguageAssertLog("Arabic"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseFarsiOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningFarsiText = mainPage.getVoiceWarningFarsiText();
        String expectedFarsiText = "هشدار صوتی";
        if (voiceWarningFarsiText.equals(expectedFarsiText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningFarsiText, expectedFarsiText, incorrectLanguageAssertLog("Farsi"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseHebrewOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningHebrewText = mainPage.getVoiceWarningHebrewText();
        String expectedHebrewText = "אזהרה קולית";
        if (voiceWarningHebrewText.equals(expectedHebrewText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningHebrewText, expectedHebrewText, incorrectLanguageAssertLog("Hebrew"));

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseHindiOption();
        LOG.info(CHECK_LANGUAGE_LOG);
        String voiceWarningHindiText = mainPage.getVoiceWarningHindiText();
        String expectedHindiText = "आवाज चेतावनी";
        if (voiceWarningHindiText.equals(expectedHindiText)) {
            LOG.info(CORRECT_LANGUAGE_LOG);
        } else {
            LOG.error(INCORRECT_LANGUAGE_LOG);
        }
        Assert.assertEquals(voiceWarningHindiText, expectedHindiText, incorrectLanguageAssertLog("Hindi"));
    }
}