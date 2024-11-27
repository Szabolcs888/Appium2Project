package com.myappium2project.tests.batteryalarm;

import com.myappium2project.utils.batteryalarm.LanguageUtils;
import org.testng.Assert;
import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmBaseTest;
import org.testng.annotations.Test;

public class LanguagesTests extends BatteryAlarmBaseTest {

    @Test
    public void testLanguages() {
        String LOG_CHECK_LANGUAGE = "We check whether the app switches to the selected language";
        String LOG_LANGUAGE_CORRECT = "The displayed language is correct";
        String LOG_LANGUAGE_INCORRECT = "The displayed language is not correct";
        String ASSERT_MESSAGE_BASE = "The displayed language should be ";
        String ASSERT_MESSAGE_SUFFIX = ", but it is not.";

        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        LanguageUtils.scrollToEnglishLanguage(driver, mainPage, languagesDropdownMenu);

        languagesDropdownMenu.chooseEnglishOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningEnglishText = mainPage.getVoiceWarningEnglishText();
        String expectedEnglishText = "Voice Warning";
        if (voiceWarningEnglishText.equals(expectedEnglishText))
            LOG.info(LOG_LANGUAGE_CORRECT);
        else
            LOG.error(LOG_LANGUAGE_INCORRECT);
        Assert.assertEquals(voiceWarningEnglishText, expectedEnglishText,
                ASSERT_MESSAGE_BASE + "English" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseCestinaOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningCzechText = mainPage.getVoiceWarningCzechText();
        String expectedCzechText = "Hlasové varování";
        if (voiceWarningCzechText.equals(expectedCzechText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningCzechText, expectedCzechText,
                ASSERT_MESSAGE_BASE + "Czech" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseDanskOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningDanishText = mainPage.getVoiceWarningDanishText();
        String expectedDanishText = "Stemmeadvarsel";
        if (voiceWarningDanishText.equals(expectedDanishText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningDanishText, expectedDanishText,
                ASSERT_MESSAGE_BASE + "Danish" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseDeutschOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningGermanText = mainPage.getVoiceWarningGermanText();
        String expectedGermanText = "Sprach warnung";
        if (voiceWarningGermanText.equals(expectedGermanText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningGermanText, expectedGermanText,
                ASSERT_MESSAGE_BASE + "German" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseEspanolOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningSpanishText = mainPage.getVoiceWarningSpanishText();
        String expectedSpanishText = "Advert. de voz";
        if (voiceWarningSpanishText.equals(expectedSpanishText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningSpanishText, expectedSpanishText,
                ASSERT_MESSAGE_BASE + "Spanish" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseFrancaisOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningFranchiseText = mainPage.getVoiceWarningFranchiseText();
        String expectedFranchiseText = "Avertiss. vocal";
        if (voiceWarningFranchiseText.equals(expectedFranchiseText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningFranchiseText, expectedFranchiseText,
                ASSERT_MESSAGE_BASE + "French" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseIndonesiaOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningIndonesiaText = mainPage.getVoiceWarningIndonesiaText();
        String expectedIndonesiaText = "Pering. Suara";
        if (voiceWarningIndonesiaText.equals(expectedIndonesiaText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningIndonesiaText, expectedIndonesiaText,
                ASSERT_MESSAGE_BASE + "Indonesian" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseItalianoOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningItalianText = mainPage.getVoiceWarningItalianText();
        String expectedItalianText = "Avviso vocale";
        if (voiceWarningItalianText.equals(expectedItalianText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningItalianText, expectedItalianText,
                ASSERT_MESSAGE_BASE + "Italian" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseMagyarOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningHungarianText = mainPage.getVoiceWarningHungarianText();
        String expectedHungarianText = "Hang figyelmeztetés";
        if (voiceWarningHungarianText.equals(expectedHungarianText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningHungarianText, expectedHungarianText,
                ASSERT_MESSAGE_BASE + "Hungarian" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseNederlandsOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningDutchText = mainPage.getVoiceWarningDutchText();
        String expectedDutchText = "Gesproken waarsch.";
        if (voiceWarningDutchText.equals(expectedDutchText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningDutchText, expectedDutchText,
                ASSERT_MESSAGE_BASE + "Dutch" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.choosePolskiOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningPolishText = mainPage.getVoiceWarningPolishText();
        String expectedPolishText = "Alert głosowe";
        if (voiceWarningPolishText.equals(expectedPolishText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningPolishText, expectedPolishText,
                ASSERT_MESSAGE_BASE + "Polish" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.choosePortuguesOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningPortugueseText = mainPage.getVoiceWarningPortugueseText();
        String expectedPortugueseText = "Aviso de voz";
        if (voiceWarningPortugueseText.equals(expectedPortugueseText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningPortugueseText, expectedPortugueseText,
                ASSERT_MESSAGE_BASE + "Portuguese" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseRomanaOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningRomanText = mainPage.getVoiceWarningRomanText();
        String expectedRomanText = "Avert. vocal";
        if (voiceWarningRomanText.equals(expectedRomanText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningRomanText, expectedRomanText,
                ASSERT_MESSAGE_BASE + "Romanian" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSlovencinaOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningSlovenianText = mainPage.getVoiceWarningSlovenianText();
        String expectedSlovenianText = "Hlasové varov.";
        if (voiceWarningSlovenianText.equals(expectedSlovenianText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningSlovenianText, expectedSlovenianText,
                ASSERT_MESSAGE_BASE + "Slovenian" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSvenskaOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningSwedishText = mainPage.getVoiceWarningSwedishText();
        String expectedSwedishText = "Röstvarning";
        if (voiceWarningSwedishText.equals(expectedSwedishText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningSwedishText, expectedSwedishText,
                ASSERT_MESSAGE_BASE + "Swedish" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSrpskiOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningSerbianText = mainPage.getVoiceWarningSerbianText();
        String expectedSerbianText = "Glasovno upozorenje";
        if (voiceWarningSerbianText.equals(expectedSerbianText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningSerbianText, expectedSerbianText,
                ASSERT_MESSAGE_BASE + "Serbian" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSuomiOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningFinnishText = mainPage.getVoiceWarningFinnishText();
        String expectedFinnishText = "Ihmisen ääni Varoitus";
        if (voiceWarningFinnishText.equals(expectedFinnishText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningFinnishText, expectedFinnishText,
                ASSERT_MESSAGE_BASE + "Finnish" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseTurkceOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningTurkishText = mainPage.getVoiceWarningTurkishText();
        String expectedTurkishText = "Sesli uyarı";
        if (voiceWarningTurkishText.equals(expectedTurkishText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningTurkishText, expectedTurkishText,
                ASSERT_MESSAGE_BASE + "Turkish" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseBulgarianOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningBulgarianText = mainPage.getVoiceWarningBulgarianText();
        String expectedBulgarianText = "Гласово пред.";
        if (voiceWarningBulgarianText.equals(expectedBulgarianText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningBulgarianText, expectedBulgarianText,
                ASSERT_MESSAGE_BASE + "Bulgarian" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseRussianOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningRussianText = mainPage.getVoiceWarningRussianText();
        String expectedRussianText = "Голосовое пред.";
        if (voiceWarningRussianText.equals(expectedRussianText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningRussianText, expectedRussianText,
                ASSERT_MESSAGE_BASE + "Russian" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseUkrainianOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningUkrainianText = mainPage.getVoiceWarningUkrainianText();
        String expectedUkrainianText = "Голосове сповіщ.";
        if (voiceWarningUkrainianText.equals(expectedUkrainianText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningUkrainianText, expectedUkrainianText,
                ASSERT_MESSAGE_BASE + "Ukrainian" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseGreekOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningGreekText = mainPage.getVoiceWarningGreekText();
        String expectedGreekText = "Φωνητική ειδοποίηση";
        if (voiceWarningGreekText.equals(expectedGreekText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningGreekText, expectedGreekText,
                ASSERT_MESSAGE_BASE + "Greek" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseVietnameseOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningVietnameseText = mainPage.getVoiceWarningVietnameseText();
        String expectedVietnameseText = "Cảnh báo bằng giọng nói";
        if (voiceWarningVietnameseText.equals(expectedVietnameseText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningVietnameseText, expectedVietnameseText,
                ASSERT_MESSAGE_BASE + "Vietnamese" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseJapaneseOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningJapaneseText = mainPage.getVoiceWarningJapaneseText();
        String expectedJapaneseText = "音声警告";
        if (voiceWarningJapaneseText.equals(expectedJapaneseText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningJapaneseText, expectedJapaneseText,
                ASSERT_MESSAGE_BASE + "Japanese" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseChineseOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningChineseText = mainPage.getVoiceWarningChineseText();
        String expectedChineseText = "语音警告";
        if (voiceWarningChineseText.equals(expectedChineseText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningChineseText, expectedChineseText,
                ASSERT_MESSAGE_BASE + "Chinese" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseKoreanOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningKoreanText = mainPage.getVoiceWarningKoreanText();
        String expectedKoreanText = "음성 경고";
        if (voiceWarningKoreanText.equals(expectedKoreanText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningKoreanText, expectedKoreanText,
                ASSERT_MESSAGE_BASE + "Korean" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseThaiOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningThaiText = mainPage.getVoiceWarningThaiText();
        String expectedThaiText = "คำเตือนด้วยเสียง";
        if (voiceWarningThaiText.equals(expectedThaiText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningThaiText, expectedThaiText,
                ASSERT_MESSAGE_BASE + "Thai" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseArabicOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningArabicText = mainPage.getVoiceWarningArabicText();
        String expectedArabicText = "تحذیر بالصوت";
        if (voiceWarningArabicText.equals(expectedArabicText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningArabicText, expectedArabicText,
                ASSERT_MESSAGE_BASE + "Arabic" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseFarsiOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningFarsiText = mainPage.getVoiceWarningFarsiText();
        String expectedFarsiText = "هشدار صوتی";
        if (voiceWarningFarsiText.equals(expectedFarsiText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningFarsiText, expectedFarsiText,
                ASSERT_MESSAGE_BASE + "Farsi" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseHebrewOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningHebrewText = mainPage.getVoiceWarningHebrewText();
        String expectedHebrewText = "אזהרה קולית";
        if (voiceWarningHebrewText.equals(expectedHebrewText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningHebrewText, expectedHebrewText,
                ASSERT_MESSAGE_BASE + "Hebrew" + ASSERT_MESSAGE_SUFFIX);

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseHindiOption();
        LOG.info(LOG_CHECK_LANGUAGE);
        String voiceWarningHindiText = mainPage.getVoiceWarningHindiText();
        String expectedHindiText = "आवाज चेतावनी";
        if (voiceWarningHindiText.equals(expectedHindiText)) {
            LOG.info(LOG_LANGUAGE_CORRECT);
        } else {
            LOG.error(LOG_LANGUAGE_INCORRECT);
        }
        Assert.assertEquals(voiceWarningHindiText, expectedHindiText,
                ASSERT_MESSAGE_BASE + "Hindi" + ASSERT_MESSAGE_SUFFIX);
    }
}