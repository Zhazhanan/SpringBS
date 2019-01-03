package org.huha.bsresponsewrap.demo.user.login.impl;

import lombok.extern.slf4j.Slf4j;
import org.huha.bsresponsewrap.demo.user.*;
import org.huha.bsresponsewrap.demo.user.login.LoginService;
import org.huha.bsresponsewrap.demo.user.token.helper.LoginTokenHelper;
import org.huha.bsresponsewrap.module.constants.HeaderConstants;
import org.huha.bsresponsewrap.module.enums.CacheKeyEnum;
import org.huha.bsresponsewrap.module.enums.ResultCode;
import org.huha.bsresponsewrap.module.exception.BusinessException;
import org.huha.bsresponsewrap.module.utils.IpUtil;
import org.huha.bsresponsewrap.module.utils.RequestContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author zhumaer
 * @desc 登录服务实现
 * @since 3/3/2018 22:39 PM
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    @Qualifier("loginTokenTemplate")
    RedisTemplate<String, LoginToken> loginTokenTemplate;

    @Override
    public LoginToken login(LoginQO loginQO) {
        // TODO: 2019-01-03 11:20 验证密码是否正确
        LoginToken loginToken = this.saveLoginToken(loginQO);
        loginTokenTemplate.opsForValue().set("token",loginToken);
        return loginToken;
    }

    @Override
    public LoginToken getLoginToken() {
        return null;
    }

    private LoginToken saveLoginToken(LoginQO loginQO) {
        Date currentDate = new Date();
        LoginUser loginUser = new LoginUser();
        loginUser.setId("1");
        loginUser.setNickname(loginQO.getAccount());

        HttpServletRequest request = RequestContextUtil.getRequest();

        LoginToken loginToken = LoginToken.builder()
                .createTime(currentDate)
                .ip(IpUtil.getRealIp(request))
                .platform(request.getHeader(HeaderConstants.CALL_SOURCE))
                .ttl(CacheKeyEnum.VALUE_LOGIN_TOKENS.sec().longValue())
                .loginUser(loginUser)
                .build();

        LoginTokenHelper.addLoginTokenIdToCookie(loginToken.getId(), CacheKeyEnum.VALUE_LOGIN_TOKENS.sec());
        return loginToken;
    }

    @Override
    public void logout() {
        LoginToken loginToken = LoginTokenHelper.getLoginTokenFromRequest();
        if (loginToken == null) {
            throw new BusinessException(ResultCode.USER_NOT_LOGGED_IN);
        }

        LoginTokenHelper.delLoginTokenIdFromCookie();
    }
}
