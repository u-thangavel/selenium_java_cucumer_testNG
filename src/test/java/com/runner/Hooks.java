package com.runner;

import com.utils.BaseClass;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
      BaseClass.launch();
    }

    @After
    public void tearDown() {
        BaseClass.tearDown();
    }
}

