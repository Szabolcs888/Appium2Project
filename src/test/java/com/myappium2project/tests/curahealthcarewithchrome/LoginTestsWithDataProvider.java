package com.myappium2project.tests.curahealthcarewithchrome;

import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;
import com.myappium2project.testsdata.CommonTestData;
import com.myappium2project.testsdata.TestDataCura;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarewithchrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarewithchrome.LoginPage;
import com.myappium2project.pages.curahealthcarewithchrome.MakeAppointmentPage;

public class LoginTestsWithDataProvider extends ChromeBrowserBaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        Object[][] data = {
                {TestDataCura.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE, TestDataCura.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE, true},
                {TestDataCura.VALID_USERNAME_ACC1, CommonTestData.VALID_LOG_MESSAGE, CommonTestData.INVALID_PASSWORD, CommonTestData.INVALID_LOG_MESSAGE, false},
                {CommonTestData.INVALID_USERNAME, CommonTestData.INVALID_LOG_MESSAGE, TestDataCura.VALID_PASSWORD_ACC1, CommonTestData.VALID_LOG_MESSAGE, false},
                {"", CommonTestData.EMPTY_LOG_MESSAGE, "", CommonTestData.EMPTY_LOG_MESSAGE, false}
        };
        return data;
    }

    @Test(dataProvider = "loginData")
    public void testsAllLoginCura(String username, String validOrInvalidUN, String password, String validOrInvalidPW, boolean expectedResult) {
        driver.get(TestDataCura.CURA_BASE_URL);

        HamburgerMenu hamburgerMenu = new HamburgerMenu(driver);
        hamburgerMenu.pressHamburgerMenuButton();
        hamburgerMenu.pressLoginButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUserNameInput(username, validOrInvalidUN);
        loginPage.fillPasswordInput(password, validOrInvalidPW);
        loginPage.pressLoginText();
        loginPage.pressLoginButton();

        LOG.info("We check whether the login is successful. The expected result: {}", expectedResult);
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            LOG.info("Login is successful");
        } else {
            LOG.error("Login failed");
        }
        Assert.assertEquals(isMakeAppointmentPageLoaded, expectedResult,
                "The login result should be '" + expectedResult + "', but it is '" + isMakeAppointmentPageLoaded + "'.");
    }
}