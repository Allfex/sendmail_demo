package com.automation.scenario.netseasy.feature;

import com.automation.scenario.netseasy.page.HomePage;
import com.automation.scenario.netseasy.params.TestParams;
import com.automation.util.ScreenUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginAction {

    private String url = "https://mail.163.com";

    public void testLogin(WebDriver driver, TestParams params){

        try {
            //打开网站
            driver.get(params.getUrl());
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //首页截图
            ScreenUtils.takeScreenshot(params.getImagePath() + "首页_登陆窗口", driver);
            //切换frame
            driver.switchTo().frame(0);

            HomePage.userNameInput(driver).clear();
            HomePage.loginButton(driver).click();
            TimeUnit.SECONDS.sleep(1);
            //此处验证不通过，因为预期结果不正确
            // Assert.assertEquals(HomePage.errorMsg(driver).getText(),"这个预期结果不正确");
            Assert.assertEquals("请输入帐号", HomePage.errorMsg(driver).getText());
            TimeUnit.SECONDS.sleep(1);
            ScreenUtils.takeScreenshot(params.getImagePath() + "首页_未输入用户错误", driver);

            HomePage.userNameInput(driver).sendKeys("automatic_test2021");
            HomePage.loginButton(driver).click();
            TimeUnit.SECONDS.sleep(2);
            Assert.assertEquals(HomePage.errorMsg(driver).getText(), "请输入密码");
            ScreenUtils.takeScreenshot(params.getImagePath() + "首页_未输入密码错误", driver);
            TimeUnit.SECONDS.sleep(2);

            HomePage.passwordInput(driver).sendKeys("I_love_fidelity");
            HomePage.loginButton(driver).click();
            TimeUnit.SECONDS.sleep(2);
            //Assert.assertEquals(HomePage.errorMsg(driver).getText(), "帐号或密码错误");
            ScreenUtils.takeScreenshot(params.getImagePath() + "首页_账号密码错误", driver);
            TimeUnit.SECONDS.sleep(2);

            driver.navigate().refresh();
            driver.switchTo().frame(0);
            HomePage.userNameInput(driver).clear();
            HomePage.userNameInput(driver).sendKeys(params.getUsername());
            HomePage.passwordInput(driver).clear();
            HomePage.passwordInput(driver).sendKeys(params.getPassword());
            HomePage.loginButton(driver).click();
            TimeUnit.SECONDS.sleep(3);

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
