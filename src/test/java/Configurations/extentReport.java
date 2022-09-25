package Configurations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class extentReport {

    //Call this Test in the test class, latest version 5.0.9 calls as ExtentReporter
    private ExtentHtmlReporter myhtmlReporter;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void reportSetup() {

        myhtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/AutomationReport.html");
        myhtmlReporter.config().setDocumentTitle("SauceDemo Automation Report");
        myhtmlReporter.config().setReportName("Automation Report");
        myhtmlReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(myhtmlReporter);
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("Tester", "Lungi");

    }

    public void tearDown(ITestResult myresult) {

        if (myresult.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed is: " + myresult.getName());
            test.log(Status.FAIL, "Test case failed is: " + myresult.getThrowable());

        } else if
        (myresult.getStatus() == ITestResult.SKIP) {
            test.log(Status.FAIL, "Test case skipped is: " + myresult.getName());

        } else if (myresult.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed is: " + myresult.getName());
        }
    }

    @AfterSuite
    public void reportTearDown() {
        extent.flush();
    }



}
