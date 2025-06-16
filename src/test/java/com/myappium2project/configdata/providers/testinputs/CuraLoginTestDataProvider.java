package com.myappium2project.configdata.providers.testinputs;

import com.myappium2project.configdata.configpaths.TestPaths;
import com.myappium2project.configdata.models.testinputs.CuraDataProviderLoginData;
import com.myappium2project.utils.JsonDataReader;
import org.testng.annotations.DataProvider;

import java.util.List;

/**
 * Provides login test data for the Cura web application.
 * <p>
 * The data is loaded from a JSON file and supplied to TestNG tests via a named {@code DataProvider}.
 */
public class CuraLoginTestDataProvider {

    private CuraLoginTestDataProvider() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Data provider for login tests, reading input from a JSON resource.
     *
     * @return a 2D Object array containing test data fields:
     * username, usernameStatus, password, passwordStatus, expectedResult
     */
    @DataProvider(name = "curaLoginDataFromJson")
    public static Object[][] provideLoginData() {
        List<CuraDataProviderLoginData> testDataList = JsonDataReader.readJsonListFromResource(
                TestPaths.CURA_HEALTHCARE_DATA_PROVIDER_LOGIN_DATA_JSON, CuraDataProviderLoginData.class
        );

        Object[][] data = new Object[testDataList.size()][5];
        for (int i = 0; i < testDataList.size(); i++) {
            CuraDataProviderLoginData entry = testDataList.get(i);
            data[i][0] = entry.getUsername();
            data[i][1] = entry.getUsernameStatus();
            data[i][2] = entry.getPassword();
            data[i][3] = entry.getPasswordStatus();
            data[i][4] = entry.isExpectedResult();
        }

        return data;
    }
}