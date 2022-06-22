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

        // Running the Test in Loop to check Basic Performance
        // Total Testcase = 16+ 24 + 13 = 53 ; Executing 53 * 100 = 5300 tests in 80 secs
        for (int i = 0; i < 100; i++)
        {
            new OidAppTester("true").doTest();
            new OidAppTester("false").doTest();
            new OidAppTester("invalid").doTest();

        }
    }
}
