package com.myappium2project.pages.nativeapps.batteryalarm;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import com.myappium2project.utils.CommonUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainPage extends BasePageClass {
    private static final String ALARM_BUTTON_PRESS_LOG = "We press the '{}' {} button {} times";
    private final Map<String, WebElement> voiceWarningTextMap = new LinkedHashMap<>();

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

    public MainPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        initVoiceWarningTexts();
    }

    private void initVoiceWarningTexts() {
        voiceWarningTextMap.put("English", voiceWarningEnglishText);
        voiceWarningTextMap.put("Czech", voiceWarningCzechText);
        voiceWarningTextMap.put("Danish", voiceWarningDanishText);
        voiceWarningTextMap.put("German", voiceWarningGermanText);
        voiceWarningTextMap.put("Spanish", voiceWarningSpanishText);
        voiceWarningTextMap.put("French", voiceWarningFranchiseText);
        voiceWarningTextMap.put("Indonesian", voiceWarningIndonesiaText);
        voiceWarningTextMap.put("Italian", voiceWarningItalianText);
        voiceWarningTextMap.put("Hungarian", voiceWarningHungarianText);
        voiceWarningTextMap.put("Dutch", voiceWarningDutchText);
        voiceWarningTextMap.put("Polish", voiceWarningPolishText);
        voiceWarningTextMap.put("Portuguese", voiceWarningPortugueseText);
        voiceWarningTextMap.put("Romanian", voiceWarningRomanText);
        voiceWarningTextMap.put("Slovenian", voiceWarningSlovenianText);
        voiceWarningTextMap.put("Swedish", voiceWarningSwedishText);
        voiceWarningTextMap.put("Serbian", voiceWarningSerbianText);
        voiceWarningTextMap.put("Finnish", voiceWarningFinnishText);
        voiceWarningTextMap.put("Turkish", voiceWarningTurkishText);
        voiceWarningTextMap.put("Bulgarian", voiceWarningBulgarianText);
        voiceWarningTextMap.put("Russian", voiceWarningRussianText);
        voiceWarningTextMap.put("Ukrainian", voiceWarningUkrainianText);
        voiceWarningTextMap.put("Greek", voiceWarningGreekText);
        voiceWarningTextMap.put("Vietnamese", voiceWarningVietnameseText);
        voiceWarningTextMap.put("Japanese", voiceWarningJapaneseText);
        voiceWarningTextMap.put("Chinese", voiceWarningChineseText);
        voiceWarningTextMap.put("Korean", voiceWarningKoreanText);
        voiceWarningTextMap.put("Thai", voiceWarningThaiText);
        voiceWarningTextMap.put("Arabic", voiceWarningArabicText);
        voiceWarningTextMap.put("Farsi", voiceWarningFarsiText);
        voiceWarningTextMap.put("Hebrew", voiceWarningHebrewText);
        voiceWarningTextMap.put("Hindi", voiceWarningHindiText);
    }

    public void pressInformationButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "information");
        informationButton.click();
    }

    public void pressCloseAppButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "X' '(close app)");
        closeAppButton.click();
    }

    public void pressPutItOnTheTrayButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "-' '(put it on the tray)");
        putItOnTheTrayButton.click();
    }

    public void pressNoButtonOnWarningPopupWindow() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "NO");
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
        int currentMaxAlarmValue =
                Integer.parseInt(alarmData.get(9).getText().substring(11).replace("%", ""));
        return currentMaxAlarmValue;
    }

    public int getCurrentMinAlarmValue() {
        int currentMinAlarmValue =
                Integer.parseInt(alarmData.get(8).getText().substring(11).replace("%", ""));
        return currentMinAlarmValue;
    }

    public int getCurrentBatteryChargeValue() {
        int currentBatteryChargeValue =
                Integer.parseInt(alarmData.get(2).getText().replace("%", ""));
        return currentBatteryChargeValue;
    }

    public void pressMaxAlarmMinusButton(int numberOfPresses) {
        LOG.info(ALARM_BUTTON_PRESS_LOG, "Max Alarm", "minus", numberOfPresses);
        int minimumMaxAlamValue = 1;
        for (int i = 0; i < numberOfPresses; i++) {
            if (getCurrentMaxAlarmValue() == minimumMaxAlamValue) {
                break;
            }
            maxAlarmMinusButton.click();
        }
    }

    public void pressMinAlarmPlusButton(int numberOfPresses) {
        LOG.info(ALARM_BUTTON_PRESS_LOG, "Min Alarm", "plus", numberOfPresses);
        int maximumMinAlamValue = 100;
        for (int i = 0; i < numberOfPresses; i++) {
            if (getCurrentMinAlarmValue() == maximumMinAlamValue) {
                break;
            }
            minAlarmPlusButton.click();
        }
    }

    public boolean isTheCountdownGoing() {
        CommonUtils.threadSleep(7000);
        String countdownTimer = widgetsButtons.get(1).getText();
        if (!"0h:0m:10s".equals(countdownTimer) && !"0h:0m:30s".equals(countdownTimer)) {
            return true;
        } else {
            return false;
        }
    }

    public String getChooseASoundText() {
        try {
            return chooseASoundText.getText();
        } catch (StaleElementReferenceException | NoSuchElementException e) {
            return CommonPageLogMessages.textNotAvailableLog("Choose a sound");
        }
    }

    public String getVoiceWarningText(String language) {
        WebElement element = voiceWarningTextMap.get(language);
        if (element == null) {
            throw new IllegalArgumentException("Unsupported language: " + language);
        }

        try {
            return element.getText();
        } catch (NoSuchElementException e) {
            return String.format("The 'Voice Warning' %s text is not available", language);
        }
    }
}