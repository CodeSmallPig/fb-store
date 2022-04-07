package com.feng.fbstore.utils;

import lombok.Data;

/**
 * Created by FengBin on 2021/5/6 20:15
 * 返回的信息类 :
 * msg : 信息内容
 * status : 返回的状态码
 */
@Data
public class Msg {
    String msg;
    Integer status;

    public Msg(String msg, Integer status) {
        this.msg = msg;
        this.status = status;
    }
}
