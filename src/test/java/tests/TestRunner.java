package tests;

import listeners.TestListener;
import org.testng.TestNG;
import tests.a_sauceLabApk.DropdownMenuTests;

public class TestRunner {

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{DropdownMenuTests.class});
        testng.addListener(new TestListener());
        testng.run();
    }
}