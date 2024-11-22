package com.myappium2project.utils;

public class TestDataFilePaths {
    private static final String CURA_TEST_DATA_PATH = "src/test/resources/testdata/curaHealthcareCredentials.txt";
    private static final String SAUCELAB_TEST_DATA_PATH = "src/test/resources/testdata/sauceLabCredentials.txt";

    public static String getCuraTestDataPath() {
        return CURA_TEST_DATA_PATH;
    }

    public static String getSaucelabTestDataPath() {
        return SAUCELAB_TEST_DATA_PATH;
    }
}
