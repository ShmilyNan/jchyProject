package com.whcd.lotteryappui.action;

import com.whcd.lotteryappui.pageObject.LoginPage;
import com.whcd.lotteryappui.utils.ElementAction;
import com.whcd.lotteryappui.utils.TestBaseCase;

import java.io.IOException;

/**
 * Created by Lance on 2016/9/2 0002.
 */
public class LoginAction extends TestBaseCase {
    public LoginAction(String username,String password) throws IOException {
        ElementAction action=new ElementAction();
        LoginPage loginPage=new LoginPage();
        action.isTextCorrect(action.findElement(loginPage.账号输入框()).getAttribute("placeholder"), "登录账号");
        action.isTextCorrect(action.findElement(loginPage.密码输入框()).getAttribute("placeholder"), "登录账号");
        action.click(loginPage.账号输入框());
        action.clear(loginPage.账号输入框());
        action.type(loginPage.账号输入框(),username);
        action.click(loginPage.密码输入框());
        action.clear(loginPage.密码输入框());
        action.type(loginPage.密码输入框(),password);
        action.sleep(1);
        action.click(loginPage.登录按钮());
    }
}
