package com.myappium2project.pages.batteryalarm;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LanguagesDropdownMenu extends BasePage {
    private static final String SELECTED_LANGUAGE_OPTION_LOG = "We choose the '{}' option";

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
    }

    public void pressLanguageSelectorDropdownMenuButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "language selector' 'dropdown menu");
        languageSelectorDropdownMenu.click();
    }

    public void chooseEnglishOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "English");
        englishOption.click();
    }

    public void chooseCestinaOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "cestina");
        cestinaOption.click();
    }

    public void chooseDanskOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "dansk");
        danskOption.click();
    }

    public void chooseDeutschOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "Deutsch");
        deutschOption.click();
    }

    public void chooseEspanolOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "espanol");
        espanolOption.click();
    }

    public void chooseFrancaisOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "francais");
        francaisOption.click();
    }

    public void chooseIndonesiaOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "Indonesia");
        indonesiaOption.click();
    }

    public void chooseItalianoOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "italiano");
        italianoOption.click();
    }

    public void chooseMagyarOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "magyar");
        magyarOption.click();
    }

    public void chooseNederlandsOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "Nederlands");
        nederlandsOption.click();
    }

    public void choosePolskiOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "polski");
        polskiOption.click();
    }

    public void choosePortuguesOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "portugues");
        portuguesOption.click();
    }

    public void chooseRomanaOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "romana");
        romanaOption.click();
    }

    public void chooseSlovencinaOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "slovencina");
        slovencinaOption.click();
    }

    public void chooseSvenskaOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "svenska");
        svenskaOption.click();
    }

    public void chooseSrpskiOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "srpski");
        srpskiOption.click();
    }

    public void chooseSuomiOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "Suomi");
        suomiOption.click();
    }

    public void chooseTurkceOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "Türkce");
        turkceOption.click();
    }

    public void chooseBulgarianOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "bulgarian");
        bulgarianOption.click();
    }

    public void chooseRussianOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "russian");
        russianOption.click();
    }

    public void chooseUkrainianOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "Ukrainian");
        ukrainianOption.click();
    }

    public void chooseGreekOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "Greek");
        greekOption.click();
    }

    public void chooseVietnameseOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "Vietnamese");
        vietnameseOption.click();
    }

    public void chooseJapaneseOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "japanese");
        japaneseOption.click();
    }

    public void chooseChineseOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "chinese");
        chineseOption.click();
    }

    public void chooseKoreanOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "korean");
        koreanOption.click();
    }

    public void chooseThaiOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "thai");
        thaiOption.click();
    }

    public void chooseArabicOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "arab");
        arabOption.click();
    }

    public void chooseFarsiOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "farsi");
        farsiOption.click();
    }

    public void chooseHebrewOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "hebrew");
        hebrewOption.click();
    }

    public void chooseHindiOption() {
        LOG.info(SELECTED_LANGUAGE_OPTION_LOG, "hindi");
        hindiOption.click();
    }
}