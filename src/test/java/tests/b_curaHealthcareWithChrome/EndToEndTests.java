package tests.b_curaHealthcareWithChrome;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.b_curaHealthcareWithChrome.*;
import tests._baseTests.ChromeBrowserBaseTest;
import utils.CommonUtils;

import java.util.Arrays;
import java.util.List;

@Listeners(TestListener.class)
public class EndToEndTests extends ChromeBrowserBaseTest {
    private static final Logger log = LogManager.getLogger(tests.b_curaHealthcareWithChrome.EndToEndTests.class);
    private static final String testDataPath = "src/test/resources/testData/curaHealthcareCredentials.txt";

    @Test
    public void testEndToEndCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(9), "valid");
        loginPage.fillPasswordInput(testData.get(10), "valid");
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        log.info("We check if we are on the 'Make Appointment' page");
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            log.info("We are on the 'Make Appointment' page");
        } else {
            log.error("We are not on the 'Make Appointment' page");
        }
        Assert.assertTrue(isMakeAppointmentPageLoaded);

        makeAppointmentPage.pressFacilityDropDownMenuButton();
        makeAppointmentPage.choiceFacilityOption(testData.get(11));
        makeAppointmentPage.pressApplyForHospitalReadmissionCheckBoxOrDontPressIt(testData.get(12));
        makeAppointmentPage.choiceHealthcareProgramOption(testData.get(13));
        makeAppointmentPage.fillDateOfVisitInput(testData.get(14));
        makeAppointmentPage.fillCommentInput(testData.get(15));
        makeAppointmentPage.pressBookAppointmentButton();

        log.info("We check if we are on the 'Appointment Confirmation' page");
        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        boolean isAppointmentConfirmationPageLoaded = appointmentConfirmationPage.isPageLoaded();
        if (isAppointmentConfirmationPageLoaded) {
            log.info("We are on the 'Appointment Confirmation' page");
        } else {
            log.error("We are not on the 'Appointment Confirmation' page");
        }
        Assert.assertTrue(isAppointmentConfirmationPageLoaded);

        log.info("We check whether the appointment data matches the ones we provided");
        List<String> appointmentDataAsTheyAreOnTheAppointmentConfirmationPage = appointmentConfirmationPage.getAppointmentDataAsTheyAreOnTheAppointmentConfirmationPage();
        List<String> appointmentDataAsItShouldBe = Arrays.asList(testData.get(11), testData.get(12), testData.get(13), testData.get(14), testData.get(15));
        System.out.println("Appointment data is on the 'Appointment Confirmation' page: \n" + appointmentDataAsTheyAreOnTheAppointmentConfirmationPage);
        System.out.println("Original appointment data: \n" + appointmentDataAsItShouldBe);
        if (appointmentDataAsTheyAreOnTheAppointmentConfirmationPage.equals(appointmentDataAsItShouldBe)) {
            log.info("The appointment data is correct on the 'Appointment Confirmation' page");
        } else {
            log.error("The appointment data is not correct on the 'Appointment Confirmation' page");
        }
        Assert.assertEquals(appointmentDataAsTheyAreOnTheAppointmentConfirmationPage, appointmentDataAsItShouldBe);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressHistoryButton();

        log.info("We check if we are on the 'History' page");
        HistoryPage historyPage = new HistoryPage(driver);
        boolean isDisplayedHistoryPageTitleText = historyPage.isPageLoaded();
        if (historyPage.isPageLoaded()) {
            log.info("We are on the 'History' page");
        } else {
            log.error("We are not on the 'History' page");
        }
        Assert.assertTrue(isDisplayedHistoryPageTitleText);

        log.info("We also check the appointment data on the 'History' page");
        List<String> appointmentDataAsTheyAreOnTheHistoryPage = historyPage.getAppointmentDataAsTheyAreOnTheHistoryPage();
        List<String> appointmentDataAsItShouldBe2 = Arrays.asList(testData.get(14), testData.get(11), testData.get(12), testData.get(13), testData.get(15));
        System.out.println("Appointment data is on the 'History' page: \n" + appointmentDataAsTheyAreOnTheHistoryPage);
        System.out.println("Original appointment data: \n" + appointmentDataAsItShouldBe2);
        if (appointmentDataAsTheyAreOnTheHistoryPage.equals(appointmentDataAsItShouldBe2)) {
            log.info("The appointment data is correct on the 'History' page");
        } else {
            log.error("The appointment data is not correct on the 'History' page");
        }
        Assert.assertEquals(appointmentDataAsTheyAreOnTheHistoryPage, appointmentDataAsItShouldBe2);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressProfileButton();

        log.info("We check whether we are on the 'Profile' page");
        ProfilePage profilePage = new ProfilePage(driver);
        boolean isProfilePageLoaded = profilePage.isPageLoaded();
        if (isProfilePageLoaded) {
            log.info("We are on the 'Profile' page");
        } else {
            log.error("We are not on the 'Profile' page");
        }
        Assert.assertTrue(isProfilePageLoaded);

        profilePage.pressLogoutButton();

        log.info("We check whether we are on the 'Main' page");
        MainPage mainPage = new MainPage(driver);
        boolean isMainPageLoaded = mainPage.isPageLoaded();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
        if (isMainPageLoaded && currentUrl.equals(expectedUrl)) {
            log.info("We are on the 'Main' page");
        } else {
            log.error("We are not on the 'Main' page");
        }
        Assert.assertTrue(isMainPageLoaded);
        Assert.assertEquals(currentUrl, expectedUrl);
    }
}

