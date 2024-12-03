package com.myappium2project.tests.saucelab;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.logging.testlogmessages.SLabTestLogMessages;
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
        LOG.info(CommonTestLogMessages.getCheckPageLog(), webviewPageName);
        WebviewPage webviewPage = new WebviewPage(driver);
        String webviewPageTitleText = webviewPage.getWebviewPageTitleText();
        if (webviewPageTitleText.equals(webviewPageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), webviewPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), webviewPageName);
        }
        Assert.assertEquals(webviewPageTitleText, webviewPageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(webviewPageName));
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testQrCodeScannerPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressQrCodeScannerButton();

        String qrCodeScannerPageName = "QR Code Scanner";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), qrCodeScannerPageName);
        QrCodeScannerPage qrCodeScannerPage = new QrCodeScannerPage(driver);
        String qrCodeScannerPageTitleText = qrCodeScannerPage.getQrCodeScannerPageTitleText();
        if (qrCodeScannerPageTitleText.equals(qrCodeScannerPageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), qrCodeScannerPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), qrCodeScannerPageName);
        }
        Assert.assertEquals(qrCodeScannerPageTitleText, qrCodeScannerPageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(qrCodeScannerPageName));
    }

    @Test(priority = 3,
            groups = {"smoke"})
    public void testGeoLocationPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressGeoLocationButton();

        String geoLocationPageName = "Geo Location";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), geoLocationPageName);
        GeoLocationPage geoLocationPage = new GeoLocationPage(driver);
        String geoLocationPageTitleText = geoLocationPage.getGeoLocationPageTitleText();
        if (geoLocationPageTitleText.equals(geoLocationPageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), geoLocationPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), geoLocationPageName);
        }
        Assert.assertEquals(geoLocationPageTitleText, geoLocationPageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(geoLocationPageName));
    }

    @Test(priority = 4,
            groups = {"smoke"})
    public void testDrawingPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressDrawingButton();

        String drawingPageName = "Drawing";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), drawingPageName);
        DrawingPage drawingPage = new DrawingPage(driver);
        String drawingPageTitleText = drawingPage.getDrawingPageTitleText();
        if (drawingPageTitleText.equals(drawingPageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), drawingPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), drawingPageName);
        }
        Assert.assertEquals(drawingPageTitleText, drawingPageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(drawingPageName));
    }

    @Test(priority = 5,
            groups = {"smoke"})
    public void testAboutPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressAboutButton();

        String aboutPageName = "About";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), aboutPageName);
        AboutPage aboutPage = new AboutPage(driver);
        String aboutPageTitleText = aboutPage.getAboutPageTitleText();
        if (aboutPageTitleText.equals(aboutPageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), aboutPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), aboutPageName);
        }
        Assert.assertEquals(aboutPageTitleText, aboutPageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(aboutPageName));
    }

    @Test(priority = 6,
            groups = {"smoke"})
    public void testFingerPrintPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressFingerPrintButton();

        String fingerPrintPageName = "Finger Print";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), fingerPrintPageName);
        FingerPrintPage fingerPrintPage = new FingerPrintPage(driver);
        String fingerPrintPageTitleText = fingerPrintPage.getFingerPrintPageTitleText();
        if (fingerPrintPageTitleText.equals(fingerPrintPageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), fingerPrintPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), fingerPrintPageName);
        }
        Assert.assertEquals(fingerPrintPageTitleText, fingerPrintPageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(fingerPrintPageName));
    }

    @Test(priority = 7,
            groups = {"smoke"})
    public void testApiCallsPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressApiCallsButton();

        String apiCallsPageName = "API calls";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), apiCallsPageName);
        ApiCallsPage apiCallsPage = new ApiCallsPage(driver);
        String apiCallsPageTitleText = apiCallsPage.getApiCallsPageTitleText();
        if (apiCallsPageTitleText.equals(apiCallsPageName)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), apiCallsPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), apiCallsPageName);
        }
        Assert.assertEquals(apiCallsPageTitleText, apiCallsPageName,
                SLabTestLogMessages.getPageTitleValidationAssertLog(apiCallsPageName));
    }

    @Test(priority = 8,
            groups = {"smoke"})
    public void testSauceBotVideoPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressSauceBotVideoButton();

        String sauceBotVideoPageName = "Sauce Bot Video";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), sauceBotVideoPageName);
        SauceBotVideoPage sauceBotVideoPage = new SauceBotVideoPage(driver);
        String sauceBotVideoPageTitleText = sauceBotVideoPage.getSauceBotVideoPageTitleText();
        String expectedSauceBotPageTitleText = "SauceBot - The Beginning";
        if (sauceBotVideoPageTitleText.equals(expectedSauceBotPageTitleText)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), sauceBotVideoPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), sauceBotVideoPageName);
        }
        Assert.assertEquals(sauceBotVideoPageTitleText, expectedSauceBotPageTitleText,
                SLabTestLogMessages.getPageTitleValidationAssertLog(expectedSauceBotPageTitleText));
    }
}