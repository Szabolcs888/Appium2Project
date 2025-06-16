package com.myappium2project.tests.webapps.curahealthcare;

import com.myappium2project.logging.pagelogmessages.CuraPageLogMessages;
import com.myappium2project.logging.testlogmessages.CommonTestLogMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

/**
 * Utility class providing reusable assertion methods for CURA Healthcare tests.
 * <p>
 * Contains assertions for verifying page load status and appointment data.
 */
public class CuraCommonAssertions {
    private static final Logger LOG = LoggerFactory.getLogger(CuraCommonAssertions.class);

    private CuraCommonAssertions() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    static void verifyPageLoaded(boolean isPageLoaded, String pageName) {
        LOG.info(CommonTestLogMessages.CHECK_ON_PAGE_LOG, pageName);
        if (isPageLoaded) {
            LOG.info(CommonTestLogMessages.ON_PAGE_LOG, pageName);
        } else {
            LOG.error(CommonTestLogMessages.NOT_ON_PAGE_LOG, pageName);
        }

        Assert.assertTrue(isPageLoaded, CuraPageLogMessages.pageNotLoadAssertLog(pageName));
    }

    static void verifyAppointmentData(List<String> actual, List<String> expected, String pageName) {
        LOG.info("We check if the appointment data matches the ones we provided");
        System.out.println("The appointment data is on the '" + pageName + "', page: " + System.lineSeparator() + actual);
        System.out.println("Original appointment data: " + System.lineSeparator() + expected);
        if (actual.equals(expected)) {
            LOG.info("The appointment data is correct on the '{}' page", pageName);
        } else {
            LOG.error("The appointment data is not correct on the '{}' page", pageName);
        }

        Assert.assertEquals(actual, expected, "The appointment data on the '" + pageName + "' page should match the provided data, but it does not.");
    }
}