package com.myappium2project.pages.batteryalarm;

import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LanguagesDropdownMenu extends BasePage {

    public LanguagesDropdownMenu(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

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

    public void pressLanguageSelectorDropdownMenuButton() {
        LOG.info("We press the language selector dropdown menu button");
        languageSelectorDropdownMenu.click();
    }

    public void chooseEnglishOption() {
        LOG.info("We choose the 'English' option");
        englishOption.click();
    }

    public void chooseCestinaOption() {
        LOG.info("We choose the 'cestina' option");
        cestinaOption.click();
    }

    public void chooseDanskOption() {
        LOG.info("We choose the 'dansk' option");
        danskOption.click();
    }

    public void chooseDeutschOption() {
        LOG.info("We choose the 'Deutsch' option");
        deutschOption.click();
    }

    public void chooseEspanolOption() {
        LOG.info("We choose the 'espanol' option");
        espanolOption.click();
    }

    public void chooseFrancaisOption() {
        LOG.info("We choose the 'francais' option");
        francaisOption.click();
    }

    public void chooseIndonesiaOption() {
        LOG.info("We choose the 'Indonesia' option");
        indonesiaOption.click();
    }

    public void chooseItalianoOption() {
        LOG.info("We choose the 'italiano' option");
        italianoOption.click();
    }

    public void chooseMagyarOption() {
        LOG.info("We choose the 'magyar' option");
        magyarOption.click();
    }

    public void chooseNederlandsOption() {
        LOG.info("We choose the 'Nederlands' option");
        nederlandsOption.click();
    }

    public void choosePolskiOption() {
        LOG.info("We choose the 'polski' option");
        polskiOption.click();
    }

    public void choosePortuguesOption() {
        LOG.info("We choose the 'portugues' option");
        portuguesOption.click();
    }

    public void chooseRomanaOption() {
        LOG.info("We choose the 'romana' option");
        romanaOption.click();
    }

    public void chooseSlovencinaOption() {
        LOG.info("We choose the 'slovencina' option");
        slovencinaOption.click();
    }

    public void chooseSvenskaOption() {
        LOG.info("We choose the 'svenska' option");
        svenskaOption.click();
    }

    public void chooseSrpskiOption() {
        LOG.info("We choose the 'srpski' option");
        srpskiOption.click();
    }

    public void chooseSuomiOption() {
        LOG.info("We choose the 'Suomi' option");
        suomiOption.click();
    }

    public void chooseTurkceOption() {
        LOG.info("We choose the 'Türkce' option");
        turkceOption.click();
    }

    public void chooseBulgarianOption() {
        LOG.info("We choose the 'bulgarian' option");
        bulgarianOption.click();
    }

    public void chooseRussianOption() {
        LOG.info("We choose the 'russian' option");
        russianOption.click();
    }

    public void chooseUkrainianOption() {
        LOG.info("We choose the 'Ukrainian' option");
        ukrainianOption.click();
    }

    public void chooseGreekOption() {
        LOG.info("We choose the 'Greek' option");
        greekOption.click();
    }

    public void chooseVietnameseOption() {
        LOG.info("We choose the 'Vietnamese' option");
        vietnameseOption.click();
    }

    public void chooseJapaneseOption() {
        LOG.info("We choose the 'japanese' option");
        japaneseOption.click();
    }

    public void chooseChineseOption() {
        LOG.info("We choose the 'chinese' option");
        chineseOption.click();
    }

    public void chooseKoreanOption() {
        LOG.info("We choose the 'korean' option");
        koreanOption.click();
    }

    public void chooseThaiOption() {
        LOG.info("We choose the 'thai' option");
        thaiOption.click();
    }

    public void chooseArabicOption() {
        LOG.info("We choose the 'arab' option");
        arabOption.click();
    }

    public void chooseFarsiOption() {
        LOG.info("We choose the 'farsi' option");
        farsiOption.click();
    }

    public void chooseHebrewOption() {
        LOG.info("We choose the 'hebrew' option");
        hebrewOption.click();
    }

    public void chooseHindiOption() {
        LOG.info("We choose the 'hindi' option");
        hindiOption.click();
    }
}
