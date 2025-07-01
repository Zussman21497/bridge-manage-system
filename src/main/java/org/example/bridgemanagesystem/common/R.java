package org.example.bridgemanagesystem.common;

import lombok.Data;

@Data
public class  R<T> {

    private Integer code;
    private String msg;
    private T data;

    public static <T> R<T> success(String msg){
        R<T> r = new R<>();
        r.code = 1;
        r.msg = msg;
        return r;
    }

    public static <T> R<T> success(T data){
        R<T> r = new R<>();
        r.code = 1;
        r.data = data;
        return r;
    }

    public static <T> R<T> error(String msg){
        R<T> r = new R<>();
        r.code = 0;
        r.msg = msg;
        return r;
    }

}
