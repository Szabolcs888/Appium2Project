package com.myappium2project.tests.curahealthcarewithchrome;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.logging.testlogmessages.CuraTestLogMessages;
import com.myappium2project.pages.curahealthcarewithchrome.*;
import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataCura;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class EndToEndTests extends ChromeBrowserBaseTest {

    @Test
    public void testEndToEndCura() {
        driver.get(TestDataCura.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataCura.VALID_USERNAME_ACC2, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataCura.VALID_PASSWORD_ACC2, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        String makeAppointmentPageName = "Make Appointment";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), makeAppointmentPageName);
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), makeAppointmentPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), makeAppointmentPageName);
        }
        Assert.assertTrue(isMakeAppointmentPageLoaded, CommonTestLogMessages.getPageLoadErrorAssertLog(makeAppointmentPageName));

        makeAppointmentPage.pressFacilityDropDownMenuButton();
        makeAppointmentPage.choiceFacilityOption(TestDataCura.FACILTY_ACC2);
        makeAppointmentPage.pressApplyForHospitalReadmissionCheckBoxOrDontPressIt(TestDataCura.READMISSION_ACC2);
        makeAppointmentPage.choiceHealthcareProgramOption(TestDataCura.HEALTHCARE_PROGRAM_ACC2);
        makeAppointmentPage.fillDateOfVisitInput(TestDataCura.VIST_DATE_ACC2);
        makeAppointmentPage.fillCommentInput(TestDataCura.COMMENT_ACC2);
        makeAppointmentPage.pressBookAppointmentButton();

        String appointmentConfirmationPageName = "Appointment Confirmation";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), appointmentConfirmationPageName);
        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        boolean isAppointmentConfirmationPageLoaded = appointmentConfirmationPage.isPageLoaded();
        if (isAppointmentConfirmationPageLoaded) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), appointmentConfirmationPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), appointmentConfirmationPageName);
        }
        Assert.assertTrue(isAppointmentConfirmationPageLoaded,
                CommonTestLogMessages.getPageLoadErrorAssertLog(appointmentConfirmationPageName));

        LOG.info(CuraTestLogMessages.CHECK_APPOINTMENT_DATA_LOG);
        List<String> appointmentDataOnAppointmentConfirmationPage =
                appointmentConfirmationPage.getAppointmentDataOnAppointmentConfirmationPage();
        List<String> appointmentDataAsItShouldBe = Arrays.asList(
                TestDataCura.FACILTY_ACC2, TestDataCura.READMISSION_ACC2, TestDataCura.HEALTHCARE_PROGRAM_ACC2,
                TestDataCura.VIST_DATE_ACC2, TestDataCura.COMMENT_ACC2);
        System.out.println(CuraTestLogMessages.getAppointmentDataConsoleLog(appointmentConfirmationPageName) +
                appointmentDataOnAppointmentConfirmationPage);
        System.out.println(CuraTestLogMessages.ORIGINAL_APPOINTMENT_DATA_CONSOLELOG + appointmentDataAsItShouldBe);
        if (appointmentDataOnAppointmentConfirmationPage.equals(appointmentDataAsItShouldBe)) {
            LOG.info(CuraTestLogMessages.getCorrectAppointmentDataLog(), appointmentConfirmationPageName);
        } else {
            LOG.error(CuraTestLogMessages.getIncorrectAppointmentDataErrorLog(), appointmentConfirmationPageName);
        }
        Assert.assertEquals(appointmentDataOnAppointmentConfirmationPage, appointmentDataAsItShouldBe,
                CuraTestLogMessages.APPOINTMENT_DATA_VALIDATION_ERROR_ASSERTLOG);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressHistoryButton();

        String historyPageName = "History";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), historyPageName);
        HistoryPage historyPage = new HistoryPage(driver);
        boolean isDisplayedHistoryPageTitleText = historyPage.isPageLoaded();
        if (historyPage.isPageLoaded()) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), historyPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), historyPageName);
        }
        Assert.assertTrue(isDisplayedHistoryPageTitleText,
                CommonTestLogMessages.getPageLoadErrorAssertLog(historyPageName));

        LOG.info("We also check the appointment data on the '" + historyPageName + "' page");
        List<String> appointmentDataOnHistoryPage = historyPage.getAppointmentDataOnHistoryPage();
        List<String> appointmentDataAsItShouldBe2 = Arrays.asList(
                TestDataCura.VIST_DATE_ACC2, TestDataCura.FACILTY_ACC2, TestDataCura.READMISSION_ACC2,
                TestDataCura.HEALTHCARE_PROGRAM_ACC2, TestDataCura.COMMENT_ACC2);
        System.out.println(CuraTestLogMessages.getAppointmentDataConsoleLog(historyPageName) + appointmentDataOnHistoryPage);
        System.out.println(CuraTestLogMessages.ORIGINAL_APPOINTMENT_DATA_CONSOLELOG + appointmentDataAsItShouldBe2);
        if (appointmentDataOnHistoryPage.equals(appointmentDataAsItShouldBe2)) {
            LOG.info(CuraTestLogMessages.getCorrectAppointmentDataLog(), historyPageName);
        } else {
            LOG.error(CuraTestLogMessages.getIncorrectAppointmentDataErrorLog(), historyPageName);
        }
        Assert.assertEquals(appointmentDataOnHistoryPage, appointmentDataAsItShouldBe2,
                CuraTestLogMessages.getAppointmentDataValidationErrorAssertLog(historyPageName));

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressProfileButton();

        String profilePageName = "Profile";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), profilePageName);
        ProfilePage profilePage = new ProfilePage(driver);
        boolean isProfilePageLoaded = profilePage.isPageLoaded();
        if (isProfilePageLoaded) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), profilePageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), profilePageName);
        }
        Assert.assertTrue(isProfilePageLoaded,
                CommonTestLogMessages.getPageLoadErrorAssertLog(profilePageName));

        profilePage.pressLogoutButton();

        String mainPageName = "Main";
        LOG.info(CommonTestLogMessages.getCheckPageLog(), mainPageName);
        MainPage mainPage = new MainPage(driver);
        boolean isMainPageLoaded = mainPage.isPageLoaded();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
        if (isMainPageLoaded && currentUrl.equals(expectedUrl)) {
            LOG.info(CommonTestLogMessages.getOnPageLog(), mainPageName);
        } else {
            LOG.error(CommonTestLogMessages.getNotOnPageErrorLog(), mainPageName);
        }
        Assert.assertTrue(isMainPageLoaded, CommonTestLogMessages.getPageLoadErrorAssertLog(mainPageName));
        Assert.assertEquals(currentUrl, expectedUrl,
                "The current URL should be '" + expectedUrl + "', but it is '" + currentUrl + "'.");
    }
}