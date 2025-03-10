package Listeners;

import io.qameta.allure.Allure;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import utilities.LogsUtils;
import utilities.classesUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static Factory.DriverFactory.getDriver;
import static Factory.DriverFactory.setUpDriver;

public class IInvokedListeners implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

        if (testResult.getStatus() == ITestResult.FAILURE)
        {
            try {
                classesUtils.takeScreenShot(testResult.getName(),getDriver());
                LogsUtils.error(testResult.getTestName() + "failing TC....");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        try {
            File fileLog = classesUtils.getLastFile(LogsUtils.fileLogsPath);
            Allure.addAttachment("Logs", Files.readString(fileLog.toPath()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
