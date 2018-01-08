package com.dounine.crud.base;


/**
 * act 返回数据接口
 *
 * Created by tanghaixiang on 2018/1/6.
 */
public interface Result {
    /**
     * 消息码
     */
    int getCode();

    /**
     * 错误消息
     */
    String getMsg();

    /**
     * 返回数据
     */
    Object getData();
}
