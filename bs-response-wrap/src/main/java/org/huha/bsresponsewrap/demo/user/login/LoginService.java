package org.huha.bsresponsewrap.demo.user.login;


import org.huha.bsresponsewrap.demo.user.LoginQO;
import org.huha.bsresponsewrap.demo.user.LoginToken;

/**
 * @author zhumaer
 * @desc 登录服务
 * @since 3/3/2018 22:39 PM
 */
public interface LoginService {

    LoginToken login(LoginQO loginQO);

    LoginToken getLoginToken();

    void logout();
}
