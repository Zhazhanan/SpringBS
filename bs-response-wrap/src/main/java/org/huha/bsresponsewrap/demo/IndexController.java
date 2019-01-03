package org.huha.bsresponsewrap.demo;

import org.huha.bsresponsewrap.demo.user.LoginQO;
import org.huha.bsresponsewrap.demo.user.LoginToken;
import org.huha.bsresponsewrap.demo.user.login.LoginService;
import org.huha.bsresponsewrap.module.annotations.LoginAuth;
import org.huha.bsresponsewrap.module.annotations.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangKun
 * @create 2018-12-21
 * @desc
 **/
@RestController
@ResponseResult
public class IndexController {

    @Autowired
    LoginService loginService;

    @GetMapping("/index")
    public String index() {
        return "index hello";
    }

    @PostMapping("/login")
    public LoginToken login(@RequestBody LoginQO loginQO) {
        LoginToken login = loginService.login(loginQO);
        return login;
    }

    @LoginAuth
    @GetMapping("/home")
    public String home() throws Exception {
        return "index hello";
    }
}
