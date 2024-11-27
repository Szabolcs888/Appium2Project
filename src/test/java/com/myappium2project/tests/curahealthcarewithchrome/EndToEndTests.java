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
    private static final String LOG_CHECK_PAGE = "We check whether we are on the '";
    private static final String LOG_PAGE_SUFFIX = "' page";
    private static final String LOG_ON_PAGE = "We are on the '";
    private static final String LOG_NOT_ON_PAGE = "We are not on the '";
    private static final String LOG_PAGE_SHOULD_BE_LOADED_PREFIX = "The ";
    private static final String LOG_PAGE_SHOULD_BE_LOADED_SUFFIX = " page should be loaded, but it is not.";
    private static final String LOG_APPOINTMENT_DATA_CORRECT_PREFIX = "The appointment data is correct on the '";
    private static final String LOG_APPOINTMENT_DATA_INCORRECT_PREFIX = "The appointment data is not correct on the '";
    private static final String LOG_APPOINTMENT_DATA_PREFIX = "Appointment data is on the '";
    private static final String LOG_ORIGINAL_APPOINTMENT_DATA = "Original appointment data: \n";

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
        LOG.info(LOG_CHECK_PAGE + makeAppointmentPageName + LOG_PAGE_SUFFIX);
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            LOG.info(LOG_ON_PAGE + makeAppointmentPageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + makeAppointmentPageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertTrue(isMakeAppointmentPageLoaded,
                LOG_PAGE_SHOULD_BE_LOADED_PREFIX + makeAppointmentPageName + LOG_PAGE_SHOULD_BE_LOADED_SUFFIX);

        makeAppointmentPage.pressFacilityDropDownMenuButton();
        makeAppointmentPage.choiceFacilityOption(TestDataCura.FACILTY_ACC2);
        makeAppointmentPage.pressApplyForHospitalReadmissionCheckBoxOrDontPressIt(TestDataCura.READMISSION_ACC2);
        makeAppointmentPage.choiceHealthcareProgramOption(TestDataCura.HEALTHCARE_PROGRAM_ACC2);
        makeAppointmentPage.fillDateOfVisitInput(TestDataCura.VIST_DATE_ACC2);
        makeAppointmentPage.fillCommentInput(TestDataCura.COMMENT_ACC2);
        makeAppointmentPage.pressBookAppointmentButton();

        String appointmentConfirmationPageName = "Appointment Confirmation";
        LOG.info(LOG_CHECK_PAGE + appointmentConfirmationPageName + LOG_PAGE_SUFFIX);
        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        boolean isAppointmentConfirmationPageLoaded = appointmentConfirmationPage.isPageLoaded();
        if (isAppointmentConfirmationPageLoaded) {
            LOG.info(LOG_ON_PAGE + appointmentConfirmationPageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + appointmentConfirmationPageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertTrue(isAppointmentConfirmationPageLoaded,
                LOG_PAGE_SHOULD_BE_LOADED_PREFIX + appointmentConfirmationPageName + LOG_PAGE_SHOULD_BE_LOADED_SUFFIX);

        LOG.info("We check whether the appointment data matches the ones we provided");
        List<String> appointmentDataAsTheyAreOnTheAppointmentConfirmationPage =
                appointmentConfirmationPage.getAppointmentDataAsTheyAreOnTheAppointmentConfirmationPage();
        List<String> appointmentDataAsItShouldBe = Arrays.asList(
                TestDataCura.FACILTY_ACC2, TestDataCura.READMISSION_ACC2, TestDataCura.HEALTHCARE_PROGRAM_ACC2,
                TestDataCura.VIST_DATE_ACC2, TestDataCura.COMMENT_ACC2);
        System.out.println(LOG_APPOINTMENT_DATA_PREFIX + appointmentConfirmationPageName + LOG_PAGE_SUFFIX + ": \n" +
                appointmentDataAsTheyAreOnTheAppointmentConfirmationPage);
        System.out.println(LOG_ORIGINAL_APPOINTMENT_DATA + appointmentDataAsItShouldBe);
        if (appointmentDataAsTheyAreOnTheAppointmentConfirmationPage.equals(appointmentDataAsItShouldBe)) {
            LOG.info(LOG_APPOINTMENT_DATA_CORRECT_PREFIX + appointmentConfirmationPageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_APPOINTMENT_DATA_INCORRECT_PREFIX + appointmentConfirmationPageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertEquals(appointmentDataAsTheyAreOnTheAppointmentConfirmationPage, appointmentDataAsItShouldBe,
                "The appointment data should match the provided data, but it does not.");

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressHistoryButton();

        String historyPageName = "History";
        LOG.info(LOG_CHECK_PAGE + historyPageName + LOG_PAGE_SUFFIX);
        HistoryPage historyPage = new HistoryPage(driver);
        boolean isDisplayedHistoryPageTitleText = historyPage.isPageLoaded();
        if (historyPage.isPageLoaded()) {
            LOG.info(LOG_ON_PAGE + historyPageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + historyPageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertTrue(isDisplayedHistoryPageTitleText,
                LOG_PAGE_SHOULD_BE_LOADED_PREFIX + historyPageName + LOG_PAGE_SHOULD_BE_LOADED_SUFFIX);

        LOG.info("We also check the appointment data on the '" + historyPageName + LOG_PAGE_SUFFIX);
        List<String> appointmentDataAsTheyAreOnTheHistoryPage = historyPage.getAppointmentDataAsTheyAreOnTheHistoryPage();
        List<String> appointmentDataAsItShouldBe2 = Arrays.asList(
                TestDataCura.VIST_DATE_ACC2, TestDataCura.FACILTY_ACC2, TestDataCura.READMISSION_ACC2,
                TestDataCura.HEALTHCARE_PROGRAM_ACC2, TestDataCura.COMMENT_ACC2);
        System.out.println(LOG_APPOINTMENT_DATA_PREFIX + historyPageName + LOG_PAGE_SUFFIX + ": \n" + appointmentDataAsTheyAreOnTheHistoryPage);
        System.out.println(LOG_APPOINTMENT_DATA_PREFIX + historyPageName + LOG_PAGE_SUFFIX + ": \n" + appointmentDataAsTheyAreOnTheHistoryPage);
        System.out.println(LOG_ORIGINAL_APPOINTMENT_DATA + appointmentDataAsItShouldBe2);
        if (appointmentDataAsTheyAreOnTheHistoryPage.equals(appointmentDataAsItShouldBe2)) {
            LOG.info(LOG_APPOINTMENT_DATA_CORRECT_PREFIX + historyPageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_APPOINTMENT_DATA_INCORRECT_PREFIX + historyPageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertEquals(appointmentDataAsTheyAreOnTheHistoryPage, appointmentDataAsItShouldBe2,
                "The appointment data on the " + historyPageName + " page should match the provided data, but it does not.");

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressProfileButton();

        String profilePageName = "Profile";
        LOG.info(LOG_CHECK_PAGE + profilePageName + LOG_PAGE_SUFFIX);
        ProfilePage profilePage = new ProfilePage(driver);
        boolean isProfilePageLoaded = profilePage.isPageLoaded();
        if (isProfilePageLoaded) {
            LOG.info(LOG_ON_PAGE + profilePageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + profilePageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertTrue(isProfilePageLoaded,
                LOG_PAGE_SHOULD_BE_LOADED_PREFIX + profilePageName + LOG_PAGE_SHOULD_BE_LOADED_SUFFIX);

        profilePage.pressLogoutButton();

        String mainPageName = "Main";
        LOG.info(LOG_CHECK_PAGE + mainPageName + LOG_PAGE_SUFFIX);
        MainPage mainPage = new MainPage(driver);
        boolean isMainPageLoaded = mainPage.isPageLoaded();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
        if (isMainPageLoaded && currentUrl.equals(expectedUrl)) {
            LOG.info(LOG_ON_PAGE + mainPageName + LOG_PAGE_SUFFIX);
        } else {
            LOG.error(LOG_NOT_ON_PAGE + mainPageName + LOG_PAGE_SUFFIX);
        }
        Assert.assertTrue(isMainPageLoaded,
                LOG_PAGE_SHOULD_BE_LOADED_PREFIX + mainPageName + LOG_PAGE_SHOULD_BE_LOADED_SUFFIX);
        Assert.assertEquals(currentUrl, expectedUrl,
                "The current URL should be '" + expectedUrl + "', but it is '" + currentUrl + "'.");
    }
}