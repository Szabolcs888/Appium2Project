package com.myappium2project.tests.saucelab;

import com.myappium2project.pages.saucelab.menupages.*;
import com.myappium2project.tests.basetests.SauceLabApkBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.saucelab.HamburgerMenu;

public class PageAccessTests extends SauceLabApkBaseTest {
    private static final String LOG_CHECK_PAGE = "We check whether we are on the '";
    private static final String LOG_PAGE_SUFFIX = "' page";
    private static final String LOG_ON_PAGE = "We are on the '";
    private static final String LOG_NOT_ON_PAGE = "We are not on the '";
    private static final String PAGE_TITLE_SHOULD_BE_PREFIX = "The page title should be '";
    private static final String PAGE_TITLE_SHOULD_BE_SUFFIX = "', but it is not.";

    @Test(priority = 1,
            groups = {"smoke"})
    public void testWebviewPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressWebviewButton();

        String pageName = "Webview";
        LOG.info(LOG_CHECK_PAGE + pageName + LOG_PAGE_SUFFIX);
        WebviewPage webviewPage = new WebviewPage(driver);
        String webviewPageTitleText = webviewPage.getWebviewPageTitleText();
        String expectedPageTitleText = pageName;
        if (webviewPageTitleText.equals(expectedPageTitleText)) {
            LOG.info(LOG_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertEquals(webviewPageTitleText, expectedPageTitleText,
                PAGE_TITLE_SHOULD_BE_PREFIX + expectedPageTitleText + PAGE_TITLE_SHOULD_BE_SUFFIX);
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testQrCodeScannerPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressQrCodeScannerButton();

        String pageName = "QR Code Scanner";
        LOG.info(LOG_CHECK_PAGE + pageName + LOG_PAGE_SUFFIX);
        QrCodeScannerPage qrCodeScannerPage = new QrCodeScannerPage(driver);
        String qrCodeScannerPageTitleText = qrCodeScannerPage.getQrCodeScannerPageTitleText();
        String expectedPageTitleText = pageName;
        if (qrCodeScannerPageTitleText.equals(expectedPageTitleText)) {
            LOG.info(LOG_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertEquals(qrCodeScannerPageTitleText, expectedPageTitleText,
                PAGE_TITLE_SHOULD_BE_PREFIX + expectedPageTitleText + PAGE_TITLE_SHOULD_BE_SUFFIX);
    }

    @Test(priority = 3,
            groups = {"smoke"})
    public void testGeoLocationPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressGeoLocationButton();

        String pageName = "Geo Location";
        LOG.info(LOG_CHECK_PAGE + pageName + LOG_PAGE_SUFFIX);
        GeoLocationPage geoLocationPage = new GeoLocationPage(driver);
        String geoLocationPageTitleText = geoLocationPage.getGeoLocationPageTitleText();
        String expectedPageTitleText = pageName;
        if (geoLocationPageTitleText.equals(expectedPageTitleText)) {
            LOG.info(LOG_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertEquals(geoLocationPageTitleText, expectedPageTitleText,
                PAGE_TITLE_SHOULD_BE_PREFIX + expectedPageTitleText + PAGE_TITLE_SHOULD_BE_SUFFIX);
    }

    @Test(priority = 4,
            groups = {"smoke"})
    public void testDrawingPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressDrawingButton();

        String pageName = "Drawing";
        LOG.info(LOG_CHECK_PAGE + pageName + LOG_PAGE_SUFFIX);
        DrawingPage drawingPage = new DrawingPage(driver);
        String drawingPageTitleText = drawingPage.getDrawingPageTitleText();
        String expectedPageTitleText = pageName;
        if (drawingPageTitleText.equals(expectedPageTitleText)) {
            LOG.info(LOG_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertEquals(drawingPageTitleText, expectedPageTitleText,
                PAGE_TITLE_SHOULD_BE_PREFIX + expectedPageTitleText + PAGE_TITLE_SHOULD_BE_SUFFIX);
    }

    @Test(priority = 5,
            groups = {"smoke"})
    public void testAboutPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressAboutButton();

        String pageName = "About";
        LOG.info(LOG_CHECK_PAGE + pageName + LOG_PAGE_SUFFIX);
        AboutPage aboutPage = new AboutPage(driver);
        String aboutPageTitleText = aboutPage.getAboutPageTitleText();
        String expectedPageTitleText = pageName;
        if (aboutPageTitleText.equals(expectedPageTitleText)) {
            LOG.info(LOG_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertEquals(aboutPageTitleText, expectedPageTitleText,
                PAGE_TITLE_SHOULD_BE_PREFIX + expectedPageTitleText + PAGE_TITLE_SHOULD_BE_SUFFIX);
    }

    @Test(priority = 6,
            groups = {"smoke"})
    public void testFingerPrintPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressFingerPrintButton();

        String pageName = "Finger Print";
        LOG.info(LOG_CHECK_PAGE + pageName + LOG_PAGE_SUFFIX);
        FingerPrintPage fingerPrintPage = new FingerPrintPage(driver);
        String fingerPrintPageTitleText = fingerPrintPage.getFingerPrintPageTitleText();
        String expectedPageTitleText = pageName;
        if (fingerPrintPageTitleText.equals(expectedPageTitleText)) {
            LOG.info(LOG_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertEquals(fingerPrintPageTitleText, expectedPageTitleText,
                PAGE_TITLE_SHOULD_BE_PREFIX + expectedPageTitleText + PAGE_TITLE_SHOULD_BE_SUFFIX);
    }

    @Test(priority = 7,
            groups = {"smoke"})
    public void testApiCallsPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressApiCallsButton();

        String pageName = "API calls";
        LOG.info(LOG_CHECK_PAGE + pageName + LOG_PAGE_SUFFIX);
        ApiCallsPage apiCallsPage = new ApiCallsPage(driver);
        String apiCallsPageTitleText = apiCallsPage.getApiCallsPageTitleText();
        String expectedPageTitleText = pageName;
        if (apiCallsPageTitleText.equals(expectedPageTitleText)) {
            LOG.info(LOG_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertEquals(apiCallsPageTitleText, expectedPageTitleText,
                PAGE_TITLE_SHOULD_BE_PREFIX + expectedPageTitleText + PAGE_TITLE_SHOULD_BE_SUFFIX);
    }

    @Test(priority = 8,
            groups = {"smoke"})
    public void testSauceBotVideoPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressSauceBotVideoButton();

        String pageName = "Sauce Bot Video";
        LOG.info(LOG_CHECK_PAGE + pageName + LOG_PAGE_SUFFIX);
        SauceBotVideoPage sauceBotVideoPage = new SauceBotVideoPage(driver);
        String sauceBotVideoPageTitleText = sauceBotVideoPage.getSauceBotVideoPageTitleText();
        String expectedPageTitleText = "SauceBot - The Beginning";
        if (sauceBotVideoPageTitleText.equals(expectedPageTitleText)) {
            LOG.info(LOG_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + pageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertEquals(sauceBotVideoPageTitleText, expectedPageTitleText,
                PAGE_TITLE_SHOULD_BE_PREFIX + expectedPageTitleText + PAGE_TITLE_SHOULD_BE_SUFFIX);
    }
}