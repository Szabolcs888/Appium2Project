package com.myappium2project.pages.nativeapps.batteryalarm;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.Map;

public class LanguagesDropdownMenu extends BasePageClass {
    private final Map<String, WebElement> languageOptionsMap = new LinkedHashMap<>();

    @AndroidFindBy(className = "android.widget.Spinner")
    private WebElement languageSelectorDropdownMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"English\")")
    private WebElement englishOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"čeština\")")
    private WebElement cestinaOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"dansk\")")
    private WebElement danskOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Deutsch\")")
    private WebElement deutschOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"español\")")
    private WebElement espanolOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"français\")")
    private WebElement francaisOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Indonesia\")")
    private WebElement indonesiaOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"italiano\")")
    private WebElement italianoOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"magyar\")")
    private WebElement magyarOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Nederlands\")")
    private WebElement nederlandsOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"polski\")")
    private WebElement polskiOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"português\")")
    private WebElement portuguesOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"română\")")
    private WebElement romanaOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"slovenčina\")")
    private WebElement slovencinaOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"svenska\")")
    private WebElement svenskaOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"srpski\")")
    private WebElement srpskiOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Suomi\")")
    private WebElement suomiOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Türkçe\")")
    private WebElement turkceOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"български\")")
    private WebElement bulgarianOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"русский\")")
    private WebElement russianOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Українська\")")
    private WebElement ukrainianOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Ελληνικά\")")
    private WebElement greekOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Tiếng việt\")")
    private WebElement vietnameseOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"日本語\")")
    private WebElement japaneseOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"中文\")")
    private WebElement chineseOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"한국어\")")
    private WebElement koreanOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"ไทย\")")
    private WebElement thaiOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"عربي\")")
    private WebElement arabOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"فارسی\")")
    private WebElement farsiOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"עִברִית\")")
    private WebElement hebrewOption;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"हिन्दी\")")
    private WebElement hindiOption;

    public LanguagesDropdownMenu(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        initLanguageOptions();
    }

    private void initLanguageOptions() {
        languageOptionsMap.put("English", englishOption);
        languageOptionsMap.put("Czech", cestinaOption);
        languageOptionsMap.put("Danish", danskOption);
        languageOptionsMap.put("German", deutschOption);
        languageOptionsMap.put("Spanish", espanolOption);
        languageOptionsMap.put("French", francaisOption);
        languageOptionsMap.put("Indonesian", indonesiaOption);
        languageOptionsMap.put("Italian", italianoOption);
        languageOptionsMap.put("Hungarian", magyarOption);
        languageOptionsMap.put("Dutch", nederlandsOption);
        languageOptionsMap.put("Polish", polskiOption);
        languageOptionsMap.put("Portuguese", portuguesOption);
        languageOptionsMap.put("Romanian", romanaOption);
        languageOptionsMap.put("Slovenian", slovencinaOption);
        languageOptionsMap.put("Swedish", svenskaOption);
        languageOptionsMap.put("Serbian", srpskiOption);
        languageOptionsMap.put("Finnish", suomiOption);
        languageOptionsMap.put("Turkish", turkceOption);
        languageOptionsMap.put("Bulgarian", bulgarianOption);
        languageOptionsMap.put("Russian", russianOption);
        languageOptionsMap.put("Ukrainian", ukrainianOption);
        languageOptionsMap.put("Greek", greekOption);
        languageOptionsMap.put("Vietnamese", vietnameseOption);
        languageOptionsMap.put("Japanese", japaneseOption);
        languageOptionsMap.put("Chinese", chineseOption);
        languageOptionsMap.put("Korean", koreanOption);
        languageOptionsMap.put("Thai", thaiOption);
        languageOptionsMap.put("Arabic", arabOption);
        languageOptionsMap.put("Farsi", farsiOption);
        languageOptionsMap.put("Hebrew", hebrewOption);
        languageOptionsMap.put("Hindi", hindiOption);
    }

    public void pressLanguageSelectorDropdownMenuButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "language selector' 'dropdown menu");
        languageSelectorDropdownMenu.click();
    }

    public void chooseLanguageOption(String language) {
        WebElement languageElement = languageOptionsMap.get(language);
        if (languageElement != null) {
            logSelectedLanguageOption(language);
            languageElement.click();
        } else {
            throw new IllegalArgumentException("Unknown language: " + language);
        }
    }

    private void logSelectedLanguageOption(String language) {
        LOG.info("We choose the '{}' option", language);
    }
}