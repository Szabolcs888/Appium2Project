package com.myappium2project.testsdata;

import com.myappium2project.utils.CommonUtils;

import java.util.List;

/**
 * Cura Healthcare test data constants.
 * This class is not meant to be instantiated.
 */
public final class CuraHealthcareData {
    public static final String CURA_BASE_URL = "https://katalon-demo-cura.herokuapp.com";
    private static final String CURA_TEST_DATA_PATH = "src/test/resources/testsdatafiles/curaHealthcareCredentials.txt";
    private static final List<String> TEST_DATA = CommonUtils.readDataFromFile(CURA_TEST_DATA_PATH);

    // Account 1.
    public static final String VALID_USERNAME_ACC1 = TEST_DATA.get(1);
    public static final String VALID_PASSWORD_ACC1 = TEST_DATA.get(2);
    public static final String FACILTY_ACC1 = TEST_DATA.get(3);
    public static final String READMISSION_ACC1 = TEST_DATA.get(4);
    public static final String HEALTHCARE_PROGRAM_ACC1 = TEST_DATA.get(5);
    public static final String VIST_DATE_ACC1 = TEST_DATA.get(6);
    public static final String COMMENT_ACC1 = TEST_DATA.get(7);

    // Account 2.
    public static final String VALID_USERNAME_ACC2 = TEST_DATA.get(9);
    public static final String VALID_PASSWORD_ACC2 = TEST_DATA.get(10);
    public static final String FACILTY_ACC2 = TEST_DATA.get(11);
    public static final String READMISSION_ACC2 = TEST_DATA.get(12);
    public static final String HEALTHCARE_PROGRAM_ACC2 = TEST_DATA.get(13);
    public static final String VIST_DATE_ACC2 = TEST_DATA.get(14);
    public static final String COMMENT_ACC2 = TEST_DATA.get(15);

    private CuraHealthcareData() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }
}