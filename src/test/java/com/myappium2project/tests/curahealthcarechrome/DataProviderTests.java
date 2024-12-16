package com.myappium2project.tests.curahealthcarechrome;

import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import com.myappium2project.tests.basetests.ChromeBrowserTestBase;
import com.myappium2project.testsdata.CuraHealthcareData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarechrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarechrome.LoginPage;
import com.myappium2project.pages.curahealthcarechrome.MakeAppointmentPage;

public class DataProviderTests extends ChromeBrowserTestBase {

    /**
     * The order of attributes of the data Object:
     * 1.username, 2.username validation status message, 3.password, 4.password validation status message, 5.login success result
     */
    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        Object[][] data = {
                {CuraHealthcareData.VALID_USERNAME_ACC1, CommonTestLogMessages.VALID_LOG,
                        CuraHealthcareData.VALID_PASSWORD_ACC1, CommonTestLogMessages.VALID_LOG, true},
                {CuraHealthcareData.VALID_USERNAME_ACC1, CommonTestLogMessages.VALID_LOG,
                        CommonTestLogMessages.INVALID_PASSWORD_LOG, CommonTestLogMessages.INVALID_LOG, false},
                {CommonTestLogMessages.INVALID_USERNAME_LOG, CommonTestLogMessages.INVALID_LOG,
                        CuraHealthcareData.VALID_PASSWORD_ACC1, CommonTestLogMessages.VALID_LOG, false},
                {"", CommonTestLogMessages.EMPTY_LOG, "", CommonTestLogMessages.EMPTY_LOG, false}
        };
        return data;
    }

    @Test(dataProvider = "loginData")
    public void testsAllLoginCura(
            String username, String usernameValidityStatus, String password,
            String passwordValidityStatus, boolean expectedResult) {
        driver.get(CuraHealthcareData.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(username, usernameValidityStatus);
        loginPage.fillPasswordInput(password, passwordValidityStatus);
        loginPage.pressLoginButton();

        String loginExpectedResultMessage = getLoginExpectedResultMessage(expectedResult);
        LOG.info("We check if the login is successful. The expected result: {}", loginExpectedResultMessage);
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            LOG.info("Login is successful");
        } else {
            LOG.info("Login failed");
        }
        Assert.assertEquals(isMakeAppointmentPageLoaded, expectedResult,
                "The login result should be '" + expectedResult + "', but it is '" + isMakeAppointmentPageLoaded + "'.");
    }

    private static String getLoginExpectedResultMessage(boolean expectedResult) {
        if (expectedResult) {
            return "successful login";
        } else {
            return "failed login";
        }
    }
}