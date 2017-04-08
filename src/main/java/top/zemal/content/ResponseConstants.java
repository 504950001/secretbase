package top.zemal.content;

/**
 * @author ZhangHuaRong
 * @title ResponseConstants.java
 * @package com.xinfang.context
 * @description TODO
 * @update 2016年12月20日 下午8:30:13
 */
public interface ResponseConstants {
    boolean SUCCESS_FAILED = false;
    boolean SUCCESS_OK = true;

    /*---- http ----*/
    int CODE_SUCCESS = 200;    // 请求成功
    int CODE_FAILED = 500;     // 请求失败
    String CODE_SUCCESS_VALUE = "SUCCESS";
    String CODE_FAILED_VALUE = "FAILED";


    Integer MY_CODE_FAILED  = 0;
    Integer CODE_OK = 1;
    Integer CODE_EXCEPTION = -1;
}
