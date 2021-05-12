package com.stepdefinitions;

import com.testbase.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void startTest() {
        BaseClass.setUp();
    }

    @After
    public void endTest() {
        BaseClass.tearDown();
    }
}
