package com.myappium2project.pages.batteryalarm;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import com.myappium2project.utils.CommonUtils;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Choose a sound\")")
    private WebElement chooseASoundText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/text1\")")
    private WebElement selectedLanguage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\uF05A\")")
    private WebElement informationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\uF2D3\")")
    private WebElement closeAppButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\uF056\")")
    private WebElement putItOnTheTrayButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/alertTitle\")")
    private WebElement warningPopupAlertTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button2\")")
    private WebElement noButtonOnWarningPopupWindow;

    @AndroidFindBy(xpath = "//android.widget.TextView")
    private List<WebElement> alarmData;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\uF068\").instance(1)")
    private WebElement maxAlarmMinusButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"\uF067\").instance(0)")
    private WebElement minAlarmPlusButton;

    @AndroidFindBy(xpath = "//android.widget.Button")
    private List<WebElement> widgetsButtons;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Voice Warning\")")
    private WebElement voiceWarningEnglishText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Hlasové varování\")")
    private WebElement voiceWarningCzechText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Stemmeadvarsel\")")
    private WebElement voiceWarningDanishText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Sprach warnung\")")
    private WebElement voiceWarningGermanText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Advert. de voz\")")
    private WebElement voiceWarningSpanishText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Avertiss. vocal\")")
    private WebElement voiceWarningFranchiseText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Pering. Suara\")")
    private WebElement voiceWarningIndonesiaText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Avviso vocale\"]")
    private WebElement voiceWarningItalianText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Hang figyelmeztetés\"]")
    private WebElement voiceWarningHungarianText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Gesproken waarsch.\"]")
    private WebElement voiceWarningDutchText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Alert głosowe\")")
    private WebElement voiceWarningPolishText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Aviso de voz\"]")
    private WebElement voiceWarningPortugueseText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Avert. vocal\")")
    private WebElement voiceWarningRomanText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Hlasové varov.\")")
    private WebElement voiceWarningSlovenianText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Röstvarning\")")
    private WebElement voiceWarningSwedishText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Glasovno upozorenje\")")
    private WebElement voiceWarningSerbianText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Ihmisen ääni Varoitus\"]")
    private WebElement voiceWarningFinnishText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Sesli uyarı\"]")
    private WebElement voiceWarningTurkishText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Гласово пред.\"]")
    private WebElement voiceWarningBulgarianText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Голосовое пред.\")")
    private WebElement voiceWarningRussianText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Голосове сповіщ.\"]")
    private WebElement voiceWarningUkrainianText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Φωνητική ειδοποίηση\")")
    private WebElement voiceWarningGreekText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Cảnh báo bằng giọng nói\"]")
    private WebElement voiceWarningVietnameseText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"音声警告\")")
    private WebElement voiceWarningJapaneseText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"语音警告\")")
    private WebElement voiceWarningChineseText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"음성 경고\")")
    private WebElement voiceWarningKoreanText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"คำเตือนด้วยเสียง\")")
    private WebElement voiceWarningThaiText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"تحذیر بالصوت\"]")
    private WebElement voiceWarningArabicText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"هشدار صوتی\")")
    private WebElement voiceWarningFarsiText;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"אזהרה קולית\"]")
    private WebElement voiceWarningHebrewText;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"आवाज चेतावनी\")")
    private WebElement voiceWarningHindiText;

    public void pressInformationButton() {
        LOG.info("We press the 'information' button");
        informationButton.click();
    }

    public void pressCloseAppButton() {
        LOG.info("We press the 'X' (close app) button");
        closeAppButton.click();
    }

    public void pressPutItOnTheTrayButton() {
        LOG.info("We press the '-' (put it on the tray) button");
        putItOnTheTrayButton.click();
    }

    public void pressNoButtonOnWarningPopupWindow() {
        LOG.info("We press the 'NO' button on warning popup window");
        noButtonOnWarningPopupWindow.click();
    }

    public boolean isDisplayedExitWarningPopupWindow() {
        try {
            return warningPopupAlertTitle.isDisplayed() && warningPopupAlertTitle.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getSelectedLanguage() {
        return selectedLanguage.getText();
    }

    public int getCurrentMaxAlarmValue() {
        int currentMaxAlarmValue = Integer.parseInt(alarmData.get(9).getText().substring(11).replace("%", ""));
        return currentMaxAlarmValue;
    }

    public int getCurrentMinAlarmValue() {
        int currentMinAlarmValue = Integer.parseInt(alarmData.get(8).getText().substring(11).replace("%", ""));
        return currentMinAlarmValue;
    }

    public int getCurrentBatteryChargeValue() {
        int currentBatteryChargeValue = Integer.parseInt(alarmData.get(2).getText().replace("%", ""));
        return currentBatteryChargeValue;
    }

    public void pressMaxAlarmMinusButton(int buttonPressCounter) {
        LOG.info("We press the 'Max Alarm' minus button {} times", buttonPressCounter);
        for (int i = 0; i < buttonPressCounter; i++) {
            if (getCurrentMaxAlarmValue() == 1) {
                break;
            }
            maxAlarmMinusButton.click();
        }
    }

    public void pressMinAlarmPlusButton(int buttonPressCounter) {
        LOG.info("We press the 'Min Alarm' plus button {} times", buttonPressCounter);
        for (int i = 0; i < buttonPressCounter; i++) {
            if (getCurrentMinAlarmValue() == 100) {
                break;
            }
            minAlarmPlusButton.click();
        }
    }

    public boolean isTheCountdownGoing() {
        CommonUtils.threadSleep(7000);
        String countdownTimer = widgetsButtons.get(1).getText();
        if (!countdownTimer.equals("0h:0m:10s") && !countdownTimer.equals("0h:0m:30s"))
            return true;
        else
            return false;
    }

    public String getChooseASoundText() {
        try {
            return chooseASoundText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Choose a sound' text is not available";
        }
    }

    public String getVoiceWarningEnglishText() {
        try {
            return voiceWarningEnglishText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' English text is not available";
        }
    }

    public String getVoiceWarningCzechText() {
        try {
            return voiceWarningCzechText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Czech text is not available";
        }
    }

    public String getVoiceWarningDanishText() {
        try {
            return voiceWarningDanishText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Danish text is not available";
        }
    }

    public String getVoiceWarningGermanText() {
        try {
            return voiceWarningGermanText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' German text is not available";
        }
    }

    public String getVoiceWarningSpanishText() {
        try {
            return voiceWarningSpanishText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Spanish text is not available";
        }
    }

    public String getVoiceWarningFranchiseText() {
        try {
            return voiceWarningFranchiseText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Franchise text is not available";
        }
    }

    public String getVoiceWarningIndonesiaText() {
        try {
            return voiceWarningIndonesiaText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Indonesia text is not available";
        }
    }

    public String getVoiceWarningItalianText() {
        try {
            return voiceWarningItalianText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Italian text is not available";
        }
    }

    public String getVoiceWarningHungarianText() {
        try {
            return voiceWarningHungarianText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Hungarian text is not available";
        }
    }

    public String getVoiceWarningDutchText() {
        try {
            return voiceWarningDutchText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Dutch text is not available";
        }
    }

    public String getVoiceWarningPolishText() {
        try {
            return voiceWarningPolishText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Polish text is not available";
        }
    }

    public String getVoiceWarningPortugueseText() {
        try {
            return voiceWarningPortugueseText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Portuguese text is not available";
        }
    }

    public String getVoiceWarningRomanText() {
        try {
            return voiceWarningRomanText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Roman text is not available";
        }
    }

    public String getVoiceWarningSlovenianText() {
        try {
            return voiceWarningSlovenianText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Slovenian text is not available";
        }
    }

    public String getVoiceWarningSwedishText() {
        try {
            return voiceWarningSwedishText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Swedish text is not available";
        }
    }

    public String getVoiceWarningSerbianText() {
        try {
            return voiceWarningSerbianText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Serbian text is not available";
        }
    }

    public String getVoiceWarningFinnishText() {
        try {
            return voiceWarningFinnishText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Finnish text is not available";
        }
    }

    public String getVoiceWarningTurkishText() {
        try {
            return voiceWarningTurkishText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Turkish text is not available";
        }
    }

    public String getVoiceWarningBulgarianText() {
        try {
            return voiceWarningBulgarianText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Bulgarian text is not available";
        }
    }

    public String getVoiceWarningRussianText() {
        try {
            return voiceWarningRussianText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Russian text is not available";
        }
    }

    public String getVoiceWarningUkrainianText() {
        try {
            return voiceWarningUkrainianText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Ukrainian text is not available";
        }
    }

    public String getVoiceWarningGreekText() {
        try {
            return voiceWarningGreekText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Greek text is not available";
        }
    }

    public String getVoiceWarningVietnameseText() {
        try {
            return voiceWarningVietnameseText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Vietnamese text is not available";
        }
    }

    public String getVoiceWarningJapaneseText() {
        try {
            return voiceWarningJapaneseText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Japanese text is not available";
        }
    }

    public String getVoiceWarningChineseText() {
        try {
            return voiceWarningChineseText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Chinese text is not available";
        }
    }

    public String getVoiceWarningKoreanText() {
        try {
            return voiceWarningKoreanText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Korean text is not available";
        }
    }

    public String getVoiceWarningThaiText() {
        try {
            return voiceWarningThaiText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Thai text is not available";
        }
    }

    public String getVoiceWarningArabicText() {
        try {
            return voiceWarningArabicText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Arabic text is not available";
        }
    }

    public String getVoiceWarningFarsiText() {
        try {
            return voiceWarningFarsiText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Farsi text is not available";
        }
    }

    public String getVoiceWarningHebrewText() {
        try {
            return voiceWarningHebrewText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Hebrew text is not available";
        }
    }

    public String getVoiceWarningHindiText() {
        try {
            return voiceWarningHindiText.getText();
        } catch (NoSuchElementException e) {
            return "The 'Voice Warning' Hindi text is not available";
        }
    }
}
