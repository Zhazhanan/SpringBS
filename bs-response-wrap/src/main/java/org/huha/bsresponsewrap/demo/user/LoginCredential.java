package org.huha.bsresponsewrap.demo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 * @author zhumaer
 * @desc 登录凭证
 * @since 6/15/2017 2:48 PM
 */
@ApiModel("登录凭证PO")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginCredential extends BasePO<Long> {

    private static final long serialVersionUID = 5550420394013305835L;

    @ApiModelProperty(value = "凭证主键")
    private Long id;

    @ApiModelProperty(value = "账号")
    @NotBlank
    @Length(min = 1, max = 128)
    private String account;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "密码加密随机盐")
    @Length(max = 64)
    private String randomSalt;

    @ApiModelProperty(value = "用户主键")
    @NotBlank
    private String userId;

    @ApiModelProperty(value = "账号类型")
    private String type;

    /**
     * 账号类型枚举
     */
    public enum TypeEnum {
        /**
         * 自定义
         */
        CUSTOM,
        /**
         * 微信UNION ID
         */
        UNION_ID;

        public static boolean isValidName(String name) {
            for (LoginCredential.TypeEnum typeEnum : LoginCredential.TypeEnum.values()) {
                if (typeEnum.name().equals(name)) {
                    return true;
                }
            }
            return false;
        }
    }
}
