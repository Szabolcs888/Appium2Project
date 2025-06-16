package com.myappium2project.tests.webapps.curahealthcare;

import com.myappium2project.configdata.models.accounts.CuraHealthcareAccount;
import com.myappium2project.configdata.providers.accounts.CuraHealthcareAccountProvider;
import com.myappium2project.tests.basetests.BrowserTestBase;
import com.myappium2project.testsgroups.TestGroups;
import org.testng.annotations.Test;
import com.myappium2project.pages.webapps.curahealthcare.AppointmentConfirmationPage;
import com.myappium2project.pages.webapps.curahealthcare.HamburgerMenu;
import com.myappium2project.pages.webapps.curahealthcare.MakeAppointmentPage;

import java.util.Arrays;
import java.util.List;

@Test(groups = {TestGroups.INTEGRATION})
public class AppointmentConfirmationTests extends BrowserTestBase {
    private static final CuraHealthcareAccount CURA_ACC1 = CuraHealthcareAccountProvider.getAccount(0);

    @Test
    public void testAppointmentConfirmation() {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        CuraCommonSteps.loginToCura(driver, hamburgerMenu, CURA_ACC1);

        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        makeAppointmentPage.pressFacilityDropDownMenuButton();
        makeAppointmentPage.choiceFacilityOption(CURA_ACC1.getFacility());
        makeAppointmentPage.pressApplyForHospitalReadmissionCheckBoxOrDontPressIt(CURA_ACC1.getReadmission());
        makeAppointmentPage.choiceHealthcareProgramOption(CURA_ACC1.getHealthcareProgram());
        makeAppointmentPage.fillDateOfVisitInput(CURA_ACC1.getVisitDate());
        makeAppointmentPage.fillCommentInput(CURA_ACC1.getComment());
        makeAppointmentPage.pressBookAppointmentButton();

        String appointmentConfirmationPageName = "Appointment Confirmation";
        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        List<String> appointmentDataOnAppointmentConfirmationPage =
                appointmentConfirmationPage.getAppointmentDataOnAppointmentConfirmationPage();
        List<String> appointmentDataAsItShouldBe = Arrays.asList(
                CURA_ACC1.getFacility(), CURA_ACC1.getReadmission(),
                CURA_ACC1.getHealthcareProgram(), CURA_ACC1.getVisitDate(),
                CURA_ACC1.getComment());
        CuraCommonAssertions.verifyAppointmentData(appointmentDataOnAppointmentConfirmationPage, appointmentDataAsItShouldBe, appointmentConfirmationPageName);
    }
}