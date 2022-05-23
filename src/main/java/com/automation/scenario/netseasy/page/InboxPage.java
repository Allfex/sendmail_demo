package com.automation.scenario.netseasy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InboxPage {

    private static WebElement element = null;
    public static WebElement subjectContent(WebDriver driver, String content){
        element = driver.findElement(By.xpath("//*[contains(text(), '"+content+"')]"));
        return element;
    }
}
