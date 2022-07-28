package com.company.swaglabs.utils;

import org.apache.log4j.PropertyConfigurator;
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

import org.apache.log4j.Logger;


public class MyListener implements ITestListener {
    private int fileNum = 1;
    static Logger logger = Logger.getLogger(MyListener.class);
    String log4jConfigFile = System.getProperty("user.dir")
            + File.separator + "src/main/resources/log4j.properties";


    @Override
    public void onTestStart(ITestResult result) {
        PropertyConfigurator.configure(log4jConfigFile);
        logger.info("Start: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        PropertyConfigurator.configure(log4jConfigFile);
        logger.info("Success of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Failure of test cases and its details are : " + result.getName());
        Screenshot screenshot1 = new AShot().coordsProvider(new WebDriverCoordsProvider()).
                takeScreenshot(getDriver());

        BufferedImage randomImageItem1 = screenshot1.getImage();
        File file = new File("C:\\Users\\NR-Gaming-Front\\Pictures\\Screenshots\\" + "bug" + fileNum + ".png");
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
        PropertyConfigurator.configure(log4jConfigFile);
        logger.info("Skip of test cases and its details are : " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        PropertyConfigurator.configure(log4jConfigFile);
        logger.info("Failure of test cases and its details are : " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }
}

