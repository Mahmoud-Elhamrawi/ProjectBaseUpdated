package Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.LogsUtils;

public class ITestListeners implements ITestListener {

    public void onTestStart(ITestResult result) {
        LogsUtils.info("TC start" + result.getTestName());
    }

    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("TC Success" + result.getTestName());
    }

    public void onTestFailure(ITestResult result) {
        LogsUtils.info("TC Failure" + result.getTestName());

    }

    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("TC Skipped" + result.getTestName());

    }


    public void onStart(ITestContext context) {
        LogsUtils.info("Test Start..." + context.getName());

    }

    public void onFinish(ITestContext context) {
        LogsUtils.info("Test Finish..." + context.getName());

    }
}
