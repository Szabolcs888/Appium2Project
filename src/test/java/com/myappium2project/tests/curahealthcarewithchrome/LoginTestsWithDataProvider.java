package com.myappium2project.tests.curahealthcarewithchrome;

import com.myappium2project.tests.basetests.ChromeBrowserBaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.myappium2project.pages.curahealthcarewithchrome.HamburgerMenu;
import com.myappium2project.pages.curahealthcarewithchrome.LoginPage;
import com.myappium2project.pages.curahealthcarewithchrome.MakeAppointmentPage;

public class LoginTestsWithDataProvider extends ChromeBrowserBaseTest {

    // Here, I did not read the data directly from a file for the sake of illustration.
    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        Object[][] data = {
                {"John Doe", "valid", "ThisIsNotAPassword", "valid", true},
                {"John Doe", "valid", "invalidPassword", "invalid", false},
                {"invalidUsername", "invalid", "ThisIsNotAPassword", "valid", false},
                {"", "empty", "", "empty", false}
        };
        return data;
    }

    @Test(dataProvider = "loginData")
    public void testsAllLoginCura(String username, String validOrInvalidUN, String password, String validOrInvalidPW, boolean expectedResult) {
        driver.get("https://katalon-demo-cura.herokuapp.com");

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