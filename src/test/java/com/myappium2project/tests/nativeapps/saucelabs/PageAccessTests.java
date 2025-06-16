package com.myappium2project.tests.nativeapps.saucelabs;

import com.myappium2project.pages.nativeapps.saucelabs.menupages.*;
import com.myappium2project.tests.basetests.SauceLabsAppTestBase;
import com.myappium2project.testsgroups.TestGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.myappium2project.pages.nativeapps.saucelabs.HamburgerMenu;

public class PageAccessTests extends SauceLabsAppTestBase {
    private HamburgerMenu hamburgerMenu;

    @BeforeMethod(alwaysRun = true)
    public void initializeHamburgerMenu() {
        hamburgerMenu = new HamburgerMenu(driver, wait);
    }

    @Test(priority = 1, groups = {TestGroups.SMOKE})
    public void testWebviewPageAccess() throws InterruptedException {
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressWebviewButton();

        String pageName = "Webview";
        WebviewPage webviewPage = new WebviewPage(driver);
        String pageTitle = webviewPage.getWebviewPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(pageTitle, pageName);
    }

    @Test(priority = 2, groups = {TestGroups.SMOKE})
    public void testQrCodeScannerPageAccess() throws InterruptedException {
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressQrCodeScannerButton();

        String pageName = "QR Code Scanner";
        QrCodeScannerPage qrCodeScannerPage = new QrCodeScannerPage(driver);
        String pageTitle = qrCodeScannerPage.getQrCodeScannerPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(pageTitle, pageName);
    }

    @Test(priority = 3, groups = {TestGroups.SMOKE})
    public void testGeoLocationPageAccess() throws InterruptedException {
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressGeoLocationButton();

        String pageName = "Geo Location";
        GeoLocationPage geoLocationPage = new GeoLocationPage(driver);
        String pageTitle = geoLocationPage.getGeoLocationPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(pageTitle, pageName);
    }

    @Test(priority = 4, groups = {TestGroups.SMOKE})
    public void testDrawingPageAccess() throws InterruptedException {
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressDrawingButton();

        String pageName = "Drawing";
        DrawingPage drawingPage = new DrawingPage(driver);
        String pageTitle = drawingPage.getDrawingPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(pageTitle, pageName);
    }

    @Test(priority = 5, groups = {TestGroups.SMOKE})
    public void testAboutPageAccess() throws InterruptedException {
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressAboutButton();

        String pageName = "About";
        AboutPage aboutPage = new AboutPage(driver);
        String pageTitle = aboutPage.getAboutPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(pageTitle, pageName);
    }

    @Test(priority = 6, groups = {TestGroups.SMOKE})
    public void testFingerPrintPageAccess() throws InterruptedException {
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressFingerPrintButton();

        String pageName = "FingerPrint";
        FingerPrintPage fingerPrintPage = new FingerPrintPage(driver);
        String pageTitle = fingerPrintPage.getFingerPrintPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(pageTitle, pageName);
    }

    @Test(priority = 7, groups = {TestGroups.SMOKE})
    public void testApiCallsPageAccess() throws InterruptedException {
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressApiCallsButton();

        String pageName = "API calls";
        ApiCallsPage apiCallsPage = new ApiCallsPage(driver);
        String pageTitle = apiCallsPage.getApiCallsPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(pageTitle, pageName);
    }

    @Test(priority = 8, groups = {TestGroups.SMOKE})
    public void testSauceBotVideoPageAccess() throws InterruptedException {
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressSauceBotVideoButton();

        String pageName = "Sauce Bot Video";
        String expectedTitle = "SauceBot - The Beginning";
        SauceBotVideoPage sauceBotVideoPage = new SauceBotVideoPage(driver);
        String pageTitle = sauceBotVideoPage.getSauceBotVideoPageTitleText();
        SauceLabsCommonAssertions.verifyPageLoaded(pageTitle, expectedTitle);
    }
}