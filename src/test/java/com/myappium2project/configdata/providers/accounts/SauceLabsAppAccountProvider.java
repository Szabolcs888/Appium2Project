package com.myappium2project.configdata.providers.accounts;

import com.myappium2project.configdata.configpaths.TestPaths;
import com.myappium2project.configdata.models.accounts.SauceLabsAppAccount;
import com.myappium2project.utils.JsonDataReader;

import java.util.Arrays;
import java.util.List;

/**
 * Provides test account data for the Sauce Labs mobile application.
 * <p>
 * Loads account details from a JSON file defined in {@link TestPaths#SLABS_ACCOUNTS_JSON}
 * and makes them available for test classes via static access methods.
 */
public class SauceLabsAppAccountProvider {
    private static final List<SauceLabsAppAccount> accounts =
            Arrays.asList(JsonDataReader.readJsonFromResource(TestPaths.SLABS_ACCOUNTS_JSON, SauceLabsAppAccount[].class));

    private SauceLabsAppAccountProvider() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static SauceLabsAppAccount getAccount(int index) {
        return accounts.get(index);
    }

    public static List<SauceLabsAppAccount> getAllAccounts() {
        return accounts;
    }
}