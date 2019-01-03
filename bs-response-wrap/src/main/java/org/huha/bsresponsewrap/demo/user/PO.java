package org.huha.bsresponsewrap.demo.user;


import java.util.Date;

public interface PO<PK> extends Model {

    PK getId();

    void setId(PK id);

    Date getCreateTime();

    void setCreateTime(Date createTime);

    Date getUpdateTime();

    void setUpdateTime(Date updateTime);
}
