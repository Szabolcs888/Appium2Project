package tests.b_curaHealthcareWithChrome;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.b_curaHealthcareWithChrome.AppointmentConfirmationPage;
import pages.b_curaHealthcareWithChrome.HamburgerMenu;
import pages.b_curaHealthcareWithChrome.LoginPage;
import pages.b_curaHealthcareWithChrome.MakeAppointmentPage;
import tests._baseTests.ChromeBrowserBaseTest;
import utils.CommonUtils;

import java.util.Arrays;
import java.util.List;

@Listeners(TestListener.class)
public class AppointmentConfirmationTests extends ChromeBrowserBaseTest {
    private static final Logger log = LogManager.getLogger(AppointmentConfirmationTests.class);
    private static final String testDataPath = "src/test/resources/testData/curaHealthcareCredentials.txt";

    @Test
    public void testAppointmentConfirmationCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(testDataPath);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(testData.get(1), "valid");
        loginPage.fillPasswordInput(testData.get(2), "valid");
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        makeAppointmentPage.pressFacilityDropDownMenuButton();
        makeAppointmentPage.choiceFacilityOption(testData.get(3));
        makeAppointmentPage.pressApplyForHospitalReadmissionCheckBoxOrDontPressIt(testData.get(4));
        makeAppointmentPage.choiceHealthcareProgramOption(testData.get(5));
        makeAppointmentPage.fillDateOfVisitInput(testData.get(6));
        makeAppointmentPage.fillCommentInput(testData.get(7));
        makeAppointmentPage.pressBookAppointmentButton();

        log.info("We check whether the appointment data matches the ones we provided");
        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        List<String> appointmentDataAsTheyAreOnThePage = appointmentConfirmationPage.getAppointmentDataAsTheyAreOnTheAppointmentConfirmationPage();
        List<String> appointmentDataAsItShouldBe = Arrays.asList(testData.get(3), testData.get(4), testData.get(5), testData.get(6), testData.get(7));
        System.out.println("Appointment data is on the page: \n" + appointmentDataAsTheyAreOnThePage);
        System.out.println("Original appointment data: \n" + appointmentDataAsItShouldBe);
        if (appointmentDataAsTheyAreOnThePage.equals(appointmentDataAsItShouldBe)) {
            log.info("The appointment data is correct");
        } else {
            log.error("The appointment data is not correct");
        }
        Assert.assertEquals(appointmentDataAsTheyAreOnThePage, appointmentDataAsItShouldBe);
    }
}
