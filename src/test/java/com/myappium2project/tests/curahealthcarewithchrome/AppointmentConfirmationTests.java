package com.myappium2project.tests.curahealthcarewithchrome;

import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;
import com.myappium2project.utils.TestDataFilePaths;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarewithchrome.AppointmentConfirmationPage;
import com.myappium2project.pages.curahealthcarewithchrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarewithchrome.LoginPage;
import com.myappium2project.pages.curahealthcarewithchrome.MakeAppointmentPage;
import com.myappium2project.utils.CommonUtils;

import java.util.Arrays;
import java.util.List;

public class AppointmentConfirmationTests extends ChromeBrowserBaseTest {
    private static final String TEST_DATA_PATH = TestDataFilePaths.getCuraTestDataPath();

    @Test
    public void testAppointmentConfirmationCura() {
        driver.get("https://katalon-demo-cura.herokuapp.com");

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        List<String> testData = CommonUtils.readDataFromFile(TEST_DATA_PATH);
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

        LOG.info("We check whether the appointment data matches the ones we provided");
        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        List<String> appointmentDataAsTheyAreOnThePage = appointmentConfirmationPage.getAppointmentDataAsTheyAreOnTheAppointmentConfirmationPage();
        List<String> appointmentDataAsItShouldBe = Arrays.asList(
                testData.get(3), testData.get(4), testData.get(5),
                testData.get(6), testData.get(7));
        System.out.println("Appointment data is on the page: \n" + appointmentDataAsTheyAreOnThePage);
        System.out.println("Original appointment data: \n" + appointmentDataAsItShouldBe);
        if (appointmentDataAsTheyAreOnThePage.equals(appointmentDataAsItShouldBe)) {
            LOG.info("The appointment data is correct");
        } else {
            LOG.error("The appointment data is not correct");
        }
        Assert.assertEquals(appointmentDataAsTheyAreOnThePage, appointmentDataAsItShouldBe,
                "The appointment data should match the provided data, but it does not.");
    }
}