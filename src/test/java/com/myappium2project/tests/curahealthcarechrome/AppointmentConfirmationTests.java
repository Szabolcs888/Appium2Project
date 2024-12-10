package com.myappium2project.tests.curahealthcarechrome;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.logging.testlogmessages.CuraTestLogMessages;
import com.myappium2project.tests.basetests.ChromeBrowserTestBase;
import com.myappium2project.testsdata.CuraHealthcareData;
import com.myappium2project.testsgroups.TestGroups;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarechrome.AppointmentConfirmationPage;
import com.myappium2project.pages.curahealthcarechrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarechrome.LoginPage;
import com.myappium2project.pages.curahealthcarechrome.MakeAppointmentPage;

import java.util.Arrays;
import java.util.List;

@Test(groups = {TestGroups.INTEGRATION})
public class AppointmentConfirmationTests extends ChromeBrowserTestBase {

    @Test
    public void testAppointmentConfirmationCura() {
        driver.get(CuraHealthcareData.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(CuraHealthcareData.VALID_USERNAME_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.fillPasswordInput(CuraHealthcareData.VALID_PASSWORD_ACC1, CommonTestLogMessages.VALID_LOG);
        loginPage.pressLoginButton();

        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        makeAppointmentPage.pressFacilityDropDownMenuButton();
        makeAppointmentPage.choiceFacilityOption(CuraHealthcareData.FACILTY_ACC1);
        makeAppointmentPage.pressApplyForHospitalReadmissionCheckBoxOrDontPressIt(CuraHealthcareData.READMISSION_ACC1);
        makeAppointmentPage.choiceHealthcareProgramOption(CuraHealthcareData.HEALTHCARE_PROGRAM_ACC1);
        makeAppointmentPage.fillDateOfVisitInput(CuraHealthcareData.VIST_DATE_ACC1);
        makeAppointmentPage.fillCommentInput(CuraHealthcareData.COMMENT_ACC1);
        makeAppointmentPage.pressBookAppointmentButton();

        LOG.info(CuraTestLogMessages.CHECK_APPOINTMENT_DATA_LOG);
        String appointmentConfirmationPageName = "Appointment Confirmation";
        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        List<String> appointmentDataOnAppointmentConfirmationPage =
                appointmentConfirmationPage.getAppointmentDataOnAppointmentConfirmationPage();
        List<String> appointmentDataAsItShouldBe = Arrays.asList(
                CuraHealthcareData.FACILTY_ACC1, CuraHealthcareData.READMISSION_ACC1,
                CuraHealthcareData.HEALTHCARE_PROGRAM_ACC1, CuraHealthcareData.VIST_DATE_ACC1,
                CuraHealthcareData.COMMENT_ACC1);
        System.out.println(CuraTestLogMessages.appointmentDataLog(appointmentConfirmationPageName) +
                appointmentDataOnAppointmentConfirmationPage);
        System.out.println(CuraTestLogMessages.ORIGINAL_APPOINTMENT_DATA_LOG + appointmentDataAsItShouldBe);
        if (appointmentDataOnAppointmentConfirmationPage.equals(appointmentDataAsItShouldBe)) {
            LOG.info(CuraTestLogMessages.CORRECT_APPOINTMENT_DATA_LOG, appointmentConfirmationPageName);
        } else {
            LOG.error(CuraTestLogMessages.INCORRECT_APPOINTMENT_DATA_LOG, appointmentConfirmationPageName);
        }
        Assert.assertEquals(appointmentDataOnAppointmentConfirmationPage, appointmentDataAsItShouldBe,
                CuraTestLogMessages.incorrectAppointmentDataAssertLog(appointmentConfirmationPageName));
    }
}