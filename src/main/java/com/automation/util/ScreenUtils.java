package com.automation.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenUtils {

    public static void takeScreenshot(String screenPath, WebDriver driver) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//OutputType.FILE--截幕保存为图片
            FileUtils.copyFile(scrFile, new File(screenPath));//把图片保存到指定路径
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("截图出现错误");
        }
    }



}
