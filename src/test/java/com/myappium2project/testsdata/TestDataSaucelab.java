package com.myappium2project.testsdata;

import com.myappium2project.utils.CommonUtils;

import java.util.List;

public class TestDataSaucelab {
    private static final String SAUCELAB_TEST_DATA_PATH = "src/test/resources/testsdatafiles/sauceLabCredentials.txt";
    private static final List<String> testData = CommonUtils.readDataFromFile(SAUCELAB_TEST_DATA_PATH);

    // Account 1.
    public static final String VALID_USERNAME_ACC1 = testData.get(1);
    public static final String VALID_PASSWORD_ACC1 = testData.get(2);
    public static final String FULL_NAME_ACC1 = testData.get(3);
    public static final String ADDRESS_LINE1_ACC1 = testData.get(4);
    public static final String CITY_ACC1 = testData.get(5);
    public static final String STATE_REGION_ACC1 = testData.get(6);
    public static final String ZIP_CODE_ACC1 = testData.get(7);
    public static final String COUNTRY_ACC1 = testData.get(8);
    public static final String CARD_NUMBER_ACC1 = testData.get(9);
    public static final String EXPIRATION_DATE_ACC1 = testData.get(10);
    public static final String SECURITY_CODE_ACC1 = testData.get(11);

    // Account 2.
    public static final String VALID_USERNAME_ACC2 = testData.get(13);
    public static final String VALID_PASSWORD_ACC2 = testData.get(14);
    public static final String FULL_NAME_ACC2 = testData.get(15);
    public static final String ADDRESS_LINE1_ACC2 = testData.get(16);
    public static final String CITY_ACC2 = testData.get(17);
    public static final String STATE_REGION_ACC2 = testData.get(18);
    public static final String ZIP_CODE_ACC2 = testData.get(19);
    public static final String COUNTRY_ACC2 = testData.get(20);
    public static final String CARD_NUMBER_ACC2 = testData.get(21);
    public static final String EXPIRATION_DATE_ACC2 = testData.get(22);
    public static final String SECURITY_CODE_ACC2 = testData.get(23);
}
