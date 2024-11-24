package com.myappium2project.tests.batteryalarm;

import org.testng.Assert;
import com.myappium2project.pages.batteryalarm.LanguagesDropdownMenu;
import com.myappium2project.pages.batteryalarm.MainPage;
import com.myappium2project.tests.basetests.BatteryAlarmBaseTest;
import org.testng.annotations.Test;
import com.myappium2project.utils.AppiumActions;

public class LanguagesTests extends BatteryAlarmBaseTest {

    @Test
    public void testLanguages() {
        String LOG_MESSAGE_1 = "We check whether the app switches to the selected language";
        String LOG_MESSAGE_2 = "The displayed language is correct";
        String LOG_MESSAGE_3 = "The displayed language is not correct";

        MainPage mainPage = new MainPage(driver);
        LanguagesDropdownMenu languagesDropdownMenu = new LanguagesDropdownMenu(driver);
        if (!mainPage.getSelectedLanguage().equals("English")) {
            languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
            AppiumActions.scrollWithFreeCoordinates(driver, 2, 112, 700, 112, 1900, "We scroll up in the dropdown menu");
        } else {
            languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        }

        languagesDropdownMenu.chooseEnglishOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningEnglishText = mainPage.getVoiceWarningEnglishText();
        String expectedEnglishText = "Voice Warning";
        if (voiceWarningEnglishText.equals(expectedEnglishText))
            LOG.info(LOG_MESSAGE_2);
        else
            LOG.error(LOG_MESSAGE_3);
        Assert.assertEquals(voiceWarningEnglishText, expectedEnglishText, "The displayed language should be English, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseCestinaOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningCzechText = mainPage.getVoiceWarningCzechText();
        String expectedCzechText = "Hlasové varování";
        if (voiceWarningCzechText.equals(expectedCzechText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningCzechText, expectedCzechText, "The displayed language should be Czech, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseDanskOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningDanishText = mainPage.getVoiceWarningDanishText();
        String expectedDanishText = "Stemmeadvarsel";
        if (voiceWarningDanishText.equals(expectedDanishText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningDanishText, expectedDanishText, "The displayed language should be Danish, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseDeutschOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningGermanText = mainPage.getVoiceWarningGermanText();
        String expectedGermanText = "Sprach warnung";
        if (voiceWarningGermanText.equals(expectedGermanText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningGermanText, expectedGermanText, "The displayed language should be German, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseEspanolOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningSpanishText = mainPage.getVoiceWarningSpanishText();
        String expectedSpanishText = "Advert. de voz";
        if (voiceWarningSpanishText.equals(expectedSpanishText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningSpanishText, expectedSpanishText, "The displayed language should be Spanish, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseFrancaisOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningFranchiseText = mainPage.getVoiceWarningFranchiseText();
        String expectedFranchiseText = "Avertiss. vocal";
        if (voiceWarningFranchiseText.equals(expectedFranchiseText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningFranchiseText, expectedFranchiseText, "The displayed language should be French, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseIndonesiaOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningIndonesiaText = mainPage.getVoiceWarningIndonesiaText();
        String expectedIndonesiaText = "Pering. Suara";
        if (voiceWarningIndonesiaText.equals(expectedIndonesiaText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningIndonesiaText, expectedIndonesiaText, "The displayed language should be Indonesian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseItalianoOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningItalianText = mainPage.getVoiceWarningItalianText();
        String expectedItalianText = "Avviso vocale";
        if (voiceWarningItalianText.equals(expectedItalianText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningItalianText, expectedItalianText, "The displayed language should be Italian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseMagyarOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningHungarianText = mainPage.getVoiceWarningHungarianText();
        String expectedHungarianText = "Hang figyelmeztetés";
        if (voiceWarningHungarianText.equals(expectedHungarianText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningHungarianText, expectedHungarianText, "The displayed language should be Hungarian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseNederlandsOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningDutchText = mainPage.getVoiceWarningDutchText();
        String expectedDutchText = "Gesproken waarsch.";
        if (voiceWarningDutchText.equals(expectedDutchText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningDutchText, expectedDutchText, "The displayed language should be Dutch, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.choosePolskiOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningPolishText = mainPage.getVoiceWarningPolishText();
        String expectedPolishText = "Alert głosowe";
        if (voiceWarningPolishText.equals(expectedPolishText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningPolishText, expectedPolishText, "The displayed language should be Polish, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.choosePortuguesOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningPortugueseText = mainPage.getVoiceWarningPortugueseText();
        String expectedPortugueseText = "Aviso de voz";
        if (voiceWarningPortugueseText.equals(expectedPortugueseText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningPortugueseText, expectedPortugueseText, "The displayed language should be Portuguese, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseRomanaOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningRomanText = mainPage.getVoiceWarningRomanText();
        String expectedRomanText = "Avert. vocal";
        if (voiceWarningRomanText.equals(expectedRomanText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningRomanText, expectedRomanText, "The displayed language should be Romanian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSlovencinaOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningSlovenianText = mainPage.getVoiceWarningSlovenianText();
        String expectedSlovenianText = "Hlasové varov.";
        if (voiceWarningSlovenianText.equals(expectedSlovenianText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningSlovenianText, expectedSlovenianText, "The displayed language should be Slovenian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSvenskaOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningSwedishText = mainPage.getVoiceWarningSwedishText();
        String expectedSwedishText = "Röstvarning";
        if (voiceWarningSwedishText.equals(expectedSwedishText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningSwedishText, expectedSwedishText, "The displayed language should be Swedish, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSrpskiOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningSerbianText = mainPage.getVoiceWarningSerbianText();
        String expectedSerbianText = "Glasovno upozorenje";
        if (voiceWarningSerbianText.equals(expectedSerbianText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningSerbianText, expectedSerbianText, "The displayed language should be Serbian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseSuomiOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningFinnishText = mainPage.getVoiceWarningFinnishText();
        String expectedFinnishText = "Ihmisen ääni Varoitus";
        if (voiceWarningFinnishText.equals(expectedFinnishText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningFinnishText, expectedFinnishText, "The displayed language should be Finnish, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseTurkceOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningTurkishText = mainPage.getVoiceWarningTurkishText();
        String expectedTurkishText = "Sesli uyarı";
        if (voiceWarningTurkishText.equals(expectedTurkishText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningTurkishText, expectedTurkishText, "The displayed language should be Turkish, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseBulgarianOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningBulgarianText = mainPage.getVoiceWarningBulgarianText();
        String expectedBulgarianText = "Гласово пред.";
        if (voiceWarningBulgarianText.equals(expectedBulgarianText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningBulgarianText, expectedBulgarianText, "The displayed language should be Bulgarian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseRussianOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningRussianText = mainPage.getVoiceWarningRussianText();
        String expectedRussianText = "Голосовое пред.";
        if (voiceWarningRussianText.equals(expectedRussianText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningRussianText, expectedRussianText, "The displayed language should be Russian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseUkrainianOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningUkrainianText = mainPage.getVoiceWarningUkrainianText();
        String expectedUkrainianText = "Голосове сповіщ.";
        if (voiceWarningUkrainianText.equals(expectedUkrainianText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningUkrainianText, expectedUkrainianText, "The displayed language should be Ukrainian, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseGreekOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningGreekText = mainPage.getVoiceWarningGreekText();
        String expectedGreekText = "Φωνητική ειδοποίηση";
        if (voiceWarningGreekText.equals(expectedGreekText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningGreekText, expectedGreekText, "The displayed language should be Greek, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseVietnameseOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningVietnameseText = mainPage.getVoiceWarningVietnameseText();
        String expectedVietnameseText = "Cảnh báo bằng giọng nói";
        if (voiceWarningVietnameseText.equals(expectedVietnameseText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningVietnameseText, expectedVietnameseText, "The displayed language should be Vietnamese, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseJapaneseOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningJapaneseText = mainPage.getVoiceWarningJapaneseText();
        String expectedJapaneseText = "音声警告";
        if (voiceWarningJapaneseText.equals(expectedJapaneseText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningJapaneseText, expectedJapaneseText, "The displayed language should be Japanese, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseChineseOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningChineseText = mainPage.getVoiceWarningChineseText();
        String expectedChineseText = "语音警告";
        if (voiceWarningChineseText.equals(expectedChineseText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningChineseText, expectedChineseText, "The displayed language should be Chinese, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseKoreanOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningKoreanText = mainPage.getVoiceWarningKoreanText();
        String expectedKoreanText = "음성 경고";
        if (voiceWarningKoreanText.equals(expectedKoreanText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningKoreanText, expectedKoreanText, "The displayed language should be Korean, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseThaiOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningThaiText = mainPage.getVoiceWarningThaiText();
        String expectedThaiText = "คำเตือนด้วยเสียง";
        if (voiceWarningThaiText.equals(expectedThaiText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningThaiText, expectedThaiText, "The displayed language should be Thai, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseArabicOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningArabicText = mainPage.getVoiceWarningArabicText();
        String expectedArabicText = "تحذیر بالصوت";
        if (voiceWarningArabicText.equals(expectedArabicText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningArabicText, expectedArabicText, "The displayed language should be Arabic, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseFarsiOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningFarsiText = mainPage.getVoiceWarningFarsiText();
        String expectedFarsiText = "هشدار صوتی";
        if (voiceWarningFarsiText.equals(expectedFarsiText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningFarsiText, expectedFarsiText, "The displayed language should be Farsi, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseHebrewOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningHebrewText = mainPage.getVoiceWarningHebrewText();
        String expectedHebrewText = "אזהרה קולית";
        if (voiceWarningHebrewText.equals(expectedHebrewText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningHebrewText, expectedHebrewText, "The displayed language should be Hebrew, but it is not.");

        languagesDropdownMenu.pressLanguageSelectorDropdownMenuButton();
        languagesDropdownMenu.chooseHindiOption();
        LOG.info(LOG_MESSAGE_1);
        String voiceWarningHindiText = mainPage.getVoiceWarningHindiText();
        String expectedHindiText = "आवाज चेतावनी";
        if (voiceWarningHindiText.equals(expectedHindiText)) {
            LOG.info(LOG_MESSAGE_2);
        } else {
            LOG.error(LOG_MESSAGE_3);
        }
        Assert.assertEquals(voiceWarningHindiText, expectedHindiText, "The displayed language should be Hindi, but it is not.");
    }
}
