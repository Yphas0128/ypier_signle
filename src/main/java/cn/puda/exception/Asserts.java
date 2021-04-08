package cn.puda.exception;

import cn.puda.result.IErrorCode;

/**
 *  断言处理类，用于抛出各种API异常
 * @title: Asserts
 * @Author Ypier
 * @Date: 2021/4/6 9:53
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
