package com.automation.scenario.netseasy.feature;

import com.automation.scenario.netseasy.page.MailPage;
import com.automation.scenario.netseasy.params.TestParams;
import com.automation.util.ScreenUtils;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SendMailAction {

    public void doSend(WebDriver driver, TestParams params){
            try {
                    ScreenUtils.takeScreenshot(params.getImagePath() + "收件箱1", driver);
                    MailPage.sendMailButton(driver).click();
                    TimeUnit.SECONDS.sleep(2);
                    ScreenUtils.takeScreenshot(params.getImagePath() + "收件箱2", driver);
                    MailPage.mailToInput(driver).sendKeys(params.getMailTo());
                    MailPage.subjectInput(driver).sendKeys(params.getSubject());
                    //切换frame
                    driver.switchTo().frame(MailPage.iframContent(driver));
                    MailPage.contentInput(driver).sendKeys(params.getMailContent());
                    TimeUnit.SECONDS.sleep(2);
                    ScreenUtils.takeScreenshot(params.getImagePath() + "收件箱3", driver);
                    driver.switchTo().defaultContent();
                    MailPage.sendButton(driver).click();
                    TimeUnit.SECONDS.sleep(5);
                    ScreenUtils.takeScreenshot(params.getImagePath() + "收件箱4", driver);
            } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    throw new RuntimeException(e);
            }
    }
}
