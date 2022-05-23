package com.automation.scenario.netseasy.feature;

import com.automation.scenario.netseasy.page.InboxPage;
import com.automation.scenario.netseasy.page.MailDetailPage;
import com.automation.scenario.netseasy.page.MailPage;
import com.automation.scenario.netseasy.params.TestParams;
import com.automation.util.ScreenUtils;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CheckMailAction {

    public void doCheck(WebDriver driver, TestParams params){
        try {
            //返回收件箱
            MailPage.returnMailBoxBtn(driver).click();
            TimeUnit.SECONDS.sleep(3);
            InboxPage.subjectContent(driver, params.getSubject()).click();
            TimeUnit.SECONDS.sleep(2);
            System.out.println(MailDetailPage.mailSubject(driver).getText());
            ScreenUtils.takeScreenshot(params.getImagePath() + "查看邮件1", driver);
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
