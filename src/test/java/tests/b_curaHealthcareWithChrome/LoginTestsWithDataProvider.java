package tests.b_curaHealthcareWithChrome;

import listeners.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.b_curaHealthcareWithChrome.HamburgerMenu;
import pages.b_curaHealthcareWithChrome.LoginPage;
import pages.b_curaHealthcareWithChrome.MakeAppointmentPage;
import tests._baseTests.ChromeBrowserBaseTest;

@Listeners(TestListener.class)
public class LoginTestsWithDataProvider extends ChromeBrowserBaseTest {
    private static final Logger log = LogManager.getLogger(LoginTestsWithDataProvider.class);

    /**
     * Here, I did not read the data directly from a file for the sake of illustration.
     **/
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

        log.info("We check whether the login is successful. The expected result: {}", expectedResult);
        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        boolean isMakeAppointmentPageLoaded = makeAppointmentPage.isPageLoaded();
        if (isMakeAppointmentPageLoaded) {
            log.info("Login is successful");
        } else {
            log.error("Login failed");
        }
        Assert.assertEquals(isMakeAppointmentPageLoaded, expectedResult);
    }
}
