package cn.puda.result;

import lombok.Data;

/**
 *  前后端分离 结果返回封装
 * @title: CommonResult
 * @Author Ypier
 * @Date: 2021/4/6 9:42
 */
@Data
public class CommonResult<T> {
    private long code; // 返回状态
    private String message; // 返回说明message
    private T data; // 返回数据

    protected CommonResult() {
    }

    protected CommonResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success() {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 失败
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed() {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), null);
    }

    /**
     * 失败返回信息
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回信息
     * @param iErrorCode
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> failed(IErrorCode iErrorCode) {
        return new CommonResult<T>(iErrorCode.getCode(), iErrorCode.getMessage(), null);
    }

    /**
     * 权限不足
     * @param message
     * @return
     */
    public static <T> CommonResult<T>  forbidden(String message) {
        return  new CommonResult<T>(ResultCode.FORBIDDEN.getCode(),message,null);
    }

    /**
     * 未验证
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> unauthorized(String message) {
        return  new CommonResult<T>(ResultCode.UNAUTHORIZED.getCode(),message,null);
    }

    /**
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> validateFailed(String message) {
        return  new CommonResult<T>(ResultCode.VALIDATE_FAILED.getCode(),message,null);
    }
}
