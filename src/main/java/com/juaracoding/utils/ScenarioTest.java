package com.juaracoding.utils;

public enum ScenarioTest {

    T1("Successful login with valid credentials"),
    T2("Unsuccessful login with wrong username or password"),
    T3("Unsuccessful login without password"),
    T4("Unsuccessful login without username"),
    T5("Successfully added 2 products and checkout"),
    T6("After added products and emptying the postal code"),
    T7("After added products and emptying the last name");

    // T1000

    private String scenarioTestName;

    ScenarioTest(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName() {
        return scenarioTestName;
    }
}