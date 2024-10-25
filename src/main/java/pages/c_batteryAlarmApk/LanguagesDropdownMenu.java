package pages.c_batteryAlarmApk;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LanguagesDropdownMenu {
    private static final Logger log = LogManager.getLogger(LanguagesDropdownMenu.class);

    public LanguagesDropdownMenu(AndroidDriver driver) {
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
    private WebElement türkceOption;

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
        log.info("We press the language selector dropdown menu button");
        languageSelectorDropdownMenu.click();
    }

    public void chooseEnglishOption() {
        log.info("We choose the 'English' option");
        englishOption.click();
    }

    public void chooseCestinaOption() {
        log.info("We choose the 'cestina' option");
        cestinaOption.click();
    }

    public void chooseDanskOption() {
        log.info("We choose the 'dansk' option");
        danskOption.click();
    }

    public void chooseDeutschOption() {
        log.info("We choose the 'Deutsch' option");
        deutschOption.click();
    }

    public void chooseEspanolOption() {
        log.info("We choose the 'espanol' option");
        espanolOption.click();
    }

    public void chooseFrancaisOption() {
        log.info("We choose the 'francais' option");
        francaisOption.click();
    }

    public void chooseIndonesiaOption() {
        log.info("We choose the 'Indonesia' option");
        indonesiaOption.click();
    }

    public void chooseItalianoOption() {
        log.info("We choose the 'italiano' option");
        italianoOption.click();
    }

    public void chooseMagyarOption() {
        log.info("We choose the 'magyar' option");
        magyarOption.click();
    }

    public void chooseNederlandsOption() {
        log.info("We choose the 'Nederlands' option");
        nederlandsOption.click();
    }

    public void choosePolskiOption() {
        log.info("We choose the 'polski' option");
        polskiOption.click();
    }

    public void choosePortuguesOption() {
        log.info("We choose the 'portugues' option");
        portuguesOption.click();
    }

    public void chooseRomanaOption() {
        log.info("We choose the 'romana' option");
        romanaOption.click();
    }

    public void chooseSlovencinaOption() {
        log.info("We choose the 'slovencina' option");
        slovencinaOption.click();
    }

    public void chooseSvenskaOption() {
        log.info("We choose the 'svenska' option");
        svenskaOption.click();
    }

    public void chooseSrpskiOption() {
        log.info("We choose the 'srpski' option");
        srpskiOption.click();
    }

    public void chooseSuomiOption() {
        log.info("We choose the 'Suomi' option");
        suomiOption.click();
    }

    public void chooseTürkceOption() {
        log.info("We choose the 'Türkce' option");
        türkceOption.click();
    }

    public void chooseBulgarianOption() {
        log.info("We choose the 'bulgarian' option");
        bulgarianOption.click();
    }

    public void chooseRussianOption() {
        log.info("We choose the 'russian' option");
        russianOption.click();
    }

    public void chooseUkrainianOption() {
        log.info("We choose the 'Ukrainian' option");
        ukrainianOption.click();
    }

    public void chooseGreekOption() {
        log.info("We choose the 'Greek' option");
        greekOption.click();
    }

    public void chooseVietnameseOption() {
        log.info("We choose the 'Vietnamese' option");
        vietnameseOption.click();
    }

    public void chooseJapaneseOption() {
        log.info("We choose the 'japanese' option");
        japaneseOption.click();
    }

    public void chooseChineseOption() {
        log.info("We choose the 'chinese' option");
        chineseOption.click();
    }

    public void chooseKoreanOption() {
        log.info("We choose the 'korean' option");
        koreanOption.click();
    }

    public void chooseThaiOption() {
        log.info("We choose the 'thai' option");
        thaiOption.click();
    }

    public void chooseArabicOption() {
        log.info("We choose the 'arab' option");
        arabOption.click();
    }

    public void chooseFarsiOption() {
        log.info("We choose the 'farsi' option");
        farsiOption.click();
    }

    public void chooseHebrewOption() {
        log.info("We choose the 'hebrew' option");
        hebrewOption.click();
    }

    public void chooseHindiOption() {
        log.info("We choose the 'hindi' option");
        hindiOption.click();
    }
}
