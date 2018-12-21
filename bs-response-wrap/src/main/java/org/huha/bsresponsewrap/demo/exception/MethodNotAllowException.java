package org.huha.bsresponsewrap.demo.exception;


import org.huha.bsresponsewrap.module.enums.ResultCode;
import org.huha.bsresponsewrap.module.exception.BusinessException;

/**
 * @desc 方法不允许异常
 */
public class MethodNotAllowException extends BusinessException {

    private static final long serialVersionUID = -3813290937049524713L;

    public MethodNotAllowException() {
        super();
    }

    public MethodNotAllowException(Object data) {
        super.data = data;
    }

    public MethodNotAllowException(ResultCode resultCode) {
        super(resultCode);
    }

    public MethodNotAllowException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public MethodNotAllowException(String msg) {
        super(msg);
    }

}
