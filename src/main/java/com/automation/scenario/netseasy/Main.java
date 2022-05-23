package com.automation.scenario.netseasy;

import com.automation.scenario.netseasy.feature.CheckMailAction;
import com.automation.scenario.netseasy.feature.LoginAction;
import com.automation.scenario.netseasy.feature.LogoutAction;
import com.automation.scenario.netseasy.feature.SendMailAction;
import com.automation.scenario.netseasy.params.TestParams;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;


public class Main{

    private static WebDriver driver;
    TestParams params = new TestParams();

    @BeforeClass
    public void preparation(){

        System.setProperty("webdriver.chrome.driver", "/Users/lifeng/Downloads/chromedriver");

        //工作中我感到最有成就的事
        String content = "I have self-developed web-based automated test platform through constant" +
                " hardworking and technology research, and solved the problems that resulted in " +
                "testing bottlenecks and insufficient manpower due to corporate business expansion," +
                " which significantly improved testing efficiency and secured the smooth running of " +
                "the software.";

        //设置图片存储路径，发送测试报告
        String imagePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        File file = new File(imagePath+".."+File.separator+"images");
        file.mkdirs();
        imagePath = file.getPath()+File.separator;
        //组织测试参数
        params.setImagePath(imagePath);
        params.setMailContent(content);
        params.setUrl("https://mail.163.com");
        params.setUsername("automatic_test2022");
        params.setPassword("I_love_fidelity");
        params.setMailTo("automatic_test2022@163.com");
        params.setSubject("自动化测试邮件serial="+ System.currentTimeMillis());
        //设置chrome浏览器
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * 登陆
     */
    @Test(priority = 1)
    public void login(){
        LoginAction loginAction = new LoginAction();
        loginAction.testLogin(driver, params);
    }

    /**
     * 发送邮件
     */
    @Test(priority = 2)
    public void sendMail(){
        SendMailAction sendMailAction = new SendMailAction();
        sendMailAction.doSend(driver, params);
    }

    /**
     * 查看邮件
     */
    @Test(priority = 3)
    public void checkMail(){
        CheckMailAction checkMailAction = new CheckMailAction();
        checkMailAction.doCheck(driver, params);
    }

    /**
     * 登出
     */
    @Test(priority = 4)
    public void logout(){
        LogoutAction logoutAction = new LogoutAction();
        logoutAction.testLogout(driver, params);
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }

}