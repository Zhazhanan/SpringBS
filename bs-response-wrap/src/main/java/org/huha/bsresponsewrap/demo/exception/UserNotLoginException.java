package org.huha.bsresponsewrap.demo.exception;

import org.huha.bsresponsewrap.module.exception.BusinessException;

/**
 * @desc 用户未登录异常
 */
public class UserNotLoginException extends BusinessException {

    private static final long serialVersionUID = -1879503946782379204L;

    public UserNotLoginException() {
        super();
    }

    public UserNotLoginException(String msg) {
        super(msg);
    }
}
