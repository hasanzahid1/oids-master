package com.bouff.oids;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class OidAppTester {
    private Map<String, String> expectedOutput = new HashMap();
    public static String testType;

    public OidAppTester(String testCase)
    {
        testType= testCase;
        if (testCase == "true")
        {
            System.out.println("\nPositive Test Scenarios");
            System.out.println("========================================");

            // Tests FOR VALID OIDS : OID is EXACT MATCH WITH PREFIX
            expectedOutput.put(".1.3.6.1.6.3.1.1.5", "true");
            expectedOutput.put(".1.3.6.1.2.1.10.166.3", "true");
            expectedOutput.put(".1.3.6.1.4.1.9.9.117.2", "true");
            expectedOutput.put(".1.3.6.1.2.1.10.32.0.1", "true");
            expectedOutput.put(".1.3.6.1.2.1.14.16.2.2", "true");
            expectedOutput.put(".1.3.6.1.4.1.9.10.137.0.1", "true");


            // Tests FOR VALID OIDS : OID is PREFIX + VALID INPUT
            expectedOutput.put(".1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1", "true");
            expectedOutput.put(".1.3.6.1.2.1.10.166.3.2.3.4.5.6.7", "true");
            expectedOutput.put(".1.3.6.1.4.1.9.9.117.2.5.6.7.8.1.2", "true");
            expectedOutput.put(".1.3.6.1.2.1.10.32.0.1.0.0.0.0.0", "true");
            expectedOutput.put(".1.3.6.1.2.1.14.16.2.2.2.1.3.4.5.6.7.8", "true");
            expectedOutput.put(".1.3.6.1.4.1.9.10.137.0.1.114748360.1121474836", "true");

            // Tests FOR VALID OIDS : OID is PREFIX + MAX INT VALUE 32BIT
            expectedOutput.put(".1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.2147483647", "true");

            // Test Fail: if value grater than MaxIntergerValue (=2147483647) is added soon after exact prefix.
            //expectedOutput.put(".1.3.6.1.2.1.10.166.3.1.121471483647.33333.323.4.214748364752545525134124", "true");

            // Tests FOR VALID OIDS : OID is PREFIX  + NEXT LINE
            expectedOutput.put(".1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1.10.166.3.2." +
                            "3.4.5.6.7.3.33333.323.4.21.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4" +
                    ".1.2.1.1.3334.2.3.4.21.474.21.4748.36.47.1.5.45.345.345.345.21312.8765.3", "true");

            // Tests FOR VALID OIDS : Performance Check
            expectedOutput.put(".1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1.10.166.3.2." +
                    "3.4.5.6.7.3.33333.323.4.21.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1." +
                    "5.45.345.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1.10.166.3.10.166.3." +
                    "3.4.5.6.7.3.33333.323.4.21.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1." +
                    "5.45.345.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1.10.166.3.10.166.3." +
                    "3.4.5.6.7.3.33333.323.4.21.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1." +
                    "5.45.345.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1.10.166.3.10.166.3." +
                    "3.4.5.6.7.3.33333.323.4.21.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1." +
                    "5.45.345.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1.10.166.3.10.166.3.8" +
                    "3.4.5.6.7.3.33333.323.4.21.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1." +
                    "5.45.345.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1.10.166.3.10.166.3." +
                    "3.4.5.6.7.3.33333.323.4.21.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1." +
                    "5.45.345.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1.10.166.3.10.166.3." +
                    "3.4.5.6.7.3.33333.323.4.21.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1." +
                    "5.45.345.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1.10.166.3.10.166.3." +
                    "3.4.5.6.7.3.33333.323.4.21.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1." +
                    "5.45.345.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1.10.166.3.10.166.3.8" +
                    "4748.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1.10.166.3.3.87687687." +
                    "4748.1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6.1.2.1.10.166.3.33", "true");

            // Tests FOR VALID OIDS :+ Escape Sequence CHARS IN JAVA "\N" ( Test Fails)
            expectedOutput.put(".1.3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3334.2.3.4.2147483647.1.3.6" +
                    ".1.2.1.10.166.3.2.3.4.5.6.7.3.3333333.33333.323.323.4.254.61" +
                    ".3.6.1.6.3.1.1.5.1.9.8.1.2.1.1.3333.33333.323.323.4.21", "true");

        } 
        else if (testCase == "false")
        {
            System.out.println("\nNegative Test Scenarios");
            System.out.println("========================================");

            // Tests FOR False OIDS : OID is Partial MATCH
            expectedOutput.put(".1.3.6.1.6.3", "false");
            expectedOutput.put(".1.3.6.1.2.1.10", "false");
            expectedOutput.put(".1.3.6.1.4.1.9.9.117", "false");
            expectedOutput.put(".1.3.6.1.4.1", "false");
            expectedOutput.put(".1.3.6.1.2.1.10.32.0", "false");
            expectedOutput.put(".1.3.6.1.2.1.14.16.2", "false");
            expectedOutput.put(".1.3.6.1.4.1.9.10.137.01", "false");
            expectedOutput.put(".1.3.6.1.4", "false");


            // Tests FOR False OIDS : EXACT MATCH but with 1 change (.1.3.6.1.6.3.1.1.5 --> .1.3.6.1.6.3.1.1.4)
            expectedOutput.put(".1.3.6.1.6.3.1.1.4", "false");
            expectedOutput.put(".1.3.6.1.2.1.11.166.3", "false");
            expectedOutput.put(".1.3.6.1.4.1.9.9.17.2", "false");
            expectedOutput.put(".1.3.6.1.2.1.10.32.0.2", "false");
            expectedOutput.put(".1.3.6.1.2.1.14.16.2.1", "false");
            expectedOutput.put(".1.3.6.1.4.1.9.10.127.0.1", "false");

            // Tests FOR False OIDS : OID is No MATCH
            expectedOutput.put(".1.1.3.6.1.6.3.1.1.5", "false");
            expectedOutput.put(".0.1.3.6.1.2.1.10.166.3", "false");
            expectedOutput.put(".2.1.3.6.1.4.1.9.9.117.26.32.", "false");
            expectedOutput.put(".4.1.3.6.18.3.2.32.33.2.1.10.32.0.1", "false");
            expectedOutput.put(".5.1.3.6.1.2.1.14.16.2.2", "false");
            expectedOutput.put(".1.1.3.6.1.4.1.9.10.137.0.1", "false");

            // Tests FOR False OIDS : Edge Scenariosw
            expectedOutput.put(".1.1.3.6.1.6.3.1.1.5.35.453.345.45.435.345.345.345.435.543.45.3.4", "false");
            expectedOutput.put(".1.3.6.1.2.1.10.166.2.3.4.3534432.445436", "false");
            expectedOutput.put(".4.3534432445436.1.3.6.1.2.1.10.166.3", "false");

            // Tests FOR False OIDS : Long Format OID using Next Line
            expectedOutput.put(".1.3.6.1.6.1.1.5.1.9.8.1.2.1.1.1.1.1.1.1.1.1.2.3.3.4.5.6.7.8.1.2.3.4.9.2.2.3.5.6.7.8.1.2.3.4"+
                    ".1.6.1.6.3.1.1.5.1.9.8.1.2.1.1.1.1.1.1.1.1.1.2.3.1.1.1.2.3.3.4.5.6.7.8.1.2.3.4.9.2.2.3.5.6.7.8.1.2.3.4" +
                    ".1.6.1.6.3.1.1.5.1.9.8.1.2.1.1.1.1.1.1.1.1.1.2.3.3.4.5.63.4.5.6.7.8.1.2.3.4.9.2.2.3.5.6.7.8.1.2.3", "false");

        }
        else if ((testCase == "invalid")) {
            
            System.out.println("\n Invalid Test Scenarios");
            System.out.println("========================================");
            
            // Invalid TestCase : dot at end.
            expectedOutput.put(".1.3.6.1.6.3.1.1.5.", "invalid");

            // Invalid TestCase : No dot at Start.
            expectedOutput.put("1.3.6.1.2.1.10.166.3", "invalid");

            // Invalid TestCase : EXTRA dot at MIDDLE.
            expectedOutput.put("1.3.6.1.2..1.10.166.3", "invalid");


            // Invalid Input : Special Char and Alpha
            expectedOutput.put(".1.3.6.1.4.1.9.9.117.2.!", "invalid");
            expectedOutput.put(".1.3.6.1.2.1.10.32.0.1v", "invalid");
            expectedOutput.put(".1.3.6.1.2.1.14.16.2.2m.#", "invalid");
            expectedOutput.put("1.3.6.1.2.1.10.166.3,5", "invalid");


            // Invalid Input : Space at Start, Middle and End
            expectedOutput.put(" 0.1.3.6.1.4.1.9.10.137.0.1", "invalid");
            expectedOutput.put(".1.3.6.1.2.1.10. 32.0.41", "invalid");
            expectedOutput.put("1.3.6.1.2.1.14.1.6.2.42 ", "invalid");

            // Invalid Input : Alpha used for OIDs
            expectedOutput.put(".M.0.1.3.6.1.4.1.9.10.137.0.1", "invalid");
            expectedOutput.put(".1.3.6.1.2.1.10.32.0.41.&", "invalid");
            expectedOutput.put(".1.3.6.1MFM.2.1.14.1.6.2.42", "invalid");
            
        }
        else
        {
            System.out.println("\n Test Scenarios Does not Exist");
            System.out.println("========================================");
        }
    }

    public static int testCaseTotal= 0,testCasePass=0,testCaseFail=0,testCaseNumber=1;

    public void doTest()
    {
        ProcessBuilder pb = new ProcessBuilder("/Users/hzahid/Documents/OpenNMS/oids-master/bin/oid.sh");
        pb.redirectErrorStream(true);
        PrintWriter writer = null;
        Scanner scanner = null;
        String currentEntry = "";
        testCaseNumber=1;testCaseFail=0;testCasePass=0;testCaseTotal=0;
        try
        {
            Process p = pb.start();
            writer = new PrintWriter(p.getOutputStream(), true);
            scanner = new Scanner(p.getInputStream());
            String line = "";
            //Skipping 4 Lines to read response from OIDAppLauncher
            scanner.nextLine();scanner.nextLine();scanner.nextLine();scanner.nextLine();

            for(Map.Entry<String, String> entry : expectedOutput.entrySet())
            {
                System.out.println();
                currentEntry = entry.getKey();
                System.out.println("Test Case:" + testCaseNumber++ +"\nTesting value: \"" + currentEntry + "\"");
                writer.println(entry.getKey());
                line = scanner.nextLine();
                System.out.println("Recieved from application: \"" + line + "\"");

                if(line.contains(entry.getValue()))
                {
                    System.out.println("Test passed for: " + entry.getKey());
                    testCasePass++;


                }
                else
                {
                    System.out.println("Test failed for: " + entry.getKey());
                    testCaseFail++;
                }
                testCaseTotal++;
                scanner.nextLine();
            }

        }
        catch(IOException ex)
        {
            System.out.println("Could not start process");
            ex.printStackTrace();
        }
        catch(Exception ex)
        {
            System.out.println("Exception thrown. currectEntry: \"" + currentEntry + "\"");
            System.out.println("Cannot continue test");
        }
        finally
        {
            if(scanner != null)
                scanner.close();
            if(writer != null)
                writer.close();
        }
        System.out.println("\nTest Scenarios for : \"" + testType + "\"");
        System.out.println("Total Test Cases Ran: \"" + testCaseTotal + "\"");
        System.out.println("Total Test Cases Pass: \"" + testCasePass + "\"");
        System.out.println("Total Test Cases Fail: \"" + testCaseFail + "\"");
    }

}
