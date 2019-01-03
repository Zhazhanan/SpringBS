package org.huha.bsresponsewrap.demo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.huha.bsresponsewrap.module.enums.CallSourceEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * @desc 登录的TOKEN
 *
 * @author zhumaer
 * @since 6/20/2017 3:00 PM
 */
@ApiModel("登录的TOKEN")
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginToken implements Serializable {

	private static final long serialVersionUID = -7925886220912655791L;
	@ApiModelProperty(value = "登陆token ID", required = true, position = 0)
	private String id;

	@ApiModelProperty(value = "生存时长(单位：秒)", required = true, position = 1)
	private Long ttl;

	@ApiModelProperty(value = "登录IP", required = true, position = 2)
	private String ip;

	/**
	 * 平台 {@link CallSourceEnum}
	 */
	@ApiModelProperty(value = "登录平台", required = true, position = 3)
	private String platform;

	@ApiModelProperty(value = "登录时间", required = true, position = 4)
	private Date createTime;

	@ApiModelProperty(value = "登录凭证", required = true, position =5)
	LoginCredential loginCredential;

	@ApiModelProperty(value = "登录的用户信息", required = true, position = 6)
	private LoginUser loginUser;

}
