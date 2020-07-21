package com.hangyu.platform.global;



import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Result implements Serializable {


    private static final long serialVersionUID = -1802122468331526708L;
    private int status = 200;
    private String message = "请求成功";
    private Map<String, Object> data = new HashMap<String, Object>();


    public Result(){}

    public Result(int status, String message){
        this.status = status;
        this.message = message;
    }
    public Result(int status,String message ,Map<String,Object> data){
        this.status = status;
        this.message = message;
        this.data = data;
    }



    public void putData(String key, Object value) {
        data.put(key, value);
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }


}
