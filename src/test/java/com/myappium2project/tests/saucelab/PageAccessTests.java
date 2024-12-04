package com.myappium2project.tests.saucelab;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.logging.testlogmessages.SlabTestLogMessages;
import com.myappium2project.pages.saucelab.menupages.*;
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

        String webviewPageName = "Webview";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, webviewPageName);
        WebviewPage webviewPage = new WebviewPage(driver);
        String webviewPageTitleText = webviewPage.getWebviewPageTitleText();
        if (webviewPageTitleText.equals(webviewPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, webviewPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, webviewPageName);
        }
        Assert.assertEquals(webviewPageTitleText, webviewPageName,
                SlabTestLogMessages.getPageTitleValidationAssertLog(webviewPageName));
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testQrCodeScannerPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressQrCodeScannerButton();

        String qrCodeScannerPageName = "QR Code Scanner";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, qrCodeScannerPageName);
        QrCodeScannerPage qrCodeScannerPage = new QrCodeScannerPage(driver);
        String qrCodeScannerPageTitleText = qrCodeScannerPage.getQrCodeScannerPageTitleText();
        if (qrCodeScannerPageTitleText.equals(qrCodeScannerPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, qrCodeScannerPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, qrCodeScannerPageName);
        }
        Assert.assertEquals(qrCodeScannerPageTitleText, qrCodeScannerPageName,
                SlabTestLogMessages.getPageTitleValidationAssertLog(qrCodeScannerPageName));
    }

    @Test(priority = 3,
            groups = {"smoke"})
    public void testGeoLocationPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressGeoLocationButton();

        String geoLocationPageName = "Geo Location";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, geoLocationPageName);
        GeoLocationPage geoLocationPage = new GeoLocationPage(driver);
        String geoLocationPageTitleText = geoLocationPage.getGeoLocationPageTitleText();
        if (geoLocationPageTitleText.equals(geoLocationPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, geoLocationPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, geoLocationPageName);
        }
        Assert.assertEquals(geoLocationPageTitleText, geoLocationPageName,
                SlabTestLogMessages.getPageTitleValidationAssertLog(geoLocationPageName));
    }

    @Test(priority = 4,
            groups = {"smoke"})
    public void testDrawingPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressDrawingButton();

        String drawingPageName = "Drawing";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, drawingPageName);
        DrawingPage drawingPage = new DrawingPage(driver);
        String drawingPageTitleText = drawingPage.getDrawingPageTitleText();
        if (drawingPageTitleText.equals(drawingPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, drawingPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, drawingPageName);
        }
        Assert.assertEquals(drawingPageTitleText, drawingPageName,
                SlabTestLogMessages.getPageTitleValidationAssertLog(drawingPageName));
    }

    @Test(priority = 5,
            groups = {"smoke"})
    public void testAboutPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressAboutButton();

        String aboutPageName = "About";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, aboutPageName);
        AboutPage aboutPage = new AboutPage(driver);
        String aboutPageTitleText = aboutPage.getAboutPageTitleText();
        if (aboutPageTitleText.equals(aboutPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, aboutPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, aboutPageName);
        }
        Assert.assertEquals(aboutPageTitleText, aboutPageName,
                SlabTestLogMessages.getPageTitleValidationAssertLog(aboutPageName));
    }

    @Test(priority = 6,
            groups = {"smoke"})
    public void testFingerPrintPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressFingerPrintButton();

        String fingerPrintPageName = "Finger Print";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, fingerPrintPageName);
        FingerPrintPage fingerPrintPage = new FingerPrintPage(driver);
        String fingerPrintPageTitleText = fingerPrintPage.getFingerPrintPageTitleText();
        if (fingerPrintPageTitleText.equals(fingerPrintPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, fingerPrintPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, fingerPrintPageName);
        }
        Assert.assertEquals(fingerPrintPageTitleText, fingerPrintPageName,
                SlabTestLogMessages.getPageTitleValidationAssertLog(fingerPrintPageName));
    }

    @Test(priority = 7,
            groups = {"smoke"})
    public void testApiCallsPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressApiCallsButton();

        String apiCallsPageName = "API calls";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, apiCallsPageName);
        ApiCallsPage apiCallsPage = new ApiCallsPage(driver);
        String apiCallsPageTitleText = apiCallsPage.getApiCallsPageTitleText();
        if (apiCallsPageTitleText.equals(apiCallsPageName)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, apiCallsPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, apiCallsPageName);
        }
        Assert.assertEquals(apiCallsPageTitleText, apiCallsPageName,
                SlabTestLogMessages.getPageTitleValidationAssertLog(apiCallsPageName));
    }

    @Test(priority = 8,
            groups = {"smoke"})
    public void testSauceBotVideoPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressSauceBotVideoButton();

        String sauceBotVideoPageName = "Sauce Bot Video";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, sauceBotVideoPageName);
        SauceBotVideoPage sauceBotVideoPage = new SauceBotVideoPage(driver);
        String sauceBotVideoPageTitleText = sauceBotVideoPage.getSauceBotVideoPageTitleText();
        String expectedSauceBotPageTitleText = "SauceBot - The Beginning";
        if (sauceBotVideoPageTitleText.equals(expectedSauceBotPageTitleText)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, sauceBotVideoPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_ERRORLOG, sauceBotVideoPageName);
        }
        Assert.assertEquals(sauceBotVideoPageTitleText, expectedSauceBotPageTitleText,
                SlabTestLogMessages.getPageTitleValidationAssertLog(expectedSauceBotPageTitleText));
    }
}