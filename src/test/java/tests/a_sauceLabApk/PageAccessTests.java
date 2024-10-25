package tests.a_sauceLabApk;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.a_sauceLabApk.HamburgerMenu;
import pages.a_sauceLabApk.menuPages.*;
import tests._baseTests.SauceLabApkBaseTest;

@Listeners(TestListener.class)
public class PageAccessTests extends SauceLabApkBaseTest {
    private static final Logger log = LogManager.getLogger(PageAccessTests.class);

    @Test(priority = 1,
            groups = {"smoke"})
    public void testWebviewPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressWebviewButton();

        log.info("We check whether we are on the 'Webview' page");
        WebviewPage webviewPage = new WebviewPage(driver);
        String webviewPageTitleText = webviewPage.getWebviewPageTitleText();
        String expectedPageTitleText = "Webview";
        if (webviewPageTitleText.equals(expectedPageTitleText)) {
            log.info("We are on the 'Webview' page");
        } else {
            log.error("We are not on the 'Webview' page");
        }
        Assert.assertEquals(webviewPageTitleText, expectedPageTitleText);
    }

    @Test(priority = 2,
            groups = {"smoke"})
    public void testQrCodeScannerPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressQrCodeScannerButton();

        log.info("We check whether we are on the 'QR Code Scanner' page");
        QrCodeScannerPage qrCodeScannerPage = new QrCodeScannerPage(driver);
        String qrCodeScannerPageTitleText = qrCodeScannerPage.getQrCodeScannerPageTitleText();
        String expectedPageTitleText = "QR Code Scanner";
        if (qrCodeScannerPageTitleText.equals(expectedPageTitleText)) {
            log.info("We are on the 'QR Code Scanner' page");
        } else {
            log.error("We are not on the 'QR Code Scanner' page");
        }
        Assert.assertEquals(qrCodeScannerPageTitleText, expectedPageTitleText);
    }

    @Test(priority = 3,
            groups = {"smoke"})
    public void testGeoLocationPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressGeoLocationButton();

        log.info("We check whether we are on the 'Geo Location' page");
        GeoLocationPage geoLocationPage = new GeoLocationPage(driver);
        String geoLocationPageTitleText = geoLocationPage.getGeoLocationPageTitleText();
        String expectedPageTitleText = "Geo Location";
        if (geoLocationPageTitleText.equals(expectedPageTitleText)) {
            log.info("We are on the 'Geo Location' page");
        } else {
            log.error("We are not on the 'Geo Location' page");
        }
        Assert.assertEquals(geoLocationPageTitleText, expectedPageTitleText);
    }

    @Test(priority = 4,
            groups = {"smoke"})
    public void testDrawingPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressDrawingButton();

        log.info("We check whether we are on the 'Drawing' page");
        DrawingPage drawingPage = new DrawingPage(driver);
        String drawingPageTitleText = drawingPage.getDrawingPageTitleText();
        String expectedPageTitleText = "Drawing";
        if (drawingPageTitleText.equals(expectedPageTitleText)) {
            log.info("We are on the 'Drawing' page");
        } else {
            log.error("We are not on the 'Drawing' page");
        }
        Assert.assertEquals(drawingPageTitleText, expectedPageTitleText);
    }

    @Test(priority = 5,
            groups = {"smoke"})
    public void testAboutPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressAboutButton();

        log.info("We check whether we are on the 'About' page");
        AboutPage aboutPage = new AboutPage(driver);
        String aboutPageTitleText = aboutPage.getAboutPageTitleText();
        String expectedPageTitleText = "About";
        if (aboutPageTitleText.equals(expectedPageTitleText)) {
            log.info("We are on the 'About' page");
        } else {
            log.error("We are not on the 'About' page");
        }
        Assert.assertEquals(aboutPageTitleText, expectedPageTitleText);
    }

    @Test(priority = 6,
            groups = {"smoke"})
    public void testFingerPrintPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressFingerPrintButton();

        log.info("We check whether we are on the 'Finger Print' page");
        FingerPrintPage fingerPrintPage = new FingerPrintPage(driver);
        String fingerPrintPageTitleText = fingerPrintPage.getFingerPrintPageTitleText();
        String expectedPageTitleText = "Finger Print";
        if (fingerPrintPageTitleText.equals(expectedPageTitleText)) {
            log.info("We are on the 'Finger Print' page");
        } else {
            log.error("We are not on the 'Finger Print' page");
        }
        Assert.assertEquals(fingerPrintPageTitleText, expectedPageTitleText);
    }

    @Test(priority = 7,
            groups = {"smoke"})
    public void testApiCallsPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressApiCallsButton();

        log.info("We check whether we are on the 'API calls' page");
        ApiCallsPage apiCallsPage = new ApiCallsPage(driver);
        String apiCallsPageTitleText = apiCallsPage.getApiCallsPageTitleText();
        String expectedPageTitleText = "API calls";
        if (apiCallsPageTitleText.equals(expectedPageTitleText)) {
            log.info("We are on the 'API calls' page");
        } else {
            log.error("We are not on the 'API calls' page");
        }
        Assert.assertEquals(apiCallsPageTitleText, expectedPageTitleText);
    }

    @Test(priority = 8,
            groups = {"smoke"})
    public void testSauceBotVideoPageAccess() throws InterruptedException {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver, wait);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressSauceBotVideoButton();

        log.info("We check whether we are on the 'Sauce Bot Video' page");
        SauceBotVideoPage sauceBotVideoPage = new SauceBotVideoPage(driver);
        String sauceBotVideoPageTitleText = sauceBotVideoPage.getSauceBotVideoPageTitleText();
        String expectedPageTitleText = "SauceBot - The Beginning";
        if (sauceBotVideoPageTitleText.equals(expectedPageTitleText)) {
            log.info("We are on the 'Sauce Bot Video' page");
        } else {
            log.error("We are not on the 'Sauce Bot Video' page");
        }
        Assert.assertEquals(sauceBotVideoPageTitleText, expectedPageTitleText);
    }
}
