package com.myappium2project.tests.webapps.curahealthcare;

import com.myappium2project.configdata.configpaths.AppConfig;
import com.myappium2project.configdata.models.accounts.CuraHealthcareAccount;
import com.myappium2project.configdata.providers.accounts.CuraHealthcareAccountProvider;
import com.myappium2project.logging.pagelogmessages.CuraPageLogMessages;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.pages.webapps.curahealthcare.*;
import com.myappium2project.tests.basetests.BrowserTestBase;
import com.myappium2project.testsgroups.TestGroups;
import com.myappium2project.utils.BrowserHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Test(groups = {TestGroups.E2E})
public class EndToEndTests extends BrowserTestBase {
    private static final CuraHealthcareAccount CURA_ACC2 = CuraHealthcareAccountProvider.getAccount(1);

    @Test
    public void testEndToEnd() {
        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        CuraCommonSteps.loginToCura(driver, hamburgerMenu, CURA_ACC2);

        BrowserHelper browserHelper = new BrowserHelper(driver, wait);
        browserHelper.dismissPasswordPopupInChrome();

        String makeAppointmentPageName = "Make Appointment";
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded(AppConfig.CURA_MAKE_APPOINTMENT_PAGE_URL);
        CuraCommonAssertions.verifyPageLoaded(isMakeAppointmentPageLoaded, makeAppointmentPageName);

        makeAppointmentPage.pressFacilityDropDownMenuButton();
        makeAppointmentPage.choiceFacilityOption(CURA_ACC2.getFacility());
        makeAppointmentPage.pressApplyForHospitalReadmissionCheckBoxOrDontPressIt(CURA_ACC2.getReadmission());
        makeAppointmentPage.choiceHealthcareProgramOption(CURA_ACC2.getHealthcareProgram());
        makeAppointmentPage.fillDateOfVisitInput(CURA_ACC2.getVisitDate());
        makeAppointmentPage.fillCommentInput(CURA_ACC2.getComment());
        makeAppointmentPage.pressBookAppointmentButton();

        String appointmentConfirmationPageName = "Appointment Confirmation";
        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        boolean isAppointmentConfirmationPageLoaded = appointmentConfirmationPage.isPageLoaded();
        CuraCommonAssertions.verifyPageLoaded(isAppointmentConfirmationPageLoaded, appointmentConfirmationPageName);

        List<String> appointmentDataOnAppointmentConfirmationPage =
                appointmentConfirmationPage.getAppointmentDataOnAppointmentConfirmationPage();
        List<String> appointmentDataAsItShouldBe = Arrays.asList(
                CURA_ACC2.getFacility(), CURA_ACC2.getReadmission(),
                CURA_ACC2.getHealthcareProgram(), CURA_ACC2.getVisitDate(),
                CURA_ACC2.getComment());
        CuraCommonAssertions.verifyAppointmentData(appointmentDataOnAppointmentConfirmationPage, appointmentDataAsItShouldBe, appointmentConfirmationPageName);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressHistoryButton();

        String historyPageName = "History";
        HistoryPage historyPage = new HistoryPage(driver);
        boolean isHistoryPageLoaded = historyPage.isPageLoaded();
        CuraCommonAssertions.verifyPageLoaded(isHistoryPageLoaded, historyPageName);

        // We also check the appointment data on the History page
        List<String> appointmentDataOnHistoryPage = historyPage.getAppointmentDataOnHistoryPage();
        List<String> appointmentDataAsItShouldBe2 = Arrays.asList(
                CURA_ACC2.getVisitDate(), CURA_ACC2.getFacility(),
                CURA_ACC2.getReadmission(), CURA_ACC2.getHealthcareProgram(),
                CURA_ACC2.getComment());
        CuraCommonAssertions.verifyAppointmentData(appointmentDataOnHistoryPage, appointmentDataAsItShouldBe2, historyPageName);

        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressProfileButton();

        String profilePageName = "Profile";
        ProfilePage profilePage = new ProfilePage(driver);
        boolean isProfilePageLoaded = profilePage.isPageLoaded();
        CuraCommonAssertions.verifyPageLoaded(isProfilePageLoaded, profilePageName);

        profilePage.pressLogoutButton();

        String mainPageName = "Main";
        MainPage mainPage = new MainPage(driver);
        boolean isMainPageLoaded = mainPage.isPageLoaded();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = AppConfig.CURA_MAIN_PAGE_URL;
        verifyPageLoaded(isMainPageLoaded, mainPageName, currentUrl, expectedUrl);
    }

    private void verifyPageLoaded(boolean isPageLoaded, String pageName, String currentUrl, String expectedUrl) {
        LOG.info(CommonTestLogMessages.CHECK_ON_PAGE_LOG, pageName);
        if (isPageLoaded && currentUrl.equals(expectedUrl)) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, pageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, pageName);
        }

        Assert.assertTrue(isPageLoaded, CuraPageLogMessages.pageNotLoadAssertLog(pageName));
        Assert.assertEquals(currentUrl, expectedUrl,
                "The current URL should be '" + expectedUrl + "', but it is '" + currentUrl + "'.");
    }
}