package com.myappium2project.pages.batteryalarm;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import com.myappium2project.utils.CommonUtils;

import java.util.List;

public class MainPage extends BasePageClass {
    private static final String ALARM_BUTTON_PRESS_LOG = "We press the '{}' {} button {} times";
    private static final String MAX_ALARM_TEXT = "Max Alarm";
    private static final String MIN_ALARM_TEXT = "Min Alarm";
    private static final String BUTTON_TYPE_PLUS = "plus";
    private static final String BUTTON_TYPE_MINUS = "minus";

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
    }

    public static String voiceWarningTextNotAvailableLog(String language) {
        return String.format("The 'Voice Warning' %s text is not available", language);
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
        LOG.info(ALARM_BUTTON_PRESS_LOG, MAX_ALARM_TEXT, BUTTON_TYPE_MINUS, numberOfPresses);
        int minimumMaxAlamValue = 1;
        for (int i = 0; i < numberOfPresses; i++) {
            if (getCurrentMaxAlarmValue() == minimumMaxAlamValue) {
                break;
            }
            maxAlarmMinusButton.click();
        }
    }

    public void pressMinAlarmPlusButton(int numberOfPresses) {
        LOG.info(ALARM_BUTTON_PRESS_LOG, MIN_ALARM_TEXT, BUTTON_TYPE_PLUS, numberOfPresses);
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

    public String getVoiceWarningEnglishText() {
        try {
            return voiceWarningEnglishText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("English");
        }
    }

    public String getVoiceWarningCzechText() {
        try {
            return voiceWarningCzechText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Czech");
        }
    }

    public String getVoiceWarningDanishText() {
        try {
            return voiceWarningDanishText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Danish");
        }
    }

    public String getVoiceWarningGermanText() {
        try {
            return voiceWarningGermanText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("German");
        }
    }

    public String getVoiceWarningSpanishText() {
        try {
            return voiceWarningSpanishText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Spanish");
        }
    }

    public String getVoiceWarningFranchiseText() {
        try {
            return voiceWarningFranchiseText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Franchise");
        }
    }

    public String getVoiceWarningIndonesiaText() {
        try {
            return voiceWarningIndonesiaText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Indonesia");
        }
    }

    public String getVoiceWarningItalianText() {
        try {
            return voiceWarningItalianText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Italian");
        }
    }

    public String getVoiceWarningHungarianText() {
        try {
            return voiceWarningHungarianText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Hungarian");
        }
    }

    public String getVoiceWarningDutchText() {
        try {
            return voiceWarningDutchText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Dutch");
        }
    }

    public String getVoiceWarningPolishText() {
        try {
            return voiceWarningPolishText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Polish");
        }
    }

    public String getVoiceWarningPortugueseText() {
        try {
            return voiceWarningPortugueseText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Portuguese");
        }
    }

    public String getVoiceWarningRomanText() {
        try {
            return voiceWarningRomanText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Roman");
        }
    }

    public String getVoiceWarningSlovenianText() {
        try {
            return voiceWarningSlovenianText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Slovenian");
        }
    }

    public String getVoiceWarningSwedishText() {
        try {
            return voiceWarningSwedishText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Swedish");
        }
    }

    public String getVoiceWarningSerbianText() {
        try {
            return voiceWarningSerbianText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Serbian");
        }
    }

    public String getVoiceWarningFinnishText() {
        try {
            return voiceWarningFinnishText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Finnish");
        }
    }

    public String getVoiceWarningTurkishText() {
        try {
            return voiceWarningTurkishText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Turkish");
        }
    }

    public String getVoiceWarningBulgarianText() {
        try {
            return voiceWarningBulgarianText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Bulgarian");
        }
    }

    public String getVoiceWarningRussianText() {
        try {
            return voiceWarningRussianText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Russian");
        }
    }

    public String getVoiceWarningUkrainianText() {
        try {
            return voiceWarningUkrainianText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Ukrainian");
        }
    }

    public String getVoiceWarningGreekText() {
        try {
            return voiceWarningGreekText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Greek");
        }
    }

    public String getVoiceWarningVietnameseText() {
        try {
            return voiceWarningVietnameseText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Vietnamese");
        }
    }

    public String getVoiceWarningJapaneseText() {
        try {
            return voiceWarningJapaneseText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Japanese");
        }
    }

    public String getVoiceWarningChineseText() {
        try {
            return voiceWarningChineseText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Chinese");
        }
    }

    public String getVoiceWarningKoreanText() {
        try {
            return voiceWarningKoreanText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Korean");
        }
    }

    public String getVoiceWarningThaiText() {
        try {
            return voiceWarningThaiText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Thai");
        }
    }

    public String getVoiceWarningArabicText() {
        try {
            return voiceWarningArabicText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Arabic");
        }
    }

    public String getVoiceWarningFarsiText() {
        try {
            return voiceWarningFarsiText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Farsi");
        }
    }

    public String getVoiceWarningHebrewText() {
        try {
            return voiceWarningHebrewText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Hebrew");
        }
    }

    public String getVoiceWarningHindiText() {
        try {
            return voiceWarningHindiText.getText();
        } catch (NoSuchElementException e) {
            return voiceWarningTextNotAvailableLog("Hindi");
        }
    }
}