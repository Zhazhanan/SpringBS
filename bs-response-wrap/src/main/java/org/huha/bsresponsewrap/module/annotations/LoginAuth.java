package org.huha.bsresponsewrap.module.annotations;

import java.lang.annotation.*;

/**
 * @className: LoginAuth
 * @package: org.huha.bsresponsewrap.module.annotations
 * @describe: 录权限验证注解
 * @auther: wangkun
 * @date: 2019-01-03
 * @time: 上午 10:52
 **/
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoginAuth {

}
