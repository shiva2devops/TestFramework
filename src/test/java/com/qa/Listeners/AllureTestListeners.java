package com.qa.Listeners;

import com.qa.Tests.BaseTest;
import io.qameta.allure.Allure;
import org.testng.ITestListener;
import org.testng.*;
import com.qa.Utility.AllureUtils;

public class AllureTestListeners implements ITestListener {

    ThreadLocal<Allure> test=new ThreadLocal<Allure>();

    @Override
    public void onTestStart(ITestResult result) {
        AllureUtils.attachlog("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        AllureUtils.attachlog("Test PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        AllureUtils.attachlog("Test FAILED: " + result.getName());

        // Get Playwright page from BaseTest
        Object testClass = result.getInstance();
        if (testClass instanceof BaseTest) {
            BaseTest base = (BaseTest) testClass;

            if (base.page != null) {
                // Screenshot
                AllureUtils.takescreenshot(base.page);

                // Page source (optional but very useful)
                String html = base.page.content();
                AllureUtils.attachPageSource(html);
            }
        }

        if (result.getThrowable() != null) {
            AllureUtils.attachlog("Exception: " + result.getThrowable().toString());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        AllureUtils.attachlog("Test SKIPPED: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        AllureUtils.attachlog("Test Suite Started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        AllureUtils.attachlog("Test Suite Finished: " + context.getName());
    }
}
