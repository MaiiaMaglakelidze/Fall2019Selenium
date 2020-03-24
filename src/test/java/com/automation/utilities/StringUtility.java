package com.automation.utilities;

public class StringUtility {
    public static String verifyEquals(String expected, String actual){
        if(expected.equals(actual)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        return expected;
    }
}
