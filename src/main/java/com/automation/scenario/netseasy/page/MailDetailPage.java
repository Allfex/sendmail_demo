package com.automation.scenario.netseasy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailDetailPage {
    private static WebElement element = null;

    public static WebElement deleteMailBtn(WebDriver driver){
        //element = driver.findElement(By.xpath("//div/span[contains(text(), '删 除')]"));
       element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[5]/header/div/div[3]/div[1]"));
       // element = driver.findElement(By.xpath("//div[@class='js-component-button nui-btn'][1]"));
        return element;
    }

    public static WebElement mailSubject(WebDriver driver){
        element = driver.findElement(By.xpath("//h1[@class='nui-fIBlock py0']"));
        return element;
    }

}
