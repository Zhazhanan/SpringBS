package org.huha.bsresponsewrap.demo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @className: LoginQO
 * @package: org.huha.bsresponsewrap.demo.user
 * @describe: 登录QO
 * @auther: wangkun
 * @date: 2019-01-03
 * @time: 下午 5:37
 **/
@ApiModel("登录QO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginQO {

    @NotBlank
    @ApiModelProperty(value = "账号")
    private String account;

    @NotBlank
    @ApiModelProperty(value = "密码")
    private String pwd;
}
