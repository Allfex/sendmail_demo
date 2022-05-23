package com.automation.scenario.netseasy.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailPage {
    private static WebElement element;
    //【写信】按钮
    public static WebElement sendMailButton(WebDriver driver){
        element = driver.findElement(By.xpath("//span[contains(text(), '写 信')]"));
        return element;
    }

    //收件人地址，input控件
    public static WebElement mailToInput(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@class='nui-editableAddr-ipt']"));
        return element;
    }

    //主题， input控件
    public static WebElement subjectInput(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@aria-label='邮件主题输入框，请输入邮件主题']/input"));
        return element;
    }

    //内容, input控件
    public static WebElement contentInput(WebDriver driver){
        //element = driver.findElement(By.xpath("//body[@class='nui-scroll']"));
        element = driver.findElement(By.tagName("body"));
        return element;
    }

    //发送按钮
    public static WebElement sendButton(WebDriver driver){
        //element = driver.findElement(By.xpath("//span[contains(text(),'发送')]/span[2]"));
        element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/section/footer/div[1]/span[2]"));
        return element;
    }

    //返回收件箱
    public static WebElement returnMailBoxBtn(WebDriver driver){
        element = driver.findElement(By.xpath("//a[contains(text(), '返回收件箱')]"));
        return element;
    }

    //用户信息
    public static WebElement userInfo(WebDriver driver){
        element = driver.findElement(By.xpath("//span[@id='spnUid']"));
        return element;
    }

    public static WebElement logoutButton(WebDriver driver){
        element = driver.findElement(By.xpath("//div[@class='js-component-component kt1']"));
        return element;
    }

    public static WebElement sendResultMsg(WebDriver driver){
        element = driver.findElement(By.xpath("//h1[@class='tk1']"));
        return element;
    }

    public static WebElement logoutMsg(WebDriver driver){
        element = driver.findElement(By.xpath("//span[@class='icon-exit']"));
        return element;
    }









    public static WebElement iframContent(WebDriver driver){
        element = driver.findElement(By.xpath("//iframe[@class='APP-editor-iframe']"));
        return element;
    }



}
