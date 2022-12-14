package com.springboot_rt.entity;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {
    private Boolean flag; //编码：true成功，flase为失败

    private String msg; //错误信息

    private Object data; //数据

    private Map map = new HashMap(); //动态数据

    public static  R success(Object object) {
        R r = new R();
        r.data = object;
        r.flag = true;
        return r;
    }

    public static  R error(String msg) {
        R r = new R();
        r.msg = msg;
        r.flag = false;
        return r;
    }

    public R add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
