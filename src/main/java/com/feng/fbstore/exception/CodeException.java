package com.feng.fbstore.exception;

/**
 * Created by FengBin on 2021/5/10 15:04
 * 定义异常类
 */
public enum CodeException {
    //用户 : 10001开始
    MISSED_User_EXCEPTION("用户名或者密码错误异常",10001),
    FALSED_User_EXCEPTION("用户名或者密码错误",10002),
    //商品内容 : 20001开始
    NOTFOUND_Content("内容不存在",20001),
    //购物车 : 30001开始
    NOTEXISTED_Cart("购物车为空",30001);

    private String msg;
    private Integer status;

    CodeException(String msg, Integer status) {
        this.msg = msg;
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
