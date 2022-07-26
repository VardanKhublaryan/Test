package com.company.swaglabs.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import com.company.swaglabs.utils.CustomWebDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.company.swaglabs.utils.CustomWebDriver.*;


public class MyListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Start: " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Success of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Failure of test cases and its details are : " + result.getName());
        Screenshot screenshot1 = new AShot().coordsProvider(new WebDriverCoordsProvider()).
                takeScreenshot(getDriver());

        BufferedImage randomImageItem1 = screenshot1.getImage();
        try {
            ImageIO.write(randomImageItem1, "png",
                    new File("C:\\Users\\NR-Gaming-Front\\Pictures\\Screenshots"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Skip of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Failure of test cases and its details are : " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

}

