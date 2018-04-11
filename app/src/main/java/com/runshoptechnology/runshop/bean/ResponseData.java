package com.runshoptechnology.runshop.bean;

import java.io.Serializable;

/**
 * Created by zns on 2017/4/7.
 */

public class ResponseData<T> implements Serializable {
    //提示信息
    private String message;
    //30000 表示成功
    private String code;
    //数据结果
    private T result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
