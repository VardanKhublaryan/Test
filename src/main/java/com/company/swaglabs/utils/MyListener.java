package com.company.swaglabs.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.company.swaglabs.utils.CustomWebDriver.getDriver;
import static com.company.swaglabs.utils.MyLog4j.*;


public class MyListener implements ITestListener {
    private int fileNum = 1;


    @Override
    public void onTestStart(ITestResult result) {
        info("Start: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        info("Success of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        error("Failure of test cases and its details are : " + result.getName());

        Screenshot screenshot1 = new AShot().coordsProvider(new WebDriverCoordsProvider()).
                takeScreenshot(getDriver());
        BufferedImage randomImageItem1 = screenshot1.getImage();
        File file = new File("C:\\Users\\user\\bugsScreenshot\\" + "bug" + fileNum + ".png");
        try {
            ImageIO.write(randomImageItem1, "png", file);
            if (file.exists()) {
                fileNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        info("Skip of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        info("Failure of test cases and its details are : " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}

