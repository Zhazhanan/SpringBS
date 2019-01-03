package org.huha.bsgeneralmapper.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author WangKun
 * @create 2019-01-03 下午 6:26
 * @desc
 **/
public interface MyBaseMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
