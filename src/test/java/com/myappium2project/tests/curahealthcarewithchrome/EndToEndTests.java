package com.myappium2project.tests.curahealthcarewithchrome;

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

        LOG.info("We check if we are on the 'Make Appointment' page");
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            LOG.info("We are on the 'Make Appointment' page");
        } else {
            LOG.error("We are not on the 'Make Appointment' page");
        }
        Assert.assertTrue(isMakeAppointmentPageLoaded,
                "The 'Make Appointment' page should be loaded, but it is not.");

        makeAppointmentPage.pressFacilityDropDownMenuButton();
        makeAppointmentPage.choiceFacilityOption(TestDataCura.FACILTY_ACC2);
        makeAppointmentPage.pressApplyForHospitalReadmissionCheckBoxOrDontPressIt(TestDataCura.READMISSION_ACC2);
        makeAppointmentPage.choiceHealthcareProgramOption(TestDataCura.HEALTHCARE_PROGRAM_ACC2);
        makeAppointmentPage.fillDateOfVisitInput(TestDataCura.VIST_DATE_ACC2);
        makeAppointmentPage.fillCommentInput(TestDataCura.COMMENT_ACC2);
        makeAppointmentPage.pressBookAppointmentButton();

        LOG.info("We check if we are on the 'Appointment Confirmation' page");
        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        boolean isAppointmentConfirmationPageLoaded = appointmentConfirmationPage.isPageLoaded();
        if (isAppointmentConfirmationPageLoaded) {
            LOG.info("We are on the 'Appointment Confirmation' page");
        } else {
            LOG.error("We are not on the 'Appointment Confirmation' page");
        }
        Assert.assertTrue(isAppointmentConfirmationPageLoaded,
                "The 'Appointment Confirmation' page should be loaded, but it is not.");

        LOG.info("We check whether the appointment data matches the ones we provided");
        List<String> appointmentDataAsTheyAreOnTheAppointmentConfirmationPage = appointmentConfirmationPage.getAppointmentDataAsTheyAreOnTheAppointmentConfirmationPage();
        List<String> appointmentDataAsItShouldBe = Arrays.asList(
                TestDataCura.FACILTY_ACC2, TestDataCura.READMISSION_ACC2, TestDataCura.HEALTHCARE_PROGRAM_ACC2,
                TestDataCura.VIST_DATE_ACC2, TestDataCura.COMMENT_ACC2);
        System.out.println("Appointment data is on the 'Appointment Confirmation' page: \n" + appointmentDataAsTheyAreOnTheAppointmentConfirmationPage);
        System.out.println("Original appointment data: \n" + appointmentDataAsItShouldBe);
        if (appointmentDataAsTheyAreOnTheAppointmentConfirmationPage.equals(appointmentDataAsItShouldBe)) {
            LOG.info("The appointment data is correct on the 'Appointment Confirmation' page");
        } else {
            LOG.error("The appointment data is not correct on the 'Appointment Confirmation' page");
        }
        Assert.assertEquals(appointmentDataAsTheyAreOnTheAppointmentConfirmationPage, appointmentDataAsItShouldBe,
                "The appointment data should match the provided data, but it does not.");

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressHistoryButton();

        LOG.info("We check if we are on the 'History' page");
        HistoryPage historyPage = new HistoryPage(driver);
        boolean isDisplayedHistoryPageTitleText = historyPage.isPageLoaded();
        if (historyPage.isPageLoaded()) {
            LOG.info("We are on the 'History' page");
        } else {
            LOG.error("We are not on the 'History' page");
        }
        Assert.assertTrue(isDisplayedHistoryPageTitleText, "The 'History' page should be loaded, but it is not.");

        LOG.info("We also check the appointment data on the 'History' page");
        List<String> appointmentDataAsTheyAreOnTheHistoryPage = historyPage.getAppointmentDataAsTheyAreOnTheHistoryPage();
        List<String> appointmentDataAsItShouldBe2 = Arrays.asList(
                TestDataCura.VIST_DATE_ACC2, TestDataCura.FACILTY_ACC2, TestDataCura.READMISSION_ACC2,
                TestDataCura.HEALTHCARE_PROGRAM_ACC2, TestDataCura.COMMENT_ACC2);
        System.out.println("Appointment data is on the 'History' page: \n" + appointmentDataAsTheyAreOnTheHistoryPage);
        System.out.println("Original appointment data: \n" + appointmentDataAsItShouldBe2);
        if (appointmentDataAsTheyAreOnTheHistoryPage.equals(appointmentDataAsItShouldBe2)) {
            LOG.info("The appointment data is correct on the 'History' page");
        } else {
            LOG.error("The appointment data is not correct on the 'History' page");
        }
        Assert.assertEquals(appointmentDataAsTheyAreOnTheHistoryPage, appointmentDataAsItShouldBe2,
                "The appointment data on the 'History' page should match the provided data, but it does not.");

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressProfileButton();

        LOG.info("We check whether we are on the 'Profile' page");
        ProfilePage profilePage = new ProfilePage(driver);
        boolean isProfilePageLoaded = profilePage.isPageLoaded();
        if (isProfilePageLoaded) {
            LOG.info("We are on the 'Profile' page");
        } else {
            LOG.error("We are not on the 'Profile' page");
        }
        Assert.assertTrue(isProfilePageLoaded, "The 'Profile' page should be loaded, but it is not.");

        profilePage.pressLogoutButton();

        LOG.info("We check whether we are on the 'Main' page");
        MainPage mainPage = new MainPage(driver);
        boolean isMainPageLoaded = mainPage.isPageLoaded();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
        if (isMainPageLoaded && currentUrl.equals(expectedUrl)) {
            LOG.info("We are on the 'Main' page");
        } else {
            LOG.error("We are not on the 'Main' page");
        }
        Assert.assertTrue(isMainPageLoaded, "The 'Main' page should be loaded, but it is not.");
        Assert.assertEquals(currentUrl, expectedUrl,
                "The current URL should be '" + expectedUrl + "', but it is '" + currentUrl + "'.");
    }
}