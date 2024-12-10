package com.myappium2project.tests.curahealthcarechrome;

import com.myappium2project.logging.pagelogmessages.CuraPageLogMessages;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.logging.testlogmessages.CuraTestLogMessages;
import com.myappium2project.pages.curahealthcarechrome.*;
import com.myappium2project.tests.basetests.ChromeBrowserTestBase;
import com.myappium2project.testsdata.CuraHealthcareData;
import com.myappium2project.testsgroups.TestGroups;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Test(groups = {TestGroups.E2E})
public class EndToEndTests extends ChromeBrowserTestBase {

    @Test
    public void testEndToEndCura() {
        driver.get(CuraHealthcareData.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(CuraHealthcareData.VALID_USERNAME_ACC2, CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(CuraHealthcareData.VALID_PASSWORD_ACC2, CommonTestLogMessages.VALID_LOG);
        loginPage.pressLoginButton();

        String makeAppointmentPageName = "Make Appointment";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, makeAppointmentPageName);
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, makeAppointmentPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, makeAppointmentPageName);
        }
        Assert.assertTrue(isMakeAppointmentPageLoaded,
                CuraPageLogMessages.pageNotLoadAssertLog(makeAppointmentPageName));

        makeAppointmentPage.pressFacilityDropDownMenuButton();
        makeAppointmentPage.choiceFacilityOption(CuraHealthcareData.FACILTY_ACC2);
        makeAppointmentPage.pressApplyForHospitalReadmissionCheckBoxOrDontPressIt(CuraHealthcareData.READMISSION_ACC2);
        makeAppointmentPage.choiceHealthcareProgramOption(CuraHealthcareData.HEALTHCARE_PROGRAM_ACC2);
        makeAppointmentPage.fillDateOfVisitInput(CuraHealthcareData.VIST_DATE_ACC2);
        makeAppointmentPage.fillCommentInput(CuraHealthcareData.COMMENT_ACC2);
        makeAppointmentPage.pressBookAppointmentButton();

        String appointmentConfirmationPageName = "Appointment Confirmation";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, appointmentConfirmationPageName);
        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        boolean isAppointmentConfirmationPageLoaded = appointmentConfirmationPage.isPageLoaded();
        if (isAppointmentConfirmationPageLoaded) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, appointmentConfirmationPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, appointmentConfirmationPageName);
        }
        Assert.assertTrue(isAppointmentConfirmationPageLoaded,
                CuraPageLogMessages.pageNotLoadAssertLog(appointmentConfirmationPageName));

        LOG.info(CuraTestLogMessages.CHECK_APPOINTMENT_DATA_LOG);
        List<String> appointmentDataOnAppointmentConfirmationPage =
                appointmentConfirmationPage.getAppointmentDataOnAppointmentConfirmationPage();
        List<String> appointmentDataAsItShouldBe = Arrays.asList(
                CuraHealthcareData.FACILTY_ACC2, CuraHealthcareData.READMISSION_ACC2,
                CuraHealthcareData.HEALTHCARE_PROGRAM_ACC2, CuraHealthcareData.VIST_DATE_ACC2,
                CuraHealthcareData.COMMENT_ACC2);
        System.out.println(CuraTestLogMessages.appointmentDataLog(appointmentConfirmationPageName) +
                appointmentDataOnAppointmentConfirmationPage);
        System.out.println(CuraTestLogMessages.ORIGINAL_APPOINTMENT_DATA_LOG + appointmentDataAsItShouldBe);
        if (appointmentDataOnAppointmentConfirmationPage.equals(appointmentDataAsItShouldBe)) {
            LOG.info(CuraTestLogMessages.CORRECT_APPOINTMENT_DATA_LOG, appointmentConfirmationPageName);
        } else {
            LOG.error(CuraTestLogMessages.INCORRECT_APPOINTMENT_DATA_LOG, appointmentConfirmationPageName);
        }
        Assert.assertEquals(appointmentDataOnAppointmentConfirmationPage, appointmentDataAsItShouldBe,
                CuraTestLogMessages.INCORRECT_APPOINTMENT_DATA_ASSERT_LOG);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressHistoryButton();

        String historyPageName = "History";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, historyPageName);
        HistoryPage historyPage = new HistoryPage(driver);
        boolean isDisplayedHistoryPageTitleText = historyPage.isPageLoaded();
        if (isDisplayedHistoryPageTitleText) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, historyPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, historyPageName);
        }
        Assert.assertTrue(isDisplayedHistoryPageTitleText,
                CuraPageLogMessages.pageNotLoadAssertLog(historyPageName));

        LOG.info("We also check the appointment data on the '{}' page", historyPageName);
        List<String> appointmentDataOnHistoryPage = historyPage.getAppointmentDataOnHistoryPage();
        List<String> appointmentDataAsItShouldBe2 = Arrays.asList(
                CuraHealthcareData.VIST_DATE_ACC2, CuraHealthcareData.FACILTY_ACC2,
                CuraHealthcareData.READMISSION_ACC2, CuraHealthcareData.HEALTHCARE_PROGRAM_ACC2,
                CuraHealthcareData.COMMENT_ACC2);
        System.out.println(CuraTestLogMessages.appointmentDataLog(historyPageName) + appointmentDataOnHistoryPage);
        System.out.println(CuraTestLogMessages.ORIGINAL_APPOINTMENT_DATA_LOG + appointmentDataAsItShouldBe2);
        if (appointmentDataOnHistoryPage.equals(appointmentDataAsItShouldBe2)) {
            LOG.info(CuraTestLogMessages.CORRECT_APPOINTMENT_DATA_LOG, historyPageName);
        } else {
            LOG.error(CuraTestLogMessages.INCORRECT_APPOINTMENT_DATA_LOG, historyPageName);
        }
        Assert.assertEquals(appointmentDataOnHistoryPage, appointmentDataAsItShouldBe2,
                CuraTestLogMessages.incorrectAppointmentDataAssertLog(historyPageName));

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressProfileButton();

        String profilePageName = "Profile";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, profilePageName);
        ProfilePage profilePage = new ProfilePage(driver);
        boolean isProfilePageLoaded = profilePage.isPageLoaded();
        if (isProfilePageLoaded) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, profilePageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, profilePageName);
        }
        Assert.assertTrue(isProfilePageLoaded,
                CuraPageLogMessages.pageNotLoadAssertLog(profilePageName));

        profilePage.pressLogoutButton();

        String mainPageName = "Main";
        LOG.info(CommonTestLogMessages.CHECK_PAGE_LOG, mainPageName);
        MainPage mainPage = new MainPage(driver);
        boolean isMainPageLoaded = mainPage.isPageLoaded();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
        if (isMainPageLoaded && currentUrl.equals(expectedUrl)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, mainPageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, mainPageName);
        }
        Assert.assertTrue(isMainPageLoaded, CuraPageLogMessages.pageNotLoadAssertLog(mainPageName));
        Assert.assertEquals(currentUrl, expectedUrl,
                "The current URL should be '" + expectedUrl + "', but it is '" + currentUrl + "'.");
    }
}