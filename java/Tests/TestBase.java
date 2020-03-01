package  Tests;
import ExtentReports.ExtentTestManager;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import utils.GetScreenShot;
import org.testng.ITestResult;

import org.testng.annotations.*;
import java.io.IOException;


public class TestBase {

    @BeforeClass
    public void setUp(){
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            ExtentTestManager.getTest().fail(result.getThrowable());
            String screenPath="C:\\Users\\reyna\\IdeaProjects\\CursoAutomation\\web.png";
           // String screenPath= GetScreenShot.capture(this.driver,"fail_step")
            ExtentTestManager.getTest().log(Status.FAIL, "Snapshot below: " + ExtentTestManager.getTest().addScreenCaptureFromPath(screenPath));
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            ExtentTestManager.getTest().log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            ExtentTestManager.getTest().log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            ExtentTestManager.getTest().skip(result.getThrowable());
        }

    }
    @AfterTest
    public void tearDown() {

        ExtentReports.ExtentManager.getReporter().flush();
    }
    @AfterClass
    public void close(){
        // this.driver.close();
    }
}
