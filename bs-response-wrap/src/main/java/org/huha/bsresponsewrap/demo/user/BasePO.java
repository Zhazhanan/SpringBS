package org.huha.bsresponsewrap.demo.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author zhuamer
 * @desc 基础PO类
 * @since 7/3/2017 2:14 PM
 */
@Data
public abstract class BasePO<PK> implements PO<PK> {

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}
