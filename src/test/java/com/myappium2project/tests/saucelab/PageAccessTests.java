package com.myappium2project.tests.saucelab;

import com.myappium2project.pages.saucelab.menuPages.*;
import com.myappium2project.tests.basetests.SauceLabApkBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.saucelab.HamburgerMenu;

public class PageAccessTests extends SauceLabApkBaseTest {

    @Test(priority = 1,
            groups = {"smoke"})
    public void testWebviewPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressWebviewButton();

        LOG.info("We check whether we are on the 'Webview' page");
        WebviewPage webviewPage = new WebviewPage(driver);
        String webviewPageTitleText = webviewPage.getWebviewPageTitleText();
        String expectedPageTitleText = "Webview";
        if (webviewPageTitleText.equals(expectedPageTitleText)) {
            LOG.info("We are on the 'Webview' page");
        } else {
            LOG.error("We are not on the 'Webview' page");
        }
        Assert.assertEquals(webviewPageTitleText, expectedPageTitleText, "The page title should be 'Webview', but it is not.");
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testQrCodeScannerPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressQrCodeScannerButton();

        LOG.info("We check whether we are on the 'QR Code Scanner' page");
        QrCodeScannerPage qrCodeScannerPage = new QrCodeScannerPage(driver);
        String qrCodeScannerPageTitleText = qrCodeScannerPage.getQrCodeScannerPageTitleText();
        String expectedPageTitleText = "QR Code Scanner";
        if (qrCodeScannerPageTitleText.equals(expectedPageTitleText)) {
            LOG.info("We are on the 'QR Code Scanner' page");
        } else {
            LOG.error("We are not on the 'QR Code Scanner' page");
        }
        Assert.assertEquals(qrCodeScannerPageTitleText, expectedPageTitleText, "The page title should be 'QR Code Scanner', but it is not.");
    }

    @Test(priority = 3,
            groups = {"smoke"})
    public void testGeoLocationPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressGeoLocationButton();

        LOG.info("We check whether we are on the 'Geo Location' page");
        GeoLocationPage geoLocationPage = new GeoLocationPage(driver);
        String geoLocationPageTitleText = geoLocationPage.getGeoLocationPageTitleText();
        String expectedPageTitleText = "Geo Location";
        if (geoLocationPageTitleText.equals(expectedPageTitleText)) {
            LOG.info("We are on the 'Geo Location' page");
        } else {
            LOG.error("We are not on the 'Geo Location' page");
        }
        Assert.assertEquals(geoLocationPageTitleText, expectedPageTitleText, "The page title should be 'Geo Location', but it is not.");
    }

    @Test(priority = 4,
            groups = {"smoke"})
    public void testDrawingPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressDrawingButton();

        LOG.info("We check whether we are on the 'Drawing' page");
        DrawingPage drawingPage = new DrawingPage(driver);
        String drawingPageTitleText = drawingPage.getDrawingPageTitleText();
        String expectedPageTitleText = "Drawing";
        if (drawingPageTitleText.equals(expectedPageTitleText)) {
            LOG.info("We are on the 'Drawing' page");
        } else {
            LOG.error("We are not on the 'Drawing' page");
        }
        Assert.assertEquals(drawingPageTitleText, expectedPageTitleText, "The page title should be 'Drawing', but it is not.");
    }

    @Test(priority = 5,
            groups = {"smoke"})
    public void testAboutPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressAboutButton();

        LOG.info("We check whether we are on the 'About' page");
        AboutPage aboutPage = new AboutPage(driver);
        String aboutPageTitleText = aboutPage.getAboutPageTitleText();
        String expectedPageTitleText = "About";
        if (aboutPageTitleText.equals(expectedPageTitleText)) {
            LOG.info("We are on the 'About' page");
        } else {
            LOG.error("We are not on the 'About' page");
        }
        Assert.assertEquals(aboutPageTitleText, expectedPageTitleText, "The page title should be 'About', but it is not.");
    }

    @Test(priority = 6,
            groups = {"smoke"})
    public void testFingerPrintPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressFingerPrintButton();

        LOG.info("We check whether we are on the 'Finger Print' page");
        FingerPrintPage fingerPrintPage = new FingerPrintPage(driver);
        String fingerPrintPageTitleText = fingerPrintPage.getFingerPrintPageTitleText();
        String expectedPageTitleText = "FingerPrint";
        if (fingerPrintPageTitleText.equals(expectedPageTitleText)) {
            LOG.info("We are on the 'Finger Print' page");
        } else {
            LOG.error("We are not on the 'Finger Print' page");
        }
        Assert.assertEquals(fingerPrintPageTitleText, expectedPageTitleText, "The page title should be 'Finger Print', but it is not.");
    }

    @Test(priority = 7,
            groups = {"smoke"})
    public void testApiCallsPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressApiCallsButton();

        LOG.info("We check whether we are on the 'API calls' page");
        ApiCallsPage apiCallsPage = new ApiCallsPage(driver);
        String apiCallsPageTitleText = apiCallsPage.getApiCallsPageTitleText();
        String expectedPageTitleText = "API calls";
        if (apiCallsPageTitleText.equals(expectedPageTitleText)) {
            LOG.info("We are on the 'API calls' page");
        } else {
            LOG.error("We are not on the 'API calls' page");
        }
        Assert.assertEquals(apiCallsPageTitleText, expectedPageTitleText, "The page title should be 'API calls', but it is not.");
    }

    @Test(priority = 8,
            groups = {"smoke"})
    public void testSauceBotVideoPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressSauceBotVideoButton();

        LOG.info("We check whether we are on the 'Sauce Bot Video' page");
        SauceBotVideoPage sauceBotVideoPage = new SauceBotVideoPage(driver);
        String sauceBotVideoPageTitleText = sauceBotVideoPage.getSauceBotVideoPageTitleText();
        String expectedPageTitleText = "SauceBot - The Beginning";
        if (sauceBotVideoPageTitleText.equals(expectedPageTitleText)) {
            LOG.info("We are on the 'Sauce Bot Video' page");
        } else {
            LOG.error("We are not on the 'Sauce Bot Video' page");
        }
        Assert.assertEquals(sauceBotVideoPageTitleText, expectedPageTitleText, "The page title should be 'SauceBot - The Beginning', but it is not.");
    }
}
