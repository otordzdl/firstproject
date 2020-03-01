import ExtentReports.ExtentTestManager;
import ExtentReports.ExtentManager;

import Tests.TestBase;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.io.IOException;


public class TestDriver extends TestBase {

    @Test
    public void Test1() throws IOException {
        ExtentTestManager.startTest("Test Case 0", "Failed test case");

        Assert.assertTrue(false);

    }
    @Test
    public void testCase1() {

        ExtentTestManager.startTest("Test Case 1", "PASSED test case");
        Assert.assertTrue(true);
    }

    @Test
    public void testCase2() {
        ExtentTestManager.startTest("Test Case 2", "PASSED test case");
        Assert.assertTrue(true);
    }

    @Test
    public void testCase3() {
        ExtentTestManager.startTest("Test Case 3", "PASSED test case");
        Assert.assertTrue(true);
    }

    @Test
    public void testCase4() {
        ExtentTestManager.startTest("Test Case 4", "PASSED test case");
        Assert.assertTrue(false,"Prueba");
        Assert.assertTrue(true,"Prueba");
    }

    @Test
    public void testCase5() {
        ExtentTestManager.startTest("Test Case 5", "SKIPPED test case");
        throw new SkipException("Skipping this test with exception");
    }

    @Test(enabled=false)
    public void testCase6(){
        ExtentTestManager.startTest("Test Case 6", "I'm Not Ready, please don't execute me");

    }

}
