package org.huha.bsresponsewrap.module.interceptor;

import org.huha.bsresponsewrap.demo.user.LoginToken;
import org.huha.bsresponsewrap.demo.user.LoginUser;
import org.huha.bsresponsewrap.demo.user.token.helper.LoginTokenHelper;
import org.huha.bsresponsewrap.module.annotations.LoginAuth;
import org.huha.bsresponsewrap.module.enums.ResultCode;
import org.huha.bsresponsewrap.module.exception.BusinessException;
import org.huha.bsresponsewrap.module.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @className: LoginAuthInterceptor
 * @package: org.huha.bsresponsewrap.module.interceptor
 * @describe: 录权限验证拦截器 备注：通过{@link LoginAuth}配合使用
 * @auther: wangkun
 * @date: 2019-01-03
 * @time: 上午 10:54
 **/
public class LoginAuthInterceptor implements HandlerInterceptor {


    @Autowired
    @Qualifier("loginTokenTemplate")
    RedisTemplate<String, LoginToken> loginTokenTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();

            if (clazz.isAnnotationPresent(LoginAuth.class) || method.isAnnotationPresent(LoginAuth.class)) {

                //获取登录TOKEN信息
                LoginToken loginToken = loginTokenTemplate.opsForValue().get("token");
                if (loginToken == null) {
                    throw new BusinessException(ResultCode.USER_NOT_LOGGED_IN);
                }

                //登录TOKEN信息放入请求对象，方便后续controller中获取
//                LoginTokenHelper.addLoginTokenToRequest(loginToken);
                return true;
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // nothing to do
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // nothing to do
    }

}
