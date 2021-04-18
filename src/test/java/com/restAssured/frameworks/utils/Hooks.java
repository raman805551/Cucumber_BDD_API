package com.restAssured.frameworks.utils;

import io.cucumber.java.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Hooks {

    @Before
    public void setUpDriver() {
        Properties prop = null;
        try {
            InputStream input = new FileInputStream("./src/test/resources/Endpoints.properties");
            prop = new Properties();
            prop.load(input);
        } catch (IOException io) {
            io.printStackTrace();
        }
        RestOperations.setProp(prop);
    }
}
