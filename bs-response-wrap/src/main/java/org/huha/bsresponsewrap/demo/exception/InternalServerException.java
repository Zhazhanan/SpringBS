package org.huha.bsresponsewrap.demo.exception;

import org.huha.bsresponsewrap.module.exception.BusinessException;

/**
 * @desc 内部服务异常
 */
public class InternalServerException extends BusinessException {

    private static final long serialVersionUID = 2659909836556958676L;

    public InternalServerException() {
        super();
    }

    public InternalServerException(String msg) {
        super(msg);
    }

}
