package com.bouff.oids;

public class executePerformanceTest {

    public static void main(String [] args)
    {

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


