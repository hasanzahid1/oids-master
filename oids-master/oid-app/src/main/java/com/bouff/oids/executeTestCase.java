package com.bouff.oids;

public class executeTestCase {

    public static void main(String [] args)
    {
        // Running Test Cases with True OIDs Match
        OidAppTester appTesterTrue = new OidAppTester("true");
        appTesterTrue.doTest();

        // Running Test Cases with False OIDs Match
        OidAppTester appTesterFalse = new OidAppTester("false");
        appTesterFalse.doTest();

        // Running Test Cases with Invalid OIDs
        OidAppTester appTesterInvalid = new OidAppTester("invalid");
        appTesterInvalid.doTest();
    }
}
