package com.whcd.lotteryappui.testcase.login;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.whcd.lotteryappui.action.LoginAction;
import com.whcd.lotteryappui.pageObject.LoginPage;
import com.whcd.lotteryappui.pageObject.StartPage;
import com.whcd.lotteryappui.utils.*;

import java.io.IOException;

/**
 * Created by Lance on 2016/9/2 0002.
 */
public class LoginPage_002_Login_Success_Test extends TestBaseCase {
    ElementAction action=new ElementAction();
    @BeforeClass
    public  void  beforeclass() throws IOException {
    	/**
    	 * 99彩票APP没有启动首页，而是直接进入登录页面
    	 */
//        StartPage startPage=new StartPage();
//        action.click(startPage.登录());

//    	99彩票APP登录页面不需要选择其他登录方式，直接输入账号密码登录
//        LoginPage loginPage=new LoginPage();
//        action.sleep(2);
        /*
        action.click(loginPage.使用其他方式登录());
        action.sleep(2);
        */
    }
    @Test(description = "登录测试")
    public  void login() throws IOException {
        //调用登录方法(需填写正确的用户名和密码)
    	
        new LoginAction("13100008888", "123456");
        action.sleep(5);
        //设置检查点
        Assertion.VerityTextPresent("开奖","验证是否登录成功！");
        //设置断言 。判断用例是否失败
        Assertion.VerityError();
    }
    //数据驱动案例--start
    @DataProvider(name="longinData")
    public Object[][] loginData()
    {
        //读取登录用例测试数据
        String filePath="src/main/resources/data/loginData.xls";
        //读取第一个sheet，第2行到第5行-第2到第4列之间的数据
        return ExcelReadUtil.case_data_excel(0, 1, 2, 1, 3,filePath);
    }
    @Test(description="登录失败用例:数据驱动例子",dataProvider = "longinData")
    public void loginFail (String userName,String password,String message) throws IOException, DocumentException {
        //调用登录方法
        new  LoginAction(userName,password);
        LoginPage loginPage=new LoginPage();
        action.sleep(4);
        log.info("登录失败信息："+action.getText(loginPage.失败toast提示信息()));
        Assertion.VerityCationString(action.getText(loginPage.失败toast提示信息()),message,"验证是否出现预期的错误提示信息:"+message);
//        action.click(loginPage.失败toast提示信息());//toast提示信息不需要点击
        //设置断言
        Assertion.VerityError();
    }
    //数据驱动案例--end
    @AfterSuite
    public  void openResult()
    {
        WebDriver driver =new FirefoxDriver();
        driver.get("http://127.0.0.1");
    }
}
