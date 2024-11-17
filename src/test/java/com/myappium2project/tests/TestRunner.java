package com.myappium2project.tests;

import com.myappium2project.listeners.TestListener;
import org.testng.TestNG;
import com.myappium2project.tests.saucelab.DropdownMenuTests;

public class TestRunner {

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[]{DropdownMenuTests.class});
        testng.addListener(new TestListener());
        testng.run();
    }
}