package com.myappium2project.tests.curahealthcarewithchrome;

import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataCura;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarewithchrome.AppointmentConfirmationPage;
import com.myappium2project.pages.curahealthcarewithchrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarewithchrome.LoginPage;
import com.myappium2project.pages.curahealthcarewithchrome.MakeAppointmentPage;

import java.util.Arrays;
import java.util.List;

public class AppointmentConfirmationTests extends ChromeBrowserBaseTest {

    @Test
    public void testAppointmentConfirmationCura() {
        driver.get(TestDataCura.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(TestDataCura.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.fillPasswordInput(TestDataCura.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE);
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        makeAppointmentPage.pressFacilityDropDownMenuButton();
        makeAppointmentPage.choiceFacilityOption(TestDataCura.FACILTY_ACC1);
        makeAppointmentPage.pressApplyForHospitalReadmissionCheckBoxOrDontPressIt(TestDataCura.READMISSION_ACC1);
        makeAppointmentPage.choiceHealthcareProgramOption(TestDataCura.HEALTHCARE_PROGRAM_ACC1);
        makeAppointmentPage.fillDateOfVisitInput(TestDataCura.VIST_DATE_ACC1);
        makeAppointmentPage.fillCommentInput(TestDataCura.COMMENT_ACC1);
        makeAppointmentPage.pressBookAppointmentButton();

        LOG.info("We check whether the appointment data matches the ones we provided");
        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        List<String> appointmentDataAsTheyAreOnThePage = appointmentConfirmationPage.getAppointmentDataAsTheyAreOnTheAppointmentConfirmationPage();
        List<String> appointmentDataAsItShouldBe = Arrays.asList(
                TestDataCura.FACILTY_ACC1, TestDataCura.READMISSION_ACC1, TestDataCura.HEALTHCARE_PROGRAM_ACC1,
                TestDataCura.VIST_DATE_ACC1, TestDataCura.COMMENT_ACC1);
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