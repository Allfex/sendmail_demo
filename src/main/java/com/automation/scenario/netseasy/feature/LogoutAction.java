package com.automation.scenario.netseasy.feature;

import com.automation.scenario.netseasy.page.MailPage;
import com.automation.scenario.netseasy.params.TestParams;
import com.automation.util.ScreenUtils;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LogoutAction {

    public void testLogout(WebDriver driver, TestParams params){
        try {
            MailPage.userInfo(driver).click();
            TimeUnit.SECONDS.sleep(2);
            MailPage.logoutButton(driver).click();
            TimeUnit.SECONDS.sleep(3);
            ScreenUtils.takeScreenshot(params.getImagePath() + "已退出登陆_end", driver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
