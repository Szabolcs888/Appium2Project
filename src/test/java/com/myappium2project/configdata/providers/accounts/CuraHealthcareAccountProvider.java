package com.myappium2project.configdata.providers.accounts;

import com.myappium2project.configdata.configpaths.TestPaths;
import com.myappium2project.configdata.models.accounts.CuraHealthcareAccount;
import com.myappium2project.utils.JsonDataReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides test account data for the CURA Healthcare web application.
 * <p>
 * Loads user credentials and related data from a JSON file defined in
 * {@link TestPaths#CURA_ACCOUNTS_JSON}, and exposes it through static methods.
 */
public final class CuraHealthcareAccountProvider {
    private static final List<CuraHealthcareAccount> accounts =
            JsonDataReader.readJsonListFromResource(TestPaths.CURA_ACCOUNTS_JSON, CuraHealthcareAccount.class);

    private CuraHealthcareAccountProvider() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static CuraHealthcareAccount getAccount(int index) {
        return accounts.get(index);
    }

    public static List<CuraHealthcareAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
}