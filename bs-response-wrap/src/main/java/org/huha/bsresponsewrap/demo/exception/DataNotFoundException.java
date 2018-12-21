package org.huha.bsresponsewrap.demo.exception;


import org.huha.bsresponsewrap.module.enums.ResultCode;
import org.huha.bsresponsewrap.module.exception.BusinessException;

/**
 * @desc 数据没有找到异常
 */
public class DataNotFoundException extends BusinessException {

    private static final long serialVersionUID = 3721036867889297081L;

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(Object data) {
        super();
        super.data = data;
    }

    public DataNotFoundException(ResultCode resultCode) {
        super(resultCode);
    }

    public DataNotFoundException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public DataNotFoundException(String msg) {
        super(msg);
    }

}
