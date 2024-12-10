package com.myappium2project.testsdata;

import com.myappium2project.utils.CommonUtils;

import java.util.List;

/**
 * Saucelab test data constants.
 * This class is not meant to be instantiated.
 */
public final class SaucelabData {
    private static final String SAUCELAB_TEST_DATA_PATH = "src/test/resources/testsdatafiles/sauceLabCredentials.txt";
    private static final List<String> TEST_DATA = CommonUtils.readDataFromFile(SAUCELAB_TEST_DATA_PATH);

    // Account 1.
    public static final String VALID_USERNAME_ACC1 = TEST_DATA.get(1);
    public static final String VALID_PASSWORD_ACC1 = TEST_DATA.get(2);
    public static final String FULL_NAME_ACC1 = TEST_DATA.get(3);
    public static final String ADDRESS_LINE1_ACC1 = TEST_DATA.get(4);
    public static final String CITY_ACC1 = TEST_DATA.get(5);
    public static final String STATE_REGION_ACC1 = TEST_DATA.get(6);
    public static final String ZIP_CODE_ACC1 = TEST_DATA.get(7);
    public static final String COUNTRY_ACC1 = TEST_DATA.get(8);
    public static final String CARD_NUMBER_ACC1 = TEST_DATA.get(9);
    public static final String EXPIRATION_DATE_ACC1 = TEST_DATA.get(10);
    public static final String SECURITY_CODE_ACC1 = TEST_DATA.get(11);

    // Account 2.
    public static final String VALID_USERNAME_ACC2 = TEST_DATA.get(13);
    public static final String VALID_PASSWORD_ACC2 = TEST_DATA.get(14);
    public static final String FULL_NAME_ACC2 = TEST_DATA.get(15);
    public static final String ADDRESS_LINE1_ACC2 = TEST_DATA.get(16);
    public static final String CITY_ACC2 = TEST_DATA.get(17);
    public static final String STATE_REGION_ACC2 = TEST_DATA.get(18);
    public static final String ZIP_CODE_ACC2 = TEST_DATA.get(19);
    public static final String COUNTRY_ACC2 = TEST_DATA.get(20);
    public static final String CARD_NUMBER_ACC2 = TEST_DATA.get(21);
    public static final String EXPIRATION_DATE_ACC2 = TEST_DATA.get(22);
    public static final String SECURITY_CODE_ACC2 = TEST_DATA.get(23);

    private SaucelabData() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}