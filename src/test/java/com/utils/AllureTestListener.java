package com.utils;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class AllureTestListener extends BaseClass implements ITestListener  {
    @Override
    public void onTestStart(ITestResult result) {
        // You can add test data here
        String testData = "Test Data: " + result.getMethod().getDescription();
        attachTestData(testData);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        // Optionally handle success cases
    }
    @Override
    public void onTestFailure(ITestResult result) {
        // Attach screenshot on failure
        captureScreenshot(result);
    }
    private void attachTestData(String testData) {
        Allure.addAttachment("Test Data", "text/plain", testData, "txt");
    }
    private void captureScreenshot(ITestResult result) {
        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            File destFile = new File("Results/Screenshot" + result.getName() + ".png");
            FileUtils.copyFile(srcFile, destFile);
            Allure.addAttachment("Screenshot", "image/png", new FileInputStream(destFile), ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}