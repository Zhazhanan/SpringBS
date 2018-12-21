package org.huha.bsresponsewrap.module.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.huha.bsresponsewrap.module.enums.ResultCode;


/**
 * @desc 平台通用返回结果
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlatformResult implements Result {

    private static final long serialVersionUID = 1346771751516872229L;
    private Integer code;

    private String msg;

    private Object data;

    public static PlatformResult success() {
        return PlatformResult.builder().code(ResultCode.SUCCESS.code()).msg(ResultCode.SUCCESS.message()).build();
    }

    public static PlatformResult success(Object data) {
        return PlatformResult.builder().code(ResultCode.SUCCESS.code()).msg(ResultCode.SUCCESS.message()).data(data).build();
    }

    public static PlatformResult failure(ResultCode resultCode) {
        return PlatformResult.builder().code(resultCode.code()).msg(resultCode.message()).build();
    }

    public static PlatformResult failure(ResultCode resultCode, Object data) {
        return PlatformResult.builder().code(resultCode.code()).msg(resultCode.message()).data(data).build();
    }

    public static PlatformResult failure(String message) {
        return PlatformResult.builder().code(ResultCode.PARAM_IS_INVALID.code()).msg(message).build();
    }
}
