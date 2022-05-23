package com.automation.scenario.netseasy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private static WebElement element = null;

    public static WebElement loginButton(WebDriver driver){
        //element = driver.findElement(By.xpath("//*[text()='登录']"));
        element = driver.findElement(By.id("dologin"));
        return element;
    }

    public static WebElement userNameInput(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@name='email']"));
        return element;
    }

    public static WebElement passwordInput(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@name='password']"));
        return element;
    }

    public static WebElement errorMessage(WebDriver driver, String msg){
        element = driver.findElement(By.xpath("//div[contains(text(), '"+msg+"')]"));
        return element;
    }

    public static WebElement errorMsg(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@class='ferrorhead']"));
        return element;
    }




}
